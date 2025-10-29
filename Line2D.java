public class Line2D extends Line {
    
    private ScalarWrapper slope;
    private ScalarWrapper yIntercept;

    public Line2D(ScalarWrapper slope, ScalarWrapper yIntercept) {
        ScalarWrapper[] coordinates = {yIntercept, new ScalarWrapper(0)};
        Point basePoint = new Point(coordinates);
        ScalarWrapper[] components = {new ScalarWrapper(1), slope};
        Vector directionVector = new Vector(components);
        super(basePoint, directionVector);

        this.slope = slope;
        this.yIntercept = yIntercept;
    }

}
