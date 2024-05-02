package oslomet.data1700.eksamen;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Ord2022Controller {
    // Oppgave 1
    @GetMapping("/ord2022.html/sjekk")
    public String sjekk() {
        return "OK";
    }

    // Oppgave 2
    @PostMapping("/ord2022.html/bestilling")
    public void bestilling() {

    }
}
