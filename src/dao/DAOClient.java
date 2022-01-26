package dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import entities.Client;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DAOClient extends DAOGeneric{

    public DAOClient(Session session, Class entityClass) {
        super(session, entityClass);
    }

    public Client findById(int id) {
        Criteria criteria = session.createCriteria(entityClass);
        Criterion criterion = Restrictions.eq("cliNum", id);
        return (Client) criteria.add(criterion).list().get(0);
    }
}
