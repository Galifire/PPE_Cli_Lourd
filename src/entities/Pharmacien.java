package entities;

import javax.persistence.*;

@Entity
@Table(name = "pharmacien")
public class Pharmacien {
    @Id
    @Column(name = "PHNum")
    private Integer phNum;

    @Column(name = "Nom")
    private String nom;

    @Column(name = "Prenom")
    private String prenom;

    @Column(name = "Email")
    private String email;

    @Column(name = "Telephone")
    private String telephone;

    @Column(name = "PHARNum")
    private Integer pharNum;

    public Integer getPhNum() {
        return this.phNum;
    }

    public void setPhNum(Integer phNum) {
        this.phNum = phNum;
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

    public Integer getPharNum() {
        return this.pharNum;
    }

    public void setPharNum(Integer pharNum) {
        this.pharNum = pharNum;
    }
}
