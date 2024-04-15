package co.com.personal.api.pqrds.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

//Una anotacion es un objeto de java que permite hacer cambios en el codigo en tiempoi de ejecucion, como cuales; npara esta clase
// para esta clase, agregar o adicionar codigo, hacer configuraciones la base de datos
@Getter // Anotacion de Lombok que va carear o inyectar los metoddos get para todos loa tributos de la calse
@Setter // Anotacion de Lombok que va carear o inyectar los metoddos set para todos loa tributos de la calse
@Entity // Es una anotacion que denota que esta clase es el modelo relacionado a la base de datos en la tabla que se configura acontinuacion
@Table(name = "country") // Es la anotacion que permite configurar particularidades de la tabla en la base de datos (nombre, indices, etc..)
public class Country {
    // Para el codigo de los paises ISO 3166-1 numérico
    @Id // Especifica o configura el atributo como primary key
    @Column(name = "code", nullable = false, length = 3) //Configura el campo en la tabla
    private String code;
    @Column(name = "name", nullable = false, length = 50) //Lo mismo
    private String name;

    @OneToMany(mappedBy = "country", fetch = FetchType.LAZY) //Una relaciona de Uno a Muchos, pero como es asi debe de
    // ser con un mappedBy y el nombre del la otra tabla y de una carga perezosa
    private List<Department> department;

}