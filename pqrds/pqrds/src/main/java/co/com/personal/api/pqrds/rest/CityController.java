package co.com.personal.api.pqrds.rest;

import co.com.personal.api.pqrds.bussines.LocalitationBussinesImpl;
import co.com.personal.api.pqrds.dto.CityDTO;
import co.com.personal.api.pqrds.dto.CitySaveDTO;
import co.com.personal.api.pqrds.model.City;
import co.com.personal.api.pqrds.repository.CityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/city")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CityController {

    private final LocalitationBussinesImpl localitationBussines;

    @GetMapping(value = "/all")
    public List<CityDTO> getAllCity() {
        return localitationBussines.getCities();
    }

    @PostMapping
    public ResponseEntity<CityDTO> createCity(@RequestBody CitySaveDTO city ) {
        CityDTO newCity = localitationBussines.saveCity(city);
        return new ResponseEntity<>(newCity, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{code}")
    public ResponseEntity<Void> deleteCity(@PathVariable String code ){
        localitationBussines.deleteCity(code);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<CityDTO> updateCity(@RequestBody CitySaveDTO city){
        CityDTO newCity = localitationBussines.updateCity(city);
        return new ResponseEntity<>(newCity, HttpStatus.OK);
    }

    @GetMapping(value = "/{code}")
    public ResponseEntity<CityDTO> getCity(@PathVariable String code ) {
        CityDTO city = localitationBussines.getCity(code);
        return new ResponseEntity<>(city,HttpStatus.OK);
    }

}
