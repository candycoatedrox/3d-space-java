public class Line {

    // can be 2+D
    
    protected final int dim;
    protected Point basePoint;
    protected Vector directionVector;
    
    protected static final String[] variableNames = {"x", "y", "z", "w"};
    
    /**
     * Constructs a Line from a Point and a Vector
     * @param basePoint the base point of the Line
     * @param directionVector the direction vector of the Line
     * @throws IllegalArgumentException if basePoint and directionVector have different dimensions or fewer than 2 components
     */
    public Line(Point basePoint, Vector directionVector) {
        if (basePoint.getDim() != directionVector.getDim()) {
            throw new IllegalArgumentException("Point and Vector must share dimension");
        } else if (basePoint.getDim() < 2) {
            throw new IllegalArgumentException("Line cannot have fewer than 2 components");
        } else {
            this.dim = basePoint.getDim();
        }

        this.basePoint = basePoint;
        this.directionVector = directionVector;
    }
    
    /**
     * Constructs a Line from two Points that make up a Vector
     * @param basePoint the base point of the Line and initial point of the direction Vector
     * @param directionTerminal the terminal point of the direction Vector
     * @throws IllegalArgumentException if basePoint and directionTerminal have different dimensions or fewer than 2 components
     */
    public Line(Point basePoint, Point directionTerminal) {
        if (basePoint.getDim() != directionTerminal.getDim()) {
            throw new IllegalArgumentException("Points must share dimension");
        } else if (basePoint.getDim() < 2) {
            throw new IllegalArgumentException("Line cannot have fewer than 2 components");
        } else {
            this.dim = basePoint.getDim();
        }

        this.basePoint = basePoint;
        this.directionVector = new Vector(basePoint, directionTerminal);
    }
    
    /**
     * Constructs a Line from a Point and two Points that make up a vector
     * @param basePoint the base point of the Line
     * @param directionInitial the initial point of the direction Vector
     * @param directionTerminal the terminal point of the direction Vector
     * @throws IllegalArgumentException if basePoint, directionInitial, and directionTerminal are not all of the same dimension or have fewer than 2 components
     */
    public Line(Point basePoint, Point directionInitial, Point directionTerminal) {
        if (basePoint.getDim() != directionInitial.getDim() || directionInitial.getDim() != directionTerminal.getDim()) {
            throw new IllegalArgumentException("All Points must share dimension");
        } else if (basePoint.getDim() < 2) {
            throw new IllegalArgumentException("Line cannot have fewer than 2 components");
        } else {
            this.dim = basePoint.getDim();
        }

        this.basePoint = basePoint;
        this.directionVector = new Vector(directionInitial, directionTerminal);
    }

    /**
     * Accessor for dim
     * @return the dimension of this Line
     */
    public int getDim() {
        return this.dim;
    }

    /**
     * Accessor for basePoint
     * @return the base point of this Line
     */
    public Point getBasePoint() {
        return this.basePoint;
    }

    /**
     * Returns the ith coordinate of the base point of this Line
     * @return the ith coordinate of basePoint
     */
    public ScalarWrapper getFromBase(int i) {
        return this.basePoint.get(i);
    }

    /**
     * Returns x0, or the x coordinate of the base point of this Line
     * @return the x coordinate of basePoint
     */
    public ScalarWrapper getX0() {
        return this.basePoint.getX();
    }

    /**
     * Returns y0, or the y coordinate of the base point of this Line
     * @return the y coordinate of basePoint
     */
    public ScalarWrapper getY0() {
        return this.basePoint.getY();
    }

    /**
     * Returns z0, or the z coordinate of the base point of this Line
     * @return the z coordinate of basePoint
     * @throws IllegalArgumentException if this Line is 2D
     */
    public ScalarWrapper getZ0() {
        if (this.dim >= 3) {
            return this.basePoint.getZ();
        } else {
            throw new IllegalArgumentException("Line must be at least 3D");
        }
    }

    /**
     * Accessor for directionVector
     * @return the direction vector of this Line
     */
    public Vector getDirectionVector() {
        return this.directionVector;
    }

    /**
     * Returns the ith coordinate of the base point of this Line
     * @return the ith coordinate of basePoint
     */
    public ScalarWrapper getFromDirection(int i) {
        return this.directionVector.get(i);
    }

    /**
     * Returns a, or the first component of the direction vector of this Line
     * @return the first component of directionVector
     */
    public ScalarWrapper getA() {
        return this.directionVector.get(0);
    }

    /**
     * Returns b, or the second component of the direction vector of this Line
     * @return the second component of directionVector
     */
    public ScalarWrapper getB() {
        return this.directionVector.get(1);
    }

    /**
     * Returns c, or the third component of the direction vector of this Line
     * @return the third component of directionVector
     * @throws IllegalArgumentException if this Line is 2D
     */
    public ScalarWrapper getC() {
        if (this.dim >= 3) {
            return this.directionVector.get(2);
        } else {
            throw new IllegalArgumentException("Line must be at least 3D");
        }
    }

    /**
     * Calculates the slope of this 2D Line (as delta-y/delta-x)
     * @return the slope of this 2D Line
     * @throws IllegalArgumentException if this Line is not 2D
     */
    public ScalarWrapper slope() {
        if (this.dim != 2) {
            throw new IllegalArgumentException("Line must be 2D");
        }

        return this.directionVector.slope();
    }

    /**
     * Returns an integer corresponding to the interaction between this Line and another
     * @param other the Line to compare with
     * @return 0 if this Line and other are equal; 1 if they are parallel; 2 if they are intersecting; 3 if they are skew
     */
    public int interactionType(Line other) {
        if (this.dim != other.dim) {
            throw new IllegalArgumentException("Lines must share dimension");
        }

        if (this.equals(other)) {
            return 0;
        } else if (this.isParallel(other)) {
            return 1;
        } else if (this.dim >= 3 && !this.intersects(other)) {
            return 3;
        } else {
            return 2;
        }
    }

    /**
     * Compares this Line to another Line
     * @param other the Line to compare with
     * @return true if this Line is effectively equal to other; false otherwise
     */
    public boolean equals(Line other) {
        if (this.dim != other.dim) {
            return false;
        } else {
            return this.inSameDirection(other) && this.includesPoint(other.basePoint);
        }
    }

    /**
     * Checks whether this Line is in the same direction as a Line
     * @param other the Line to compare with
     * @return true if this Line is in the same direction as other; false otherwise
     */
    public boolean inSameDirection(Line other) {
        if (this.dim != other.dim) {
            throw new IllegalArgumentException("Lines must share dimension");
        }
        
        return (this.directionVector.isScalarMultOf(other.directionVector));
    }

    /**
     * Checks whether this Line is in the same direction as a Vector
     * @param other the Vector to compare with
     * @return true if this Line is in the same direction as other; false otherwise
     */
    public boolean inSameDirection(Vector other) {
        if (this.dim != other.getDim()) {
            throw new IllegalArgumentException("Line and Vector must share dimension");
        }

        return (this.directionVector.isScalarMultOf(other));
    }

    /**
     * Checks whether this Line is parallel (and not equal) to another Line
     * @param other the Line to compare with
     * @return true if this Line and other are parallel and not equal; false otherwise
     */
    public boolean isParallel(Line other) {
        if (this.dim != other.dim) {
            throw new IllegalArgumentException("Lines must share dimension");
        }

        return this.inSameDirection(other) && !this.includesPoint(other.basePoint);
    }

    /**
     * Checks whether this Line intersects with another Line (at one point or at all points)
     * @param other the Line to compare with
     * @return true if this Line and other intersect; false otherwise
     */
    public boolean intersects(Line other) {
        if (this.dim != other.dim) {
            throw new IllegalArgumentException("Lines must share dimension");
        }

        if (this.intersection(other) == null) {
            if (this.equals(other)) {
                return true;
            } else {
                return false;
            }
        } else {
            return true;
        }
    }

    /**
     * Returns the intersection Point between this Line and another Line
     * @param other the Line to compare with
     * @return the intersection Point between this Line and other
     */
    public Point intersection(Line other) {
        if (this.dim != other.dim) {
            throw new IllegalArgumentException("Lines must share dimension");
        }

        Vector basePoints = new Vector(this.basePoint, other.basePoint);
        Vector hVec = Vector.crossProduct(other.directionVector, basePoints);
        ScalarWrapper h = hVec.mag();
        Vector kVec = Vector.crossProduct(other.directionVector, this.directionVector);
        ScalarWrapper k = kVec.mag();

        if (h.equals(0) || k.equals(0)) {
            return null;
        } else {
            Vector v = this.directionVector.multiply(h.divideBy(k));
            Point intersection;
            if (hVec.isScalarMultOf(kVec)) {
                intersection = this.basePoint.add(v);
            } else {
                intersection = this.basePoint.subtract(v);
            }

            // one last failsafe; should always succeed and should be removed after testing
            if (this.includesPoint(intersection) && other.includesPoint(intersection)) {
                return intersection;
            } else {
                throw new ArithmeticException();
            }
        }
    }

    /**
     * Returns the intersection Point between this Line and a Plane
     * @param other the Plane to compare with
     * @return the intersection Point between this Line and other
     */
    // FILL AFTER PLANE IS SET UP
    /* public Point intersection(Plane other) {
        if (this.dim != 3) {
            throw new IllegalArgumentException("Line must be 3D");
        }
    } */

    /**
     * Checks if a given Point is on this Line
     * @param other the Point to compare with
     * @return true if other is on this Line; false otherwise
     */
    public boolean includesPoint(Point other) {
        if (this.dim != other.getDim()) {
            throw new IllegalArgumentException("Line and Point must share dimension");
        }

        ScalarWrapper t = this.solveForT(other);
        if (t == null) {
            return false;
        }
        return true;
    }

    /**
     * Returns the value of t at a given Point on this Line
     * @param other a Point on this Line
     * @return the value of t at other
     */
    public ScalarWrapper solveForT(Point other) {
        if (this.dim != other.getDim()) {
            throw new IllegalArgumentException("Line and Point must share dimension");
        }

        ScalarWrapper[] tSolutions = new ScalarWrapper[this.dim];
        for (int i = 0; i < this.dim; i++) {
            tSolutions[i] = other.get(i).subtract(this.getFromBase(i)).divideBy(this.getFromDirection(i));
            if (tSolutions[i] != tSolutions[0]) { // if all solutions for t are not the same
                return null;
            }
        }

        return tSolutions[0];
    }

    /**
     * Returns this Line with its base point shifted by a given Vector
     * @param delta the direction and distance to shift this Line
     * @return this Line, shifted
     */
    public Line shifted(Vector delta) {
        if (this.dim != delta.getDim()) {
            throw new IllegalArgumentException("Line and Point must share dimension");
        }

        Line copy = this.clone();
        copy.shift(delta);
        return copy;
    }

    /**
     * Shifts the base point of this Line by a given Vector
     * @param delta the direction and distance to shift this Line
     */
    public void shift(Vector delta) {
        if (this.dim != delta.getDim()) {
            throw new IllegalArgumentException("Line and Point must share dimension");
        }
        
        this.basePoint = this.basePoint.add(delta);
    }
    
    /**
     * Creates and returns a deep copy of this Line
     * @return a deep copy of this Line
     */
    @Override
    public Line clone() {
        return new Line(this.basePoint.clone(), this.directionVector.clone());
    }

    /**
     * Returns a String representation of the parametric equation of the ith component of this Line
     * @return a String representation of the parametric equation of the ith component of this Line
     */
    public String parametricEquation(int i) {
        if (i > 4) {
            // at a certain point we just run out of letters for variables. sorry
            throw new IllegalArgumentException("i cannot be greater than 4");
        }

        return variableNames[i] + " - " + this.getFromBase(i) + " = t" + this.getFromDirection(i);
    }

    /**
     * Returns a String representation of the parametric equations of this Line
     * @return a String representation of the parametric equations of this Line
     */
    public String parametricEquations() {
        if (this.dim > 4) {
            // at a certain point we just run out of letters for variables. sorry
            throw new IllegalArgumentException("Vector must be of dimension 2, 3, or 4");
        }

        String s = "";
        for (int i = 0; i < this.dim; i++) {
            if (i > 0) {
                s += "\n";
            }
            s += "|";
            s += this.parametricEquation(i);
        }
        
        return s;
    }

    /**
     * Returns a String representation of the alternate parametric equation of the ith component of this Line
     * @return a String representation of the alternate parametric equation of the ith component of this Line
     */
    public String altParametricEquation(int i) {
        if (i > 4) {
            // at a certain point we just run out of letters for variables. sorry
            throw new IllegalArgumentException("i cannot be greater than 4");
        }

        return variableNames[i] + " = " + this.getFromBase(i) + " + t" + this.getFromDirection(i);
    }

    /**
     * Returns a String representation of the alternate parametric equations of this Line
     * @return a String representation of the alternate parametric equations of this Line
     */
    public String altParametricEquations() {
        if (this.dim > 4) {
            // at a certain point we just run out of letters for variables. sorry
            throw new IllegalArgumentException("Vector must be of dimension 2, 3, or 4");
        }

        String s = "";
        for (int i = 0; i < this.dim; i++) {
            if (i > 0) {
                s += "\n";
            }
            s += "|";
            s += this.altParametricEquation(i);
        }
        
        return s;
    }

    /**
     * Returns a String representation of the symmetric equation of the ith component of this Line
     * @return a String representation of the symmetric equation of the ith component of this Line
     */
    public String symmetricEquation(int i) {
        if (i > 4) {
            // at a certain point we just run out of letters for variables. sorry
            throw new IllegalArgumentException("i cannot be greater than 4");
        }

        return "t = (" + variableNames[i] + " - " + this.getFromBase(i) + ")/" + this.getFromDirection(i);
    }

    /**
     * Returns a String representation of the symmetric equations of this Line
     * @return a String representation of the symmetric equations of this Line
     */
    public String symmetricEquations() {
        if (this.dim > 4) {
            // at a certain point we just run out of letters for variables. sorry
            throw new IllegalArgumentException("Vector must be of dimension 2, 3, or 4");
        }

        String s = "t ";
        String e;
        for (int i = 0; i < this.dim; i++) {
            if (i > 0) {
                s += "\n";
            }
            e = "= (" + variableNames[i] + " - " + this.getFromBase(i) + ")/" + this.getFromDirection(i);
            s += e;
        }
        
        return s;
    }

    /**
     * Returns a String representation of this Line in vector notation
     * @return a String representation of this Line in vector notation
     */
    public String vectorEquation() {
        Vector baseVector = new Vector(this.basePoint);
        return baseVector + " + t" + directionVector;
    }

    /**
     * Returns a String representation of this Line in vector notation
     * @return a String representation of this Line in vector notation
     */
    @Override
    public String toString() {
        // Vector notation <x0, y0, z0> + t<a, b, c>
        return this.vectorEquation();
    }

}
