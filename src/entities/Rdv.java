package entities;

import javax.persistence.*;

@Entity
@Table(name = "rdv")
public class Rdv {
    @Id
    @Column(name = "MEDNum")
    private Integer medNum;

    @Id
    @Column(name = "CLINum")
    private Integer cliNum;

    @Id
    @Column(name = "DateRdv")
    private java.sql.Date dateRdv;

    @Column(name = "Heure")
    private java.sql.Time heure;

    @Column(name = "Duree")
    private Integer duree;

    @Column(name = "Prix")
    private Integer prix;

    @Column(name = "Commentaires")
    private String commentaires;

    public Integer getMedNum() {
        return this.medNum;
    }

    public void setMedNum(Integer medNum) {
        this.medNum = medNum;
    }

    public Integer getCliNum() {
        return this.cliNum;
    }

    public void setCliNum(Integer cliNum) {
        this.cliNum = cliNum;
    }

    public java.sql.Date getDateRdv() {
        return this.dateRdv;
    }

    public void setDateRdv(java.sql.Date dateRdv) {
        this.dateRdv = dateRdv;
    }

    public java.sql.Time getHeure() {
        return this.heure;
    }

    public void setHeure(java.sql.Time heure) {
        this.heure = heure;
    }

    public Integer getDuree() {
        return this.duree;
    }

    public void setDuree(Integer duree) {
        this.duree = duree;
    }

    public Integer getPrix() {
        return this.prix;
    }

    public void setPrix(Integer prix) {
        this.prix = prix;
    }

    public String getCommentaires() {
        return this.commentaires;
    }

    public void setCommentaires(String commentaires) {
        this.commentaires = commentaires;
    }
}
