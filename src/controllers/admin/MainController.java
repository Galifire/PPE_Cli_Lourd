package controllers.admin;

import org.hibernate.Session;
import windows.admin.Logger;
import windows.admin.Main;
import windows.admin.Register;

public class MainController {

    Main main;
    Session session;

    public MainController(Main main, Session session) {
        this.main = main;
        this.session = session;

        main.getRegisterBtn().addActionListener(e -> {
            register();
        });

        main.getLoginBtn().addActionListener(e -> {
            logging();
        });
    }

    public void register() {
        main.dispose();
        Register register = new Register();
        new RegisterController(register, session);
        register.setSize(800,600);
        register.setVisible(true);
    }

    public void logging() {
        Logger logger = new Logger();
        new LoggerController(logger, session);
        logger.setSize(800,600);
        main.dispose();
        logger.setVisible(true);

    }
}
