package entities;

import javax.persistence.*;

@Entity
@Table(name = "cabinet_medical")
public class CabinetMedical {
    @Id
    @Column(name = "CABNum")
    private Integer cabNum;

    @Column(name = "Nom")
    private String nom;

    @Column(name = "Adresse")
    private String adresse;

    @Column(name = "Effectif")
    private Integer effectif;

    @Column(name = "Horaires")
    private String horaires;

    public Integer getCabNum() {
        return this.cabNum;
    }

    public void setCabNum(Integer cabNum) {
        this.cabNum = cabNum;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
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

    public String getHoraires() {
        return this.horaires;
    }

    public void setHoraires(String horaires) {
        this.horaires = horaires;
    }
}
