package dao;

import org.hibernate.Session;

public class DAOPharmacie extends DAOGeneric {

    public DAOPharmacie(Session session, Class entityClass) {
        super(session, entityClass);
    }
}
