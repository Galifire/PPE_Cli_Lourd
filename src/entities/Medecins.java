package entities;

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
        this.nom = nom;
    }

    public String getPrenom() {
        return this.prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return this.adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return this.telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
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
