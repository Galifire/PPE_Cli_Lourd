package controllers.create;

import dao.DAOCabinetMedical;
import entities.CabinetMedical;
import org.hibernate.Session;
import windows.entities.WindowCabinetMedical;

public class CreateCabinetMedicalController {

    WindowCabinetMedical ccm;
    Session session;

    public CreateCabinetMedicalController(WindowCabinetMedical ccm, Session session) {
        this.ccm = ccm;
        this.session = session;

        ccm.setTitle("Créer un médecin");

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
