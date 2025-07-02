package Task5;

import common.Car;
import common.CarType;

import java.util.*;

public class MenuApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CarDealership auto = new CarDealership();

        auto.addCar(new Car("VI001N", "X5", "BMW", 2023, 10000, 1800, CarType.SUV));
        auto.addCar(new Car("VI002N", "Model S", "Tesla", 2022, 10000, 1500, CarType.ELECTRIC));
        auto.addCar(new Car("VI003N", "Camry", "Toyota", 2018, 10000, 1300, CarType.SEDAN));
        auto.addCar(new Car("VI004N", "Land Cruiser Prado", "Toyota", 2024, 10000, 1300, CarType.SUV));
        auto.addCar(new Car("VI005N", "Golf", "Volkswagen", 2020, 10000, 1000, CarType.HATCHBACK));
        auto.addCar(new Car("VI006N", "Touareg", "Volkswagen", 2023, 10000, 1000, CarType.SUV));
        auto.addCar(new Car("VI007N", "Malibu", "Chevrolet", 2024, 10000, 1200, CarType.COUPE));

        while (true) {
            System.out.println("|Main menu|");
            System.out.println("1 - Add new Car");
            System.out.println("2 - Find Car by the company");
            System.out.println("3 - Average Price by your Type");
            System.out.println("4 - Sort all Cars by Year Produce");
            System.out.println("5 - Show Stats");
            System.out.println("0 - Exit");
            System.out.println("Select the correct number: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch(choice) {
                case 1:
                    System.out.println("Enter VIN: ");
                    String vin = sc.nextLine();
                    System.out.println("Enter model: ");
                    String model = sc.nextLine();
                    System.out.println("Enter company: ");
                    String company = sc.nextLine();
                    System.out.println("Enter year produce: ");
                    int year = sc.nextInt();
                    System.out.println("Enter mileage: ");
                    int mileage = sc.nextInt();
                    System.out.println("Enter price: ");
                    double price = sc.nextDouble();
                    sc.nextLine();
                    System.out.println("Enter type [SEDAN/SUV/ELECTRIC/HATCHBACK/COUPE]: ");
                    CarType type = CarType.valueOf(sc.nextLine().toUpperCase());
                    auto.addCar(new Car(vin, model, company, year, mileage, price, type));
                    break;
                case 2:
                    System.out.println("Enter company: ");
                    String cmp = sc.nextLine();
                    auto.findByProd(cmp).forEach(System.out::println);
                    break;
                case 3:
                    System.out.println("Enter car type: ");
                    CarType tp = CarType.valueOf(sc.nextLine().toUpperCase());
                    double avg = auto.avgPrice(tp);
                    System.out.printf("Average price for %s: %.2f\n", tp, avg);
                    break;
                case 4:
                    auto.srtYear().forEach(System.out::println);
                    break;
                case 5:
                    auto.showStat();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Wrong option!");
            }
        }
    }
}
