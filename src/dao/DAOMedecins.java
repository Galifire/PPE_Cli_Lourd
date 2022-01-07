package dao;

import entities.CabinetMedical;
import entities.Medecins;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import utils.HibernateUtil;

import java.util.List;

public class DAOMedecins extends DAOGeneric {

    public DAOMedecins(Session session, Class entityClass) {
        super(session, entityClass);
    }

    public List<Medecins> showMedecinsFromCabinetByName(String nomCabinet) {
        SessionFactory sessFac = HibernateUtil.getSessionFactory();
        Session session = sessFac.openSession();
        String sqlCabinet = "SELECT * FROM cabinet_medical WHERE Nom=:nom";
        SQLQuery query = session.createSQLQuery(sqlCabinet);
        query.setString("nom", nomCabinet);
        query.addEntity(CabinetMedical.class);
        List<CabinetMedical> cabinets = query.list();
        List<Medecins> medecins = null;
        for (CabinetMedical c : cabinets) {
            System.out.println(c.getCabNum());
            String sqlMedecins = "SELECT * FROM medecins WHERE CABNum=:cabNum";
            SQLQuery queryMedecins = session.createSQLQuery(sqlMedecins);
            queryMedecins.setInteger("cabNum", c.getCabNum());
            queryMedecins.addEntity(Medecins.class);
            medecins = queryMedecins.list();
        }
        return medecins;
    }
}
