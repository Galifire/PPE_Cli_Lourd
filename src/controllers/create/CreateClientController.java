package controllers.create;

import dao.DAOClient;
import entities.Client;
import org.hibernate.Session;
import windows.entities.WindowClient;

public class CreateClientController {

    WindowClient cc;
    Session session;

    public CreateClientController(WindowClient cc, Session session) {
        this.cc = cc;
        this.session = session;

        cc.setTitle("Créer un client");
        cc.getNumField().setEditable(false);

        cc.getButtonOK().addActionListener(e -> {
            submit();
        });

        cc.getButtonCancel().addActionListener(e -> {
            cancel();
        });
    }

    public void submit() {
        Client c = new Client();
        c.setNom(cc.getNomField().getText());
        c.setPrenom(cc.getPrenomField().getText());
        c.setAdresse(cc.getAdresseField().getText());
        c.setEmail(cc.getEmailField().getText());
        c.setTelephone(cc.getTelField().getText());
        DAOClient dao = new DAOClient(session, Client.class);
        dao.saveOrUpdate(c);
        cc.dispose();
    }

    public void cancel() {
        cc.dispose();
    }
}
