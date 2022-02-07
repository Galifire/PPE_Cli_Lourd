package controllers.create;

import controllers.admin.ErreurController;
import dao.DAOStocks;
import entities.Stocks;
import org.hibernate.Session;
import windows.admin.Erreur;
import windows.entities.WindowStock;

import java.util.ArrayList;

public class CreateStockController {

    WindowStock cs;
    Session session;

    public CreateStockController(WindowStock cs, Session session) {
        this.cs = cs;
        this.session = session;

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
        ArrayList<Stocks> s = dao.findAll();
        for (Stocks st : s) {
            cs.getMedicField().addItem(st.getMedicNum());
            cs.getPharField().addItem(st.getPharNum());
        }

        cs.setTitle("Ajouter un stock");
        cs.getNumField().setEditable(false);
    }

    public void submit() {
        Stocks s = new Stocks();
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
