package controllers.edit;

import dao.DAOClient;
import entities.Client;
import org.hibernate.Session;
import windows.entities.WindowClient;

public class EditClientController {

    WindowClient cc;
    Session session;
    Client c;

    public EditClientController(WindowClient cc, Session session, Client c) {
        this.cc = cc;
        this.session = session;
        this.c = c;

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

        cc.getNumField().setText((c.getCliNum()).toString());
        cc.getNomField().setText(c.getNom());
        cc.getPrenomField().setText(c.getPrenom());
        cc.getAdresseField().setText(c.getAdresse());
        cc.getEmailField().setText(c.getEmail());
        cc.getTelField().setText(c.getTelephone());
    }

    public void submit() {
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
