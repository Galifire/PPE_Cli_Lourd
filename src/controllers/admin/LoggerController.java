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

    /**
     * @param logger fenêtre de log pour se connecter
     * @param session données de session
     */
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

    /**
     * Vérifie lors de la connexion que le login correspond à un dans la base de données
     * et que le mot de passe associé (avec un hash) est correct.
     */

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
            Erreur e = new Erreur();
            new ErreurController(e, "nom d'utilisateur ou mot de passe incorrect, recommencez.");
            e.setVisible(true);
        }
    }

    public void onCancel() {
        logger.dispose();
    }

    public void register() {
        logger.dispose();
        Register r = new Register();
        new RegisterController(r, session);
        r.setVisible(true);
    }
}
