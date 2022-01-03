package dao;

import org.hibernate.Session;

public class DAORdv extends DAOGeneric
{
    public DAORdv(Session session, Class entityClass) {
        super(session, entityClass);
    }

}
