package controllers.create;

import org.hibernate.Session;
import windows.create.CreateClient;

public class CreateClientController {

    CreateClient cc;
    Session session;

    public CreateClientController(CreateClient cc, Session session) {
        this.cc = cc;
        this.session = session;
    }
}
