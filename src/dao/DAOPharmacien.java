package dao;

import org.hibernate.Session;

public class DAOPharmacien extends DAOGeneric {

    public DAOPharmacien(Session session, Class entityClass) {
        super(session, entityClass);
    }
}
