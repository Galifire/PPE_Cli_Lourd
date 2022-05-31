package dao;

import entities.Pharmacie;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

public class DAOPharmacie extends DAOGeneric {

    /**
     *
     * @param session données de session
     * @param entityClass permet de déterminer dynamiquement la classe utilisée
     */
    public DAOPharmacie(Session session, Class entityClass) {
        super(session, entityClass);
    }

    public Pharmacie findById(int id) {
        Criteria criteria = session.createCriteria(entityClass);
        Criterion criterion = Restrictions.eq("pharNum", id);
        return (Pharmacie) criteria.add(criterion).list().get(0);
    }
}
