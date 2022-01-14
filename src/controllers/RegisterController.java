package controllers;

import dao.DAOUser;
import entities.User;
import org.hibernate.Session;
import windows.Erreur;
import windows.Logger;
import windows.Register;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

public class RegisterController {

    Register register;
    Session session;

    public RegisterController(Register register, Session session) {
        this.register = register;
        this.session = session;


        register.getRegisterBtn().addActionListener(e -> {
            try {
                register();
            } catch (NoSuchAlgorithmException ex) {
                ex.printStackTrace();
            }
        });

        register.getCancelBtn().addActionListener(e -> {
            cancel();
        });
    }

    public void register() throws NoSuchAlgorithmException {
        DAOUser dao = new DAOUser(session, User.class);
        String username = register.getUsernameField().getText();
        String pwd = dao.hashPwd(register.getPwdField().getText());
        String pwdConfirmed = dao.hashPwd(register.getConfirmedPwdField().getText());
        System.out.println(dao.userNotExists(username));
        System.out.println(Objects.equals(pwd, pwdConfirmed));
        if (dao.userNotExists(username) && (Objects.equals(pwd, pwdConfirmed))) {
            User user = new User();
            user.setId(((int)dao.count())+1);
            user.setUsername(username);
            user.setPassword(pwdConfirmed);
            dao.saveOrUpdate(user);
            register.dispose();
            Logger logger = new Logger();
            new LoggerController(logger, session);
            logger.setSize(800,600);
            logger.setVisible(true);
        } else if (!(Objects.equals(pwd, pwdConfirmed))) {
            Erreur erreur = new Erreur();
            new ErreurController(erreur, "mots de passe différents, recommencez.");
            erreur.setSize(400,200);
            erreur.setVisible(true);
        } else if (!dao.userNotExists(username)) {
            Erreur erreur = new Erreur();
            new ErreurController(erreur, "utilisateur déjà existant");
            erreur.setSize(400,200);
            erreur.setVisible(true);
        }
    }

    public void cancel() {
        register.dispose();
    }


}
