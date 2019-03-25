public class County {
    private String name;
    private int fips;
    private ElectionData vote;
    private EducationData education;
    private EmploymentData employment;
    private String stateAbbr;


    public County(String stateAbbr, String name, int fips, ElectionData vote, EducationData education, EmploymentData employment) {
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

    public ElectionData getVote() {
        return vote;
    }

    public void setVote(ElectionData vote) {
        this.vote = vote;
    }

    public EducationData getEducation() {
        return education;
    }

    public void setEducation(EducationData education) {
        this.education = education;
    }

    public EmploymentData getEmployment() {
        return employment;
    }

    public void setEmployment(EmploymentData employment) {
        this.employment = employment;
    }

    public String getStateAbbr() {
        return stateAbbr;
    }

    public void setEducation(double noHighSchool) {
        EducationData e = new EducationData(noHighSchool);
        setEducation(e);
    }
}
