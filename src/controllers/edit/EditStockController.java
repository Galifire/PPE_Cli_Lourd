package controllers.edit;

import controllers.admin.ErreurController;
import dao.DAOStocks;
import entities.Stocks;
import org.hibernate.Session;
import windows.admin.Erreur;
import windows.entities.WindowStock;

import java.util.ArrayList;

public class EditStockController {

    WindowStock cs;
    Session session;
    Stocks s;

    public EditStockController(WindowStock cs, Session session, Stocks s) {
        this.cs = cs;
        this.session = session;
        this.s = s;

        init();

        cs.getButtonOK().addActionListener(e -> {
            submit();
        });

        cs.getButtonCancel().addActionListener(e -> {
            cancel();
        });
    }

    public void init() {
        DAOStocks dao = new DAOStocks(session, Stocks.class);
        ArrayList<Stocks> stock = dao.findAll();
        for (Stocks st : stock) {
            cs.getMedicField().addItem(st.getMedicNum());
            cs.getPharField().addItem(st.getPharNum());
        }

        cs.setTitle("Ajouter un stock");
        cs.getNumField().setEditable(false);

        cs.getNumField().setText(s.getStockNum().toString());
        cs.getMedicField().setSelectedItem(s.getMedicNum());
        cs.getPharField().setSelectedItem(s.getPharNum());
        cs.getQteField().setText(s.getQte().toString());
    }

    public void submit() {
        s.setMedicNum(Integer.parseInt(cs.getMedicField().getSelectedItem().toString()));
        s.setPharNum(Integer.parseInt(cs.getPharField().getSelectedItem().toString()));
        s.setQte(Integer.parseInt(cs.getQteField().getText()));
        DAOStocks dao = new DAOStocks(session, Stocks.class);
        dao.saveOrUpdate(s);
        cs.dispose();
    }

    public void cancel() {
        cs.dispose();
    }
}
