package controllers.create;

import org.hibernate.Session;
import windows.create.CreatePharmacie;

public class CreatePharmacieController {

    CreatePharmacie cp;
    Session session;

    public CreatePharmacieController(CreatePharmacie cp, Session session) {
        this.cp = cp;
        this.session = session;
    }
}
