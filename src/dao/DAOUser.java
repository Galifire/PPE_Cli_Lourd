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

    public DAOUser(Session session, Class entityClass) {
        super(session, entityClass);
    }

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

    public boolean checkCreds(String username, String pwd) {
        Criteria criteria = session.createCriteria(User.class);
        Criterion criterion = Restrictions.and(
                Restrictions.eq("username", username),
                Restrictions.eq("password", pwd)
        );
        criteria.add(criterion);
        return criteria.list().isEmpty();
    }

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

    public boolean userNotExists(String username) {
        Criteria criteria = session.createCriteria(User.class);
        Criterion criterion = Restrictions.eq("username", username);
        criteria.add(criterion);
        return criteria.list().isEmpty();
    }
}
