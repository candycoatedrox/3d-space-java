import java.util.Arrays;
import java.util.stream.Stream;

public class Point extends SpacialObject {
    
    protected ScalarWrapper[] coordinates;

    /**
     * Constructs a point at the origin in a given dimension
     * @param dim the dimension of the point
     */
    public Point(int dim) {
        super(dim);
        int[] coordinates = new int[dim];
        this.coordinates = ScalarWrapper.wrapArray(coordinates);
    }

    /**
     * Constructs a Point in n dimensions from an array of n ScalarWrappers
     * @param coordinates a list of the point's coordinates
     */
    public Point(ScalarWrapper[] coordinates) {
        super(coordinates.length);
        this.coordinates = coordinates;
    }

    /**
     * Constructs a Point in n dimensions from an array of n ints
     * @param coordinates a list of the point's coordinates
     */
    public Point(int[] coordinates) {
        super(coordinates.length);
        this.coordinates = ScalarWrapper.wrapArray(coordinates);
    }

    /**
     * Constructs a Point in n dimensions from an array of n Integers
     * @param coordinates a list of the point's coordinates
     */
    public Point(Integer[] coordinates) {
        super(coordinates.length);
        this.coordinates = ScalarWrapper.wrapArray(coordinates);
    }

    /**
     * Constructs a Point in n dimensions from an array of n doubles
     * @param coordinates a list of the point's coordinates
     */
    public Point(double[] coordinates) {
        super(coordinates.length);
        this.coordinates = ScalarWrapper.wrapArray(coordinates);
    }

    /**
     * Constructs a Point in n dimensions from an array of n Doubles
     * @param coordinates a list of the point's coordinates
     */
    public Point(Double[] coordinates) {
        super(coordinates.length);
        this.coordinates = ScalarWrapper.wrapArray(coordinates);
    }

    /**
     * Constructs a Point in n dimensions from an array of n Rationals
     * @param coordinates a list of the point's coordinates
     */
    public Point(Rational[] coordinates) {
        super(coordinates.length);
        this.coordinates = ScalarWrapper.wrapArray(coordinates);
    }

    // add 2D, 3D constructors for all combos of classes... eek

    /**
     * Constructs a 2D Point from two ScalarWrapper coordinates
     * @param x the x coordinate of the Point
     * @param y the y coordinate of the Point
     */
    public Point(ScalarWrapper x, ScalarWrapper y) {
        super(2);
        ScalarWrapper[] c = {x, y};
        this.coordinates = c;
    }

    /**
     * Constructs a 2D Point from a ScalarWrapper coordinate and an int coordinate
     * @param x the x coordinate of the Point
     * @param y the y coordinate of the Point
     */
    public Point(ScalarWrapper x, int y) {
        super(2);
        ScalarWrapper[] c = {x, new ScalarWrapper(y)};
        this.coordinates = c;
    }

    /**
     * Constructs a 2D Point from a ScalarWrapper coordinate and an Integer coordinate
     * @param x the x coordinate of the Point
     * @param y the y coordinate of the Point
     */
    public Point(ScalarWrapper x, Integer y) {
        super(2);
        ScalarWrapper[] c = {x, new ScalarWrapper(y)};
        this.coordinates = c;
    }

    /**
     * Constructs a 2D Point from a ScalarWrapper coordinate and a double coordinate
     * @param x the x coordinate of the Point
     * @param y the y coordinate of the Point
     */
    public Point(ScalarWrapper x, double y) {
        super(2);
        ScalarWrapper[] c = {x, new ScalarWrapper(y)};
        this.coordinates = c;
    }

    /**
     * Constructs a 2D Point from a ScalarWrapper coordinate and a Double coordinate
     * @param x the x coordinate of the Point
     * @param y the y coordinate of the Point
     */
    public Point(ScalarWrapper x, Double y) {
        super(2);
        ScalarWrapper[] c = {x, new ScalarWrapper(y)};
        this.coordinates = c;
    }

    /**
     * Constructs a 2D Point from a ScalarWrapper coordinate and a Rational coordinate
     * @param x the x coordinate of the Point
     * @param y the y coordinate of the Point
     */
    public Point(ScalarWrapper x, Rational y) {
        super(2);
        ScalarWrapper[] c = {x, new ScalarWrapper(y)};
        this.coordinates = c;
    }

    /**
     * Constructs a 2D Point from an int coordinate and a ScalarWrapper coordinate
     * @param x the x coordinate of the Point
     * @param y the y coordinate of the Point
     */
    public Point(int x, ScalarWrapper y) {
        super(2);
        ScalarWrapper[] c = {new ScalarWrapper(x), y};
        this.coordinates = c;
    }

    /**
     * Constructs a 2D Point from two int coordinates
     * @param x the x coordinate of the Point
     * @param y the y coordinate of the Point
     */
    public Point(int x, int y) {
        super(2);
        ScalarWrapper[] c = {new ScalarWrapper(x), new ScalarWrapper(y)};
        this.coordinates = c;
    }

    /**
     * Constructs a 2D Point from an int coordinate and an Integer coordinate
     * @param x the x coordinate of the Point
     * @param y the y coordinate of the Point
     */
    public Point(int x, Integer y) {
        super(2);
        ScalarWrapper[] c = {new ScalarWrapper(x), new ScalarWrapper(y)};
        this.coordinates = c;
    }

    /**
     * Constructs a 2D Point from an int coordinate and a double coordinate
     * @param x the x coordinate of the Point
     * @param y the y coordinate of the Point
     */
    public Point(int x, double y) {
        super(2);
        ScalarWrapper[] c = {new ScalarWrapper(x), new ScalarWrapper(y)};
        this.coordinates = c;
    }

    /**
     * Constructs a 2D Point from an int coordinate and a Double coordinate
     * @param x the x coordinate of the Point
     * @param y the y coordinate of the Point
     */
    public Point(int x, Double y) {
        super(2);
        ScalarWrapper[] c = {new ScalarWrapper(x), new ScalarWrapper(y)};
        this.coordinates = c;
    }

    /**
     * Constructs a 2D Point from an int coordinate and a Rational coordinate
     * @param x the x coordinate of the Point
     * @param y the y coordinate of the Point
     */
    public Point(int x, Rational y) {
        super(2);
        ScalarWrapper[] c = {new ScalarWrapper(x), new ScalarWrapper(y)};
        this.coordinates = c;
    }

    /**
     * Constructs a 2D Point from an Integer coordinate and a ScalarWrapper coordinate
     * @param x the x coordinate of the Point
     * @param y the y coordinate of the Point
     */
    public Point(Integer x, ScalarWrapper y) {
        super(2);
        ScalarWrapper[] c = {new ScalarWrapper(x), y};
        this.coordinates = c;
    }

    /**
     * Constructs a 2D Point from an Integer coordinate and an int coordinate
     * @param x the x coordinate of the Point
     * @param y the y coordinate of the Point
     */
    public Point(Integer x, int y) {
        super(2);
        ScalarWrapper[] c = {new ScalarWrapper(x), new ScalarWrapper(y)};
        this.coordinates = c;
    }

    /**
     * Constructs a 2D Point from two Integer coordinates
     * @param x the x coordinate of the Point
     * @param y the y coordinate of the Point
     */
    public Point(Integer x, Integer y) {
        super(2);
        ScalarWrapper[] c = {new ScalarWrapper(x), new ScalarWrapper(y)};
        this.coordinates = c;
    }

    /**
     * Constructs a 2D Point from an Integer coordinate and a double coordinate
     * @param x the x coordinate of the Point
     * @param y the y coordinate of the Point
     */
    public Point(Integer x, double y) {
        super(2);
        ScalarWrapper[] c = {new ScalarWrapper(x), new ScalarWrapper(y)};
        this.coordinates = c;
    }

    /**
     * Constructs a 2D Point from an Integer coordinate and a Double coordinate
     * @param x the x coordinate of the Point
     * @param y the y coordinate of the Point
     */
    public Point(Integer x, Double y) {
        super(2);
        ScalarWrapper[] c = {new ScalarWrapper(x), new ScalarWrapper(y)};
        this.coordinates = c;
    }

    /**
     * Constructs a 2D Point from an Integer coordinate and a Rational coordinate
     * @param x the x coordinate of the Point
     * @param y the y coordinate of the Point
     */
    public Point(Integer x, Rational y) {
        super(2);
        ScalarWrapper[] c = {new ScalarWrapper(x), new ScalarWrapper(y)};
        this.coordinates = c;
    }

    /**
     * Constructs a 2D Point from a double coordinate and a ScalarWrapper coordinate
     * @param x the x coordinate of the Point
     * @param y the y coordinate of the Point
     */
    public Point(double x, ScalarWrapper y) {
        super(2);
        ScalarWrapper[] c = {new ScalarWrapper(x), y};
        this.coordinates = c;
    }

    /**
     * Constructs a 2D Point from a double coordinate and an int coordinate
     * @param x the x coordinate of the Point
     * @param y the y coordinate of the Point
     */
    public Point(double x, int y) {
        super(2);
        ScalarWrapper[] c = {new ScalarWrapper(x), new ScalarWrapper(y)};
        this.coordinates = c;
    }

    /**
     * Constructs a 2D Point from a double coordinate and an Integer coordinate
     * @param x the x coordinate of the Point
     * @param y the y coordinate of the Point
     */
    public Point(double x, Integer y) {
        super(2);
        ScalarWrapper[] c = {new ScalarWrapper(x), new ScalarWrapper(y)};
        this.coordinates = c;
    }

    /**
     * Constructs a 2D Point from two double coordinates
     * @param x the x coordinate of the Point
     * @param y the y coordinate of the Point
     */
    public Point(double x, double y) {
        super(2);
        ScalarWrapper[] c = {new ScalarWrapper(x), new ScalarWrapper(y)};
        this.coordinates = c;
    }

    /**
     * Constructs a 2D Point from a double coordinate and a Double coordinate
     * @param x the x coordinate of the Point
     * @param y the y coordinate of the Point
     */
    public Point(double x, Double y) {
        super(2);
        ScalarWrapper[] c = {new ScalarWrapper(x), new ScalarWrapper(y)};
        this.coordinates = c;
    }

    /**
     * Constructs a 2D Point from a double coordinate and a Rational coordinate
     * @param x the x coordinate of the Point
     * @param y the y coordinate of the Point
     */
    public Point(double x, Rational y) {
        super(2);
        ScalarWrapper[] c = {new ScalarWrapper(x), new ScalarWrapper(y)};
        this.coordinates = c;
    }

    /**
     * Constructs a 2D Point from a Double coordinate and a ScalarWrapper coordinate
     * @param x the x coordinate of the Point
     * @param y the y coordinate of the Point
     */
    public Point(Double x, ScalarWrapper y) {
        super(2);
        ScalarWrapper[] c = {new ScalarWrapper(x), y};
        this.coordinates = c;
    }

    /**
     * Constructs a 2D Point from a Double coordinate and an int coordinate
     * @param x the x coordinate of the Point
     * @param y the y coordinate of the Point
     */
    public Point(Double x, int y) {
        super(2);
        ScalarWrapper[] c = {new ScalarWrapper(x), new ScalarWrapper(y)};
        this.coordinates = c;
    }

    /**
     * Constructs a 2D Point from a Double coordinate and an Integer coordinate
     * @param x the x coordinate of the Point
     * @param y the y coordinate of the Point
     */
    public Point(Double x, Integer y) {
        super(2);
        ScalarWrapper[] c = {new ScalarWrapper(x), new ScalarWrapper(y)};
        this.coordinates = c;
    }

    /**
     * Constructs a 2D Point from a Double coordinate and a double coordinate
     * @param x the x coordinate of the Point
     * @param y the y coordinate of the Point
     */
    public Point(Double x, double y) {
        super(2);
        ScalarWrapper[] c = {new ScalarWrapper(x), new ScalarWrapper(y)};
        this.coordinates = c;
    }

    /**
     * Constructs a 2D Point from two Double coordinates
     * @param x the x coordinate of the Point
     * @param y the y coordinate of the Point
     */
    public Point(Double x, Double y) {
        super(2);
        ScalarWrapper[] c = {new ScalarWrapper(x), new ScalarWrapper(y)};
        this.coordinates = c;
    }

    /**
     * Constructs a 2D Point from a Double coordinate and a Rational coordinate
     * @param x the x coordinate of the Point
     * @param y the y coordinate of the Point
     */
    public Point(Double x, Rational y) {
        super(2);
        ScalarWrapper[] c = {new ScalarWrapper(x), new ScalarWrapper(y)};
        this.coordinates = c;
    }

    /**
     * Constructs a 2D Point from a Rational coordinate and a ScalarWrapper coordinate
     * @param x the x coordinate of the Point
     * @param y the y coordinate of the Point
     */
    public Point(Rational x, ScalarWrapper y) {
        super(2);
        ScalarWrapper[] c = {new ScalarWrapper(x), y};
        this.coordinates = c;
    }

    /**
     * Constructs a 2D Point from a Rational coordinate and an int coordinate
     * @param x the x coordinate of the Point
     * @param y the y coordinate of the Point
     */
    public Point(Rational x, int y) {
        super(2);
        ScalarWrapper[] c = {new ScalarWrapper(x), new ScalarWrapper(y)};
        this.coordinates = c;
    }

    /**
     * Constructs a 2D Point from a Rational coordinate and an Integer coordinate
     * @param x the x coordinate of the Point
     * @param y the y coordinate of the Point
     */
    public Point(Rational x, Integer y) {
        super(2);
        ScalarWrapper[] c = {new ScalarWrapper(x), new ScalarWrapper(y)};
        this.coordinates = c;
    }

    /**
     * Constructs a 2D Point from a Rational coordinate and a double coordinate
     * @param x the x coordinate of the Point
     * @param y the y coordinate of the Point
     */
    public Point(Rational x, double y) {
        super(2);
        ScalarWrapper[] c = {new ScalarWrapper(x), new ScalarWrapper(y)};
        this.coordinates = c;
    }

    /**
     * Constructs a 2D Point from a Rational coordinate and a Double coordinate
     * @param x the x coordinate of the Point
     * @param y the y coordinate of the Point
     */
    public Point(Rational x, Double y) {
        super(2);
        ScalarWrapper[] c = {new ScalarWrapper(x), new ScalarWrapper(y)};
        this.coordinates = c;
    }

    /**
     * Constructs a 2D Point from two Rational coordinates
     * @param x the x coordinate of the Point
     * @param y the y coordinate of the Point
     */
    public Point(Rational x, Rational y) {
        super(2);
        ScalarWrapper[] c = {new ScalarWrapper(x), new ScalarWrapper(y)};
        this.coordinates = c;
    }

    /**
     * Constructs a 3D Point from three ScalarWrapper coordinates
     * @param x the x coordinate of the Point
     * @param y the y coordinate of the Point
     * @param z the z coordinate of the Point
     */
    public Point(ScalarWrapper x, ScalarWrapper y, ScalarWrapper z) {
        super(3);
        ScalarWrapper[] c = {x, y, z};
        this.coordinates = c;
    }

    /**
     * Constructs a 3D Point from three int coordinates
     * @param x the x coordinate of the Point
     * @param y the y coordinate of the Point
     * @param z the z coordinate of the Point
     */
    public Point(int x, int y, int z) {
        super(3);
        ScalarWrapper[] c = {new ScalarWrapper(x), new ScalarWrapper(y), new ScalarWrapper(z)};
        this.coordinates = c;
    }

    /**
     * Constructs a 3D Point from three Integer coordinates
     * @param x the x coordinate of the Point
     * @param y the y coordinate of the Point
     * @param z the z coordinate of the Point
     */
    public Point(Integer x, Integer y, Integer z) {
        super(3);
        ScalarWrapper[] c = {new ScalarWrapper(x), new ScalarWrapper(y), new ScalarWrapper(z)};
        this.coordinates = c;
    }

    /**
     * Constructs a 3D Point from three double coordinates
     * @param x the x coordinate of the Point
     * @param y the y coordinate of the Point
     * @param z the z coordinate of the Point
     */
    public Point(double x, double y, double z) {
        super(3);
        ScalarWrapper[] c = {new ScalarWrapper(x), new ScalarWrapper(y), new ScalarWrapper(z)};
        this.coordinates = c;
    }

    /**
     * Constructs a 3D Point from three Double coordinates
     * @param x the x coordinate of the Point
     * @param y the y coordinate of the Point
     * @param z the z coordinate of the Point
     */
    public Point(Double x, Double y, Double z) {
        super(3);
        ScalarWrapper[] c = {new ScalarWrapper(x), new ScalarWrapper(y), new ScalarWrapper(z)};
        this.coordinates = c;
    }

    /**
     * Constructs a 3D Point from three Rational coordinates
     * @param x the x coordinate of the Point
     * @param y the y coordinate of the Point
     * @param z the z coordinate of the Point
     */
    public Point(Rational x, Rational y, Rational z) {
        super(3);
        ScalarWrapper[] c = {new ScalarWrapper(x), new ScalarWrapper(y), new ScalarWrapper(z)};
        this.coordinates = c;
    }

    /**
     * Accessor for coordinates
     * @return the coordinates of this Point
     */
    public ScalarWrapper[] getCoordinates() {
        return this.coordinates;
    }

    /**
     * Returns the ith coordinate of this Point
     * @param i the index of the coordinate
     * @return the coordinate value
     */
    public ScalarWrapper get(int i) {
        return this.coordinates[i];
    }

    /**
     * Sets the ith coordinate of this Point to the specified ScalarWrapper
     * @param i the index of the coordinate being set
     * @param newValue the new value of the coordinate
     */
    public void set(int i, ScalarWrapper newValue) {
        this.coordinates[i] = newValue;
    }

    /**
     * Sets the ith coordinate of this Point to the specified int
     * @param i the index of the coordinate being set
     * @param newValue the new value of the coordinate
     */
    public void set(int i, int newValue) {
        this.coordinates[i] = new ScalarWrapper(newValue);
    }

    /**
     * Sets the ith coordinate of this Point to the specified Integer
     * @param i the index of the coordinate being set
     * @param newValue the new value of the coordinate
     */
    public void set(int i, Integer newValue) {
        this.coordinates[i] = new ScalarWrapper(newValue);
    }

    /**
     * Sets the ith coordinate of this Point to the specified double
     * @param i the index of the coordinate being set
     * @param newValue the new value of the coordinate
     */
    public void set(int i, double newValue) {
        this.coordinates[i] = new ScalarWrapper(newValue);
    }

    /**
     * Sets the ith coordinate of this Point to the specified Double
     * @param i the index of the coordinate being set
     * @param newValue the new value of the coordinate
     */
    public void set(int i, Double newValue) {
        this.coordinates[i] = new ScalarWrapper(newValue);
    }

    /**
     * Sets the ith coordinate of this Point to the specified Rational
     * @param i the index of the coordinate being set
     * @param newValue the new value of the coordinate
     */
    public void set(int i, Rational newValue) {
        this.coordinates[i] = new ScalarWrapper(newValue);
    }

    /**
     * Returns the first (x) coordinate of this Point
     * @return the x coordinate of this Point
     */
    public ScalarWrapper getX() {
        return this.get(0);
    }

    /**
     * Sets the first (x) coordinate of this Point to the specified ScalarWrapper
     * @param newValue the new value of x
     */
    public void setX(ScalarWrapper newValue) {
        this.set(0, newValue);
    }

    /**
     * Sets the first (x) coordinate of this Point to the specified int
     * @param newValue the new value of x
     */
    public void setX(int newValue) {
        this.set(0, newValue);
    }

    /**
     * Sets the first (x) coordinate of this Point to the specified Integer
     * @param newValue the new value of x
     */
    public void setX(Integer newValue) {
        this.set(0, newValue);
    }

    /**
     * Sets the first (x) coordinate of this Point to the specified double
     * @param newValue the new value of x
     */
    public void setX(double newValue) {
        this.set(0, newValue);
    }

    /**
     * Sets the first (x) coordinate of this Point to the specified Double
     * @param newValue the new value of x
     */
    public void setX(Double newValue) {
        this.set(0, newValue);
    }

    /**
     * Sets the first (x) coordinate of this Point to the specified Rational
     * @param newValue the new value of x
     */
    public void setX(Rational newValue) {
        this.set(0, newValue);
    }

    /**
     * Returns the second (y) coordinate of this Point
     * @return the y coordinate of this Point
     * @throws IllegalArgumentException if this Point is not at least 2D
     */
    public ScalarWrapper getY() {
        if (this.dim >= 2) {
            return this.get(1);
        } else {
            throw new IllegalArgumentException("Point must have at least dimension 2");
        }
    }

    /**
     * Sets the second (y) coordinate of this Point to the specified ScalarWrapper
     * @param newValue the new value of y
     * @throws IllegalArgumentException if this Point is not at least 2D
     */
    public void setY(ScalarWrapper newValue) {
        if (this.dim >= 2) {
            this.set(1, newValue);
        } else {
            throw new IllegalArgumentException("Point must have at least dimension 2");
        }
    }

    /**
     * Sets the second (y) coordinate of this Point to the specified int
     * @param newValue the new value of y
     * @throws IllegalArgumentException if this Point is not at least 2D
     */
    public void setY(int newValue) {
        if (this.dim >= 2) {
            this.set(1, newValue);
        } else {
            throw new IllegalArgumentException("Point must have at least dimension 2");
        }
    }

    /**
     * Sets the second (y) coordinate of this Point to the specified Integer
     * @param newValue the new value of y
     * @throws IllegalArgumentException if this Point is not at least 2D
     */
    public void setY(Integer newValue) {
        if (this.dim >= 2) {
            this.set(1, newValue);
        } else {
            throw new IllegalArgumentException("Point must have at least dimension 2");
        }
    }

    /**
     * Sets the second (y) coordinate of this Point to the specified double
     * @param newValue the new value of y
     * @throws IllegalArgumentException if this Point is not at least 2D
     */
    public void setY(double newValue) {
        if (this.dim >= 2) {
            this.set(1, newValue);
        } else {
            throw new IllegalArgumentException("Point must have at least dimension 2");
        }
    }

    /**
     * Sets the second (y) coordinate of this Point to the specified Double
     * @param newValue the new value of y
     * @throws IllegalArgumentException if this Point is not at least 2D
     */
    public void setY(Double newValue) {
        if (this.dim >= 2) {
            this.set(1, newValue);
        } else {
            throw new IllegalArgumentException("Point must have at least dimension 2");
        }
    }

    /**
     * Sets the second (y) coordinate of this Point to the specified Rational
     * @param newValue the new value of y
     * @throws IllegalArgumentException if this Point is not at least 2D
     */
    public void setY(Rational newValue) {
        if (this.dim >= 2) {
            this.set(1, newValue);
        } else {
            throw new IllegalArgumentException("Point must have at least dimension 2");
        }
    }

    /**
     * Returns the third (z) coordinate of this Point
     * @return the z coordinate of this Point
     * @throws IllegalArgumentException if this Point is not at least 3D
     */
    public ScalarWrapper getZ() {
        if (this.dim >= 3) {
            return this.get(2);
        } else {
            throw new IllegalArgumentException("Point must have at least dimension 3");
        }
    }

    /**
     * Sets the third (z) coordinate of this Point to the specified ScalarWrapper
     * @param newValue the new value of z
     * @throws IllegalArgumentException if this Point is not at least 3D
     */
    public void setZ(ScalarWrapper newValue) {
        if (this.dim >= 3) {
            this.set(2, newValue);
        } else {
            throw new IllegalArgumentException("Point must have at least dimension 3");
        }
    }

    /**
     * Sets the third (z) coordinate of this Point to the specified int
     * @param newValue the new value of z
     * @throws IllegalArgumentException if this Point is not at least 3D
     */
    public void setZ(int newValue) {
        if (this.dim >= 3) {
            this.set(2, newValue);
        } else {
            throw new IllegalArgumentException("Point must have at least dimension 3");
        }
    }

    /**
     * Sets the third (z) coordinate of this Point to the specified Integer
     * @param newValue the new value of z
     * @throws IllegalArgumentException if this Point is not at least 3D
     */
    public void setZ(Integer newValue) {
        if (this.dim >= 3) {
            this.set(2, newValue);
        } else {
            throw new IllegalArgumentException("Point must have at least dimension 3");
        }
    }

    /**
     * Sets the third (z) coordinate of this Point to the specified double
     * @param newValue the new value of z
     * @throws IllegalArgumentException if this Point is not at least 3D
     */
    public void setZ(double newValue) {
        if (this.dim >= 3) {
            this.set(2, newValue);
        } else {
            throw new IllegalArgumentException("Point must have at least dimension 3");
        }
    }

    /**
     * Sets the third (z) coordinate of this Point to the specified Double
     * @param newValue the new value of z
     * @throws IllegalArgumentException if this Point is not at least 3D
     */
    public void setZ(Double newValue) {
        if (this.dim >= 3) {
            this.set(2, newValue);
        } else {
            throw new IllegalArgumentException("Point must have at least dimension 3");
        }
    }

    /**
     * Sets the third (z) coordinate of this Point to the specified Rational
     * @param newValue the new value of z
     * @throws IllegalArgumentException if this Point is not at least 3D
     */
    public void setZ(Rational newValue) {
        if (this.dim >= 3) {
            this.set(2, newValue);
        } else {
            throw new IllegalArgumentException("Point must have at least dimension 3");
        }
    }

    /**
     * Returns a version of this Point with all coordinates reduced and simplified
     * @return a reduced and simplified version of this Point
     */
    public Point simplified() {
        Point copy = this.clone();
        copy.simplify();
        return copy;
    }

    /**
     * Reduces and simplifies all coordinates of this Point
     */
    public void simplify() {
        for (int i = 0; i < this.dim; i++) {
            this.get(i).simplify();
        }
    }

    /**
     * Returns a version of this Point with all Rationals reduced to lowest terms
     * @return a reduced version of this Point
     */
    public Point reduced() {
        Point copy = this.clone();
        copy.reduce();
        return copy;
    }

    /**
     * Reduces all Rationals in this Point to lowest terms
     */
    public void reduce() {
        for (int i = 0; i < this.dim; i++) {
            this.get(i).reduce();
        }
    }

    /**
     * Converts all coordinates of this Point to doubles
     */
    public void convertToDoubles() {
        for (ScalarWrapper coordinate : this.coordinates) {
            coordinate.convertToDouble();
        }
    }

    /**
     * Converts all coordinates of this Point to Rationals
     */
    public void convertToRationals() {
        for (ScalarWrapper coordinate : this.coordinates) {
            coordinate.convertToRat();
        }
    }

    /**
     * Converts all coordinates of this Point to integers (if whole) or Rationals (otherwise)
     */
    public void convertToIntsOrRationals() {
        for (ScalarWrapper coordinate : this.coordinates) {
            coordinate.convertToIntOrRat();
        }
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
        Point copy = this.clone();
        for (int i = 0; i < this.dim; i++) {
            copy.set(i, this.get(i).absolute());
        }
        return copy;
    }

    /**
     * Compares this Point to another Point
     * @param other the Point to compare with
     * @return true if this Point is equal to other; false otherwise
     */
    public boolean equals(Point other) {
        if (!this.sameDimension(other)) {
            return false;
        }

        for (int i = 0; i < this.dim; i++) {
            if (!this.get(i).equals(other.get(i))) {
                return false;
            }
        }

        return true;
    }

    /**
     * Adds this Point and another Point
     * @param other the Point to add to this Point
     * @return the sum of this Point and other
     * @throws IllegalArgumentException if this Point and other do not share dimension
     */
    public Point add(Point other) {
        if (!this.sameDimension(other)) {
            throw new IllegalArgumentException("Points must share dimension");
        }

        ScalarWrapper[] sum = new ScalarWrapper[this.dim];
        for (int i = 0; i < this.dim; i++) {
            sum[i] = this.get(i).add(other.get(i));
        }
        return new Point(sum);
    }

    /**
     * Adds this Point and a Vector
     * @param other the Vector to add to this Point
     * @return the sum of this Point and other
     * @throws IllegalArgumentException if this Point and other do not share dimension
     */
    public Point add(Vector other) {
        if (!this.sameDimension(other)) {
            throw new IllegalArgumentException("Point and Vector must share dimension");
        }

        ScalarWrapper[] sum = new ScalarWrapper[this.dim];
        for (int i = 0; i < this.dim; i++) {
            sum[i] = this.get(i).add(other.get(i));
        }
        return new Point(sum);
    }

    /**
     * Adds this Point and a NormalVector
     * @param other the NormalVector to add to this Point
     * @return the sum of this Point and other
     * @throws IllegalArgumentException if this Point and other do not share dimension
     */
    public Point add(NormalVector other) {
        return this.add(other.trueValue());
    }

    /**
     * Subtracts another Point from this Point
     * @param other the Point to subtract from this Point
     * @return the difference between this Point and other
     * @throws IllegalArgumentException if this Point and other do not share dimension
     */
    public Point subtract(Point other) {
        return this.add(other.negative());
    }

    /**
     * Subtracts a Vector from this Point
     * @param other the Vector to subtract from this Point
     * @return the difference between this Point and other
     * @throws IllegalArgumentException if this Point and other do not share dimension
     */
    public Point subtract(Vector other) {
        return this.add(other.negative());
    }

    /**
     * Subtracts a NormalVector from this Point
     * @param other the NormalVector to subtract from this Point
     * @return the difference between this Point and other
     * @throws IllegalArgumentException if this Point and other do not share dimension
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
        ScalarWrapper[] product = new ScalarWrapper[this.dim];
        for (int i = 0; i < this.dim; i++) {
            product[i] = this.get(i).multiply(other);
        }
        return new Point(product);
    }

    /**
     * Multiplies this Point by an int
     * @param other the int to multiply with this Point
     * @return the product of this Point and other
     */
    public Point multiply(int other) {
        ScalarWrapper[] product = new ScalarWrapper[this.dim];
        for (int i = 0; i < this.dim; i++) {
            product[i] = this.get(i).multiply(other);
        }
        return new Point(product);
    }

    /**
     * Multiplies this Point by an Integer
     * @param other the Integer to multiply with this Point
     * @return the product of this Point and other
     */
    public Point multiply(Integer other) {
        ScalarWrapper[] product = new ScalarWrapper[this.dim];
        for (int i = 0; i < this.dim; i++) {
            product[i] = this.get(i).multiply(other);
        }
        return new Point(product);
    }

    /**
     * Multiplies this Point by a double
     * @param other the double to multiply with this Point
     * @return the product of this Point and other
     */
    public Point multiply(double other) {
        ScalarWrapper[] product = new ScalarWrapper[this.dim];
        for (int i = 0; i < this.dim; i++) {
            product[i] = this.get(i).multiply(other);
        }
        return new Point(product);
    }

    /**
     * Multiplies this Point by a Double
     * @param other the Double to multiply with this Point
     * @return the product of this Point and other
     */
    public Point multiply(Double other) {
        ScalarWrapper[] product = new ScalarWrapper[this.dim];
        for (int i = 0; i < this.dim; i++) {
            product[i] = this.get(i).multiply(other);
        }
        return new Point(product);
    }

    /**
     * Multiplies this Point by a Rational
     * @param other the Rational to multiply with this Point
     * @return the product of this Point and other
     */
    public Point multiply(Rational other) {
        ScalarWrapper[] product = new ScalarWrapper[this.dim];
        for (int i = 0; i < this.dim; i++) {
            product[i] = this.get(i).multiply(other);
        }
        return new Point(product);
    }

    /**
     * Multiplies this Point by a ScalarWrapper
     * @param other the ScalarWrapper to multiply with this Point
     * @return the product of this Point and other
     */
    public Point divideBy(ScalarWrapper other) {
        ScalarWrapper[] product = new ScalarWrapper[this.dim];
        for (int i = 0; i < this.dim; i++) {
            product[i] = this.get(i).divideBy(other);
        }
        return new Point(product);
    }

    /**
     * Multiplies this Point by an int
     * @param other the int to multiply with this Point
     * @return the product of this Point and other
     */
    public Point divideBy(int other) {
        ScalarWrapper[] product = new ScalarWrapper[this.dim];
        for (int i = 0; i < this.dim; i++) {
            product[i] = this.get(i).divideBy(other);
        }
        return new Point(product);
    }

    /**
     * Multiplies this Point by an Integer
     * @param other the Integer to multiply with this Point
     * @return the product of this Point and other
     */
    public Point divideBy(Integer other) {
        ScalarWrapper[] product = new ScalarWrapper[this.dim];
        for (int i = 0; i < this.dim; i++) {
            product[i] = this.get(i).divideBy(other);
        }
        return new Point(product);
    }

    /**
     * Multiplies this Point by a double
     * @param other the double to multiply with this Point
     * @return the product of this Point and other
     */
    public Point divideBy(double other) {
        ScalarWrapper[] product = new ScalarWrapper[this.dim];
        for (int i = 0; i < this.dim; i++) {
            product[i] = this.get(i).divideBy(other);
        }
        return new Point(product);
    }

    /**
     * Multiplies this Point by a Double
     * @param other the Double to multiply with this Point
     * @return the product of this Point and other
     */
    public Point divideBy(Double other) {
        ScalarWrapper[] product = new ScalarWrapper[this.dim];
        for (int i = 0; i < this.dim; i++) {
            product[i] = this.get(i).divideBy(other);
        }
        return new Point(product);
    }

    /**
     * Multiplies this Point by a Rational
     * @param other the Rational to multiply with this Point
     * @return the product of this Point and other
     */
    public Point divideBy(Rational other) {
        ScalarWrapper[] product = new ScalarWrapper[this.dim];
        for (int i = 0; i < this.dim; i++) {
            product[i] = this.get(i).divideBy(other);
        }
        return new Point(product);
    }

    /**
     * Checks if this Point is on a given Line
     * @param other the Line to compare with
     * @return true if this Point is on other; false otherwise
     * @throws IllegalArgumentException if this Point and other do not share dimension
     */
    public boolean isOnLine(Line other) {
        if (!this.sameDimension(other)) {
            throw new IllegalArgumentException("Point and Line must share dimension");
        }

        return other.includesPoint(this);
    }

    /**
     * Checks if this Point is on a given Plane
     * @param other the Plane to compare with
     * @return true if this Point is on other; false otherwise
     * @throws IllegalArgumentException if this Point is not 3D
     */
    public boolean isOnPlane(Plane other) {
        if (!this.is3D()) {
            throw new IllegalArgumentException("Point must be 3D");
        }

        return other.includesPoint(this);
    }

    /**
     * Returns a PointPolar representing this 2D Point in polar coordinates
     * @return the representation of this 2D Point in polar coordinates
     */
    public PointPolar polarForm() {
        if (!this.is2D()) {
            throw new IllegalArgumentException("Point must be 2D");
        }

        ScalarWrapper rSquared = this.getX().squared().add(this.getY().squared());
        ScalarWrapper r = rSquared.root();

        double thetaPosNeg = Math.atan2(this.getX().doubleValue(), this.getY().doubleValue());
        if (thetaPosNeg < 0) {
            thetaPosNeg = 2*Math.PI + thetaPosNeg;
        }
        ScalarWrapper theta = new ScalarWrapper(thetaPosNeg);
        theta.simplify();

        return new PointPolar(r, theta);
    }

    /**
     * Creates and returns a deep copy of this Point
     * @return a deep copy of this Point
     */
    @Override
    public Point clone() {
        Stream<ScalarWrapper> st = Arrays.stream(this.coordinates);
        ScalarWrapper[] arr = st.map(val -> val.clone()).toArray(ScalarWrapper[]::new);
        return new Point(arr);
    }

    /**
     * Returns a String representation of this Point
     * @return a String representation of this Point
     */
    @Override
    public String toString() {
        String s = "(";
        for (int i = 0; i < this.dim; i++) {
            if (i != 0) {
                s += " ";
            }
            s += this.get(i);
        }
        s += ")";

        return s;
    }

    /**
     * Returns the origin point in n dimensions
     * @param n the dimension of the point
     * @return the origin point
     */
    public static Point origin(int n) {
        int[] coordinates = new int[n];
        return new Point(coordinates);
    }

}
