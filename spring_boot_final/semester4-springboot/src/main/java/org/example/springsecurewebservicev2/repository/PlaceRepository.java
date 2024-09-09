package org.example.springsecurewebservicev2.repository;

import org.example.springsecurewebservicev2.entity.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaceRepository  extends JpaRepository<Place, Integer>  {
}
