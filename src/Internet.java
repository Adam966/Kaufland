import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Internet {
    public StringBuffer sendGET() throws IOException {
        URL obj = new URL("https://api.exchangeratesapi.io/latest?symbols=USD");
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        int responseCode = con.getResponseCode();
        System.out.println("GET Response Code :: " + responseCode);
        StringBuffer response = new StringBuffer();

        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;


            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }

            in.close();
        } else {
            System.out.println("GET request not worked");
        }

        return response;
    }

    public float getCurrency(StringBuffer res) {
        JsonObject jobj = new Gson().fromJson(String.valueOf(res), JsonObject.class);
        JsonObject currency = (JsonObject) jobj.get("rates");
        float curr = currency.get("USD").getAsFloat();

        return curr;
    }
}
