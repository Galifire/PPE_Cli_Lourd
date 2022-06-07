package entities;

import controllers.admin.ErreurController;
import windows.admin.Erreur;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "commandes")
public class Commandes implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "CDENum")
    private Integer cdeNum;

    @Id
    @Column(name = "CLINum")
    private Integer cliNum;

    @Id
    @Column(name = "MEDICNum")
    private Integer medicNum;

    @Id
    @Column(name = "DateCde")
    private String dateCde;

    @Column(name = "Qte")
    private Integer qte;

    public Integer getCdeNum() {
        return this.cdeNum;
    }

    public void setCdeNum(Integer cdeNum) {
        this.cdeNum = cdeNum;
    }

    public Integer getCliNum() {
        return this.cliNum;
    }

    public void setCliNum(Integer cliNum) {
        this.cliNum = cliNum;
    }

    public Integer getMedicNum() {
        return this.medicNum;
    }

    public void setMedicNum(Integer medicNum) {
        this.medicNum = medicNum;
    }

    public String getDateCde() {
        return this.dateCde;
    }

    public void setDateCde(String dateCde) {
        if (dateCde.length() <= 0) {
            Erreur err = new Erreur();
            new ErreurController(err, "La date ne doit pas être vide");
            err.setVisible(true);
        } else if (dateCde.length() > 15) {
            Erreur err = new Erreur();
            new ErreurController(err, "La date de doit pas excéder 15 caractères");
            err.setVisible(true);
        } else {
            this.dateCde = dateCde;
        }
    }

    public Integer getQte() {
        return this.qte;
    }

    public void setQte(Integer qte) {
        this.qte = qte;
    }
}
