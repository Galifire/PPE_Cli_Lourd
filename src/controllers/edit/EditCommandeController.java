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

        cc.setTitle("Éditer une commande");
        cc.getNumField().setEditable(false);

        cc.getButtonOK().addActionListener(e -> {
            submit();
        });

        cc.getButtonCancel().addActionListener(e -> {
            cancel();
        });
    }

    public void submit() {
        if (cc.getCliField().getText().isEmpty() || cc.getMedicField().getText().isEmpty()) {
            Erreur e = new Erreur();
            new ErreurController(e, "La clé primaire ne peut pas être vide, réessayez.");
            e.setSize(400,200);
            e.setVisible(true);
        } else {
            Commandes c = new Commandes();
            c.setCdeNum(Integer.parseInt(cc.getNumField().getText()));
            c.setCliNum(Integer.parseInt(cc.getCliField().getText()));
            c.setMedicNum(Integer.parseInt(cc.getMedicField().getText()));
            c.setDateCde(cc.getDateField().getText());
            c.setQte(Integer.parseInt(cc.getQtyField().getText()));
            DAOCabinetMedical dao = new DAOCabinetMedical(session, CabinetMedical.class);
            dao.saveOrUpdate(c);
            cc.dispose();
        }
    }

    public void cancel() {
        cc.dispose();
    }
}
