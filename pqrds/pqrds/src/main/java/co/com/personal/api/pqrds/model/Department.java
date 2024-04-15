package co.com.personal.api.pqrds.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table
public class Department{
    @Id
    @Column(name = "code",nullable = false, length = 5)
    private String code;
    @Column(name = "name", nullable = false, length = 50) //Lo mismo
    private String name;

    @OneToOne(fetch = FetchType.LAZY) // Anotacion que sirve para especificar una relacion Uno a Uno entre tablas,
    // su atributo indica una carga de datos perezosa
    @JoinColumn(name = "country_code",nullable = false,referencedColumnName = "code") //Anotacion que indica un
    // relacionamiento de tablas, name es el nombre del campo, no puede ser nul, y lo ultimo es como se encuentra el
    // id en la otra tabla
    private Country country;
    @OneToMany(mappedBy = "department", fetch = FetchType.LAZY)
    private List<City> city;
}