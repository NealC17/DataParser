public class EducationData {

    private double bachelorsOrMore;

    public EducationData(double bachelorsOrMore) {
        this.bachelorsOrMore = bachelorsOrMore;
    }

    public String toString(){
        return String.valueOf(bachelorsOrMore);
    }


    public double getBachelorsOrMore() {
        return bachelorsOrMore;
    }

    public void setBachelorsOrMore(double bachelorsOrMore) {
        this.bachelorsOrMore = bachelorsOrMore;
    }
}
