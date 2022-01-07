package entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "stocks")
public class Stocks implements Serializable {
    @Id
    @Column(name = "MEDICCode")
    private String medicCode;

    @Id
    @Column(name = "CABNum")
    private Integer cabNum;

    @Column(name = "Qte")
    private Integer qte;

    public String getMedicCode() {
        return this.medicCode;
    }

    public void setMedicCode(String medicCode) {
        this.medicCode = medicCode;
    }

    public Integer getCabNum() {
        return this.cabNum;
    }

    public void setCabNum(Integer cabNum) {
        this.cabNum = cabNum;
    }

    public Integer getQte() {
        return this.qte;
    }

    public void setQte(Integer qte) {
        this.qte = qte;
    }
}
