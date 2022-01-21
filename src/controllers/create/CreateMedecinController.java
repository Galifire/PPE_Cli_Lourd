package controllers.create;

import controllers.admin.ErreurController;
import entities.Medecins;
import org.hibernate.Session;
import windows.admin.Erreur;
import windows.create.CreateMedecin;

public class CreateMedecinController {

    CreateMedecin cm;
    Session session;

    public CreateMedecinController(CreateMedecin cm, Session session) {
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
            Medecins m = new Medecins();
            m.setMedNum(Integer.parseInt(cm.getNumField().getText()));
            m.setNom(cm.getNomField().getText());
            m.setPrenom(cm.getPrenomField().getText());
            m.setAdresse(cm.getAdresseField().getText());
            m.setEmail(cm.getEmailField().getText());
            m.setCabNum(Integer.parseInt(cm.getCabField().getText()));
            cm.dispose();
        }
    }

    public void cancel() {
        cm.dispose();
    }
}
