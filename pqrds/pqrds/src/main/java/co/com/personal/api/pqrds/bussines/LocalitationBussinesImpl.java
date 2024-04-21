package co.com.personal.api.pqrds.bussines;

import co.com.personal.api.pqrds.dto.CityDTO;
import co.com.personal.api.pqrds.dto.CitySaveDTO;
import co.com.personal.api.pqrds.dto.DepartmentDTO;
import co.com.personal.api.pqrds.mapper.CityMapper;
import co.com.personal.api.pqrds.mapper.DepartmenMapper;
import co.com.personal.api.pqrds.model.City;
import co.com.personal.api.pqrds.model.Department;
import co.com.personal.api.pqrds.repository.CityRepository;
import co.com.personal.api.pqrds.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class LocalitationBussinesImpl implements LocalitationBussines{

    private final CityRepository cityRepository;
    private final CityMapper cityMapper;
    private final DepartmentRepository departmentRepository;
    private final DepartmenMapper departmenMapper;

    public List<CityDTO> getCities() {
        List<City> cities = cityRepository.findAll(); //findAll es consultar todo
        return cityMapper.toListDto(cities);
    }


    @Override
    public List<DepartmentDTO> getDepartment(String name) {
        List<Department> departments = departmentRepository.findByName(name);
        return departmenMapper.toListDto(departments);
    }

    @Override
    public List<DepartmentDTO> getDepartmentByCountryName(String name) {
        List<Department> departments = departmentRepository.findByCountryNameLike(name);
        return departmenMapper.toListDto(departments);
    }

    @Override
    public CityDTO saveCity(CitySaveDTO citySaveDTO) {
        City city = cityMapper.toEntity(citySaveDTO);
        Optional<Department> department = departmentRepository.findById(citySaveDTO.getDepartmentCode());
        city.setDepartment(department.get());
        cityRepository.save(city);
        CityDTO cityDTO = cityMapper.toDto(city);
        return cityDTO;
    }

    @Override
    public void deleteCity(String code) {
        cityRepository.deleteById(code);
    }

    @Override
    public CityDTO updateCity(CitySaveDTO citySaveDTO) {
        Optional<City> optionalCity = cityRepository.findById(citySaveDTO.getCode());
        if (optionalCity.isPresent()) {
            // Si el producto existe en la base de datos
            City city= optionalCity.get();

            // Modificar el objeto con los nuevos valores
            city.setName(citySaveDTO.getName());
            Optional<Department> department = departmentRepository.findById(citySaveDTO.getDepartmentCode());
            city.setDepartment(department.get());

            // Guardar el objeto modificado en la base de datos
            city = cityRepository.save(city);
            CityDTO cityDTO = cityMapper.toDto(city);
            return cityDTO;
        }else {
            //Primero aprender a manejar excepciones
        }
        return null;
    }

    @Override
    public CityDTO getCity(String code) {
        Optional<City> optionalCity = cityRepository.findById(code);
        if (optionalCity.isPresent()) {
            // Si el producto existe en la base de datos
            City city= optionalCity.get();
            CityDTO cityDTO = cityMapper.toDto(city);
            return cityDTO;
        }else {
            //Primero aprender a manejar excepciones
        }
        return null;
    }
}
