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
            place.setImageUrl("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRvTRsqE06RIiDaa5h8gFlj1RbU4EuiLwbgqA&s");
            placeRepository.save(place);

            Place place1 = new Place();
            place1.setName("Sai Gon");
            place1.setImageUrl("https://vcdn1-vnexpress.vnecdn.net/2020/06/28/CG2A5516-1593332884.jpg?w=500&h=300&q=100&dpr=1&fit=crop&s=huJFW-nGkDo2KPzN5dqY6w");
            placeRepository.save(place1);

            Place place2 = new Place();
            place2.setName("Hoi An");
            place2.setImageUrl("https://vcdn1-dulich.vnecdn.net/2022/06/01/Hoi-An-VnExpress-5851-16488048-4863-2250-1654057244.jpg?w=0&h=0&q=100&dpr=1&fit=crop&s=Z2ea_f0O7kgGZllKmJF92g");
            placeRepository.save(place2);

        };
    }

}
