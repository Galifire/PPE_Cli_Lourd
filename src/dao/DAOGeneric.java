package dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;

import java.util.ArrayList;

public abstract class DAOGeneric<E> {

    protected Session session;
    protected Class<E> entityClass;

    /**
     *
     * @param session données de session
     * @param entityClass paramètre générique pouvant changer de classe en fonction de l'objet et de la méthode utilisée
     */
    public DAOGeneric(Session session, Class<E> entityClass) {
        this.session = session;
        this.entityClass = entityClass;
    }

    /**
     *
     * @param id id d'un objet
     * @return un objet d'une classe, correspondant à l'id passé en paramètre
     */
    public E find(int id) {
        return (E) session.get(entityClass, id);
    }

    /**
     *
     * @param entity entité d'une classe générique
     *               Permet de sauvegarder ou de mettre à jour des données
     */
    public void saveOrUpdate(E entity) {
        session.getTransaction().begin();
        session.saveOrUpdate(entity);
        session.getTransaction().commit();
    }

    /**
     *
     * @param entity entité d'une classe générique
     *               Permet de supprimer des données
     */
    public void delete(E entity) {
        session.getTransaction().begin();
        session.delete(entity);
        session.getTransaction().commit();
    }

    /**
     *
     * @return liste contenant toutes les données d'une classe
     */
    public ArrayList<E> findAll() {
        return (ArrayList<E>) session.createQuery("FROM " + entityClass.getName()).list();
    }

    /**
     *
     * @return retourne le nombre de données contenues dans une table en fonction de la classe mère
     */
    public long count() {
        Criteria criteria = session.createCriteria(entityClass);
        criteria.setProjection(Projections.rowCount());
        return (long) criteria.uniqueResult();
    }
}

