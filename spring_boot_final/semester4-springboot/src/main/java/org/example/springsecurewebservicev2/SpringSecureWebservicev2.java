package org.example.springsecurewebservicev2;

import org.example.springsecurewebservicev2.entity.Place;
import org.example.springsecurewebservicev2.repository.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringSecureWebservicev2 {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecureWebservicev2.class, args);
    }


    @Autowired
    PlaceRepository placeRepository;


    @Bean
    CommandLineRunner commandLineRunner(){
        return args -> {
            Place place = new Place();
            place.setName("Ha Noi");
            place.setDescription("Hanoi is the cultural, economic and education center of Northern Vietnam");
            placeRepository.save(place);

            Place place1 = new Place();
            place1.setName("Sai Gon");
            place1.setDescription("Ho Chi Minh, or Saigon as it was formerly called, is the largest and most populous city in Vietnam");
            placeRepository.save(place1);

            Place place2 = new Place();
            place2.setName("Sai Gon");
            place2.setName("Hoi An");
            place2.setDescription("Hoi An Viet Nam is located in Quang Nam province, Central Vietnam. Peaceful and ancient, Hoi an is one of the most famous tourist destinations in Vietnam");
            placeRepository.save(place2);

        };
    }

}
