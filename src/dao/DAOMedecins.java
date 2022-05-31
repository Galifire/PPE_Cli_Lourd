package dao;

import entities.CabinetMedical;
import entities.Medecins;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import utils.HibernateUtil;

import java.util.List;

public class DAOMedecins extends DAOGeneric {

    /**
     *
     * @param session données de session
     * @param entityClass permet de déterminer dynamiquement la classe utilisée
     */
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
            String sqlMedecins = "SELECT * FROM medecins WHERE CABNum=:cabNum";
            SQLQuery queryMedecins = session.createSQLQuery(sqlMedecins);
            queryMedecins.setInteger("cabNum", c.getCabNum());
            queryMedecins.addEntity(Medecins.class);
            medecins = queryMedecins.list();
        }
        return medecins;
    }

    public Medecins findById(int id) {
        Criteria criteria = session.createCriteria(entityClass);
        Criterion criterion = Restrictions.eq("medNum", id);
        return (Medecins) criteria.add(criterion).list().get(0);
    }
}
