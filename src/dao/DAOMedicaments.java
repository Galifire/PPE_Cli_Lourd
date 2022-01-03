package dao;

import org.hibernate.Session;

public class DAOMedicaments extends DAOGeneric {

    public DAOMedicaments(Session session, Class entityClass) {
        super(session, entityClass);
    }

}
