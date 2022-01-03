package dao;

import org.hibernate.Session;

public class DAOCommandes extends DAOGeneric {

    public DAOCommandes(Session session, Class entityClass) {
        super(session, entityClass);
    }

}
