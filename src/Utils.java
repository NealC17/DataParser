import java.io.File;
import java.io.IOException;
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
        add2016EmploymentData(d,employmentData);


        return d;
    }

    private static void add2016EmploymentData(DataManager d, String employmentData) {
        while(employmentData.indexOf(",,")!=-1){
            employmentData = employmentData.replace(",,", ",");
        }

        String[] lines = employmentData.split("\n");
        String[] data;
        EmploymentData e;

        double[] unemploymentPercent;
        String line;
        for(int i = 10; i < lines.length;i++){
            line = lines[i];
            data = line.split(",");
            unemploymentPercent = getUnemploymentPercent(data);
            e = new EmploymentData(unemploymentPercent);
            County c = d.getCountyByFipsCode(Integer.parseInt(line.substring(0,line.indexOf(","))));

            if(c!=null&&e.getUnemployedPercent()[0]<100){
                c.setEmployment(e);
            }
        }


    }

    private static double[] getUnemploymentPercent(String[] data) {
        double[] out = new double[11];
        int count = 0;
        for (int i = 9; i < data.length; i+=4) {
            out[count++] = Double.parseDouble(data[i].trim());
        }

        return out;
    }


    private static void add2016EducationData(DataManager d, String educationData) {
        String[] ed = educationData.split("\n");
        String[] data;
        double noHighSchool, highSchool, someCollege, bachelors;
        County c;
        String line;
        int i;
        for (i = 10; i < ed.length - 10; i++) {
            line = ed[i];

            data = line.split(",");
            bachelors = Double.parseDouble(data[data.length - 1]);
            someCollege = Double.parseDouble(data[data.length - 2]);
            highSchool = Double.parseDouble(data[data.length - 3]);
            noHighSchool = Double.parseDouble(data[data.length - 4]);
            c = new County(Integer.parseInt(line.substring(0, line.indexOf(","))));
            c.setEducation(bachelors);
            c.setStateAbbr(line.substring(line.indexOf(",") + 1, line.indexOf(",") + 3));
            d.addCounty(c);
        }
    }

    private static void add2016ElectionData(DataManager d, String data) {
        String[] lines = data.split("\n");
        String[] values;
        String line;


        double demVotes, gopVotes, totalVotes, combinedFips;
        ElectionData e;

        for (int i = 1; i < lines.length; i++) {
            line = lines[i];

            values = line.split(",");

            demVotes = Double.parseDouble(values[1]);
            gopVotes = Double.parseDouble(values[2]);
            totalVotes = Double.parseDouble(values[3]);

            combinedFips = Double.parseDouble(values[values.length - 1]);
            e = new ElectionData(demVotes, gopVotes, totalVotes);
            if (d.getCountyByFipsCode((int) combinedFips) != null) {
                d.getCountyByFipsCode((int) combinedFips).setVote(e);
            }
        }


    }

    public static String formatData(String data) {
        String normalizedString = "";
        char[] chars = data.toCharArray();
        boolean inQuotes = false;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '"') {
                inQuotes = !inQuotes;
            } else if (!(inQuotes && chars[i] == ',')) {
                normalizedString += chars[i];
            }
        }
        return normalizedString;
    }

}
