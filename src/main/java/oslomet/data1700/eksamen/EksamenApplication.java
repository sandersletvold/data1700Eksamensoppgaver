package oslomet.data1700.eksamen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude={SecurityAutoConfiguration.class})
public class EksamenApplication {

    public static void main(String[] args) {
        SpringApplication.run(EksamenApplication.class, args);
    }

}
