package dao;

import entities.Pharmacien;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

public class DAOPharmacien extends DAOGeneric {

    public DAOPharmacien(Session session, Class entityClass) {
        super(session, entityClass);
    }

    public Pharmacien findById(int id) {
        Criteria criteria = session.createCriteria(entityClass);
        Criterion criterion = Restrictions.eq("phNum", id);
        return (Pharmacien) criteria.add(criterion).list().get(0);
    }
}
