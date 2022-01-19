package controllers.create;

import org.hibernate.Session;
import windows.create.CreateCabinetMedical;

public class CreateCabinetMedicalController {

    CreateCabinetMedical ccm;
    Session session;

    public CreateCabinetMedicalController(CreateCabinetMedical ccm, Session session) {
        this.ccm = ccm;
        this.session = session;
    }

}
