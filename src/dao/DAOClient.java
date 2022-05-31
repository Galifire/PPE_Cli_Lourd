package dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import entities.Client;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DAOClient extends DAOGeneric{

    /**
     *
     * @param session données de session
     * @param entityClass permet de déterminer dynamiquement la classe utilisée
     */
    public DAOClient(Session session, Class entityClass) {
        super(session, entityClass);
    }

    /**
     *
     * @param id id du paramètre
     * @return objet de la classe
     */
    public Client findById(int id) {
        Criteria criteria = session.createCriteria(entityClass);
        Criterion criterion = Restrictions.eq("cliNum", id);
        return (Client) criteria.add(criterion).list().get(0);
    }
}
