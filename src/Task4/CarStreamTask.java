package Task4;

import common.Car;

import java.util.*;
import java.util.stream.Collectors;

public class CarStreamTask {
    public static void main(String[] args) {
        List<Car> cars = List.of(
                new Car("VI001N", "Q7", "Audi", 2021, 15000, 2200),
                new Car("VI002N", "Octavia", "Skoda", 2020, 45000, 1100),
                new Car("VI003N", "A4", "Audi", 2002, 230000, 450),
                new Car("VI004N", "Emgrand", "Geely", 2018, 49000, 800),
                new Car("VI005N", "Teana", "Nissan", 2013, 100000, 600),
                new Car("VI006N", "Focus", "Ford", 2015, 111000, 450),
                new Car("VI007N", "Almera", "Nissan", 2016, 90000, 550)
        );

        System.out.println("Cars w/ millage < 50.000 km: ");
        cars.stream()
                .filter(car -> car.getMileage() < 50000)
                .forEach(System.out::println);

        List<Car> priceSrt = cars.stream()
                .sorted(Comparator.comparing(Car::getPrice).reversed())
                .collect(Collectors.toList());

        System.out.println("\n Top 3 the most expensive cars: ");
        priceSrt.stream()
                .limit(3)
                .forEach(System.out::println);

        double avgMilage = cars.stream()
                .mapToInt(Car::getMileage)
                .average()
                .orElse(0);
        System.out.printf("\nAverage mileage of all autos is %.2f km\n", avgMilage);

        Map<String, List<Car>> grp = cars.stream()
                .collect(Collectors.groupingBy(Car::getCompany));

        System.out.println("\nGroped by Company-manufacturer: ");
        grp.forEach((maker, carList) -> {
            System.out.println("[" + maker + "]: ");
            carList.forEach(System.out::println);
        });
    }
}