package controllers.edit;

import dao.DAOMedecins;
import entities.Medecins;
import org.hibernate.Session;
import windows.entities.WindowMedecin;

public class EditMedecinController {

    WindowMedecin cm;
    Session session;
    Medecins m;

    public EditMedecinController(WindowMedecin cm, Session session, Medecins m) {
        this.cm = cm;
        this.session = session;
        this.m = m;

        init();

        cm.getButtonOK().addActionListener(e -> {
            submit();
        });

        cm.getButtonCancel().addActionListener(e -> {
            cancel();
        });
    }

    public void init() {
        cm.setTitle("Éditer un médecin");
        cm.getNumField().setEditable(false);

        cm.getNumField().setText(m.getMedNum().toString());
        cm.getNomField().setText(m.getNom());
        cm.getPrenomField().setText(m.getPrenom());
        cm.getAdresseField().setText(m.getAdresse());
        cm.getEmailField().setText(m.getEmail());
        cm.getTelField().setText(m.getTelephone());
        cm.getCabField().setText(m.getCabNum().toString());
    }

    public void submit() {
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
