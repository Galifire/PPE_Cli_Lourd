package dao;

import entities.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public class DAOUser extends DAOGeneric {

    /**
     *
     * @param session données de session
     * @param entityClass permet de déterminer dynamiquement la classe utilisée
     */
    public DAOUser(Session session, Class entityClass) {
        super(session, entityClass);
    }

    /**
     *
     * @param pwd mot de passe passé
     * @return le mot de passe hashé en SHA-512
     */
    public String hashPwd(String pwd) {
        String hash = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            byte[] bytes = md.digest(pwd.getBytes(StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++){
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            hash = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return hash;
    }

    /**
     *
     * @param username nom d'utilisateur
     * @param pwd mot de passe
     * @return si les paramètres correspondent
     */
    public boolean checkCreds(String username, String pwd) {
        Criteria criteria = session.createCriteria(User.class);
        Criterion criterion = Restrictions.and(
                Restrictions.eq("username", username),
                Restrictions.eq("password", pwd)
        );
        criteria.add(criterion);
        return criteria.list().isEmpty();
    }

    /**
     *
     * @param username nom d'utilisateur
     * @param pwd mot de passe
     * @return un utilisateur si les paramètres passés correspondent, une liste vide sinon
     * @throws NoSuchAlgorithmException throw de l'exception
     */
    public User findByCreds(String username, String pwd) throws NoSuchAlgorithmException {
        Criteria criteria = session.createCriteria(User.class);
        Criterion criterion = Restrictions.and(
                Restrictions.eq("username", username),
                Restrictions.eq("password", pwd)
        );
        criteria.add(criterion);
        List<User> user = criteria.list();
        return user.get(0);

    }

    /**
     *
     * @param username nom d'utilisateur
     * @return vrai si il n'y a pas d'utilisateur correspondant au nom d'utilisateur passé en paramètre, faux sinon
     */
    public boolean userNotExists(String username) {
        Criteria criteria = session.createCriteria(User.class);
        Criterion criterion = Restrictions.eq("username", username);
        criteria.add(criterion);
        return criteria.list().isEmpty();
    }
}
