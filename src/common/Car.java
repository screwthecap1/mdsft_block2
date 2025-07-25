package common;

public class Car implements Comparable<Car> {
    private String vin;
    private String model;
    private String company;
    private int year;
    private int mileage;
    private double price;
    private CarType type;

    public Car(String vin, String model, String company, int year, int mileage, double price, CarType type) {
        this.vin = vin;
        this.model = model;
        this.company = company;
        this.year = year;
        this.mileage = mileage;
        this.price = price;
        this.type = type;
    }

    public Car(String vin, String model, String company, int year, int mileage, double price) {
        this(vin, model, company, year, mileage, price, null);
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

    public int getMileage() {
        return mileage;
    }

    public double getPrice() {
        return price;
    }

    public CarType getType() {
        return type;
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
        return "common.Car{" +
                "vin='" + vin + '\'' +
                ", model='" + model + '\'' +
                ", company='" + company + '\'' +
                ", year=" + year +
                ", mileage=" + mileage +
                ", price=" + price +
                ", type=" + type +
                '}';
    }
}
