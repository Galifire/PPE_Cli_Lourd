package entities;

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
        this.dateCde = dateCde;
    }

    public Integer getQte() {
        return this.qte;
    }

    public void setQte(Integer qte) {
        this.qte = qte;
    }
}
