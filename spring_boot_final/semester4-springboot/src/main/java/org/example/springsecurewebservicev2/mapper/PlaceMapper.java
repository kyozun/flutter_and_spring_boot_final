package org.example.springsecurewebservicev2.mapper;

import org.example.springsecurewebservicev2.dto.place.PlaceDto;
import org.example.springsecurewebservicev2.dto.place.CreatePlaceDto;
import org.example.springsecurewebservicev2.dto.place.UpdatePlaceDto;
import org.example.springsecurewebservicev2.entity.Place;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PlaceMapper {
    PlaceMapper INSTANCE = Mappers.getMapper(PlaceMapper.class);

    /*to Dto*/
    @Mapping(source = "name", target = "name")
    PlaceDto placeToPlaceDto(Place place);

    /*to Dto*/
    List<PlaceDto> placeListToPlaceAndMoreListDto(List<Place> placeList);

    /*to Entity*/
    @Mapping(source = "name", target = "name")
    Place createPlaceDtoToPlace(CreatePlaceDto createPlaceDto);

    /*to Entity*/
    @Mapping(source = "name", target = "name")
    Place updatePlaceDtoToPlace(UpdatePlaceDto updatePlaceDto, @MappingTarget Place place);
}
