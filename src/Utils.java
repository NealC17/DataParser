import javax.sound.midi.Soundbank;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
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

    public static DataManager getDataCollection(String educationData, String employmentData, String electionData) {

        while (educationData.indexOf(",,") != -1) {
            educationData = educationData.replace(",,", ",");
        }

        while (electionData.indexOf(",,") != -1) {
            electionData = electionData.replace(",,", ",");
        }

        DataManager d = new DataManager();

        add2016EducationData(d, educationData);
        add2016ElectionData(d, electionData);


        return d;
    }

    private static void add2016EducationData(DataManager d, String educationData) {
        String[] ed = educationData.split("\n");
        String[] data;
        double noHighSchool, highSchool, someCollege, bachelors;
        County c;
        String line;
        int i;
        for (i = 9; i < ed.length - 10; i++) {
            line = ed[i];

            data = line.split(",");
            bachelors = Double.parseDouble(data[data.length - 1]);
            someCollege = Double.parseDouble(data[data.length - 2]);
            highSchool = Double.parseDouble(data[data.length - 3]);
            noHighSchool = Double.parseDouble(data[data.length - 4]);
            c = new County(Integer.parseInt(line.substring(0, line.indexOf(","))));
            c.setEducation(noHighSchool, highSchool, someCollege, bachelors);
            c.setStateAbbr(line.substring(line.indexOf(",") + 1, line.indexOf(",") + 3));
            d.addCounty(c);
        }
    }


    private static String removeRedundantCharecters(String exem) {
        return exem.replaceAll(",", "").replaceAll(" ", "").replaceAll("\"", "").replaceAll("\t", "");
    }


    private static void add2016ElectionData(DataManager d, String data) {
        String[] lines = data.split("\n");
        String[] values;
        String line;


        double demVotes, gopVotes, totalVotes, combinedFips;
        Election2016 e;

        for (int i = 1; i < lines.length; i++) {
            line = lines[i];

            values = line.split(",");

            demVotes = Double.parseDouble(values[1]);
            gopVotes = Double.parseDouble(values[2]);
            totalVotes = Double.parseDouble(values[3]);

            combinedFips = Double.parseDouble(values[values.length - 1]);
            e = new Election2016(demVotes, gopVotes, totalVotes);
            if (d.getCountyByFipsCode((int) combinedFips) != null) {
                d.getCountyByFipsCode((int) combinedFips).setVote(e);
            } else {
//                d.addCounty((int) (combinedFips));
//                d.getCountyByFipsCode((int) (combinedFips)).setVote(e);
            }
        }


    }

}
