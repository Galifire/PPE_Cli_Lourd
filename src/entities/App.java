package entities;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import utils.HibernateUtil;
import utils.TestConnection;
import dao.DAOMedecins;

import javax.swing.*;
import java.util.List;

public class App {

    public static void main(String[] args) {
        TestConnection t = new TestConnection();
        t.init();
        SessionFactory sessFac = HibernateUtil.getSessionFactory();
        Session session = sessFac.openSession();
        DAOMedecins daoCm = new DAOMedecins(session, Medecins.class);
        Window window = new Window();
        window.getTableName().setText(Medecins.class.toString());
        List<Medecins> medecins = daoCm.showMedecinsFromCabinetByName("Lyon6");
        /*for (Medecins m : medecins) {
            System.out.println(m);
        }*/
        JTable table = new JTable(

        );
    }
}
