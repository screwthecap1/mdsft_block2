package Task5;

import common.Car;
import common.CarType;

import java.util.*;
import java.util.stream.Collectors;

public class CarDealership {
    private List<Car> cars = new ArrayList<>();

    public boolean addCar(Car car) {
        if (cars.stream().anyMatch(carFromList -> carFromList.getVin().equals(car.getVin()))) {
            System.out.println("Car with VIN = " + car.getVin() + " already exists.");
            return false;
        }
        cars.add(car);
        System.out.println("Car successfully added: " + car);
        return true;
    }

    public List<Car> findByProd(String company) {
        return cars.stream()
                .filter(carFromList -> carFromList.getCompany().equalsIgnoreCase(company))
                .collect(Collectors.toList());
    }

    public double avgPrice(CarType type) {
        return cars.stream()
                .filter(carFromList -> carFromList.getType() == type)
                .mapToDouble(Car::getPrice)
                .average()
                .orElse(0);
    }

    public List<Car> srtYear() {
        return cars.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public void showStat() {
        System.out.println("\nMain statistics: ");

        Map<CarType, Long> typeCnt = cars.stream()
                .collect(Collectors.groupingBy(Car::getType, Collectors.counting()));
        typeCnt.forEach((type, count) -> System.out.println(type + "=> " + count));

        cars.stream().min(Comparator.comparing(Car::getYear))
                .ifPresent(carFromList -> System.out.println("Oldest auto: " + carFromList));

        cars.stream().max(Comparator.comparing(Car::getYear))
                .ifPresent(carFromList -> System.out.println("Newest auto: " + carFromList));
    }
}
