package oslomet.data1700.eksamen;

import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
public class Ord2022Controller {
    private Logger logger;

    @Autowired
    private HttpSession session;

    @Autowired
    private JdbcTemplate db;

    // Oppgave 1
    @GetMapping("/sjekk")
    public String sjekk() {
        return "OK";
    }

    // INNLOGGING UTEN KRYPTERING
    @GetMapping("/login")
    public boolean login(Ord2022Bruker bruker) {
        String sql = "SELECT COUNT(*) FROM Kunde WHERE NAVN = ? AND PASSORD = ?";
        try {
            int funnetEnBruker = db.queryForObject(sql, Integer.class, bruker.getNAVN(), bruker.getPASSORD());
            if (funnetEnBruker > 0){
                session.setAttribute("Innlogget", true);
                return true;
            }
            else {
                return false;
            }
        }
        catch (Exception e) {
            return false;
        }
    }

    // UTLOGGING
    @GetMapping("/logut")
    public void loggUt(){
        session.removeAttribute("Innlogget");
    }
}
