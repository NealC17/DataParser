public class ElectionData {
    private double demVotes, gopVotes,totalVotes;

    public ElectionData(double demVotes, double gopVotes, double totalVotes) {
        this.demVotes = demVotes;
        this.gopVotes = gopVotes;
        this.totalVotes = totalVotes;
    }

    public double getDemVotes() {
        return demVotes;
    }

    public void setDemVotes(double demVotes) {
        this.demVotes = demVotes;
    }

    public double getGopVotes() {
        return gopVotes;
    }

    public void setGopVotes(double gopVotes) {
        this.gopVotes = gopVotes;
    }

    public double getTotalVotes() {
        return totalVotes;
    }

    public void setTotalVotes(double totalVotes) {
        this.totalVotes = totalVotes;
    }
}
