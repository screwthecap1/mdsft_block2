import java.util.*;

public class CarModels {
    public static void main(String[] args) {
        List<String> carModels = new ArrayList<>(List.of(
                "Tesla", "Lada 2107", "Audi Q7", "Lada 2110", "Opel Astra", "Audi Q7", "Lada 2107"
        ));

        Set<String> uniqueModels = new TreeSet<>(Comparator.reverseOrder());
        uniqueModels.addAll(carModels);
        System.out.println("Unique models (reverse order): ");
        uniqueModels.forEach(System.out::println);

        Set<String> finalModels = new HashSet<>();
        for (String model : uniqueModels) {
            if (model.contains("Tesla")) {
                finalModels.add("ELECTRO CAR");
            } else {
                finalModels.add(model);
            }
        }

        System.out.println("Models after swaps: ");
        finalModels.forEach(System.out::println);
    }
}