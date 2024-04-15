package co.com.personal.api.pqrds.repository;

import co.com.personal.api.pqrds.model.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, String> {
}
