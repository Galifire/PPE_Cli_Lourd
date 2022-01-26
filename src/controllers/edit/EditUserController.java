package controllers.edit;

import controllers.admin.ErreurController;
import dao.DAOUser;
import entities.User;
import org.hibernate.Session;
import windows.admin.Erreur;
import windows.entities.WindowUser;

public class EditUserController {

    WindowUser cu;
    Session session;

    public EditUserController(WindowUser cu, Session session) {
        this.cu = cu;
        this.session = session;

        cu.setTitle("Créer un utilisateur");
        cu.getIdField().setEditable(false);

        cu.getButtonOK().addActionListener(e -> {
            submit();
        });

        cu.getButtonCancel().addActionListener(e -> {
            cancel();
        });
    }

    public void submit() {
        if (cu.getIdField().getText().isEmpty()) {
            Erreur e = new Erreur();
            new ErreurController(e, "La clé primaire ne peut pas être vide, réessayez.");
            e.setSize(400,200);
            e.setVisible(true);
        } else {
            User u = new User();
            DAOUser dao = new DAOUser(session, User.class);
            u.setUsername(cu.getUsernameField().getText());
            u.setPassword(dao.hashPwd(cu.getPwdField().getText()));
            u.setRole(cu.getRoleField().getText());
        }
    }

    public void cancel() {
        cu.dispose();
    }
}
