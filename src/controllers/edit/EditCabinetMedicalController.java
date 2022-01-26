package controllers.edit;

import dao.DAOCabinetMedical;
import entities.CabinetMedical;
import org.hibernate.Session;
import windows.entities.WindowCabinetMedical;

public class EditCabinetMedicalController {

    WindowCabinetMedical ccm;
    Session session;
    CabinetMedical cm;

    public EditCabinetMedicalController(WindowCabinetMedical ccm, Session session, CabinetMedical cm) {
        this.ccm = ccm;
        this.session = session;
        this.cm = cm;

        ccm.setTitle("Éditer un médecin");

        ccm.getNumField().setEditable(false);

        ccm.getButtonOK().addActionListener(e -> {
            submit();
        });

        ccm.getButtonCancel().addActionListener(e -> {
            cancel();
        });
    }

    public void submit() {
        CabinetMedical cm = new CabinetMedical();
        cm.setCabNum(Integer.parseInt(ccm.getNumField().getText()));
        cm.setNom(ccm.getNomField().getText());
        cm.setAdresse(ccm.getAdresseField().getText());
        cm.setEffectif(Integer.parseInt(ccm.getEffectifField().getText()));
        cm.setHoraires(ccm.getHorairesField().getText());
        DAOCabinetMedical dao = new DAOCabinetMedical(session, CabinetMedical.class);
        dao.saveOrUpdate(cm);
        ccm.dispose();
    }

    public void cancel() {
        ccm.dispose();
    }
}
