package controllers.create;

import controllers.admin.ErreurController;
import dao.DAOCabinetMedical;
import entities.CabinetMedical;
import entities.Commandes;
import org.hibernate.Session;
import windows.admin.Erreur;
import windows.entities.WindowCommande;

public class CreateCommandeController {

    WindowCommande cc;
    Session session;

    public CreateCommandeController(WindowCommande cc, Session session) {
        this.cc = cc;
        this.session = session;

        cc.setTitle("Créer une commande");
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
            new ErreurController(new Erreur(), "La clé primaire ne peut pas être vide, réessayez.");
        } else {
            Commandes c = new Commandes();
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
