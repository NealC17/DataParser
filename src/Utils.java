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

            values = line.split(",");

            demVotes = Double.parseDouble(values[1]);
            gopVotes = Double.parseDouble(values[2]);
            totalVotes = Double.parseDouble(values[3]);
            perDem = Double.parseDouble(values[4]);
            perGop = Double.parseDouble(values[5]);

            diff = getDiff(line);
            perPointDiff = getPerPointDiff(line);

            stateAbbr = values[values.length-3];
            countyName = values[values.length-2];
            combinedFips = Double.parseDouble(values[values.length-1]);

            out.add(new ElectionResult(demVotes,gopVotes,totalVotes,perDem,perGop,diff,perPointDiff,stateAbbr,countyName,combinedFips));
        }


        return out;
    }

    private static double getPerPointDiff(String line) {

        int percentIndex = line.indexOf("%");
        int firstCommaIndex, secondCommaIndex = percentIndex+1;
        int i = percentIndex;
        while (!line.substring(i-1,i).equals(",")){
            i--;
        }
        firstCommaIndex = i;

        return Double.parseDouble(line.substring(firstCommaIndex,secondCommaIndex).replace(",","").replace("%",""))/100;


    }

    private static double getDiff(String line) {
        if(line.indexOf("\"")!=-1){
            int firstQuoteIndex = line.indexOf("\"");
            int secondQuoteIndex = line.indexOf("\"",firstQuoteIndex+1);

            String out = line.substring(firstQuoteIndex,secondQuoteIndex);
            return Double.parseDouble(out.replace("\"","").replace(",",""));
        } else {
            int percentIndex = line.indexOf("%");
            int secondCommaIndex = line.indexOf(",", percentIndex), firstCommaIndex;
            int i = secondCommaIndex-1;

            while (!line.substring(i-1,i).equals(",")){
                i--;
            }

            secondCommaIndex = i;
            i--;

            while (!line.substring(i-1,i).equals(",")){
                i--;
            }
            firstCommaIndex = i;

            return Double.parseDouble(line.substring(firstCommaIndex, secondCommaIndex).replace(",",""));
        }


    }



}
