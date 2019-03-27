import Exeptions.BillExeptions;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws BillExeptions {
        Application app = Application.getInstance();

        app.example();

        Internet request = new Internet();
        try {
            request.sendGET();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
