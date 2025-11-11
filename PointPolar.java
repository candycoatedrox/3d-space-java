public class PointPolar extends Point {

    // figure out how to be able to hold theta either as a raw value or as a multiple of pi?
     
    private ScalarWrapper r;
    private ScalarWrapper theta;

    public PointPolar(ScalarWrapper r, ScalarWrapper theta) {
        super(r, theta);
        this.r = r;
        this.theta = theta;
    }

    public PointPolar(int r, int theta) {
        this(new ScalarWrapper(r), new ScalarWrapper(theta));
    }

    public PointPolar(Integer r, Integer theta) {
        this(new ScalarWrapper(r), new ScalarWrapper(theta));
    }

    public PointPolar(double r, double theta) {
        this(new ScalarWrapper(r), new ScalarWrapper(theta));
    }

    public PointPolar(Double r, Double theta) {
        this(new ScalarWrapper(r), new ScalarWrapper(theta));
    }

    public PointPolar(Rational r, Rational theta) {
        this(new ScalarWrapper(r), new ScalarWrapper(theta));
    }

    public Point cartesianForm() {
        double cosTheta = Math.cos(this.theta.doubleValue());
        ScalarWrapper x = this.r.multiply(cosTheta);
        double sinTheta = Math.sin(this.theta.doubleValue());
        ScalarWrapper y = this.r.multiply(sinTheta);

        return new Point(x, y);
    }

}
