public class Point {
    
    private ScalarWrapper x;
    private ScalarWrapper y;
    private ScalarWrapper z;

    /**
     * Constructs a Point from three ScalarWrapper coordinates
     * @param x the x coordinate of the Point
     * @param y the y coordinate of the Point
     * @param z the z coordinate of the Point
     */
    public Point(ScalarWrapper x, ScalarWrapper y, ScalarWrapper z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * Constructs a Point from three int coordinates
     * @param x the x coordinate of the Point
     * @param y the y coordinate of the Point
     * @param z the z coordinate of the Point
     */
    public Point(int x, int y, int z) {
        this.x = new ScalarWrapper(x);
        this.y = new ScalarWrapper(y);
        this.z = new ScalarWrapper(z);
    }

    /**
     * Constructs a Point from three Integer coordinates
     * @param x the x coordinate of the Point
     * @param y the y coordinate of the Point
     * @param z the z coordinate of the Point
     */
    public Point(Integer x, Integer y, Integer z) {
        this.x = new ScalarWrapper(x);
        this.y = new ScalarWrapper(y);
        this.z = new ScalarWrapper(z);
    }

    /**
     * Constructs a Point from three double coordinates
     * @param x the x coordinate of the Point
     * @param y the y coordinate of the Point
     * @param z the z coordinate of the Point
     */
    public Point(double x, double y, double z) {
        this.x = new ScalarWrapper(x);
        this.y = new ScalarWrapper(y);
        this.z = new ScalarWrapper(z);
    }

    /**
     * Constructs a Point from three Double coordinates
     * @param x the x coordinate of the Point
     * @param y the y coordinate of the Point
     * @param z the z coordinate of the Point
     */
    public Point(Double x, Double y, Double z) {
        this.x = new ScalarWrapper(x);
        this.y = new ScalarWrapper(y);
        this.z = new ScalarWrapper(z);
    }

    /**
     * Returns the ith coordinate of this Point
     * @param i the index of the coordinate
     * @return the coordinate value
     */
    public ScalarWrapper getCoordinate(int i) {
        if (i == 0) {
            return this.x;
        } else if (i == 1) {
            return this.y;
        } else if (i == 2) {
            return this.z;
        } else {
            throw new IllegalArgumentException("Index must be 0, 1, or 2");
        }
    }

    /**
     * Accessor for x
     * @return the x coordinate of this Point
     */
    public ScalarWrapper getX() {
        return this.x;
    }

    /**
     * Manipulator for x (ScalarWrapper)
     * @param newValue the new value of x
     */
    public void setX(ScalarWrapper newValue) {
        this.x = newValue;
    }

    /**
     * Manipulator for x (int)
     * @param newValue the new value of x
     */
    public void setX(int newValue) {
        this.x = new ScalarWrapper(newValue);
    }

    /**
     * Manipulator for x (Integer)
     * @param newValue the new value of x
     */
    public void setX(Integer newValue) {
        this.x = new ScalarWrapper(newValue);
    }

    /**
     * Manipulator for x (double)
     * @param newValue the new value of x
     */
    public void setX(double newValue) {
        this.x = new ScalarWrapper(newValue);
    }

    /**
     * Manipulator for x (Double)
     * @param newValue the new value of x
     */
    public void setX(Double newValue) {
        this.x = new ScalarWrapper(newValue);
    }

    /**
     * Manipulator for x (Rational)
     * @param newValue the new value of x
     */
    public void setX(Rational newValue) {
        this.x = new ScalarWrapper(newValue);
    }

    /**
     * Accessor for y
     * @return the y coordinate of this Point
     */
    public ScalarWrapper getY() {
        return this.y;
    }

    /**
     * Manipulator for y (ScalarWrapper)
     * @param newValue the new value of x
     */
    public void setY(ScalarWrapper newValue) {
        this.y =newValue;
    }

    /**
     * Manipulator for y (int)
     * @param newValue the new value of x
     */
    public void setY(int newValue) {
        this.y =new ScalarWrapper(newValue);
    }

    /**
     * Manipulator for y (Integer)
     * @param newValue the new value of x
     */
    public void setY(Integer newValue) {
        this.y =new ScalarWrapper(newValue);
    }

    /**
     * Manipulator for y (double)
     * @param newValue the new value of x
     */
    public void setY(double newValue) {
        this.y =new ScalarWrapper(newValue);
    }

    /**
     * Manipulator for y (Double)
     * @param newValue the new value of x
     */
    public void setY(Double newValue) {
        this.y =new ScalarWrapper(newValue);
    }

    /**
     * Manipulator for y (Rational)
     * @param newValue the new value of x
     */
    public void setY(Rational newValue) {
        this.y =new ScalarWrapper(newValue);
    }

    /**
     * Accessor for z
     * @return the z coordinate of this Point
     */
    public ScalarWrapper getZ() {
        return this.x;
    }

    /**
     * Manipulator for z (ScalarWrapper)
     * @param newValue the new value of x
     */
    public void setZ(ScalarWrapper newValue) {
        this.z = newValue;
    }

    /**
     * Manipulator for z (int)
     * @param newValue the new value of x
     */
    public void setZ(int newValue) {
        this.z = new ScalarWrapper(newValue);
    }

    /**
     * Manipulator for z (Integer)
     * @param newValue the new value of x
     */
    public void setZ(Integer newValue) {
        this.z = new ScalarWrapper(newValue);
    }

    /**
     * Manipulator for z (double)
     * @param newValue the new value of x
     */
    public void setZ(double newValue) {
        this.z = new ScalarWrapper(newValue);
    }

    /**
     * Manipulator for z (Double)
     * @param newValue the new value of x
     */
    public void setZ(Double newValue) {
        this.z = new ScalarWrapper(newValue);
    }

    /**
     * Manipulator for z (Rational)
     * @param newValue the new value of x
     */
    public void setZ(Rational newValue) {
        this.z = new ScalarWrapper(newValue);
    }

    /**
     * Returns the negative version of this Point
     * @return the negative version of this Point
     */
    public Point negative() {
        return this.multiply(-1);
    }

    /**
     * Returns the absolute value of this Point
     * @return the absolute value of this Point
     */
    public Point absolute() {
        return new Point(this.x.absolute(), this.y.absolute(), this.z.absolute());
    }

    /**
     * Compares this Point to another Point
     * @param other the Point to compare with
     * @return true if this Point is equal to other; false otherwise
     */
    public boolean equals(Point other) {
        return (this.x.equals(other.x) && this.y.equals(other.y) && this.z.equals(other.z));
    }

    /**
     * Adds this Point and another Point
     * @param other the Point to add to this Point
     * @return the sum of this Point and other
     */
    public Point add(Point other) {
        return new Point(this.x.add(other.x), this.y.add(other.y), this.z.add(other.z));
    }

    /**
     * Adds this Point and a Vector
     * @param other the Vector to add to this Point
     * @return the sum of this Point and other
     */
    public Point add(Vector other) {
        return new Point(this.x.add(other.get(0)), this.y.add(other.get(1)), this.z.add(other.get(2)));
    }

    /**
     * Adds this Point and a NormalVector
     * @param other the NormalVector to add to this Point
     * @return the sum of this Point and other
     */
    public Point add(NormalVector other) {
        return this.add(other.trueValue());
    }

    /**
     * Subtracts another Point from this Point
     * @param other the Point to subtract from this Point
     * @return the difference between this Point and other
     */
    public Point subtract(Point other) {
        return this.add(other.negative());
    }

    /**
     * Subtracts a Vector from this Point
     * @param other the Vector to subtract from this Point
     * @return the difference between this Point and other
     */
    public Point subtract(Vector other) {
        return this.add(other.negative());
    }

    /**
     * Subtracts a NormalVector from this Point
     * @param other the NormalVector to subtract from this Point
     * @return the difference between this Point and other
     */
    public Point subtract(NormalVector other) {
        return this.add(other.negative());
    }

    /**
     * Multiplies this Point by a ScalarWrapper
     * @param other the ScalarWrapper to multiply with this Point
     * @return the product of this Point and other
     */
    public Point multiply(ScalarWrapper other) {
        return new Point(this.x.multiply(other), this.y.multiply(other), this.z.multiply(other));
    }

    /**
     * Multiplies this Point by an int
     * @param other the int to multiply with this Point
     * @return the product of this Point and other
     */
    public Point multiply(int other) {
        return new Point(this.x.multiply(other), this.y.multiply(other), this.z.multiply(other));
    }

    /**
     * Multiplies this Point by an Integer
     * @param other the Integer to multiply with this Point
     * @return the product of this Point and other
     */
    public Point multiply(Integer other) {
        return new Point(this.x.multiply(other), this.y.multiply(other), this.z.multiply(other));
    }

    /**
     * Multiplies this Point by a double
     * @param other the double to multiply with this Point
     * @return the product of this Point and other
     */
    public Point multiply(double other) {
        return new Point(this.x.multiply(other), this.y.multiply(other), this.z.multiply(other));
    }

    /**
     * Multiplies this Point by a Double
     * @param other the Double to multiply with this Point
     * @return the product of this Point and other
     */
    public Point multiply(Double other) {
        return new Point(this.x.multiply(other), this.y.multiply(other), this.z.multiply(other));
    }

    /**
     * Multiplies this Point by a Rational
     * @param other the Rational to multiply with this Point
     * @return the product of this Point and other
     */
    public Point multiply(Rational other) {
        return new Point(this.x.multiply(other), this.y.multiply(other), this.z.multiply(other));
    }

    /**
     * Multiplies this Point by a ScalarWrapper
     * @param other the ScalarWrapper to multiply with this Point
     * @return the product of this Point and other
     */
    public Point divideBy(ScalarWrapper other) {
        return new Point(this.x.divideBy(other), this.y.divideBy(other), this.z.divideBy(other));
    }

    /**
     * Multiplies this Point by an int
     * @param other the int to multiply with this Point
     * @return the product of this Point and other
     */
    public Point divideBy(int other) {
        return new Point(this.x.divideBy(other), this.y.divideBy(other), this.z.divideBy(other));
    }

    /**
     * Multiplies this Point by an Integer
     * @param other the Integer to multiply with this Point
     * @return the product of this Point and other
     */
    public Point divideBy(Integer other) {
        return new Point(this.x.divideBy(other), this.y.divideBy(other), this.z.divideBy(other));
    }

    /**
     * Multiplies this Point by a double
     * @param other the double to multiply with this Point
     * @return the product of this Point and other
     */
    public Point divideBy(double other) {
        return new Point(this.x.divideBy(other), this.y.divideBy(other), this.z.divideBy(other));
    }

    /**
     * Multiplies this Point by a Double
     * @param other the Double to multiply with this Point
     * @return the product of this Point and other
     */
    public Point divideBy(Double other) {
        return new Point(this.x.divideBy(other), this.y.divideBy(other), this.z.divideBy(other));
    }

    /**
     * Multiplies this Point by a Rational
     * @param other the Rational to multiply with this Point
     * @return the product of this Point and other
     */
    public Point divideBy(Rational other) {
        return new Point(this.x.divideBy(other), this.y.divideBy(other), this.z.divideBy(other));
    }

    /**
     * Creates and returns a deep copy of this Point
     * @return a deep copy of this Point
     */
    @Override
    public Point clone() {
        ScalarWrapper x = this.x.clone();
        ScalarWrapper y = this.y.clone();
        ScalarWrapper z = this.z.clone();

        return new Point(x, y, z);
    }

    /**
     * Returns a String representation of this Point
     * @return a String representation of this Point
     */
    @Override
    public String toString() {
        return "(" + this.x + ", " + this.y + ", " + this.z + ")";
    }

    /**
     * Returns the origin point (0, 0, 0)
     * @return the origin point
     */
    public static Point origin() {
        return new Point(0, 0, 0);
    }

}
