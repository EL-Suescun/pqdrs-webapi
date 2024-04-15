package co.com.personal.api.pqrds.repository;

import co.com.personal.api.pqrds.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, String> {

}
