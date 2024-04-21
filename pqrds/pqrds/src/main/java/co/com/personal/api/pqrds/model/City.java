package co.com.personal.api.pqrds.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Getter
@Setter
@Entity
@Table(name = "city")
public class City {
    @Id
    @Column(name = "code",nullable = false,length = 10)
    private String code;
    @Column(name = "name")
    private String name;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "departmen_code", nullable = false, referencedColumnName = "code")
    @Fetch(FetchMode.JOIN) // Esto indica que la asociación con Derpartment debe ser recuperada mediante un join
    private Department department;
}
