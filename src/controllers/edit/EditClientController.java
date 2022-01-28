package controllers.edit;

import dao.DAOClient;
import entities.Client;
import org.hibernate.Session;
import windows.entities.WindowClient;

public class EditClientController {

    WindowClient cc;
    Session session;
    Client client;

    public EditClientController(WindowClient cc, Session session, Client client) {
        this.cc = cc;
        this.session = session;
        this.client = client;

        init();

        cc.getButtonOK().addActionListener(e -> {
            submit();
        });

        cc.getButtonCancel().addActionListener(e -> {
            cancel();
        });
    }

    public void init() {
        cc.setTitle("Éditer un client");
        cc.getNumField().setEditable(false);

        cc.getNumField().setText((client.getCliNum()).toString());
        cc.getNomField().setText(client.getNom());
        cc.getPrenomField().setText(client.getPrenom());
        cc.getAdresseField().setText(client.getAdresse());
        cc.getEmailField().setText(client.getEmail());
        cc.getTelField().setText(client.getTelephone());
    }

    public void submit() {
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

    public void cancel() {
        cc.dispose();
    }
}
