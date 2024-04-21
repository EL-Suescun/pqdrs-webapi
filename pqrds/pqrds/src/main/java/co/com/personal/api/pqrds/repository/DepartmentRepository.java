package co.com.personal.api.pqrds.repository;

import co.com.personal.api.pqrds.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, String> {
    List<Department> findByName(String name);

    @Query("SELECT d FROM Department d WHERE d.country.name LIKE %:countryName%")
    List<Department> findByCountryNameLike(String countryName);
}
