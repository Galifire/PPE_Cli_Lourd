package dao;

import entities.Stocks;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

public class DAOStocks extends DAOGeneric {

    public DAOStocks(Session session, Class entityClass) {
        super(session, entityClass);
    }

    public Stocks findById(int id) {
        Criteria criteria = session.createCriteria(entityClass);
        Criterion criterion = Restrictions.eq("stockNum", id);
        return (Stocks) criteria.add(criterion).list().get(0);
    }

}
