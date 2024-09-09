package org.example.springsecurewebservicev2.services;

import org.example.springsecurewebservicev2.dto.place.CreatePlaceDto;
import org.example.springsecurewebservicev2.dto.place.PlaceDto;
import org.example.springsecurewebservicev2.dto.place.UpdatePlaceDto;

import java.util.List;

public interface PlaceService {
    public List<PlaceDto> getAllPlaces();
    public PlaceDto getPlaceById(int id);
    public void createPlace(CreatePlaceDto createPlaceDto);
    public void updatePlace(int id, UpdatePlaceDto updatePlaceDto);
    public void deletePlace(int id);
}
