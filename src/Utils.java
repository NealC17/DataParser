import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

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
        String line;


        double demVotes, gopVotes, totalVotes, perDem,perGop, diff, perPointDiff, combinedFips;
        String stateAbbr, countyName;


        for(int i = 1; i < lines.length; i++) {
            line = lines[i];
            line = line.replaceAll("%","");
            line = line.replaceAll("\"","");

            values = line.split(",");

            System.out.println(Arrays.toString(values));

            demVotes = Double.parseDouble(values[1]);
            gopVotes = Double.parseDouble(values[2]);
            totalVotes = Double.parseDouble(values[3]);
            perDem = Double.parseDouble(values[4]);
            perGop = Double.parseDouble(values[5]);
            diff = Double.parseDouble(values[6]);
            perPointDiff = getNum(values[7],values[8]);
            stateAbbr = values[9];
            countyName = values[10];
            combinedFips = Double.parseDouble(values[11]);

            out.add(new ElectionResult(demVotes,gopVotes,totalVotes,perDem,perGop,diff,perPointDiff,stateAbbr,countyName,combinedFips));
        }


        return out;
    }

    private static double getNum(String value, String value2) {
        String out = value + value2;

        return Double.parseDouble(out);
    }
}
