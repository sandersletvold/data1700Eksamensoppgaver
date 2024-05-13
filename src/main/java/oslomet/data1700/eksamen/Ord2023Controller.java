package oslomet.data1700.eksamen;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.apache.catalina.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;
import java.util.List;

@RestController
public class Ord2023Controller {
    @Autowired
    private JdbcTemplate db;

    @Autowired
    HttpSession session;

    private Logger logger = LoggerFactory.getLogger(Ord2023Controller.class);

    @PostMapping("/login")
    public void saveCitizen(User user, HttpServletResponse response) throws IOException {
        session.setAttribute("loggedIn", user);
    }

    @GetMapping("/removeUnderage")
    public boolean removeUnderage(HttpServletResponse response) throws IOException {
        String getCitizens = "SELECT * FROM Person";
        String removeCitizen = "DELETE FROM Person WHERE id = ?";

        if (session.getAttribute("loggedIn") != null) {
            try {
                List<Ord2023> personer = db.query(getCitizens, BeanPropertyRowMapper.newInstance(Ord2023.class));
                for (Ord2023 person : personer) {
                    if (person.getFornavn().equals("Sander")) { // Placeholder if-condition
                        // Sjekk om personen er over 18 år
                        db.update(removeCitizen, person.getId());
                    }
                }
                return true;
            } catch (Exception e) {
                logger.error("Feil ved å fjerne mindreåring fra databasen");
                response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value());
                return false;
            }
        } else {
            return false;
        }
    }

    @GetMapping("/logout")
    public void logout() {
        session.removeAttribute("loggedIn");
    }

    @PostMapping("/saveCitizen")
    public void saveCitizen(Ord2023 person, HttpServletResponse response) throws IOException {
        String sql = "INSERT INTO Person (fornavn, etternavn, fodselsdato, personnr, telefonnr, email, by, gatenavn) VALUES (?,?,?,?,?,?,?,?)";
        try {
            db.update(sql, person.getFornavn(), person.getEtternavn(), person.getFodselsdato(), person.getPersonnr(), person.getTelefonnr(), person.getEmail(), person.getBy(), person.getGatenavn());
        } catch (Exception e) {
            logger.error("Feil ved å lagre personen til databasen: "+e);
            response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Feil ved lagring i database");
        }
    }
}
