package controllers;

import dao.DAOUser;
import entities.Logger;
import entities.User;
import entities.Window;
import org.hibernate.Session;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoggerController {

    Logger logger;
    Session session;


    public LoggerController(Logger logger, Session session) {
        this.logger = logger;
        this.session = session;


        logger.getOkBtn().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        logger.getCancelBtn().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });
    }

    public void onOK() {
        DAOUser dao = new DAOUser(session, User.class);
        String username = logger.getLogin().getText();
        String pwd = logger.getPwd().getText();
        if (!dao.findByCreds(username, pwd)) {
            logger.dispose();
            Window w = new Window();
            new WindowController(w, session);
            w.setSize(800,600);
            w.setVisible(true);
        }
    }

    public void onCancel() {
        logger.dispose();
    }
}
