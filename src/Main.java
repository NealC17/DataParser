import java.util.ArrayList;

/**
 * Main class for data parser
 */

public class Main {
    public static void main(String[] args) {
        // Test of Utils
        String elecData = Utils.readFileAsString("data/2016_Presidential_Results.csv");
        String edData = Utils.readFileAsString("data/Education.csv");
        String unData= Utils.readFileAsString("data/Unemployment.csv");

        DataManager dataManager = Utils.getDataCollection(edData, unData,elecData );
    }
}
