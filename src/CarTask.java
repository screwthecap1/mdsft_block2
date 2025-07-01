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

class Car implements Comparable<Car> {
    private String vin;
    private String model;
    private String company;
    private int year;
    private int range;
    private double price;

    public Car(String vin, String model, String company, int year, int range, double price) {
        this.vin = vin;
        this.model = model;
        this.company = company;
        this.year = year;
        this.range = range;
        this.price = price;
    }

    public String getVin() {
        return vin;
    }

    public String getModel() {
        return model;
    }

    public String getCompany() {
        return company;
    }

    public int getYear() {
        return year;
    }

    public int getRange() {
        return range;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Car)) return false;
        Car car = (Car) obj;
        return vin.equals(car.vin);
    }

    @Override
    public int hashCode() {
        return vin.hashCode();
    }

    @Override
    public int compareTo(Car other) {
        return Integer.compare(other.year, this.year);
    }

    @Override
    public String toString() {
        return "Car{" +
                "vin='" + vin + '\'' +
                ", model='" + model + '\'' +
                ", company='" + company + '\'' +
                ", year=" + year +
                ", range=" + range +
                ", price=" + price +
                '}';
    }
}
