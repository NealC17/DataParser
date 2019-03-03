public class ElectionResult {

    private double demVotes, gopVotes, totalVotes,perDem, perGop, diff, perPointDiff, combinedFips;
    private String stateAbbr, countyName;


    public ElectionResult(double demVotes, double gopVotes, double totalVotes, double perDem, double perGop, double diff, double perPointDiff, String stateAbbr, String countyName, double combinedFips) {
        this.demVotes = demVotes;
        this.gopVotes = gopVotes;
        this.totalVotes = totalVotes;
        this.perGop = perGop;
        this.diff = diff;
        this.perPointDiff = perPointDiff;
        this.stateAbbr = stateAbbr;
        this.countyName = countyName;
        this.combinedFips = combinedFips;
    }


    public double getPerDem() {
        return perDem;
    }

    public void setPerDem(double perDem) {
        this.perDem = perDem;
    }

    public double getCombinedFips() {
        return combinedFips;
    }

    public void setCombinedFips(double combinedFips) {
        this.combinedFips = combinedFips;
    }

    public double getDemVotes() {
        return demVotes;
    }

    public double getGopVotes() {
        return gopVotes;
    }

    public double getTotalVotes() {
        return totalVotes;
    }

    public double getPerGop() {
        return perGop;
    }

    public double getDiff() {
        return diff;
    }

    public double getPerPointDiff() {
        return perPointDiff;
    }

    public String getStateAbbr() {
        return stateAbbr;
    }

    public void setDemVotes(double demVotes) {
        this.demVotes = demVotes;
    }

    public void setGopVotes(double gopVotes) {
        this.gopVotes = gopVotes;
    }

    public void setTotalVotes(double totalVotes) {
        this.totalVotes = totalVotes;
    }

    public void setPerGop(double perGop) {
        this.perGop = perGop;
    }

    public void setDiff(double diff) {
        this.diff = diff;
    }

    public void setPerPointDiff(double perPointDiff) {
        this.perPointDiff = perPointDiff;
    }

    public void setStateAbbr(String stateAbbr) {
        this.stateAbbr = stateAbbr;
    }

    public void setCountyName(String countyName) {
        this.countyName = countyName;
    }

    public String getCountyName() {
        return countyName;
    }

    public String toString(){
        return demVotes + ", " + gopVotes + ", " + demVotes + ", " + gopVotes + ", " +totalVotes + ", " +perGop + ", " +diff + ", " +perPointDiff + ", " + stateAbbr + ", " +countyName+ ", " +combinedFips ;
    }
}
