package dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;

import java.util.ArrayList;

public abstract class DAOGeneric<E> {

    protected Session session;
    protected Class<E> entityClass;

    public DAOGeneric(Session session, Class<E> entityClass) {
        this.session = session;
        this.entityClass = entityClass;
    }

    public E find(String id) {
        E entity = (E) session.get(entityClass, id);
        return entity;
    }

    public void saveOrUpdate(E entity) {
        session.getTransaction().begin();
        session.saveOrUpdate(entity);
        session.getTransaction().commit();
    }

    public void delete(E entity) {
        session.getTransaction().begin();
        session.delete(entity);
        session.getTransaction().commit();
    }

    public ArrayList<E> findAll() {
        return (ArrayList<E>) session.createQuery("FROM " + entityClass.getName()).list();
    }

    public long count() {
        Criteria criteria = session.createCriteria(entityClass);
        criteria.setProjection(Projections.rowCount());
        long row = (long) criteria.uniqueResult();
        return row;
    }
}

