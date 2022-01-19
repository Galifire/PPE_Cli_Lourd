package controllers.create;

import org.hibernate.Session;
import windows.create.CreateCommande;

public class CreateCommandeController {

    CreateCommande cc;
    Session session;

    public CreateCommandeController(CreateCommande cc, Session session) {
        this.cc = cc;
        this.session = session;
    }
}
