import java.io.*;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by thook on 10/7/15.
 */
public class HamletParser {

    private String hamletData;
    private String hamletPattern1 = "(Hamlet)";
    private String hamletPattern2 = "(Hamlet)";
    private String horatio = "(Horatio)";

    public static void main(String[] args) {
        String text = "The Quick Brown Fox Jumps Over The Lazy Dog";
        String patternString = "(Quick)";
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(text);
//        for (int i = 0; matcher.find(); i++) {
//            System.out.println(new StringBuilder()
//                    .append("\n-------------------")
//                    .append("\nValue = " + matcher.group())
//                    .append("\nMatch Number = " + i)
//                    .append("\nStarting index = " + matcher.start())
//                    .append("\nEnding index = " + matcher.end())
//                    .toString());
//        }
        String text2 = matcher.replaceAll("Slow");
        System.out.println(text2);
    }

    public HamletParser(){
        this.hamletData = loadFile();
    }

    private String loadFile(){
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("hamlet.txt").getFile());
        StringBuilder result = new StringBuilder("");

        try(Scanner scanner = new Scanner(file)){
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                result.append(line).append("\n");
            }

            scanner.close();
        }catch(IOException e){
            e.printStackTrace();
        }

        return result.toString();
    }

    public String replaceAll(String textSource, String tofind, String replacement) {
        String regex = "("+ tofind + ")";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(textSource);
        return matcher.replaceAll(replacement);
    }

    public String changeHamletToLeon(String textSource) {
        String changedAllUpperCaseHamlets = replaceAll(textSource, "HAMLET", "LEON");
        String changedBothUpperAndLower = replaceAll(changedAllUpperCaseHamlets, "Hamlet", "Leon");
        return changedBothUpperAndLower;
    }

    public String changeHoratioToTariq(String textSource) {
        String changedAllUpperCaseHoratios = replaceAll(textSource, "HORATIO", "TARIQ");
        String changedBothUpperAndLower = replaceAll(changedAllUpperCaseHoratios, "Horatio", "Tariq");
        return changedBothUpperAndLower;
    }

    public String modifyHamletData() {
        String changedHamletsToLeons = changeHamletToLeon(hamletData);
        String changedHoratiosToTariqs = changeHoratioToTariq(changedHamletsToLeons);
        return changedHoratiosToTariqs;
    }

    public void createNewHamletFile(String newFileName) throws FileNotFoundException, UnsupportedEncodingException {
        PrintWriter out = new PrintWriter(newFileName, "UTF-8");
        out.println(modifyHamletData());
        out.close();
    }

    public String getHamletData(){
        return hamletData;
    }

}
