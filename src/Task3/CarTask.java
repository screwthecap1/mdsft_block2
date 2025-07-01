package Task3;

import common.Car;

import java.util.*;

public class CarTask {
    public static void main(String[] args) {
        Set<Car> carSet = new HashSet<>();

        carSet.add(new Car("VI001N", "Q7", "Audi", 2021, 10000, 2500));
        carSet.add(new Car("VI001N", "Q7", "Audi", 2021, 15000, 2200));
        carSet.add(new Car("VI002N", "Octavia", "Skoda", 2020, 50000, 1100));
        carSet.add(new Car("VI003N", "Emgrand", "Geely", 2018, 89000, 800));

        System.out.println("Number of unique autos in HashSet: " + carSet.size());
        carSet.forEach(System.out::println);

        List<Car> sortedCars = new ArrayList<>(carSet);
        Collections.sort(sortedCars);

        System.out.println("\nSort by release year (new to old): ");
        sortedCars.forEach(System.out::println);
    }
}