package controllers.edit;

import dao.DAOMedicaments;
import entities.Medicaments;
import org.hibernate.Session;
import windows.entities.WindowMedicament;

public class EditMedicamentController {

    WindowMedicament cm;
    Session session;
    Medicaments medic;

    public EditMedicamentController(WindowMedicament cm, Session session, Medicaments medic) {
        this.cm = cm;
        this.session = session;
        this.medic = medic;

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

        cm.getNumField().setText(medic.getMedicNum().toString());
        cm.getNomField().setText(medic.getNom());
        cm.getRestrictionsField().setText(medic.getRestrictions());
        cm.getDelaiField().setText(medic.getDelaiProduction().toString());
    }

    public void submit() {
        Medicaments m = new Medicaments();
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
