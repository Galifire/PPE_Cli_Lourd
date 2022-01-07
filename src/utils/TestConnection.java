package utils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConnection {
    Connection cnx;

    public TestConnection() {
    }

    public void init() {
        try {
            cnx = DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3306/ppe_lourd_gestionrdv_db?user=ppe_userdb&password=123+aze");
            System.out.println("DB OK");
        } catch (SQLException e) {
            System.out.println("DB KO");
            e.printStackTrace();
        }

    }
}