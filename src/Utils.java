import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Utils {

    public static String readFileAsString(String filepath) {
        StringBuilder output = new StringBuilder();

        try (Scanner scanner = new Scanner(new File(filepath))) {

            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                output.append(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return output.toString();
    }


    public static ArrayList<ElectionResult> parse2016ElectionResults(String data) {
        ArrayList<ElectionResult> out = new ArrayList<ElectionResult>();
        String[] lines = data.split("\n");
        String[] values;


        double demVotes, gopVotes, totalVotes, perGop, diff, perPointDiff, combinedFips;
        String stateAbbr, countyName;


        for(String line: lines){
            line.replace("%","");
            line.replace("\"","");

            values = line.split(",");

        }


        return out;
    }
}
