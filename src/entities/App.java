package entities;

import controllers.MainController;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import utils.HibernateUtil;
import utils.TestConnection;
import windows.Main;

public class App {

    public static void main(String[] args) {
        TestConnection t = new TestConnection();
        t.init();
        SessionFactory sessFac = HibernateUtil.getSessionFactory();
        Session session = sessFac.openSession();
        Main main = new Main();
        new MainController(main, session);
        main.setSize(800,600);
        main.setVisible(true);
    }
}
