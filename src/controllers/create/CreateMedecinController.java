package controllers.create;

import org.hibernate.Session;
import windows.create.CreateMedecin;

public class CreateMedecinController {

    CreateMedecin cm;
    Session session;

    public CreateMedecinController(CreateMedecin cm, Session session) {
        this.cm = cm;
        this.session = session;
    }
}
