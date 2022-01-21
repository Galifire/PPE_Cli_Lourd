package controllers.create;

import controllers.admin.ErreurController;
import dao.DAOUser;
import entities.User;
import org.hibernate.Session;
import windows.admin.Erreur;
import windows.create.CreateUser;

public class CreateUserController {

    CreateUser cu;
    Session session;

    public CreateUserController(CreateUser cu, Session session) {
        this.cu = cu;
        this.session = session;

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
            u.setId(Integer.parseInt(cu.getIdField().getText()));
            u.setUsername(cu.getUsernameField().getText());
            u.setPassword(dao.hashPwd(cu.getPwdField().getText()));
            u.setRole(cu.getRoleField().getText());
        }
    }

    public void cancel() {
        cu.dispose();
    }

}
