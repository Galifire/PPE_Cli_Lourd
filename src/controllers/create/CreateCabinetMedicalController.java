package controllers.create;

import controllers.admin.ErreurController;
import dao.DAOCabinetMedical;
import entities.CabinetMedical;
import org.hibernate.Session;
import windows.admin.Erreur;
import windows.create.CreateCabinetMedical;

public class CreateCabinetMedicalController {

    CreateCabinetMedical ccm;
    Session session;

    public CreateCabinetMedicalController(CreateCabinetMedical ccm, Session session) {
        this.ccm = ccm;
        this.session = session;

        ccm.getButtonOK().addActionListener(e -> {
            submit();
        });

        ccm.getButtonCancel().addActionListener(e -> {
            cancel();
        });
    }

    public void submit() {
        if (ccm.getNumField().getText().isEmpty()) {
            Erreur e = new Erreur();
            new ErreurController(e, "La clé primaire ne peut pas être vide, réessayez.");
            e.setSize(400,200);
            e.setVisible(true);
        } else {
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
    }

    public void cancel() {
        ccm.dispose();
    }

}
