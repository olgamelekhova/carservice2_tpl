package com.example.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;

import com.example.carservice.Car;

public class CarRentalClient {
    private static final Logger log = LoggerFactory.getLogger(CarRentalClient.class);

    public static void main(String[] args) {

        RestTemplate restTemplate = new RestTemplate();

        HttpEntity<Car> request = new HttpEntity<>(new Car("44QQ66", "Peugeot", 12));
        restTemplate.postForObject("http://localhost:8080/cars", request, Car.class);

        List cars = restTemplate.getForObject("http://localhost:8080/cars", List.class);
        log.info(Objects.requireNonNull(cars).toString());
    }
}
