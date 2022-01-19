package controllers.create;

import org.hibernate.Session;
import windows.create.CreateRdv;

public class CreateRdvController {

    CreateRdv cr;
    Session session;

    public CreateRdvController(CreateRdv cr, Session session) {
        this.cr = cr;
        this.session = session;
    }
}
