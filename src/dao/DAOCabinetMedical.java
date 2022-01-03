package dao;

import org.hibernate.Session;
import entities.CabinetMedical;

public class DAOCabinetMedical extends DAOGeneric {

    public DAOCabinetMedical(Session session, Class entityClass) {
        super(session, entityClass);
    }

}
