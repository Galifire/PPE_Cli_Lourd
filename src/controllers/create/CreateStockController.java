package controllers.create;

import org.hibernate.Session;
import windows.create.CreateStock;

public class CreateStockController {

    CreateStock cs;
    Session session;

    public CreateStockController(CreateStock cs, Session session) {
        this.cs = cs;
        this.session = session;
    }
}
