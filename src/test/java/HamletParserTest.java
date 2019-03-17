import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

import static org.junit.Assert.*;

public class HamletParserTest {
    private String hamletText;
    private HamletParser hamletParser;

    @Before
    public void setUp() {
        this.hamletParser = new HamletParser();
        this.hamletText = hamletParser.getHamletData();
    }

    @Test
    public void testChangeHamletToLeon() {
        String textSource = "QUEEN GERTRUDE\n" +
                "Let not thy mother lose her prayers, Hamlet:\n" +
                "I pray thee, stay with us; go not to Wittenberg.\n" +
                "HAMLET\n" +
                "I shall in all my best obey you, madam.";
        String expected = "QUEEN GERTRUDE\n" +
                "Let not thy mother lose her prayers, Leon:\n" +
                "I pray thee, stay with us; go not to Wittenberg.\n" +
                "LEON\n" +
                "I shall in all my best obey you, madam.";

        String actual = hamletParser.changeHamletToLeon(textSource);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testChangeHoratioToTariq() {
        String textSource = "HAMLET\n" +
                "I am glad to see you well:\n" +
                "Horatio,--or I do forget myself.\n" +
                "HORATIO\n" +
                "The same, my lord, and your poor servant ever.";
        String expected = "HAMLET\n" +
                "I am glad to see you well:\n" +
                "Tariq,--or I do forget myself.\n" +
                "TARIQ\n" +
                "The same, my lord, and your poor servant ever.";

        String actual = hamletParser.changeHoratioToTariq(textSource);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void replaceAllTest() {
        String textSource = "I've always been a cat person. Something about cats is great. How many cats do you have?";
        String tofind = "cat";
        String replacement = "dog";
        String expected = "I've always been a dog person. Something about dogs is great. How many dogs do you have?";

        String actual = hamletParser.replaceAll(textSource, tofind, replacement);

        Assert.assertEquals(expected, actual);
    }

}