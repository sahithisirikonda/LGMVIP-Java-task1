import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CurrencyConverter {

    public static void main(String[] args) {
        // Exchange rates (as of the knowledge cutoff date, not real-time)
        Map<String, Double> exchangeRates = new HashMap<>();
        exchangeRates.put("USD", 1.0);
        exchangeRates.put("EUR", 0.85); // 1 USD = 0.85 EUR
        exchangeRates.put("GBP", 0.73); // 1 USD = 0.73 GBP
        exchangeRates.put("INR", 82.205);//1 USD = 82.205 INR

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Currency Converter!");
        System.out.println("Available currencies: USD, EUR, GBP");
        System.out.print("Enter the amount: ");
        double amount = scanner.nextDouble();

        System.out.print("Enter the source currency (USD, EUR, GBP,INR): ");
        String sourceCurrency = scanner.next().toUpperCase();

        System.out.print("Enter the target currency (USD, EUR, GBP,INR): ");
        String targetCurrency = scanner.next().toUpperCase();

        double convertedAmount = convertCurrency(amount, sourceCurrency, targetCurrency, exchangeRates);
        System.out.println(amount + " " + sourceCurrency + " is equivalent to " + convertedAmount + " " + targetCurrency);

        scanner.close();
    }

    private static double convertCurrency(double amount, String sourceCurrency, String targetCurrency,
                                          Map<String, Double> exchangeRates) {
        double sourceRate = exchangeRates.getOrDefault(sourceCurrency, 1.0);
        double targetRate = exchangeRates.getOrDefault(targetCurrency, 1.0);
        return amount * (targetRate / sourceRate);
    }
}
