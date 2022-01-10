package entities;

import dao.DAOMedecins;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import utils.HibernateUtil;
import utils.TestConnection;

import javax.swing.*;
import java.util.List;

public class App {

    public static void main(String[] args) {
        TestConnection t = new TestConnection();
        t.init();
        SessionFactory sessFac = HibernateUtil.getSessionFactory();
        Session session = sessFac.openSession();
        new Controller(new Window(), new DAOMedecins(session, Medecins.class));
    }
}
