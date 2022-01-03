package dao;

import org.hibernate.Session;

public class DAOStocks extends DAOGeneric {

    public DAOStocks(Session session, Class entityClass) {
        super(session, entityClass);
    }

}
