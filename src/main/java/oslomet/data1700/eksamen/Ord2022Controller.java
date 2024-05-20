package oslomet.data1700.eksamen;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Ord2022Controller {
    private Logger logger;

    // Oppgave 1
    @GetMapping("/sjekk")
    public String sjekk() {
        return "OK";
    }

    // Oppgave 4 (forenklet)
    @Autowired
    private JdbcTemplate db;

    @PostMapping("/bestilling")
    public void bestilling(Ord2022 bestilling) {

    }
}
