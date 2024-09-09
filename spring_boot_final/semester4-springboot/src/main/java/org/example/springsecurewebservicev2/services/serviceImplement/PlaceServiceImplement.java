package org.example.springsecurewebservicev2.services.serviceImplement;

import org.example.springsecurewebservicev2.dto.place.CreatePlaceDto;
import org.example.springsecurewebservicev2.dto.place.PlaceDto;
import org.example.springsecurewebservicev2.dto.place.UpdatePlaceDto;
import org.example.springsecurewebservicev2.entity.Place;
import org.example.springsecurewebservicev2.mapper.PlaceMapper;
import org.example.springsecurewebservicev2.repository.PlaceRepository;
import org.example.springsecurewebservicev2.services.PlaceService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaceServiceImplement implements PlaceService {
    private final PlaceRepository placeRepository;

    public PlaceServiceImplement(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    @Override
    public List<PlaceDto> getAllPlaces() {
        List<Place> places = placeRepository.findAll();
        List<PlaceDto> placeDtos = PlaceMapper.INSTANCE.placeListToPlaceAndMoreListDto(places);
        return placeDtos;
    }

    @Override
    public PlaceDto getPlaceById(int id) {
        Place place = placeRepository.findById(id).orElse(null);
        PlaceDto placeDto = PlaceMapper.INSTANCE.placeToPlaceDto(place);
        return placeDto;
    }

    @Override
    public void createPlace(CreatePlaceDto createPlaceDto) {
        Place place = PlaceMapper.INSTANCE.createPlaceDtoToPlace(createPlaceDto);
        placeRepository.save(place);
    }

    @Override
    public void deletePlace(int id) {
        placeRepository.deleteById(id);

    }

    @Override
    public void updatePlace(int id, UpdatePlaceDto updatePlaceDto) {
        /*Tìm và update*/
        Place place = placeRepository.findById(id).orElse(null);
        PlaceMapper.INSTANCE.updatePlaceDtoToPlace(updatePlaceDto, place);
        placeRepository.save(place);
    }
}
