package dao;

import org.hibernate.Session;

public class DAORole extends DAOGeneric {

    public DAORole(Session session, Class entityClass) {
        super(session, entityClass);
    }
}
