package oslomet.data1700.eksamen;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Kunde")
public class Ord2022Bruker {
    @Id
    @GeneratedValue
    private Integer KID;
    private String NAVN;
    private String MOBIL;
    private String EPOST;
    private String PASSORD;

    public Ord2022Bruker(String EPOST, String MOBIL, String NAVN, Integer KID, String PASSORD) {
        this.EPOST = EPOST;
        this.MOBIL = MOBIL;
        this.NAVN = NAVN;
        this.KID = KID;
        this.PASSORD = PASSORD;
    }

    public Ord2022Bruker() {

    }

    public Integer getKID() {
        return KID;
    }

    public void setKID(Integer KID) {
        this.KID = KID;
    }

    public String getNAVN() {
        return NAVN;
    }

    public void setNAVN(String NAVN) {
        this.NAVN = NAVN;
    }

    public String getMOBIL() {
        return MOBIL;
    }

    public void setMOBIL(String MOBIL) {
        this.MOBIL = MOBIL;
    }

    public String getEPOST() {
        return EPOST;
    }

    public void setEPOST(String EPOST) {
        this.EPOST = EPOST;
    }

    public String getPASSORD() {
        return PASSORD;
    }

    public void setPASSORD(String PASSORD) {
        this.PASSORD = PASSORD;
    }
}
