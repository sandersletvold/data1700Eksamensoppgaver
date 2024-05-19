package oslomet.data1700.eksamen;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;

@RestController
public class Ord2023Controller {
    @Autowired
    private JdbcTemplate db;

    @Autowired
    HttpSession session;

    private Logger logger = LoggerFactory.getLogger(Ord2023Controller.class);

    // LAGRE PERSON
    @PostMapping("/saveCitizen")
    public void saveCitizen(Ord2023 person, HttpServletResponse response) throws IOException {
        if (session.getAttribute("loggetInn") != null) {
            String sql = "INSERT INTO Person (fornavn, etternavn, fodselsdato, personnr, telefonnr, email, by, gatenavn) VALUES (?,?,?,?,?,?,?,?)";
            try {
                db.update(sql, person.getFornavn(), person.getEtternavn(), person.getFodselsdato(), person.getPersonnr(), person.getTelefonnr(), person.getEmail(), person.getBy(), person.getGatenavn());
            } catch (Exception e) {
                logger.error("Feil ved å lagre personen til databasen: "+e);
                response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Feil ved lagring i database");
            }
        } else {
            response.sendError(HttpStatus.NOT_FOUND.value());
        }
    }


    // OPPRETTE BRUKER
    @PostMapping("/signUp")
    public void signUp(@RequestBody Ord2023Bruker bruker) {
        if (validerKunde(bruker)) {
            String hash = krypterPassord(bruker.getPassord());
            String sql = "INSERT INTO Bruker (brukernavn, passord) VALUES(?,?)";
            try {
                db.update(sql, bruker.getBrukernavn(), hash);
            } catch (Exception e) {
                logger.error("Feil ved å lagre ny kunde i database: " + e);
            }
        } else {
            logger.warn("Validering feilet for bruker: " + bruker.getBrukernavn());
        }
    }

    private boolean validerKunde(Ord2023Bruker bruker){
        String regexNavn = "^[a-zA-Z\\s]+";
        String regexPassord = "(?=.*[a-zA-ZæøåÆØÅ])(?=.*\\d)[a-zA-ZæøåÆØÅ\\d]{8,}";
        boolean navnOK = bruker.getBrukernavn().matches(regexNavn);
        boolean passordOK = bruker.getPassord().matches(regexPassord);
        if (navnOK && passordOK){
            return true;
        } else {
            return false;
        }
    }

    private String krypterPassord(String passord){
        BCryptPasswordEncoder bCrypt = new BCryptPasswordEncoder(14);
        String hashedPassord = bCrypt.encode(passord);
        return hashedPassord;
    }


    // INNLOGGING
    @GetMapping("/loggInn")
    public boolean loggInn(Ord2023Bruker bruker) {
        if (sjekkNavnOgPassord(bruker)) {
            session.setAttribute("loggetInn", bruker);
            return true;
        } else {
            return false;
        }
    }

    public boolean sjekkNavnOgPassord (Ord2023Bruker bruker) {
        String sql = "SELECT * FROM Bruker WHERE brukernavn=?";
        try{
            Ord2023Bruker dbKunde = db.queryForObject(sql,
                    BeanPropertyRowMapper.newInstance(Ord2023Bruker.class),new Object[]{bruker.getBrukernavn()});
            if (sjekkPassord(dbKunde.getPassord(), bruker.getPassord())) {
                return true;
            } else {
                return false;
            }
        }
        catch(Exception e) {
            logger.error("Feil i sjekkNavnOgPassord : " + e);
            return false;
        }
    }

    private boolean sjekkPassord(String hashPassord, String passord){
        BCryptPasswordEncoder bCrypt = new BCryptPasswordEncoder();
        if (bCrypt.matches(passord, hashPassord)){
            return true;
        }
        return false;
    }


    // LOGG UT
    @GetMapping("/signOut")
    public void signOut() {
        session.removeAttribute("loggetInn");
    }
}
