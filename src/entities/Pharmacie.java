package entities;

import javax.persistence.*;

@Entity
@Table(name = "pharmacie")
public class Pharmacie {
    @Id
    @Column(name = "PHARNum")
    private Integer pharNum;

    @Column(name = "Nom")
    private String nom;

    @Column(name = "Ville")
    private String ville;

    @Column(name = "CodePostal")
    private String codePostal;

    @Column(name = "Adresse")
    private String adresse;

    @Column(name = "Effectif")
    private Integer effectif;

    public Integer getPharNum() {
        return this.pharNum;
    }

    public void setPharNum(Integer pharNum) {
        this.pharNum = pharNum;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getVille() {
        return this.ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getCodePostal() {
        return this.codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getAdresse() {
        return this.adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Integer getEffectif() {
        return this.effectif;
    }

    public void setEffectif(Integer effectif) {
        this.effectif = effectif;
    }
}
