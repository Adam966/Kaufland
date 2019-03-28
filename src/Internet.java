import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Internet {
    public void sendGET() throws IOException {
        URL obj = new URL("https://api.exchangeratesapi.io/latest?symbols=USD");
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        int responseCode = con.getResponseCode();
        System.out.println("GET Response Code :: " + responseCode);

        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }

            JsonObject jobj = new Gson().fromJson(String.valueOf(response), JsonObject.class);
            JsonObject currency = (JsonObject) jobj.get("rates");
            float curr = currency.get("USD").getAsFloat();


            in.close();
        } else {
            System.out.println("GET request not worked");
        }
    }
}
