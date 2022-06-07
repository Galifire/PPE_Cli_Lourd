package entities;

import controllers.admin.ErreurController;
import windows.admin.Erreur;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "username")
    private String username;

    @Column(name = "role")
    private String role;

    @Column(name = "password")
    private String password;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        if (username.length() <= 0) {
            Erreur err = new Erreur();
            new ErreurController(err, "Le nom d'utilisateur ne peut pas être vide");
            err.setVisible(true);
        } else if (username.length() > 255) {
            Erreur err = new Erreur();
            new ErreurController(err, "Le nom d'utilisateur est trop long");
            err.setVisible(true);
        } else {
            this.username = username;
        }
    }

    public String getRole() {
        return this.role;
    }

    public void setRole(String role) {
        if (role.length() > 255) {
            Erreur err = new Erreur();
            new ErreurController(err, "Le nom rôle est trop long");
            err.setVisible(true);
        } else {
            this.username = role;
        }
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
