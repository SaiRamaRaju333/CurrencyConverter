import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Map<String, Double> conversionRates = new HashMap<>();

        conversionRates.put("USD", 1.0);//United States Dollar
        conversionRates.put("EUR", 0.92);//Euro
        conversionRates.put("NZD", 1.63);//NewZealand Dollar
        conversionRates.put("Singapore Dollar", 1.34);//Singapore Dollar
        conversionRates.put("Swiss franc", 0.98);//Switzerland and Liechtenstein
        conversionRates.put("GBP", 0.78);//Pound Sterling
        conversionRates.put("JPY", 146.60);//Japanese Yen
        conversionRates.put("AUD", 1.52);//Australian Dollar
        conversionRates.put("CAD", 1.34);//Canadian Dollar
        conversionRates.put("INR", 82.85);//Indian Rupee

        System.out.print("Enter the amount to convert: ");

        double amount = scanner.nextDouble();
        System.out.print("Enter the source currency code (e.g., USD): ");
        String sourceCurrency = scanner.next().toUpperCase();

        System.out.print("Enter the target currency code (e.g., EUR): ");
        String targetCurrency = scanner.next().toUpperCase();

        double convertedAmount = convertCurrency(amount, sourceCurrency, targetCurrency, conversionRates);
        System.out.println(amount + " " + sourceCurrency + " is equal to " + convertedAmount + " " + targetCurrency);
        scanner.close();
    }

    private static double convertCurrency(double amount, String sourceCurrency, String targetCurrency,
                                          Map<String, Double> conversionRates) {

        if (!conversionRates.containsKey(sourceCurrency) || !conversionRates.containsKey(targetCurrency)) {

            System.out.println("Unsupported source or target currency");
            return 0.0;
        }
        double usdAmount = amount / conversionRates.get(sourceCurrency);
        return usdAmount * conversionRates.get(targetCurrency);
    }
}
