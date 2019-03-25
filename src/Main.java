import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Arrays;

/**
 * Main class for data parser
 */

public class Main {
    public static void main(String[] args) {
        String elecData = Utils.readFileAsString("data/2016_Presidential_Results.csv");
        String edData = Utils.readFileAsString("data/Education.csv");
        String unData = Utils.readFileAsString("data/Unemployment_ActuallyParsable.csv");

        DataManager dataManager = Utils.getDataCollection(edData, unData, elecData);
        EducationData e;
        for (County c : dataManager.getCounties()) {
            e = c.getEducation();
            if (e != null) {
                System.out.println((e.getBachelorsOrMore()));

            }
        }
    }


    private void createFile() {

        try{
            String path="data/Unemployment_actuallyParsable.csv";
        File file = new File(path);

          if (!file.exists()) {
               file.createNewFile();
            } else {
                file.delete();
                file.createNewFile();
           }

            FileWriter fw = new FileWriter(file.getAbsoluteFile());
           BufferedWriter bw = new BufferedWriter(fw);


           String[] lines = Utils.readFileAsString("data/Unemployment.csv").split("\n");

           for(String line: lines){
               String cleaned  = Utils.formatData(line);
               bw.write(cleaned);
                bw.newLine();
            }


           bw.close();
        } catch(Exception e){
            System.out.println(e);
        }
    }
}
