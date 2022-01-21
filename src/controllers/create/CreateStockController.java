package controllers.create;

import controllers.admin.ErreurController;
import entities.Stocks;
import org.hibernate.Session;
import windows.admin.Erreur;
import windows.create.CreateStock;

public class CreateStockController {

    CreateStock cs;
    Session session;

    public CreateStockController(CreateStock cs, Session session) {
        this.cs = cs;
        this.session = session;

        cs.getButtonOK().addActionListener(e -> {
            submit();
        });

        cs.getButtonCancel().addActionListener(e -> {
            cancel();
        });
    }

    public void submit() {
        if ((cs.getMedicField().getText().isEmpty()) && (cs.getPharField().getText().isEmpty())) {
            Erreur e = new Erreur();
            new ErreurController(e, "La clé primaire ne peut pas être vide, réessayez.");
            e.setSize(400,200);
            e.setVisible(true);
        } else {
            Stocks s = new Stocks();
            s.setMedicNum(Integer.parseInt(cs.getMedicField().getText()));
            s.setPharNum(Integer.parseInt(cs.getPharField().getText()));
            s.setQte(Integer.parseInt(cs.getQteField().getText()));
        }
    }

    public void cancel() {
        cs.dispose();
    }
}
