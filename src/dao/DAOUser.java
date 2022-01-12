package dao;

import entities.User;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import utils.HibernateUtil;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class DAOUser extends DAOGeneric {

    public DAOUser(Session session, Class entityClass) {
        super(session, entityClass);
    }

    public boolean findByCreds(String username, String pwd) {
        Criteria criteria = session.createCriteria(User.class);
        Criterion criterion = Restrictions.and(
                Restrictions.eq("username", username),
                Restrictions.eq("password", pwd)
        );
        criteria.add(criterion);

        return criteria.list().isEmpty();

    }
}
