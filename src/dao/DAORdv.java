package dao;

import entities.Rdv;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

public class DAORdv extends DAOGeneric {

    /**
     *
     * @param session données de session
     * @param entityClass permet de déterminer dynamiquement la classe utilisée
     */
    public DAORdv(Session session, Class entityClass) {
        super(session, entityClass);
    }

    public Rdv findById(int id) {
        Criteria criteria = session.createCriteria(entityClass);
        Criterion criterion = Restrictions.eq("rdvNum", id);
        return (Rdv) criteria.add(criterion).list().get(0);
    }
}
