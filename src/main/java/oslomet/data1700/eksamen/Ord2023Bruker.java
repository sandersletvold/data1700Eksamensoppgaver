package oslomet.data1700.eksamen;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
@Table(name = "Bruker")
public class Ord2023Bruker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonProperty("nyttBrukernavn")
    private String brukernavn;

    @JsonProperty("nyttPassord")
    private String passord;

    // AllArgsConstructor
    public Ord2023Bruker(Integer id, String brukernavn, String passord) {
        this.id = id;
        this.brukernavn = brukernavn;
        this.passord = passord;
    }

    // NoArgsConstructor
    public Ord2023Bruker() {

    }

    // CustomConstructor
    public Ord2023Bruker(String brukernavn, String passord) {
        this.brukernavn = brukernavn;
        this.passord = passord;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrukernavn() {
        return brukernavn;
    }

    public void setBrukernavn(String brukernavn) {
        this.brukernavn = brukernavn;
    }

    public String getPassord() {
        return passord;
    }

    public void setPassord(String passord) {
        this.passord = passord;
    }
}