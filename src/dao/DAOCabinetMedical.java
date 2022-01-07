package dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import entities.CabinetMedical;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DAOCabinetMedical extends DAOGeneric {

    public DAOCabinetMedical(Session session, Class entityClass) {
        super(session, entityClass);
    }

    public List<CabinetMedical> findById(int id) {
        Criteria criteria = session.createCriteria(entityClass);
        Criterion criterion = Restrictions.eq("cabNum", id);
        return criteria.add(criterion).list();
    }
}
