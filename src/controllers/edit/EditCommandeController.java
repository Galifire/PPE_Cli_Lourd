package controllers.edit;

import controllers.admin.ErreurController;
import dao.DAOCabinetMedical;
import entities.CabinetMedical;
import entities.Commandes;
import org.hibernate.Session;
import windows.admin.Erreur;
import windows.entities.WindowCommande;

public class EditCommandeController {

    WindowCommande cc;
    Session session;
    Commandes cde;

    public EditCommandeController(WindowCommande cc, Session session, Commandes cde) {
        this.cc = cc;
        this.session = session;
        this.cde = cde;

        init();

        cc.getButtonOK().addActionListener(e -> {
            submit();
        });

        cc.getButtonCancel().addActionListener(e -> {
            cancel();
        });
    }

    public void init() {
        cc.setTitle("Éditer une commande");
        cc.getNumField().setEditable(false);

        cc.getNumField().setText(cde.getCdeNum().toString());
        cc.getCliField().setText(cde.getCliNum().toString());
        cc.getMedicField().setText(cde.getMedicNum().toString());
        cc.getDateField().setText(cde.getDateCde());
        cc.getQtyField().setText(cde.getQte().toString());
    }

    public void submit() {
        if (cc.getCliField().getText().isEmpty() || cc.getMedicField().getText().isEmpty()) {
            Erreur e = new Erreur();
            new ErreurController(e, "La clé primaire ne peut pas être vide, réessayez.");
            e.setSize(400,200);
            e.setVisible(true);
        } else {
            cde.setCdeNum(Integer.parseInt(cc.getNumField().getText()));
            cde.setCliNum(Integer.parseInt(cc.getCliField().getText()));
            cde.setMedicNum(Integer.parseInt(cc.getMedicField().getText()));
            cde.setDateCde(cc.getDateField().getText());
            cde.setQte(Integer.parseInt(cc.getQtyField().getText()));
            DAOCabinetMedical dao = new DAOCabinetMedical(session, CabinetMedical.class);
            dao.saveOrUpdate(cde);
            cc.dispose();
        }
    }

    public void cancel() {
        cc.dispose();
    }
}
