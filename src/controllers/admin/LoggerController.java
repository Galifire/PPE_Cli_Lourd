package controllers.admin;

import dao.DAOUser;
import windows.admin.Erreur;
import windows.admin.Logger;
import entities.User;
import windows.admin.Register;
import windows.admin.Window;
import org.hibernate.Session;

import javax.swing.*;
import java.security.NoSuchAlgorithmException;

public class LoggerController {

    Logger logger;
    Session session;

    public LoggerController(Logger logger, Session session) {
        this.logger = logger;
        this.session = session;

        logger.getLoginBtn().addActionListener(e -> {
            try {
                login();
            } catch (NoSuchAlgorithmException ex) {
                ex.printStackTrace();
            }
        });

        logger.getCancelBtn().addActionListener(e -> onCancel());

        logger.getRegisterBtn().addActionListener(e -> register());
    }

    public void login() throws NoSuchAlgorithmException {
        DAOUser dao = new DAOUser(session, User.class);
        String username = logger.getLogin().getText();
        String pwd = dao.hashPwd(logger.getPwd().getText());
        if (!dao.checkCreds(username, pwd)) {
            User user = dao.findByCreds(username, pwd);
            System.out.println(user.getUsername());
            logger.dispose();
            Window w = new Window();
            new WindowController(w, session, user, new JTable());
            w.setVisible(true);
        } else {
            Erreur err = new Erreur();
            new ErreurController(err, "nom d'utilisateur ou mot de passe incorrect, recommencez.");
            err.setVisible(true);
        }
    }

    public void onCancel() {
        logger.dispose();
    }

    public void register() {
        logger.dispose();
        Register register = new Register();
        new RegisterController(register, session);
        register.setVisible(true);
    }
}
