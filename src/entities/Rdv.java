package entities;

import controllers.admin.ErreurController;
import windows.admin.Erreur;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "rdv")
public class Rdv implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "RDVNum")
    private Integer rdvNum;

    @Column(name = "MEDNum")
    private Integer medNum;

    @Column(name = "CLINum")
    private Integer cliNum;

    @Column(name = "DateRdv")
    private String dateRdv;

    @Column(name = "Heure")
    private String heure;

    @Column(name = "Duree")
    private Integer duree;

    @Column(name = "Prix")
    private Integer prix;

    @Column(name = "Commentaires")
    private String commentaires;

    public Integer getRdvNum() {
        return this.rdvNum;
    }

    public void setRdvNum(Integer rdvNum) {
        this.rdvNum = rdvNum;
    }

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

    public String getDateRdv() {
        return this.dateRdv;
    }

    public void setDateRdv(String dateRdv) {
        if (dateRdv.length() <= 0) {
            Erreur err = new Erreur();
            new ErreurController(err, "La date ne peut pas être vide");
            err.setVisible(true);
        } else if (dateRdv.length() > 15) {
            Erreur err = new Erreur();
            new ErreurController(err, "La date est trop longue");
            err.setVisible(true);
        } else {
            this.dateRdv = dateRdv;
        }
    }

    public String getHeure() {
        return this.heure;
    }

    public void setHeure(String heure) {
        if (heure.length() <= 0) {
            Erreur err = new Erreur();
            new ErreurController(err, "L'heure ne peut pas être vide");
            err.setVisible(true);
        } else if (heure.length() > 15) {
            Erreur err = new Erreur();
            new ErreurController(err, "L'heure dépasse la limite");
            err.setVisible(true);
        } else {
            this.heure = heure;
        }
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
        if (commentaires.length() > 255) {
            Erreur err = new Erreur();
            new ErreurController(err, "Le commentaire rentré est trop long");
            err.setVisible(true);
        } else {
            this.commentaires = commentaires;
        }
    }
}
