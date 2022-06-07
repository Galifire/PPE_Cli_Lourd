package entities;

import controllers.admin.ErreurController;
import windows.admin.Erreur;

import javax.persistence.*;

@Entity
@Table(name = "medicaments")
public class Medicaments {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "MEDICNum")
    private Integer medicNum;

    @Column(name = "Nom")
    private String nom;

    @Column(name = "Restrictions")
    private String restrictions;

    @Column(name = "DelaiProduction")
    private Integer delaiProduction;

    public Integer getMedicNum() {
        return this.medicNum;
    }

    public void setMedicNum(Integer medicNum) {
        this.medicNum = medicNum;
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

    public String getRestrictions() {
        return this.restrictions;
    }

    public void setRestrictions(String restrictions) {
        if (restrictions.length() > 255) {
            Erreur err = new Erreur();
            new ErreurController(err, "La donnée rentrée est trop longue");
            err.setVisible(true);
        } else {
            this.restrictions = restrictions;
        }
    }

    public Integer getDelaiProduction() {
        return this.delaiProduction;
    }

    public void setDelaiProduction(Integer delaiProduction) {
        this.delaiProduction = delaiProduction;
    }
}
