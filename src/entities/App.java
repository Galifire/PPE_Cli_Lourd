package entities;

import controllers.WindowController;
import controllers.LoggerController;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import utils.HibernateUtil;
import utils.TestConnection;

public class App {

    public static void main(String[] args) {
        TestConnection t = new TestConnection();
        t.init();
        SessionFactory sessFac = HibernateUtil.getSessionFactory();
        Session session = sessFac.openSession();
        Logger l = new Logger();
        new LoggerController(l, session);
        l.setSize(800,600);
        l.setVisible(true);

    }
}
