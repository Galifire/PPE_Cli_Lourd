package controllers.create;

import controllers.admin.ErreurController;
import entities.Medecins;
import entities.Medicaments;
import org.hibernate.Session;
import windows.admin.Erreur;
import windows.create.CreateMedicament;

public class CreateMedicamentController {

    CreateMedicament cm;
    Session session;

    public CreateMedicamentController(CreateMedicament cm, Session session) {
        this.cm = cm;
        this.session = session;

        cm.getButtonOK().addActionListener(e -> {
            submit();
        });

        cm.getButtonCancel().addActionListener(e -> {
            cancel();
        });
    }

    public void submit() {
        if (cm.getNumField().getText().isEmpty()) {
            Erreur e = new Erreur();
            new ErreurController(e, "La clé primaire ne peut pas être vide, réessayez.");
            e.setSize(400,200);
            e.setVisible(true);
        } else {
            Medicaments m = new Medicaments();
            m.setMedicNum(Integer.parseInt(cm.getNumField().getText()));
            m.setNom(cm.getNomField().getText());
            m.setRestrictions(cm.getRestrictionsField().getText());
            m.setDelaiProduction(Integer.parseInt(cm.getDelaiField().getText()));
            cm.dispose();
        }
    }

    public void cancel() {
        cm.dispose();
    }
}
