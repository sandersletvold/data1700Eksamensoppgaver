package oslomet.data1700.eksamen;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
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
}
