import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public class MainApplication {

    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        HamletParser hamletParser = new HamletParser();
        hamletParser.createNewHamletFile("modified_hamlet.txt");
    }

}
