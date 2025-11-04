public class Line2D extends Line {

    private ScalarWrapper slope;
    private ScalarWrapper yIntercept;

    // add constructors to support all combinations of 2 scalars

    /**
     * Constructs a Line2D from a given slope and y-intercept
     * @param slope the slope of the Line2D
     * @param yIntercept the y-intercept of the Line2D
     */
    public Line2D(ScalarWrapper slope, ScalarWrapper yIntercept) {
        super(new Point(0, yIntercept), new Vector(new Point(1, slope)));

        this.slope = slope;
        this.yIntercept = yIntercept;
    }

    /**
     * Constructs a Line2D from a given slope and y-intercept
     * @param slope the slope of the Line2D
     * @param yIntercept the y-intercept of the Line2D
     */
    public Line2D(int slope, int yIntercept) {
        super(new Point(0, yIntercept), new Vector(new Point(1, slope)));

        this.slope = new ScalarWrapper(slope);
        this.yIntercept = new ScalarWrapper(yIntercept);
    }

    /**
     * Constructs a Line2D from a given slope and y-intercept
     * @param slope the slope of the Line2D
     * @param yIntercept the y-intercept of the Line2D
     */
    public Line2D(Integer slope, Integer yIntercept) {
        super(new Point(0, yIntercept), new Vector(new Point(1, slope)));

        this.slope = new ScalarWrapper(slope);
        this.yIntercept = new ScalarWrapper(yIntercept);
    }

    /**
     * Constructs a Line2D from a given slope and y-intercept
     * @param slope the slope of the Line2D
     * @param yIntercept the y-intercept of the Line2D
     */
    public Line2D(double slope, double yIntercept) {
        super(new Point(0, yIntercept), new Vector(new Point(1, slope)));

        this.slope = new ScalarWrapper(slope);
        this.yIntercept = new ScalarWrapper(yIntercept);
    }

    /**
     * Constructs a Line2D from a given slope and y-intercept
     * @param slope the slope of the Line2D
     * @param yIntercept the y-intercept of the Line2D
     */
    public Line2D(Double slope, Double yIntercept) {
        super(new Point(0, yIntercept), new Vector(new Point(1, slope)));

        this.slope = new ScalarWrapper(slope);
        this.yIntercept = new ScalarWrapper(yIntercept);
    }

    /**
     * Constructs a Line2D from a given slope and y-intercept
     * @param slope the slope of the Line2D
     * @param yIntercept the y-intercept of the Line2D
     */
    public Line2D(Rational slope, Rational yIntercept) {
        super(new Point(0, yIntercept), new Vector(new Point(1, slope)));

        this.slope = new ScalarWrapper(slope);
        this.yIntercept = new ScalarWrapper(yIntercept);
    }

    /**
     * Constructs a Line2D from two Points on the line
     * @param p1 a Point on the Line2D
     * @param p2 another Point on the Line2D
     * @throws IllegalArgumentException if either p1 or p2 is not 2D
     */
    public Line2D(Point p1, Point p2) {
        super(p1, p2);

        if (!p1.is2D() || !p2.is2D()) {
            throw new IllegalArgumentException("Both Points must be 2D");
        }

        Vector direction = new Vector(p1, p2);
        this.slope = direction.slope();
        this.yIntercept = p1.getY().subtract(this.slope.multiply(p1.getX()));
    }

    /**
     * Constructs a Line2D from a Point and a Vector
     * @param basePoint a Point on the Line2D
     * @param directionVector a Vector describing the direction of the Line2D
     * @throws IllegalArgumentException if either basePoint or directionVector is not 2D
     */
    public Line2D(Point basePoint, Vector directionVector) {
        super(basePoint, directionVector);

        if (!basePoint.is2D() || !directionVector.is2D()) {
            throw new IllegalArgumentException("Point and Vector must be 2D");
        }

        this.slope = directionVector.slope();
        ScalarWrapper mx = this.slope.multiply(basePoint.getX());
        this.yIntercept = basePoint.getY().subtract(mx);
    }

    @Override
    public int getDim() {
        return 2;
    }

    @Override
    public boolean is2D() {
        return true;
    }

    @Override
    public boolean is3D() {
        return true;
    }

    /**
     * Accessor for slope
     * @return the slope of this Line2D
     */
    public ScalarWrapper getSlope() {
        return this.slope;
    }

    @Override
    public ScalarWrapper slope() {
        return this.slope;
    }

    private ScalarWrapper slopeInvert() {
        if (this.slope.isDouble()) {
            double s = this.slope.doubleValue();
            return new ScalarWrapper(1 / s);
        } else {
            Rational s = this.slope.ratValue();
            return new ScalarWrapper(s.invert());   
        }
    }

    /**
     * Accessor for yIntercept
     * @return the y-intercept of this Line2D
     */
    public ScalarWrapper getYIntercept() {
        return this.yIntercept;
    }

    public Point yInterceptPoint() {
        return new Point(0, this.yIntercept);
    }

    public ScalarWrapper getXIntercept() {
        if (this.isParallel(xAxis())) {
            return null;
        } else {
            return this.intersection(xAxis()).getX();
        }
    }

    public Point xInterceptPoint() {
        return new Point(this.getXIntercept(), 0);
    }

    public ScalarWrapper yOfX(ScalarWrapper x) {
        return this.slope.multiply(x).add(this.yIntercept);
    }

    public ScalarWrapper xOfY(ScalarWrapper y) {
        return this.slopeInvert().multiply(y).add(this.getXIntercept());
    }

    public int interactionType(Line2D other) {
        if (this.equals(other)) {
            return 0;
        } else if (this.intersects(other)) {
            return 2;
        } else {
            return 1;
        }
    }

    public boolean equals(Line2D other) {
        return this.inSameDirection(other) && this.yIntercept.equals(other.yIntercept);
    }

    public boolean inSameDirection(Line2D other) {
        return this.slope.equals(other.slope);
    }

    public boolean isParallel(Line2D other) {
        return this.inSameDirection(other) && !this.yIntercept.equals(other.yIntercept);
    }

    public boolean isOrthogonal(Line2D other) {
        return other.slope.equals(this.slopeInvert());
    }

    @Override
    public boolean isSkew(Line other) {
        if (!other.is2D()) {
            throw new IllegalArgumentException("Line must be 2D");
        }

        return false;
    }

    public boolean intersects(Line2D other) {
        return !this.isParallel(other);
    }

    public Point intersection(Line2D other) {
        if (this.inSameDirection(other)) {
            return null;
        } else {
            Vector thisVector = new Vector(3);
            thisVector.set(0, 1);
            thisVector.set(1, this.slopeInvert().negative());
            thisVector.set(2, this.yIntercept);

            Vector otherVector = new Vector(3);
            otherVector.set(0, 1);
            otherVector.set(1, other.slopeInvert().negative());
            otherVector.set(2, other.yIntercept);

            Vector[] equations = {thisVector, otherVector};
            return Matrix.gaussJordan(equations);
        }
    }

    @Override
    public boolean includesPoint(Point other) {
        ScalarWrapper rightSide = this.yOfX(other.getX());
        return other.getY().equals(rightSide);
    }

    /**
     * Returns this Line2D with its base point shifted by a given Vector
     * @param delta the direction and distance to shift this Line2D
     * @return this Line2D, shifted
     * @throws IllegalArgumentException if delta is not 2D
     */
    @Override
    public Line shifted(Vector delta) {
        if (!delta.is2D()) {
            throw new IllegalArgumentException("Vector must be 2D");
        }

        return new Line2D(this.basePoint.add(delta), this.directionVector);
    }

    /**
     * Shifts the base point of this Line2D by a given Vector
     * @param delta the direction and distance to shift this Line2D
     * @throws IllegalArgumentException if delta is not 2D
     */
    @Override
    public void shift(Vector delta) {
        if (!delta.is2D()) {
            throw new IllegalArgumentException("Vector must be 2D");
        }
        
        this.basePoint = this.basePoint.add(delta);
        ScalarWrapper mx = this.slope.multiply(this.basePoint.getX());
        this.yIntercept = basePoint.getY().subtract(mx);
    }

    /**
     * Returns this Line2D shifted to a new base point
     * @param newBase the basePoint of the shifted Line2D
     * @return this Line2D, shifted
     * @throws IllegalArgumentException if newBase is not 2D
     */
    @Override
    public Line shiftedTo(Point newBase) {
        if (!newBase.is2D()) {
            throw new IllegalArgumentException("Point must be 2D");
        }

        return new Line2D(newBase, this.directionVector);
    }

    /**
     * Shifts the base point of this Line2D to a given Point
     * @param newBase the new basePoint of this Line2D
     * @throws IllegalArgumentException if newBase is not 2D
     */
    @Override
    public void shiftTo(Point newBase) {
        if (!newBase.is2D()) {
            throw new IllegalArgumentException("Point must be 2D");
        }
        
        this.basePoint = newBase;
        ScalarWrapper mx = this.slope.multiply(this.basePoint.getX());
        this.yIntercept = basePoint.getY().subtract(mx);
    }

    public Line2D rotatedMultipleOfPi(ScalarWrapper radiansMultiple) {
        return this.rotated(radiansMultiple, this.yInterceptPoint(), true);
    }

    public Line2D rotatedMultipleOfPi(ScalarWrapper radiansMultiple, Point anchorPoint) {
        return this.rotated(radiansMultiple, anchorPoint, true);
    }

    public Line2D rotatedMultipleOfPi(ScalarWrapper radiansMultiple, boolean counterclockwise) {
        return this.rotated(radiansMultiple, this.yInterceptPoint(), counterclockwise);
    }

    public Line2D rotatedMultipleOfPi(ScalarWrapper radiansMultiple, Point anchorPoint, boolean counterclockwise) {
        Matrix rotationMatrix = Matrix.rotationMatrixMultipleOfPi(radiansMultiple);
        Vector directionVector = rotationMatrix.multiply(this.directionVector);

        return new Line2D(anchorPoint, directionVector);
    }

    public Line2D rotated(ScalarWrapper radians) {
        return this.rotated(radians, this.yInterceptPoint(), true);
    }

    public Line2D rotated(ScalarWrapper radians, Point anchorPoint) {
        return this.rotated(radians, anchorPoint, true);
    }

    public Line2D rotated(ScalarWrapper radians, boolean counterclockwise) {
        return this.rotated(radians, this.yInterceptPoint(), counterclockwise);
    }

    public Line2D rotated(ScalarWrapper radians, Point anchorPoint, boolean counterclockwise) {
        Matrix rotationMatrix = Matrix.rotationMatrix(radians);
        Vector directionVector = rotationMatrix.multiply(this.directionVector);

        return new Line2D(anchorPoint, directionVector);
    }

    public void rotateMultipleOfPi(ScalarWrapper radiansMultiple) {
        this.rotate(radiansMultiple, Point.origin(2), true);
    }

    public void rotateMultipleOfPi(ScalarWrapper radiansMultiple, Point anchorPoint) {
        this.rotate(radiansMultiple, anchorPoint, true);
    }

    public void rotateMultipleOfPi(ScalarWrapper radiansMultiple, boolean counterclockwise) {
        this.rotate(radiansMultiple, this.yInterceptPoint(), counterclockwise);
    }

    public void rotateMultipleOfPi(ScalarWrapper radiansMultiple, Point anchorPoint, boolean counterclockwise) {
        Matrix rotationMatrix = Matrix.rotationMatrixMultipleOfPi(radiansMultiple);
        Vector directionVector = rotationMatrix.multiply(this.directionVector);

        Line2D copy = new Line2D(anchorPoint, directionVector);
        this.basePoint = anchorPoint;
        this.directionVector = directionVector;
        this.slope = copy.slope;
        this.yIntercept = copy.yIntercept;
    }

    public void rotate(ScalarWrapper radians) {
        this.rotate(radians, this.yInterceptPoint(), true);
    }

    public void rotate(ScalarWrapper radians, Point anchorPoint) {
        this.rotate(radians, anchorPoint, true);
    }

    public void rotate(ScalarWrapper radians, boolean counterclockwise) {
        this.rotate(radians, this.yInterceptPoint(), counterclockwise);
    }

    public void rotate(ScalarWrapper radians, Point anchorPoint, boolean counterclockwise) {
        Matrix rotationMatrix = Matrix.rotationMatrix(radians);
        Vector directionVector = rotationMatrix.multiply(this.directionVector);

        Line2D copy = new Line2D(anchorPoint, directionVector);
        this.basePoint = anchorPoint;
        this.directionVector = directionVector;
        this.slope = copy.slope;
        this.yIntercept = copy.yIntercept;
    }
    
    /**
     * Creates and returns a deep copy of this Line2D
     * @return a deep copy of this Line2D
     */
    @Override
    public Line clone() {
        return new Line2D(this.basePoint.clone(), this.directionVector.clone());
    }

    public String xOfYEquation() {
        return "x = " + this.slopeInvert() + "y + " + this.getXIntercept();
    }

    @Override
    public String toString() {
        return "y = " + this.slope + "x + " + this.yIntercept;
    }

    public static Line2D xAxis() {
        return new Line2D(0, 0);
    }

    public static Line yAxis() {
        return new Line(Point.origin(2), new Vector(new Point(0, 1)));
    }

}