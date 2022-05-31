package controllers.admin;

import dao.DAOUser;
import entities.User;
import org.hibernate.Session;
import windows.admin.Erreur;
import windows.admin.Logger;
import windows.admin.Main;
import windows.admin.Register;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

public class RegisterController {

    Register register;
    Session session;

    /**
     *
     * @param register fenêtre register, celle pour s'enregister et créer un compte
     * @param session données de session
     */
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

        register.getMainBtn().addActionListener(e -> homePage());

        register.getCancelBtn().addActionListener(e -> cancel());
    }

    public void homePage() {
        register.dispose();
        Main m = new Main();
        new MainController(m, session);
        m.setVisible(true);
    }

    public void register() throws NoSuchAlgorithmException {
        DAOUser dao = new DAOUser(session, User.class);
        String username = register.getUsernameField().getText();
        String pwd = dao.hashPwd(register.getPwdField().getText());
        String pwdConfirmed = dao.hashPwd(register.getConfirmedPwdField().getText());
        if (username.isEmpty() || pwd.isEmpty() || pwdConfirmed.isEmpty()) {
            Erreur e = new Erreur();
            new ErreurController(e, "Les champs ne peuvent pas être vides!");
            e.setVisible(true);
        } else if (dao.userNotExists(username) && (Objects.equals(pwd, pwdConfirmed))) {
            User user = new User();
            user.setId(((int)dao.count())+1);
            user.setUsername(username);
            user.setPassword(pwdConfirmed);
            dao.saveOrUpdate(user);
            register.dispose();
            Logger l = new Logger();
            new LoggerController(l, session);
            l.setVisible(true);
        } else if (!(Objects.equals(pwd, pwdConfirmed))) {
            Erreur e = new Erreur();
            new ErreurController(e, "mots de passe différents, recommencez.");
            e.setVisible(true);
        } else if (!dao.userNotExists(username)) {
            Erreur e = new Erreur();
            new ErreurController(e, "utilisateur déjà existant");
            e.setVisible(true);
        }
    }

    public void cancel() {
        register.dispose();
    }
}
