package com.example.carservice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class CarRentalService {

    private List<Car> cars = new ArrayList<>();

    public CarRentalService() {
        cars.add(new Car("11AA22", "Ferrari", 1000));
        cars.add(new Car("33BB44", "Porshe", 2222));
    }

    @RequestMapping(value = "/cars", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Car> getCars() {
        return cars;
    }

    @RequestMapping(value = "/cars", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void addCar(@RequestBody Car car) {
        cars.add(car);
    }

    @RequestMapping(value = "/cars/{plateNumber}", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<Car> rentCar(@PathVariable String plateNumber) {
        Optional<Car> found = cars.stream()
                .filter(car -> car.getPlateNumber().equalsIgnoreCase(plateNumber))
                .findFirst();

        return found.isPresent() && found.get().rentCar() ?
                ResponseEntity.ok(found.get()) : ResponseEntity.notFound().build();
    }

    @RequestMapping(value = "/cars/{plateNumber}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity<Car> deleteCar(@PathVariable String plateNumber) {
        Optional<Car> found = cars.stream()
                .filter(car -> car.getPlateNumber().equalsIgnoreCase(plateNumber))
                .findFirst();

        return found.isPresent() && found.get().getBackCar() ?
                ResponseEntity.ok(found.get()) : ResponseEntity.notFound().build();
    }
}
