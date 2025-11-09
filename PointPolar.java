public class PointPolar extends Point {
     
    private ScalarWrapper r;
    private ScalarWrapper theta;

    public PointPolar(ScalarWrapper r, ScalarWrapper theta) {
        super(r, theta);
        this.r = r;
        this.theta = theta;
    }

    public PointPolar(int r, int theta) {
        super(r, theta);
        this.r = new ScalarWrapper(r);
        this.theta = new ScalarWrapper(theta);
    }

    public PointPolar(Integer r, Integer theta) {
        super(r, theta);
        this.r = new ScalarWrapper(r);
        this.theta = new ScalarWrapper(theta);
    }

    public PointPolar(double r, double theta) {
        super(r, theta);
        this.r = new ScalarWrapper(r);
        this.theta = new ScalarWrapper(theta);
    }

    public PointPolar(Double r, Double theta) {
        super(r, theta);
        this.r = new ScalarWrapper(r);
        this.theta = new ScalarWrapper(theta);
    }

    public PointPolar(Rational r, Rational theta) {
        super(r, theta);
        this.r = new ScalarWrapper(r);
        this.theta = new ScalarWrapper(theta);
    }

    public Point cartesianForm() {
        double cosTheta = Math.cos(this.theta.doubleValue());
        ScalarWrapper x = this.r.multiply(cosTheta);
        double sinTheta = Math.sin(this.theta.doubleValue());
        ScalarWrapper y = this.r.multiply(sinTheta);

        return new Point(x, y);
    }

}
