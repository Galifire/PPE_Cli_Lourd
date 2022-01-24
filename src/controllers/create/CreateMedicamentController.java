package controllers.create;

import entities.Medicaments;
import org.hibernate.Session;
import dao.DAOMedicaments;
import windows.entities.WindowMedicament;

public class CreateMedicamentController {

    WindowMedicament cm;
    Session session;

    public CreateMedicamentController(WindowMedicament cm, Session session) {
        this.cm = cm;
        this.session = session;

        cm.setTitle("Créer un médicament");
        cm.getNumField().setEditable(false);

        cm.getButtonOK().addActionListener(e -> {
            submit();
        });

        cm.getButtonCancel().addActionListener(e -> {
            cancel();
        });
    }

    public void submit() {
        Medicaments m = new Medicaments();
        m.setNom(cm.getNomField().getText());
        m.setRestrictions(cm.getRestrictionsField().getText());
        m.setDelaiProduction(Integer.parseInt(cm.getDelaiField().getText()));
        DAOMedicaments dao = new DAOMedicaments(session, Medicaments.class);
        dao.saveOrUpdate(m);
        cm.dispose();
    }

    public void cancel() {
        cm.dispose();
    }
}
