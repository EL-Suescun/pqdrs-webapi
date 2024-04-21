package co.com.personal.api.pqrds.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder //Sirve para instanciar objetos de forma static
@EqualsAndHashCode //Sirve para comparar objetos, inyectando la funcion equals y hash
@ToString //Visualizar el objeto de una forma de texto mas entendible
public class DepartmentDTO {
    private String code;
    private String name;
    private CountryDTO country;
}
