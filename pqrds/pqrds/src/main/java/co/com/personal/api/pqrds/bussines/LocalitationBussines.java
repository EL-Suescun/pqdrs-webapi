package co.com.personal.api.pqrds.bussines;

import co.com.personal.api.pqrds.dto.CityDTO;
import co.com.personal.api.pqrds.dto.CitySaveDTO;
import co.com.personal.api.pqrds.dto.DepartmentDTO;
import co.com.personal.api.pqrds.model.City;
import co.com.personal.api.pqrds.model.Department;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface LocalitationBussines {

    @Transactional
    List<CityDTO> getCities(); //Va a retornar las ciudades

    @Transactional
    List<DepartmentDTO> getDepartment(String name);

    @Transactional
    List<DepartmentDTO> getDepartmentByCountryName(String name);


    @Transactional
    CityDTO saveCity(CitySaveDTO city);

    @Transactional
    void deleteCity(String code);

    @Transactional
    CityDTO updateCity(CitySaveDTO citySaveDTO);

    @Transactional
    CityDTO getCity(String code); //Va a retornar las ciudades
}
