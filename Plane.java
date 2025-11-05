public class Plane extends SpacialObject implements Cloneable {
    
    private Point basePoint;
    private Vector normalVector;

    /**
     * Constructs a Plane from a Point and a Vector
     * @param basePoint a point on the Plane
     * @param normalVector the normal Vector of the Plane
     * @throws IllegalArgumentException if either basePoint or normalVector is not 3D
     */
    public Plane(Point basePoint, Vector normalVector) {
        super(3);
        if (!basePoint.is3D() || !normalVector.is3D()) {
            throw new IllegalArgumentException("Base point and normal vector must be 3D");
        }

        Vector n = normalVector.simplifiedIgnoreMagnitude();
        
        this.basePoint = basePoint;
        this.normalVector = n;
    }

    /**
     * Constructs a Plane from two Lines
     * @param line1 a Line on the Plane
     * @param line2 a different Line on the Plane
     * @throws IllegalArgumentException if either Line is not 3D; if the Lines are parallel or do not intersect
     */
    public Plane(Line line1, Line line2) {
        super(3);
        if (!line1.is3D() || !line2.is3D()) {
            throw new IllegalArgumentException("Both Lines must be 3D");
        } else if (line1.isParallel(line2)) {
            throw new IllegalArgumentException("Cannot construct Plane from two parallel Lines");
        } else if (!line1.intersects(line2)) {
            throw new IllegalArgumentException("Lines must intersect");
        }

        Vector n = Vector.crossProduct(line1.getDirectionVector(), line2.getDirectionVector());
        n.simplifyIgnoreMagnitude();

        this.basePoint = line1.intersection(line2);
        this.normalVector = n;
    }

    /**
     * Constructs a Plane from a Point and two Vectors
     * @param basePoint a Point on the Plane
     * @param vector1 a Vector on the Plane
     * @param vector2 a different Vector on the Plane
     * @throws IllegalArgumentException if basePoint or either Vector is not 3D; if the Vectors are parallel
     */
    public Plane(Point basePoint, Vector vector1, Vector vector2) {
        super(3);
        if (!basePoint.is3D() || !vector1.is3D() || !vector2.is3D()) {
            throw new IllegalArgumentException("Base point and vectors must be 3D");
        } else if (vector1.isScalarMultOf(vector2)) {
            throw new IllegalArgumentException("Cannot construct Plane from two parallel Vectors");
        }

        Vector n = Vector.crossProduct(vector1, vector2);
        n.simplifyIgnoreMagnitude();

        this.basePoint = basePoint;
        this.normalVector = n;
    }

    /**
     * Accessor for basePoint
     * @return the base point of this Plane
     */
    public Point getBasePoint() {
        return this.basePoint;
    }

    /**
     * Returns the ith coordinate of the base point of this Plane
     * @return the ith coordinate of basePoint
     */
    public ScalarWrapper getFromBase(int i) {
        return this.basePoint.get(i);
    }

    /**
     * Returns x0, or the x coordinate of the base point of this Plane
     * @return the x coordinate of basePoint
     */
    public ScalarWrapper getX0() {
        return this.basePoint.getX();
    }

    /**
     * Returns y0, or the y coordinate of the base point of this Plane
     * @return the y coordinate of basePoint
     */
    public ScalarWrapper getY0() {
        return this.basePoint.getY();
    }

    /**
     * Returns z0, or the z coordinate of the base point of this Plane
     * @return the z coordinate of basePoint
     */
    public ScalarWrapper getZ0() {
        return this.basePoint.getZ();
    }

    /**
     * Accessor for normalVector
     * @return the normal vector of this Plane
     */
    public Vector getNormalVector() {
        return this.normalVector;
    }

    /**
     * Returns the ith component of the normal vector of this Plane
     * @return the ith component of normalVector
     */
    public ScalarWrapper getFromNormal(int i) {
        return this.normalVector.get(i);
    }

    /**
     * Returns a, or the x component of the normal vector of this Plane
     * @return the x component of normalVector
     */
    public ScalarWrapper getA() {
        return this.normalVector.get(0);
    }

    /**
     * Returns b, or the y component of the normal vector of this Plane
     * @return the y component of normalVector
     */
    public ScalarWrapper getB() {
        return this.normalVector.get(1);
    }

    /**
     * Returns c, or the z component of the normal vector of this Plane
     * @return the z component of normalVector
     */
    public ScalarWrapper getC() {
        return this.normalVector.get(2);
    }

    /**
     * Returns the value of d as found in the equation of this Plane
     * @return the value of d as found in the equation of this Plane
     */
    public ScalarWrapper getD() {
        ScalarWrapper d = this.getA().multiply(this.getX0()).add(this.getB().multiply(this.getY0())).add(this.getC().multiply(this.getZ0()));
        d = d.negative();
        return d;
    }

    /**
     * Returns an array of the variables a, b, c, and d as found in the equation of this Plane
     * @return an array of the variables a, b, c, and d as found in the equation of this Plane
     */
    public ScalarWrapper[] equationVariables() {
        ScalarWrapper[] variables = {this.getA(), this.getB(), this.getC(), this.getD()};
        return variables;
    }

    /**
     * Evaluates the left side of the equation of this Plane at a given Point
     * @param p a Point on the Plane
     * @return the value of the left side of the equation of this Plane
     * @throws IllegalArgumentException if p is not 3D
     */
    private ScalarWrapper equationLeftSide(Point p) {
        if (!p.is3D()) {
            throw new IllegalArgumentException("Point must be 3D");
        }

        return this.getA().multiply(p.getX()).add(this.getB().multiply(p.getY())).add(this.getC().multiply(p.getZ()));
    }

    /**
     * Evaluates the right side of the equation of this Plane
     * @return the right side of the equation of this Plane
     */
    private ScalarWrapper equationRightSide() {
        return this.getD().negative();
    }

    /**
     * Compares this Plane to another Plane
     * @param other the Plane to compare with
     * @return true if this Plane is equivalent to other; false otherwise
     */
    public boolean equals(Plane other) {
        return this.atSameAngle(other) && this.includesPoint(other.basePoint);
    }

    /**
     * Checks whether this Plane is at the same angle as another Plane
     * @param other the Plane to compare with
     * @return true if this Plane is at the same angle as other; false otherwise
     */
    public boolean atSameAngle(Plane other) {
        return (this.normalVector.isScalarMultOf(other.normalVector));
    }

    /**
     * Checks whether this Plane is at the same angle as a Line
     * @param other the Line to compare with
     * @return true if this Plane is at the same angle as other; false otherwise
     * @throws IllegalArgumentException if other is not 3D
     */
    public boolean atSameAngle(Line other) {
        if (!other.is3D()) {
            throw new IllegalArgumentException("Line must be 3D");
        }

        return other.isOrthogonal(this.normalVector);
    }

    /**
     * Checks whether this Plane is parallel (but not equal) to another Plane
     * @param other the Plane to compare with
     * @return true if this Plane and other are parallel and not equal; false otherwise
     */
    public boolean isParallel(Plane other) {
        return (this.atSameAngle(other) && !this.includesPoint(other.basePoint));
    }

    /**
     * Checks whether this Plane is parallel to (but does not include) a Line
     * @param other the Line to compare with
     * @return true if this Plane and other are parallel, but this Plane does not include other; false otherwise
     * @throws IllegalArgumentException if other is not 3D
     */
    public boolean isParallel(Line other) {
        if (!other.is3D()) {
            throw new IllegalArgumentException("Line must be 3D");
        }

        return (this.atSameAngle(other) && !this.includesPoint(other.basePoint));
    }

    /**
     * Checks whether this Plane is orthogonal to another Plane
     * @param other the Plane to compare with
     * @return true if this Plane is orthogonal to other; false otherwise
     */
    public boolean isOrthogonal(Plane other) {
        return this.normalVector.isOrthogonal(other.normalVector);
    }

    /**
     * Checks whether this Plane is orthogonal to a Line
     * @param other the Line to compare with
     * @return true if this Plane is orthogonal to other; false otherwise
     * @throws IllegalArgumentException if other is not 3D
     */
    public boolean isOrthogonal(Line other) {
        if (!other.is3D()) {
            throw new IllegalArgumentException("Line must be 3D");
        }

        return this.normalVector.isScalarMultOf(other.getDirectionVector());
    }

    /**
     * Checks whether this Plane is orthogonal to a Vector
     * @param other the Vector to compare with
     * @return true if this Plane is orthogonal to other; false otherwise
     * @throws IllegalArgumentException if other is not 3D
     */
    public boolean isOrthogonal(Vector other) {
        if (!other.is3D()) {
            throw new IllegalArgumentException("Vector must be 3D");
        }
        
        return this.normalVector.isScalarMultOf(other);
    }

    /**
     * Checks whether this Plane intersects with another Plane (at a line or at all points)
     * @param other the Plane to compare with
     * @return true if this Plane and other intersect; false otherwise
     */
    public boolean intersects(Plane other) {
        return !this.isParallel(other);
    }

    /**
     * Checks whether this Plane intersects with a Line (at one point or at all points)
     * @param other the Plane to compare with
     * @return true if this Plane and other intersect; false otherwise
     * @throws IllegalArgumentException if other is not 3D
     */
    public boolean intersects(Line other) {
        if (!other.is3D()) {
            throw new IllegalArgumentException("Line must be 3D");
        }

        return !this.isParallel(other);
    }

    /**
     * Returns the intersection Line between this Plane and another Plane
     * @param other the Plane to compare with
     * @return the intersection Line between this Plane and other
     */
    public Line intersection(Plane other) {
        Vector directionVector = Vector.crossProduct(this.normalVector, other.normalVector);

        Vector lDirection = Vector.crossProduct(other.normalVector, directionVector);
        Line l = new Line(other.basePoint, lDirection);
        Point basePoint = this.intersection(l);

        return new Line(basePoint, directionVector);
    }

    /**
     * Returns the intersection Line between this Plane and a Line
     * @param other the Line to compare with
     * @return the intersection Point between this Plane and other
     * @throws IllegalArgumentException if other is not 3D
     */
    public Point intersection(Line other) {
        if (!other.is3D()) {
            throw new IllegalArgumentException("Line must be 3D");
        }

        if (this.includesLine(other)) {
            return null;
        }

        return other.intersection(other.projectionOnto(this));
    }

    /**
     * Calculates the cosine of the angle between this Plane and a Line
     * @param other the Line making up the angle with this Plane
     * @return the cosine of the angle between this Plane and other
     * @throws IllegalArgumentException if other is not 3D
     */
    public double cosAngle(Line other) {
        if (!other.is3D()) {
            throw new IllegalArgumentException("Line must be 3D");
        }

        return other.cosAngle(other.projectionOnto(this));
    }

    /**
     * Calculates the cosine of the angle between this Plane and a Vector
     * @param other the Vector making up the angle with this Plane
     * @return the cosine of the angle between this Plane and other
     * @throws IllegalArgumentException if other is not 3D
     */
    public double cosAngle(Vector other) {
        if (!other.is3D()) {
            throw new IllegalArgumentException("Vector must be 3D");
        }

        return other.cosAngle(other.projectionOnto(this));
    }

    /**
     * Calculates the angle between this Plane and another Plane
     * @param other the other Plane making up the angle
     * @return the angle between this Plane and other
     */
    public double angle(Plane other) {
        return this.normalVector.angle(other.normalVector);
    }

    /**
     * Calculates the angle between this Plane and a Line
     * @param other the Line making up the angle with this Plane
     * @return the angle between this Plane and other
     * @throws IllegalArgumentException if other is not 3D
     */
    public double angle(Line other) {
        if (!other.is3D()) {
            throw new IllegalArgumentException("Line must be 3D");
        }

        return other.angle(other.projectionOnto(this));
    }

    /**
     * Calculates the angle between this Plane and a Vector
     * @param other the Vector making up the angle with this Plane
     * @return the angle between this Plane and other
     * @throws IllegalArgumentException if other is not 3D
     */
    public double angle(Vector other) {
        if (!other.is3D()) {
            throw new IllegalArgumentException("Vector must be 3D");
        }

        return other.angle(other.projectionOnto(this));
    }

    /**
     * Calculates the angle between this Plane and another Plane as a multiple of pi
     * @param other the other Plane making up the angle
     * @return the angle between this Plane and other, divided by pi
     */
    public ScalarWrapper angleMultipleOfPi(Plane other) {
        return this.normalVector.angleMultipleOfPi(other.normalVector);
    }

    /**
     * Calculates the angle between this Plane and a Line as a multiple of pi
     * @param other the Line making up the angle with this Plane
     * @return the angle between this Plane and other, divided by pi
     * @throws IllegalArgumentException if other is not 3D
     */
    public ScalarWrapper angleMultipleOfPi(Line other) {
        if (!other.is3D()) {
            throw new IllegalArgumentException("Line must be 3D");
        }

        return other.angleMultipleOfPi(other.projectionOnto(this));
    }

    /**
     * Calculates the angle between this Plane and a Vector as a multiple of pi
     * @param other the Vector making up the angle with this Plane
     * @return the angle between this Plane and other, divided by pi
     * @throws IllegalArgumentException if other is not 3D
     */
    public ScalarWrapper angleMultipleOfPi(Vector other) {
        if (!other.is3D()) {
            throw new IllegalArgumentException("Vector must be 3D");
        }

        return other.angleMultipleOfPi(other.projectionOnto(this));
    }

    /**
     * Returns the projection of a Line onto this Plane
     * @param other the Line to project onto this Plane
     * @return the projection of other onto this Plane
     */
    public Line projection(Line other) {
        return other.projectionOnto(this);
    }

    /**
     * Returns the projection of a Vector onto this Plane
     * @param other the Vector to project onto this Plane
     * @return the projection of other onto this Plane
     */
    public Vector projection(Vector other) {
        return other.projectionOnto(this);
    }

    /**
     * Checks if a given Point is on this Plane
     * @param other the Point to compare with
     * @return true if other is on this Plane; false otherwise
     * @throws IllegalArgumentException if other is not 3D
     */
    public boolean includesPoint(Point other) {
        if (!other.is3D()) {
            throw new IllegalArgumentException("Point must be 3D");
        }

        return this.equationLeftSide(other) == this.equationRightSide();
    }

    /**
     * Checks if a given Line is on this Plane
     * @param other the Line to compare with
     * @return true if other is on this Plane; false otherwise
     * @throws IllegalArgumentException if other is not 3D
     */
    public boolean includesLine(Line other) {
        if (!other.is3D()) {
            throw new IllegalArgumentException("Line must be 3D");
        }

        return other.isOrthogonal(this.normalVector) && this.includesPoint(other.basePoint);
    }

    /**
     * Returns this Plane with its base point shifted by a given Vector
     * @param delta the direction and distance to shift this Plane
     * @return this Plane, shifted
     * @throws IllegalArgumentException if other is not 3D
     */
    public Plane shifted(Vector delta) {
        if (!delta.is3D()) {
            throw new IllegalArgumentException("Delta must be 3D");
        }

        return new Plane(this.basePoint.add(delta), this.normalVector);
    }

    /**
     * Shifts the base point of this Plane by a given Vector
     * @param delta the direction and distance to shift this Plane
     * @throws IllegalArgumentException if other is not 3D
     */
    public void shift(Vector delta) {
        if (!delta.is3D()) {
            throw new IllegalArgumentException("Delta must be 3D");
        }

        this.basePoint = this.basePoint.add(delta);
    }

    /**
     * Returns this Plane shifted to a new base point
     * @param newBase the basePoint of the shifted Plane
     * @return this Plane, shifted
     * @throws IllegalArgumentException if other is not 3D
     */
    public Plane shiftedTo(Point newBase) {
        if (!newBase.is3D()) {
            throw new IllegalArgumentException("Point must be 3D");
        }
        
        return new Plane(newBase, this.normalVector);
    }

    /**
     * Shifts the base point of this Plane to a given Point
     * @param newBase the new basePoint of this Plane
     * @throws IllegalArgumentException if other is not 3D
     */
    public void shiftTo(Point newBase) {
        if (!newBase.is3D()) {
            throw new IllegalArgumentException("Point must be 3D");
        }
        
        this.basePoint = newBase;
    }

    /**
     * Creates and returns a deep copy of this Plane
     * @return a deep copy of this Line
     */
    @Override
    public Plane clone() {
        return new Plane(this.basePoint.clone(), this.normalVector.clone());
    }

    /**
     * Returns a String representation of this Plane
     * @return a String representation of this Plane
     */
    @Override
    public String toString() {
        return this.getA() + "x + " + this.getB() + "y + " + this.getC() + "z = " + this.getD().negative();
    }

}
