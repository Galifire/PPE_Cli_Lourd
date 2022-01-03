package dao;

import org.hibernate.Session;

public class DAOMedecins extends DAOGeneric {

    public DAOMedecins(Session session, Class entityClass) {
        super(session, entityClass);
    }

}
