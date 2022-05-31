package dao;

import entities.Medicaments;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

public class DAOMedicaments extends DAOGeneric {

    /**
     *
     * @param session données de session
     * @param entityClass permet de déterminer dynamiquement la classe utilisée
     */
    public DAOMedicaments(Session session, Class entityClass) {
        super(session, entityClass);
    }

    public Medicaments findById(int id) {
        Criteria criteria = session.createCriteria(entityClass);
        Criterion criterion = Restrictions.eq("medicNum", id);
        return (Medicaments) criteria.add(criterion).list().get(0);
    }
}
