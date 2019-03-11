public class County {
    private String name;
    private int fips;
    private Election2016 vote;
    private Education2016 education;
    private Employment2016 employment;
    private String stateAbbr;


    public County(String stateAbbr, String name, int fips, Election2016 vote, Education2016 education, Employment2016 employment) {
        this.name = name;
        this.fips = fips;
        this.vote = vote;
        this.education = education;
        this.employment = employment;
    }

    public County(int fips){
        this.fips=fips;
    }

    public void setStateAbbr(String stateAbbr){
        this.stateAbbr=stateAbbr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFips() {
        return fips;
    }

    public void setFips(int fips) {
        this.fips = fips;
    }

    public Election2016 getVote() {
        return vote;
    }

    public void setVote(Election2016 vote) {
        this.vote = vote;
    }

    public Education2016 getEducation() {
        return education;
    }

    public void setEducation(Education2016 education) {
        this.education = education;
    }

    public Employment2016 getEmployment() {
        return employment;
    }

    public void setEmployment(Employment2016 employment) {
        this.employment = employment;
    }

    public String getStateAbbr() {
        return stateAbbr;
    }

    public void setEducation(double noHighSchool, double highSchool, double someCollege, double bachelors) {
        Education2016 e = new Education2016(noHighSchool,highSchool,someCollege,bachelors);
        setEducation(e);
    }
}
