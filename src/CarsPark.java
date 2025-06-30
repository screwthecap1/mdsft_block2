import java.util.Random;

public class CarsPark {
    public static void main(String[] args) {
        Random rnd = new Random();

        int[] years = new int[50];
        int startDate = 2000;
        int yearsNum = 26;
        for (int i = 0; i < years.length; i++) {
            years[i] = startDate + rnd.nextInt(yearsNum);
        }

        int pickDate = 2015;
        System.out.println("Cars are released after 2k15: ");
        for (int year : years) {
            if (year > 2015) {
                System.out.print(year + " ");
            }
        }
        System.out.println();

        int freshYear = 2025;
        int ttlAge = 0;
        for (int year : years) {
            ttlAge += (freshYear - year);
        }
        double avgAge = (double) ttlAge / years.length;
        System.out.printf("Average auto age: %.2f years\n", avgAge);
    }
}