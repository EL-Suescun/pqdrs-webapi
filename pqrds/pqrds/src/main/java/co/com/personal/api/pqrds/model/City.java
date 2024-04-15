package co.com.personal.api.pqrds.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "city")
public class City {
    @Id
    @Column(name = "code",nullable = false,length = 3)
    private String code;
    @Column(name = "name")
    private String name;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "departmen_code", nullable = false, referencedColumnName = "code")
    private Department department;

}
