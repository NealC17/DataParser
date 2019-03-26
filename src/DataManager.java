import java.util.ArrayList;
import java.util.List;

public class DataManager {
    private List<County> counties;
    public DataManager(){
        counties= new ArrayList<>();
    }

    public void addCounty(String stateAbbr, String name, int fips, ElectionData vote, EducationData education, EmploymentData employment){
        counties.add(new County(stateAbbr, name,fips,vote,education,employment));
    }

    public List<County> getCounties(){
        return counties;
    }

    public County getCountyByFipsCode(int fipsCode){
        for (int i = 0; i < counties.size(); i++) {
            if(fipsCode==counties.get(i).getFips()){
                return counties.get(i);
            }
        }
        return null;
    }

    //StateAbbr is the state abbreviation for the state and should be all capital letters.
    public List<County> getCountiesByState(String stateAbbr){
        List<County> countiesByState= new ArrayList<>();

        for (County c:counties) {
            if(c.getStateAbbr().equals(stateAbbr)){
                countiesByState.add(c);
            }
        }

        return countiesByState;
    }


    public void addCounty(int combinedFips) {
        County c = new County(combinedFips);
        counties.add(c);
    }

    public void addCounty(County c) {
        counties.add(c);
    }

    public ArrayList<County> getStates() {
        ArrayList<County> out = new ArrayList<>();
        for(County c: counties){
            String name = c.getName();
            if(name.indexOf("county")==-1&&name.indexOf("borough")==-1&&name.indexOf("division")==-1&&name.indexOf("parish")==-1
                    &&name.indexOf("city")==-1&&name.indexOf("park")==-1&&name.indexOf("municipio")==-1&&name.indexOf("area")==-1
                    &&name.indexOf("islands")==-1&&name.indexOf("municipality")==-1){
                out.add(c);
            }
        }

        return out;
    }

    public County getCountyByName(String name) {
        for (County c: counties) {
            if(c.getName().equals(name)){
                return c;
            }
        }
        return null;
    }
}
