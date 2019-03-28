import Exeptions.BillExeptions;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws BillExeptions, IOException {
        Application app = Application.getInstance();

        app.example();

        Internet request = new Internet();
        request.sendGET();
    }
}
