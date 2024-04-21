package co.com.personal.api.pqrds.mapper;

import co.com.personal.api.pqrds.dto.CityDTO;
import co.com.personal.api.pqrds.dto.CitySaveDTO;
import co.com.personal.api.pqrds.model.City;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CityMapper {
    City toEntity(CityDTO source);
    List<CityDTO> toListDto(List<City> target);

    City toEntity(CitySaveDTO source);

    CityDTO toDto(City source);


}
