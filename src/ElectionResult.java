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
    
}
