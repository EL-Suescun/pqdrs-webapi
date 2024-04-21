package co.com.personal.api.pqrds.rest;


import co.com.personal.api.pqrds.bussines.LocalitationBussinesImpl;
import co.com.personal.api.pqrds.dto.CityDTO;
import co.com.personal.api.pqrds.dto.CitySaveDTO;
import co.com.personal.api.pqrds.dto.DepartmentDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/department_byName")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DepartmentController {

    private final LocalitationBussinesImpl localitationBussines;

    @GetMapping
    public List<DepartmentDTO> getDepartmentByName(@RequestParam("name") String departmentName) {
        return localitationBussines.getDepartment(departmentName);
    }

    @GetMapping(value = "/country")
    public List<DepartmentDTO> getDepartmentByNameContaining(@RequestParam("name") String countryName){
        return  localitationBussines.getDepartmentByCountryName(countryName);
    }



}
