package oslomet.data1700.eksamen;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name = "Bestilling")
public class Ord2022 {
    @Id
    @GeneratedValue
    private Integer BID;
    private Integer KID;
    private Integer BORD;
    private Timestamp MOTTATT;
    private String VARER;

    public Ord2022(Integer BID, Integer KID, Integer BORD, Timestamp MOTTATT, String VARER) {
        this.BID = BID;
        this.KID = KID;
        this.BORD = BORD;
        this.MOTTATT = MOTTATT;
        this.VARER = VARER;
    }

    public Ord2022() {

    }

    public Integer getBID() {
        return BID;
    }

    public void setBID(Integer BID) {
        this.BID = BID;
    }

    public Integer getKID() {
        return KID;
    }

    public void setKID(Integer KID) {
        this.KID = KID;
    }

    public Integer getBORD() {
        return BORD;
    }

    public void setBORD(Integer BORD) {
        this.BORD = BORD;
    }

    public Timestamp getMOTTATT() {
        return MOTTATT;
    }

    public void setMOTTATT(Timestamp MOTTATT) {
        this.MOTTATT = MOTTATT;
    }

    public String getVARER() {
        return VARER;
    }

    public void setVARER(String VARER) {
        this.VARER = VARER;
    }
}
