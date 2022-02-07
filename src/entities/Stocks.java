package entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "stocks")
public class Stocks implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "STOCKNum")
    private Integer stockNum;

    @Column(name = "MEDICNum")
    private Integer medicNum;

    @Column(name = "PHARNum")
    private Integer pharNum;

    @Column(name = "Qte")
    private Integer qte;

    public Integer getStockNum() {
        return stockNum;
    }

    public void setStockNum(Integer stockNum) {
        this.stockNum = stockNum;
    }

    public Integer getMedicNum() {
        return this.medicNum;
    }

    public void setMedicNum(Integer medicNum) {
        this.medicNum = medicNum;
    }

    public Integer getPharNum() {
        return this.pharNum;
    }

    public void setPharNum(Integer cabNum) {
        this.pharNum = cabNum;
    }

    public Integer getQte() {
        return this.qte;
    }

    public void setQte(Integer qte) {
        this.qte = qte;
    }
}
