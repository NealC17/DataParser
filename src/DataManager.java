import com.sun.org.glassfish.gmbal.ParameterNames;

import java.util.ArrayList;
import java.util.List;

public class DataManager {
    private List<County> counties;
    public DataManager(){
        counties= new ArrayList<>();
    }

    public void addCounty(String stateAbbr, String name, int fips, Election2016 vote, Education2016 education, Employment2016 employment){
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

    }

    public void addCounty(County c) {
        counties.add(c);
    }
}
