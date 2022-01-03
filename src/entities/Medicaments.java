package entities;

import javax.persistence.*;

@Entity
@Table(name = "medicaments")
public class Medicaments {
    @Id
    @Column(name = "MEDICCode")
    private String medicCode;

    @Column(name = "Nom")
    private String nom;

    @Column(name = "Restrictions")
    private String restrictions;

    @Column(name = "DelaiProduction")
    private Integer delaiProduction;

    public String getMedicCode() {
        return this.medicCode;
    }

    public void setMedicCode(String medicCode) {
        this.medicCode = medicCode;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getRestrictions() {
        return this.restrictions;
    }

    public void setRestrictions(String restrictions) {
        this.restrictions = restrictions;
    }

    public Integer getDelaiProduction() {
        return this.delaiProduction;
    }

    public void setDelaiProduction(Integer delaiProduction) {
        this.delaiProduction = delaiProduction;
    }
}
