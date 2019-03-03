public class ElectionResult {

    private double demVotes, gopVotes, totalVotes, perGop, diff, perPointDiff;
    private String stateAbbr, countyName;

    public ElectionResult(double demVotes, double gopVotes, double totalVotes, double perGop, double diff, double perPointDiff, String stateAbbr, String countyName) {
        this.demVotes = demVotes;
        this.gopVotes = gopVotes;
        this.totalVotes = totalVotes;
        this.perGop = perGop;
        this.diff = diff;
        this.perPointDiff = perPointDiff;
        this.stateAbbr = stateAbbr;
        this.countyName = countyName;
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

    public String getCountyName() {
        return countyName;
    }
}
