package entities;

import controllers.admin.ErreurController;
import windows.admin.Erreur;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "medecins")
public class Medecins implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "MEDNum")
    private Integer medNum;

    @Column(name = "Nom")
    private String nom;

    @Column(name = "Prenom")
    private String prenom;

    @Column(name = "Adresse")
    private String adresse;

    @Column(name = "Email")
    private String email;

    @Column(name = "Telephone")
    private String telephone;

    @Column(name = "CABNum")
    private Integer cabNum;

    public Integer getMedNum() {
        return this.medNum;
    }

    public void setMedNum(Integer medNum) {
        this.medNum = medNum;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        if (nom.length() <= 0) {
            Erreur err = new Erreur();
            new ErreurController(err, "le nom ne doit pas être vide");
            err.setVisible(true);
        } else if (nom.length() > 255) {
            Erreur err = new Erreur();
            new ErreurController(err, "le nom est trop long");
            err.setVisible(true);
        } else {
            this.nom = nom;
        }
    }

    public String getPrenom() {
        return this.prenom;
    }

    public void setPrenom(String prenom) {
        if (prenom.length() <= 0) {
            Erreur err = new Erreur();
            new ErreurController(err, "Le prénom ne peut pas être vide");
            err.setVisible(true);
        } else if (prenom.length() > 255) {
            Erreur err = new Erreur();
            new ErreurController(err, "Le prénom est trop long");
            err.setVisible(true);
        } else {
            this.prenom = prenom;
        }
    }

    public String getAdresse() {
        return this.adresse;
    }

    public void setAdresse(String adresse) {
        if (adresse.length() <= 0) {
            Erreur err = new Erreur();
            new ErreurController(err, "L'adresse ne peut pas être vide");
            err.setVisible(true);
        } else if (adresse.length() > 255) {
            Erreur err = new Erreur();
            new ErreurController(err, "L'adresse est trop longue");
            err.setVisible(true);
        } else {
            this.adresse = adresse;
        }
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        if (email.length() <= 0) {
            Erreur err = new Erreur();
            new ErreurController(err, "L'email ne doit pas être vide");
            err.setVisible(true);
        } else if (email.length() > 255) {
            Erreur err = new Erreur();
            new ErreurController(err, "L'email est trop long");
            err.setVisible(true);
        } else {
            this.email = email;
        }
    }

    public String getTelephone() {
        return this.telephone;
    }

    public void setTelephone(String telephone) {
        if (telephone.length() <= 0) {
            Erreur err = new Erreur();
            new ErreurController(err, "Le numéro de téléphone ne peut pas être vide");
            err.setVisible(true);
        } else if (telephone.length() > 10) {
            Erreur err = new Erreur();
            new ErreurController(err, "Le numéro de téléphone ne doit pas excéder 10 caractères");
            err.setVisible(true);
        } else {
            this.telephone = telephone;
        }
    }

    public Integer getCabNum() {
        return this.cabNum;
    }

    public void setCabNum(Integer cabNum) {
        this.cabNum = cabNum;
    }

    @Override
    public String toString() {
        return "Medecins{" +
                "medNum=" + medNum +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", adresse='" + adresse + '\'' +
                ", email='" + email + '\'' +
                ", telephone='" + telephone + '\'' +
                ", cabNum=" + cabNum +
                '}';
    }
}
