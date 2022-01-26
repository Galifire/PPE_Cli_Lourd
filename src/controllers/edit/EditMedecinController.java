package controllers.edit;

import dao.DAOMedecins;
import entities.Medecins;
import org.hibernate.Session;
import windows.entities.WindowMedecin;

public class EditMedecinController {

    WindowMedecin cm;
    Session session;
    Medecins medecin;

    public EditMedecinController(WindowMedecin cm, Session session, Medecins medecin) {
        this.cm = cm;
        this.session = session;
        this.medecin = medecin;

        cm.setTitle("Éditer un médecin");
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
        m.setMedNum(Integer.parseInt(cm.getNumField().getText()));
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
