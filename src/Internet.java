import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Internet {
    public void sendGET() throws IOException, ParseException {
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
            in.close();

            try {
                JSONParser parser = new JSONParser();

                JSONObject json = (JSONObject) parser.parse(inputLine);
                System.out.println(json);

                System.out.println(response);
            } catch (ParseException pe) {

            }

        } else {
            System.out.println("GET request not worked");
        }

    }
}
