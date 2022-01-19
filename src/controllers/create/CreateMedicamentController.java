package controllers.create;

import org.hibernate.Session;
import windows.create.CreateMedicament;

public class CreateMedicamentController {

    CreateMedicament cm;
    Session session;

    public CreateMedicamentController(CreateMedicament cm, Session session) {
        this.cm = cm;
        this.session = session;
    }
}
