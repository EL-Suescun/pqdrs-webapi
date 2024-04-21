package co.com.personal.api.pqrds.mapper;

import co.com.personal.api.pqrds.dto.CityDTO;
import co.com.personal.api.pqrds.dto.DepartmentDTO;
import co.com.personal.api.pqrds.model.City;
import co.com.personal.api.pqrds.model.Department;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DepartmenMapper {
    Department toEntity(DepartmentDTO source);
    List<DepartmentDTO> toListDto(List<Department> target);
}
