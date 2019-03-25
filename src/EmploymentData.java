public class EmploymentData {



    private double[] unemployedPercent;
    private double[] employmentPercent;

    //2017 is at index 0, so forth until 2017

    public EmploymentData(double[] unemployedPercent) {
        this.unemployedPercent = unemployedPercent;
        employmentPercent = new double[unemployedPercent.length];

        for (int i = 0; i < unemployedPercent.length; i++) {
            employmentPercent[i] = 1-unemployedPercent[i];
        }
    }

    public double[] getUnemployedPercent() {
        return unemployedPercent;
    }

    public void setUnemployedPercent(double[] unemployedPercent) {
        this.unemployedPercent = unemployedPercent;
        for (int i = 0; i < unemployedPercent.length; i++) {
            employmentPercent[i] = 1-unemployedPercent[i];
        }
    }
}
