package entities;

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
