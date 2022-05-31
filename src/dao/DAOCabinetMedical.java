package dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import entities.CabinetMedical;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DAOCabinetMedical extends DAOGeneric {

    /**
     *
     * @param session données de session
     * @param entityClass permet de déterminer dynamiquement la classe utilisée
     */
    public DAOCabinetMedical(Session session, Class entityClass) {
        super(session, entityClass);
    }

    /**
     *
     * @param id id du paramètre
     * @return objet de la classe
     */
    public CabinetMedical findById(int id) {
        Criteria criteria = session.createCriteria(entityClass);
        Criterion criterion = Restrictions.eq("cabNum", id);
        return (CabinetMedical) criteria.add(criterion).list().get(0);
    }
}
