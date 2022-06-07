package entities;

import controllers.admin.ErreurController;
import windows.admin.Erreur;

import javax.persistence.*;

@Entity
@Table(name = "pharmacie")
public class Pharmacie {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
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

    public String getVille() {
        return this.ville;
    }

    public void setVille(String ville) {
        if (ville.length() <= 0) {
            Erreur err = new Erreur();
            new ErreurController(err, "Le champ ne peut pas être vide");
            err.setVisible(true);
        } else if (ville.length() > 255) {
            Erreur err = new Erreur();
            new ErreurController(err, "le nom est trop long");
            err.setVisible(true);
        } else {
            this.ville = ville;
        }
    }

    public String getCodePostal() {
        return this.codePostal;
    }

    public void setCodePostal(String codePostal) {
        if (codePostal.length() <= 0) {
            Erreur err = new Erreur();
            new ErreurController(err, "Le champ ne peut pas être vide");
            err.setVisible(true);
        } else if (codePostal.length() > 8) {
            Erreur err = new Erreur();
            new ErreurController(err, "le code postal est trop long");
            err.setVisible(true);
        } else {
            this.codePostal = codePostal;
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

    public Integer getEffectif() {
        return this.effectif;
    }

    public void setEffectif(Integer effectif) {
        this.effectif = effectif;
    }
}
