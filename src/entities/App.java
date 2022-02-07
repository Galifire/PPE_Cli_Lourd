package entities;

import controllers.admin.MainController;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import utils.HibernateUtil;
import utils.TestConnection;
import windows.admin.Main;

public class App {

    public static void main(String[] args) {
        TestConnection t = new TestConnection();
        t.init();
        SessionFactory sessFac = HibernateUtil.getSessionFactory();
        Session session = sessFac.openSession();
        Main m = new Main();
        new MainController(m, session);
        m.setVisible(true);
    }
}
