package controllers.edit;

import dao.DAOMedicaments;
import entities.Medicaments;
import org.hibernate.Session;
import windows.entities.WindowMedicament;

public class EditMedicamentController {

    WindowMedicament cm;
    Session session;
    Medicaments m;

    public EditMedicamentController(WindowMedicament cm, Session session, Medicaments m) {
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
        cm.setTitle("Éditer un médicament");
        cm.getNumField().setEditable(false);

        cm.getNumField().setText(m.getMedicNum().toString());
        cm.getNomField().setText(m.getNom());
        cm.getRestrictionsField().setText(m.getRestrictions());
        cm.getDelaiField().setText(m.getDelaiProduction().toString());
    }

    public void submit() {
        m.setMedicNum(Integer.parseInt(cm.getNumField().getText()));
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
