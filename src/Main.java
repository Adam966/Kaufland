import Exeptions.BillExeptions;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws BillExeptions, ParserConfigurationException, TransformerException, IOException {
        Application app = Application.getInstance();

        app.example();
    }
}
