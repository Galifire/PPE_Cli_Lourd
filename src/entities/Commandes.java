package entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "commandes")
public class Commandes implements Serializable {
    @Id
    @Column(name = "CDENum")
    private Integer cdeNum;

    @Id
    @Column(name = "CLINum")
    private Integer cliNum;

    @Id
    @Column(name = "MEDICCode")
    private String medicCode;

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

    public String getMedicCode() {
        return this.medicCode;
    }

    public void setMedicCode(String medicCode) {
        this.medicCode = medicCode;
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
