package dao;

import entities.Stocks;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

public class DAOStocks extends DAOGeneric {

    /**
     *
     * @param session données de session
     * @param entityClass permet de déterminer dynamiquement la classe utilisée
     */
    public DAOStocks(Session session, Class entityClass) {
        super(session, entityClass);
    }

    public Stocks findById(int id) {
        Criteria criteria = session.createCriteria(entityClass);
        Criterion criterion = Restrictions.eq("stockNum", id);
        return (Stocks) criteria.add(criterion).list().get(0);
    }

}
