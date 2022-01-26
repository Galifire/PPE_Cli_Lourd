package dao;

import entities.Pharmacie;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

public class DAOPharmacie extends DAOGeneric {

    public DAOPharmacie(Session session, Class entityClass) {
        super(session, entityClass);
    }

    public Pharmacie findById(int id) {
        Criteria criteria = session.createCriteria(entityClass);
        Criterion criterion = Restrictions.eq("pharNum", id);
        return (Pharmacie) criteria.add(criterion).list().get(0);
    }
}
