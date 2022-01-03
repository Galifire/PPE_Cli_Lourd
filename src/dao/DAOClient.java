package dao;

import org.hibernate.Session;
import entities.Client;

public class DAOClient extends DAOGeneric{

    public DAOClient(Session session, Class entityClass) {
        super(session, entityClass);
    }

}
