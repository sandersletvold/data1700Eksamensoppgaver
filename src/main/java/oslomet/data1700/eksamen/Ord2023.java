package oslomet.data1700.eksamen;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Person")
public class Ord2023 {
    @Id
    @GeneratedValue
    private Integer id;
    private String fornavn;
    private String etternavn;
    private String fodselsdato;
    private String personnr;
    private String telefonnr;
    private String email;
    private String by;
    private String gatenavn;

    // AllArgsConstructor
    public Ord2023(Integer id, String fornavn, String etternavn, String fodselsdato, String personnr, String telefonnr, String email, String by, String gatenavn) {
        this.id = id;
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        this.fodselsdato = fodselsdato;
        this.personnr = personnr;
        this.telefonnr = telefonnr;
        this.email = email;
        this.by = by;
        this.gatenavn = gatenavn;
    }

    // NoArgsConstructor
    public Ord2023() {

    }

    // Getter
    public Integer getId() {
        return id;
    }

    // Setter
    public void setId(Integer id) {
        this.id = id;
    }

    public String getFornavn() {
        return fornavn;
    }

    public void setFornavn(String fornavn) {
        this.fornavn = fornavn;
    }

    public String getEtternavn() {
        return etternavn;
    }

    public void setEtternavn(String etternavn) {
        this.etternavn = etternavn;
    }

    public String getFodselsdato() {
        return fodselsdato;
    }

    public void setFodselsdato(String fodselsdato) {
        this.fodselsdato = fodselsdato;
    }

    public String getPersonnr() {
        return personnr;
    }

    public void setPersonnr(String personnr) {
        this.personnr = personnr;
    }

    public String getTelefonnr() {
        return telefonnr;
    }

    public void setTelefonnr(String telefonnr) {
        this.telefonnr = telefonnr;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBy() {
        return by;
    }

    public void setBy(String by) {
        this.by = by;
    }

    public String getGatenavn() {
        return gatenavn;
    }

    public void setGatenavn(String gatenavn) {
        this.gatenavn = gatenavn;
    }
}

