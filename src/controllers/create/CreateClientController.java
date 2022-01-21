package controllers.create;

import controllers.admin.ErreurController;
import dao.DAOClient;
import entities.Client;
import org.hibernate.Session;
import windows.admin.Erreur;
import windows.create.CreateClient;

public class CreateClientController {

    CreateClient cc;
    Session session;

    public CreateClientController(CreateClient cc, Session session) {
        this.cc = cc;
        this.session = session;

        cc.getButtonOK().addActionListener(e -> {
            submit();
        });

        cc.getButtonCancel().addActionListener(e -> {
            cancel();
        });
    }

    public void submit() {
        if (cc.getNumField().getText().isEmpty()) {
            Erreur e = new Erreur();
            new ErreurController(e, "La clé primaire ne peut pas être vide, réessayez.");
            e.setSize(400, 200);
            e.setVisible(true);
        } else {
            Client c = new Client();
            c.setCliNum(Integer.parseInt(cc.getNumField().getText()));
            c.setNom(cc.getNomField().getText());
            c.setPrenom(cc.getPrenomField().getText());
            c.setAdresse(cc.getAdresseField().getText());
            c.setEmail(cc.getEmailField().getText());
            c.setTelephone(cc.getTelField().getText());
            DAOClient dao = new DAOClient(session, Client.class);
            dao.saveOrUpdate(c);
            cc.dispose();
        }
    }

    public void cancel() {
        cc.dispose();
    }
}
