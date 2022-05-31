package controllers.admin;

import org.hibernate.Session;
import windows.admin.Logger;
import windows.admin.Main;
import windows.admin.Register;

public class MainController {

    Main main;
    Session session;

    /**
     *
     * @param main fenêtre main, celle générale
     * @param session données de session
     */

    public MainController(Main main, Session session) {
        this.main = main;
        this.session = session;

        main.getRegisterBtn().addActionListener(e -> register());

        main.getLoginBtn().addActionListener(e -> logging());
    }

    public void register() {
        main.dispose();
        Register r = new Register();
        new RegisterController(r, session);
        r.setVisible(true);
    }

    public void logging() {
        main.dispose();
        Logger l = new Logger();
        new LoggerController(l, session);
        l.setVisible(true);
    }
}
