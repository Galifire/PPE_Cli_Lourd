package dao;

import entities.Commandes;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

public class DAOCommandes extends DAOGeneric {

    /**
     *
     * @param session données de session
     * @param entityClass permet de déterminer dynamiquement la classe utilisée
     */
    public DAOCommandes(Session session, Class entityClass) {
        super(session, entityClass);
    }

    public Commandes findById(int id) {
        Criteria criteria = session.createCriteria(entityClass);
        Criterion criterion = Restrictions.eq("cdeNum", id);
        return (Commandes) criteria.add(criterion).list().get(0);
    }
}
