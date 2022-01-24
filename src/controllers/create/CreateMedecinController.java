package controllers.create;

import entities.Medecins;
import dao.DAOMedecins;
import org.hibernate.Session;
import windows.entities.WindowMedecin;

public class CreateMedecinController {

    WindowMedecin cm;
    Session session;

    public CreateMedecinController(WindowMedecin cm, Session session) {
        this.cm = cm;
        this.session = session;

        cm.setTitle("Créer un médecin");
        cm.getNumField().setEditable(false);

        cm.getButtonOK().addActionListener(e -> {
            submit();
        });

        cm.getButtonCancel().addActionListener(e -> {
            cancel();
        });
    }

    public void submit() {
        Medecins m = new Medecins();
        m.setNom(cm.getNomField().getText());
        m.setPrenom(cm.getPrenomField().getText());
        m.setAdresse(cm.getAdresseField().getText());
        m.setEmail(cm.getEmailField().getText());
        m.setCabNum(Integer.parseInt(cm.getCabField().getText()));
        DAOMedecins dao = new DAOMedecins(session, Medecins.class);
        dao.saveOrUpdate(m);
        cm.dispose();
    }

    public void cancel() {
        cm.dispose();
    }
}
