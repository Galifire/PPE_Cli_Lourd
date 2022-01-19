package controllers.create;

import org.hibernate.Session;
import windows.create.CreatePharmacien;

public class CreatePharmacienController {

    CreatePharmacien cp;
    Session session;

    public CreatePharmacienController(CreatePharmacien cp, Session session) {
        this.cp = cp;
        this.session = session;
    }
}
