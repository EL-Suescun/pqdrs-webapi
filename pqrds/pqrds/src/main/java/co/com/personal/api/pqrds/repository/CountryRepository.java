package co.com.personal.api.pqrds.repository;

// Los repositoris son interfaces utilizadas por spring jpa para realizar toda la operacion CRUD en
// la base de datos y esta asociado a una sola entidad

import co.com.personal.api.pqrds.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, String> {
}
