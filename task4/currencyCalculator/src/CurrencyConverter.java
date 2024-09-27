import java.util.HashMap;
import org.json.JSONObject;
import java.util.Scanner;
import java.net.URL;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CurrencyConverter {

    public static void main(String[] args) {
        Boolean running = true;
    	do{
        HashMap<Integer, String> currencyCodes = new HashMap<>();
        currencyCodes.put(1, "USD");
        currencyCodes.put(2, "EUR");
        currencyCodes.put(3, "CAD");
        currencyCodes.put(4, "HKD");
        currencyCodes.put(5, "INR");

        int from, to;
        String fromCode, toCode;
        double amount;

        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the CurrencyConverter!!");

        System.out.print("Currency you want to convert from\nSelect from the below options: ");
        System.out.println("1:USD \t 2:EUR \t 3:CAD \t 4:HKD \t 5:INR");
        from = sc.nextInt();
        while (from<1 || from>=5){
            System.out.println("please enter a valid Currency (1-5)");
            System.out.println("1:USD \\t 2:EUR \\t 3:CAD \\t 4:HKD \\t 5:INR");
            from = sc.nextInt();
        }
        fromCode = currencyCodes.get(from);


        System.out.print("Currency you want to convert to\nSelect from the below options: ");
        System.out.println("1:USD \t 2:EUR \t 3:CAD \t 4:HKD \t 5:INR");
        to = sc.nextInt();
        while (to<1 || to>=5){
            System.out.println("please enter a valid Currency (1-5)");
            System.out.println("1:USD \\t 2:EUR \\t 3:CAD \\t 4:HKD \\t 5:INR");
            to = sc.nextInt();
        }
        toCode = currencyCodes.get(to);

        System.out.println("Enter the amount you want to convert:");
        amount = sc.nextDouble();

        sendHttpGETRequest(fromCode, toCode, amount);

        System.err.println("Would You ike to Use the Currency Converter Again?");
        System.out.println("1:Yes \t Any Other Key: No");
        if(sc.nextInt() != 1 ){
            running = false;
            
        }
        
        } while (running); 
        System.out.println("Thank you for using the CurrencyConverter!");
    
    }

    private static void sendHttpGETRequest(String fromCode, String toCode, double amount) {
        try {
            String GET_URL = "http://api.exchangeratesapi.io/v1/latest?access_key=6cf2ed6a005889a6c8711bc0d4697965&symbols=" 
            + toCode + "," + fromCode;

            // Create a URL object
            URL url = new URL(GET_URL);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            con.setRequestMethod("GET");

            int responseCode = con.getResponseCode();

            if(responseCode == HttpURLConnection.HTTP_OK){
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));

                String inputLine;
                StringBuffer response = new StringBuffer();
                while((inputLine = in.readLine()) != null){
                    response.append(inputLine); // Append each line of the response to the StringBuffer
                }
                in.close();

                // Parse the JSON response
                JSONObject obj = new JSONObject(response.toString()); // Create a JSONObject from the response
                Double exchangeRate = obj.getJSONObject("rates").getDouble(toCode); // Get exchange rate for target currency

                System.out.println("Exchange rates: " + obj.getJSONObject("rates"));
                System.out.println("Exchange Rate for " + toCode + ": " + exchangeRate); // Debugging output

                // Perform the conversion
                double convertedAmount = amount * exchangeRate;
                System.out.printf("%.2f %s = %.2f %s\n", amount, fromCode, convertedAmount, toCode);
            } else {
                System.out.println("Error: " + responseCode);
            }

        } catch (MalformedURLException e) {
            System.out.println("The URL is malformed: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("An I/O error occurred: " + e.getMessage());
        }
    }
}
