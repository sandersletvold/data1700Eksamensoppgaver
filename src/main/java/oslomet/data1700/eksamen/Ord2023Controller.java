package oslomet.data1700.eksamen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Ord2023Controller {
    @Autowired
    private JdbcTemplate db;

    @PostMapping("/saveCitizen")
    public void saveCitizen(Ord2023 person) {
        String sql = "INSERT INTO Person (fornavn, etternavn, fodselsdato, personnr, telefonnr, email, by, gatenavn) VALUES (?,?,?,?,?,?,?,?)";
        db.update(sql, person.getFornavn(), person.getEtternavn(), person.getFodselsdato(), person.getPersonnr(), person.getTelefonnr(), person.getEmail(), person.getBy(), person.getGatenavn());
    }
}
