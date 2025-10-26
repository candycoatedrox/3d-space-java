import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

public class Vector implements Cloneable {

    protected ScalarWrapper[] components;
    protected final int dim;
    protected static final double PI = Math.acos(-1);

    /**
     * Constructs an empty Vector of dimension dim
     * @param dim the dimension of the Vector
     */
    public Vector(int dim) {
        this.components = new ScalarWrapper[dim];
        this.dim = dim;
    }

    /**
     * Constructs a Vector from an array of ScalarWrappers
     * @param components an array of the Vector's components
     */
    public Vector(ScalarWrapper[] components) {
        this.components = components;
        this.dim = components.length;
    }

    /**
     * Constructs a Vector from an array of ints
     * @param components an array of the Vector's components
     */
    public Vector(int[] components) {
        this.components = ScalarWrapper.wrapArray(components);
        this.dim = components.length;
    }

    /**
     * Constructs a Vector from an array of Integers
     * @param components an array of the Vector's components
     */
    public Vector(Integer[] components) {
        this.components = ScalarWrapper.wrapArray(components);
        this.dim = components.length;
    }

    /**
     * Constructs a Vector from an array of doubles
     * @param components an array of the Vector's components
     */
    public Vector(double[] components) {
        this.components = ScalarWrapper.wrapArray(components);
        this.dim = components.length;
    }

    /**
     * Constructs a Vector from an array of Doubles
     * @param components an array of the Vector's components
     */
    public Vector(Double[] components) {
        this.components = ScalarWrapper.wrapArray(components);
        this.dim = components.length;
    }

    /**
     * Constructs a Vector from an array of Rationals
     * @param components an array of the Vector's components
     */
    public Vector(Rational[] components) {
        this.components = ScalarWrapper.wrapArray(components);
        this.dim = components.length;
    }

    /**
     * Accessor for components
     * @return the components of this Vector
     */
    public ScalarWrapper[] getcomponents() {
        return this.components;
    }

    /**
     * Returns the ith component of this Vector
     * @param i the index of the component
     * @return the ith component of this Vector
     */
    public ScalarWrapper get(int i) {
        return this.components[i];
    }

    /**
     * Sets the ith component of this Vector to the specified ScalarWrapper
     * @param i the index of the component being set
     * @param newValue the value to set the component to
     */
    public void set(int i, ScalarWrapper newValue) {
        this.components[i] = newValue;
    }

    /**
     * Sets the ith component of this Vector to the specified int
     * @param i the index of the component being set
     * @param newValue the value to set the component to
     */
    public void set(int i, int newValue) {
        this.components[i] = new ScalarWrapper(newValue);
    }

    /**
     * Sets the ith component of this Vector to the specified Integer
     * @param i the index of the component being set
     * @param newValue the value to set the component to
     */
    public void set(int i, Integer newValue) {
        this.components[i] = new ScalarWrapper(newValue);
    }

    /**
     * Sets the ith component of this Vector to the specified double
     * @param i the index of the component being set
     * @param newValue the value to set the component to
     */
    public void set(int i, double newValue) {
        this.components[i] = new ScalarWrapper(newValue);
    }

    /**
     * Sets the ith component of this Vector to the specified Double
     * @param i the index of the component being set
     * @param newValue the value to set the component to
     */
    public void set(int i, Double newValue) {
        this.components[i] = new ScalarWrapper(newValue);
    }

    /**
     * Sets the ith component of this Vector to the specified Rational
     * @param i the index of the component being set
     * @param newValue the value to set the component to
     */
    public void set(int i, Rational newValue) {
        this.components[i] = new ScalarWrapper(newValue);
    }

    /**
     * Accessor for dim
     * @return the dimension of this Vector
     */
    public int getDim() {
        return this.dim;
    }

    /**
     * Returns a version of this Vector with all components reduced and simplified
     * @return a reduced and simplified version of this Vector
     */
    public Vector simplified() {
        Vector copy = this.clone();
        copy.simplify();
        return copy;
    }

    /**
     * Reduces and simplifies all components of this Vector
     */
    public void simplify() {
        for (int i = 0; i < this.dim; i++) {
            this.get(i).simplify();
        }
    }

    /**
     * Returns a version of this Vector with all Rationals reduced to lowest terms
     * @return a reduced version of this Vector
     */
    public Vector reduced() {
        Vector copy = this.clone();
        copy.reduce();
        return copy;
    }

    /**
     * Reduces all Rationals in this Vector to lowest terms
     */
    public void reduce() {
        for (int i = 0; i < this.dim; i++) {
            this.get(i).reduce();
        }
    }

    /**
     * Converts all components of this Vector to doubles
     */
    public void convertToDoubles() {
        for (ScalarWrapper component : this.components) {
            component.convertToDouble();
        }
    }

    /**
     * Converts all components of this Vector to Rationals
     */
    public void convertToRationals() {
        for (ScalarWrapper component : this.components) {
            component.convertToRat();
        }
    }

    /**
     * Converts all components of this Vector to integers (if whole) or Rationals (otherwise)
     */
    public void convertToIntsOrRationals() {
        for (ScalarWrapper component : this.components) {
            component.convertToIntOrRat();
        }
    }

    /**
     * Calculates the magnitude-squared of this Vector
     * @return the magnitude-squared of this Vector
     */
    public ScalarWrapper mag2() {
        Matrix Gij = Matrix.identityMatrix(this.dim);
        return innerProduct(this, this, Gij);
    }

    /**
     * Calculates the magnitude-squared of this Vector in a given inner product space
     * @param Gij the Matrix representing a given inner product
     * @return the magnitude-squared of this Vector in the given inner product space
     */
    public ScalarWrapper mag2(Matrix Gij) {
        return innerProduct(this, this, Gij);
    }
    
    /**
     * Calculates the magnitude of this Vector
     * @return the magnitude of this Vector
     */
    public ScalarWrapper mag() {
        Matrix Gij = Matrix.identityMatrix(this.dim);
        return this.mag(Gij);
    }

    /**
     * Calculates the magnitude of this Vector in a given inner product space
     * @param Gij the Matrix representing a given inner product
     * @return the magnitude of this Vector in the given inner product space
     */
    public ScalarWrapper mag(Matrix Gij) {
        ScalarWrapper mag2 = this.mag2(Gij);
        mag2.convertToDouble();

        double root = Math.sqrt(mag2.getDouble());
        ScalarWrapper wrapper = new ScalarWrapper(root);
        return wrapper.simplified();
    }

    /**
     * Returns the negative version of this Vector
     * @return the negative version of this Vector
     */
    public Vector negative() {
        return this.multiply(-1);
    }

    /**
     * Returns the absolute value of this Vector
     * @return the absolute value of this Vector
     */
    public Vector absolute() {
        Vector copy = this.clone();
        for (int i = 0; i < this.dim; i++) {
            copy.set(i, this.get(i).absolute());
        }
        return copy;
    }

    /**
     * Checks whether this Vector is a scalar multiple of another Vector
     * @param other the Vector to compare with
     * @return true if this Vector is a scalar multiple of other; false otherwise
     */
    public boolean isScalarMultOf(Vector other) {
        if (this.dim != other.dim) {
            throw new IllegalArgumentException("Vectors must share dimension");
        }

        Matrix Gij = Matrix.identityMatrix(this.dim);
        return this.isScalarMultOf(other, Gij);
    }

    /**
     * Checks whether this Vector is a scalar multiple of another Vector in a given inner product space
     * @param other the Vector to compare with
     * @param Gij the Matrix representing a given inner product
     * @return true if this Vector is a scalar multiple of other in the given inner product space; false otherwise
     */
    public boolean isScalarMultOf(Vector other, Matrix Gij) {
        if (this.dim != other.dim) {
            throw new IllegalArgumentException("Vectors must share dimension");
        }

        NormalVector thisNormal = this.normalize(Gij);
        NormalVector otherNormal = other.normalize(Gij);
        return thisNormal.trueValue() == otherNormal.trueValue();
    }

    /**
     * Checks whether two Vectors are equal
     * @param other the Vector to compare with
     * @return true if all components of this Vector are equal to their counterparts in other; false otherwise
     */
    public boolean equals(Vector other) {
        if (this.dim != other.dim) {
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
     * Adds this Vector and another Vector
     * @param other the Vector to add to this Vector
     * @return the sum of this Vector and other
     */
    public Vector add(Vector other) {
        if (this.dim != other.dim) {
            throw new RuntimeException("Vectors must share dimension");
        }

        ScalarWrapper[] sum = new ScalarWrapper[this.dim];
        for (int i = 0; i < this.dim; i++) {
            sum[i] = this.get(i).add(other.get(i));
        }
        return new Vector(sum);
    }

    /**
     * Subtracts another Vector from this Vector
     * @param other the Vector to subtract from this Vector
     * @return the difference between this Vector and other
     */
    public Vector subtract(Vector other) {
        return this.add(other.negative());
    }

    /**
     * Multiplies this Vector with a ScalarWrapper
     * @param other the ScalarWrapper to multiply with this Vector
     * @return the product of this Vector and other
     */
    public Vector multiply(ScalarWrapper other) {
        if (other.isInt()) {
            return this.multiply(other.getInt());
        } else if (other.isDouble()) {
            return this.multiply(other.getDouble());
        } else {
            return this.multiply(other.getRat());
        }
    }

    /**
     * Multiplies this Vector with an int
     * @param other the int to multiply with this Vector
     * @return the product of this Vector and other
     */
    public Vector multiply(int other) {
        ScalarWrapper[] product = new ScalarWrapper[this.dim];
        for (int i = 0; i < this.dim; i++) {
            product[i] = this.get(i).multiply(other);
        }
        return new Vector(product);
    }

    /**
     * Multiplies this Vector with an Integer
     * @param other the Integer to multiply with this Vector
     * @return the product of this Vector and other
     */
    public Vector multiply(Integer other) {
        return this.multiply(other.intValue());
    }

    /**
     * Multiplies this Vector with a double
     * @param other the double to multiply with this Vector
     * @return the product of this Vector and other
     */
    public Vector multiply(double other) {
        ScalarWrapper[] product = new ScalarWrapper[this.dim];
        for (int i = 0; i < this.dim; i++) {
            product[i] = this.get(i).multiply(other);
        }
        return new Vector(product);
    }

    /**
     * Multiplies this Vector with a Double
     * @param other the Double to multiply with this Vector
     * @return the product of this Vector and other
     */
    public Vector multiply(Double other) {
        return this.multiply(other.intValue());
    }

    /**
     * Multiplies this Vector with a Rational
     * @param other the Rational to multiply with this Vector
     * @return the product of this Vector and other
     */
    public Vector multiply(Rational other) {
        ScalarWrapper[] product = new ScalarWrapper[this.dim];
        for (int i = 0; i < this.dim; i++) {
            product[i] = this.get(i).multiply(other);
        }
        return new Vector(product);
    }

    /**
     * Multiplies a Vector by a Matrix
     * @param other the Matrix to multiply this Vector with
     * @return the product of the Vector and the Matrix
     */
    public Matrix multiply(Matrix other) {
        if (other.getN() != 1) {
            throw new IllegalArgumentException("Vector and Matrix are incompatible");
        }

        return this.toMatrix().multiply(other);
    }

    /**
     * Divides this Vector by a ScalarWrapper
     * @param other the ScalarWrapper to divide this Vector by
     * @return the quotient of this ScalarWrapper and other
     */
    public Vector divideBy(ScalarWrapper other) {
        if (other.isInt()) {
            return this.divideBy(other.getInt());
        } else if (other.isDouble()) {
            return this.divideBy(other.getDouble());
        } else {
            return this.divideBy(other.getRat());
        }
    }

    /**
     * Divides this Vector by an int
     * @param other the int to divide this Vector by
     * @return the quotient of this ScalarWrapper and other
     */
    public Vector divideBy(int other) {
        return this.multiply(new Rational(1, other));
    }

    /**
     * Divides this Vector by an Integer
     * @param other the Integer to divide this Vector by
     * @return the quotient of this ScalarWrapper and other
     */
    public Vector divideBy(Integer other) {
        return this.divideBy(other.intValue());
    }

    /**
     * Divides this Vector by a double
     * @param other the double to divide this Vector by
     * @return the quotient of this ScalarWrapper and other
     */
    public Vector divideBy(double other) {
        double invert = 1 / other;
        return this.multiply(new Rational(invert));
    }

    /**
     * Divides this Vector by a Double
     * @param other the double to divide this Vector by
     * @return the quotient of this ScalarWrapper and other
     */
    public Vector divideBy(Double other) {
        return this.divideBy(other.doubleValue());
    }

    /**
     * Divides this Vector by a Rational
     * @param other the Rational to divide this Vector by
     * @return the quotient of this ScalarWrapper and other
     */
    public Vector divideBy(Rational other) {
        return this.multiply(other.invert());
    }

    /**
     * Checks whether this Vector is orthogonal to another Vector
     * @param other the Vector to compare with
     * @return true if this Vector is orthogonal to other; false otherwise
     */
    public boolean orthogonalTo(Vector other) {
        if (this.dim != other.dim) {
            throw new IllegalArgumentException("Vectors must share dimension");
        }

        Matrix Gij = Matrix.identityMatrix(this.dim);
        return (innerProduct(this, other, Gij).equals(0));
    }

    /**
     * Checks whether this Vector is orthogonal to another Vector in a given inner product space
     * @param other the Vector to compare with
     * @param Gij the Matrix representing a given inner product
     * @return true if this Vector is orthogonal to other in the given inner product space; false otherwise
     */
    public boolean orthogonalTo(Vector other, Matrix Gij) {
        return (innerProduct(this, other, Gij).equals(0));
    }

    /**
     * Calculates the cosine of the angle between this Vector and another Vector
     * @param other the other Vector making up the angle
     * @return the cosine of the angle between the two Vectors
     */
    public double cosAngle(Vector other) {
        if (this.dim != other.dim) {
            throw new IllegalArgumentException("Vectors must share dimension");
        }

        Matrix Gij = Matrix.identityMatrix(this.dim);
        return this.cosAngle(other, Gij);
    }

    /**
     * Calculates the cosine of the angle between this Vector and another Vector
     * @param other the other Vector making up the angle
     * @param Gij the Matrix representing a given inner product
     * @return the cosine of the angle between the two Vectors
     */
    public double cosAngle(Vector other, Matrix Gij) {
        if (this.dim != other.dim) {
            throw new IllegalArgumentException("Vectors must share dimension");
        }
        
        ScalarWrapper cos = innerProduct(this, other, Gij).divideBy(this.mag(Gij).multiply(other.mag(Gij)));
        return cos.getDouble();
    }

    /**
     * Calculates the angle between this Vector and another Vector
     * @param other the other Vector making up the angle
     * @return the angle between the two Vectors
     */
    public double angle(Vector other) {
        if (this.dim != other.dim) {
            throw new IllegalArgumentException("Vectors must share dimension");
        }

        Matrix Gij = Matrix.identityMatrix(this.dim);
        return this.cosAngle(other, Gij);
    }

    /**
     * Calculates the angle between this Vector and another Vector
     * @param other the other Vector making up the angle
     * @param Gij the Matrix representing a given inner product
     * @return the angle between the two Vectors
     */
    public double angle(Vector other, Matrix Gij) {
        if (this.dim != other.dim) {
            throw new IllegalArgumentException("Vectors must share dimension");
        }
        
        return Math.acos(this.cosAngle(other, Gij));
    }

    /**
     * Calculates the angle between this Vector and another Vector as a multiple of pi
     * @param other the other Vector making up the angle
     * @return the angle between the two Vectors, divided by pi
     */
    public ScalarWrapper angleMultipleOfPi(Vector other) {
        if (this.dim != other.dim) {
            throw new IllegalArgumentException("Vectors must share dimension");
        }

        Matrix Gij = Matrix.identityMatrix(this.dim);
        return this.angleMultipleOfPi(other, Gij);
    }

    /**
     * Calculates the angle between this Vector and another Vector as a multiple of pi
     * @param other the other Vector making up the angle
     * @param Gij the Matrix representing a given inner product
     * @return the angle between the two Vectors, divided by pi
     */
    public ScalarWrapper angleMultipleOfPi(Vector other, Matrix Gij) {
        if (this.dim != other.dim) {
            throw new IllegalArgumentException("Vectors must share dimension");
        }

        double multiple = this.angle(other, Gij) / PI;
        Rational multipleRat = new Rational(multiple);
        if (multipleRat.equals(multiple)) { // if multiple is rational
            ScalarWrapper wrapper = new ScalarWrapper(multipleRat);
            wrapper.convertToIntOrRat();
            return wrapper;
        } else {
            return new ScalarWrapper(multiple);
        }
    }

    /**
     * Returns the projection of another Vector onto this Vector
     * @param other the Vector to project onto this Vector
     * @return the projection of the two Vectors
     */
    public Vector projection(Vector other) {
        if (this.dim != other.dim) {
            throw new IllegalArgumentException("Vectors must share dimension");
        }
        
        Matrix Gij = Matrix.identityMatrix(this.dim);
        return this.projection(other, Gij);
    }

    /**
     * Returns the projection of another Vector onto this Vector in a given inner product space
     * @param other the Vector to project onto this Vector
     * @param Gij the Matrix representing a given inner product
     * @return the projection of the two Vectors in the given inner product space
     */
    public Vector projection(Vector other, Matrix Gij) {
        ScalarWrapper scalarFactor = innerProduct(this, other).divideBy(this.mag2(Gij));
        return this.multiply(scalarFactor);
    }

    /**
     * Returns the projection of this Vector onto another Vector
     * @param other the Vector to project this Vector onto
     * @return the projection of the two Vectors
     */
    public Vector projectionOnto(Vector other) {
        if (this.dim != other.dim) {
            throw new IllegalArgumentException("Vectors must share dimension");
        }
        
        Matrix Gij = Matrix.identityMatrix(this.dim);
        return other.projection(this, Gij);
    }

    /**
     * Returns the projection of this Vector onto another Vector in a given inner product space
     * @param other the Vector to project this Vector onto
     * @param Gij the Matrix representing a given inner product
     * @return the projection of the two Vectors in the given inner product space
     */
    public Vector projectionOnto(Vector other, Matrix Gij) {
        if (this.dim != other.dim) {
            throw new IllegalArgumentException("Vectors must share dimension");
        }

        return other.projection(this, Gij);
    }

    /**
     * Creates and returns a deep copy of this Vector
     * @return a deep copy of this Vector
     */
    @Override
    public Vector clone() {
        Stream<ScalarWrapper> st = Arrays.stream(this.components);
        ScalarWrapper[] arr = st.map(val -> val.clone()).toArray(ScalarWrapper[]::new);
        return new Vector(arr);
    }

    /**
     * Creates and returns the unit vector in the direction of this Vector
     * @return the unit vector in the direction of this Vector
     */
    public NormalVector normalize() {
        Matrix Gij = Matrix.identityMatrix(this.dim);
        return this.normalize(Gij);
    }

    /**
     * Creates and returns the unit vector in the direction of this Vector in a given inner product space
     * @param Gij the Matrix representing a given inner product
     * @return the unit vector in the direction of this Vector in the given inner product space
     */
    public NormalVector normalize(Matrix Gij) {
        Vector v = this;

        // Simplify the vector as much as possible without changing direction
        boolean hasRat = false;
        boolean hasDouble = false;
        ArrayList<Integer> denominators = new ArrayList<>();
        for (int n = 0; n < this.dim; n++) {
            if (this.get(n).isDouble()) {
                this.get(n).convertToIntOrRat();
            }
            
            if (this.get(n).isRat()) {
                hasRat = true;
                denominators.add(this.get(n).getRat().getDenominator());
            }
        }

        // Turn all Rationals into integers
        if (hasRat) {
            int lcm = denominators.get(0);
            if (denominators.size() > 1) {
                for (int i = 1; i < denominators.size(); i++) {
                    lcm = Util.lcm(lcm, denominators.get(i));
                }
            }

            v = v.multiply(lcm);
            v.simplify();
        }

        int gcd = v.get(0).getInt();
        if (v.dim > 1) {
            for (int i = 1; i < v.dim; i++) {
                gcd = Util.gcd(gcd, v.get(i).getInt());
            }
        }

        v = v.divideBy(gcd);

        ScalarWrapper mag2 = v.mag2(Gij);
        // if there are any doubles, the magnitude squared likely won't be an int...
        // fix this somehow??
        return new NormalVector(this.components, mag2.getInt());
    }

    /**
     * Returns this Vector as a Matrix
     * @return the Matrix form of this Vector
     */
    public Matrix toMatrix() {
        return new Matrix(this);
    }

    /**
     * Returns a String representation of this Vector
     * @return a String representation of this Vector
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
     * Returns the inner product of two Vectors
     * @param v the first Vector in the inner product
     * @param w the second Vector in the inner product
     * @return the inner product of v and w
     * @throws IllegalArgumentException if v and w have different dimensions
     */
    public static ScalarWrapper innerProduct(Vector v, Vector w) throws IllegalArgumentException {
        if (v.dim != w.dim) {
            throw new IllegalArgumentException("Vectors must share dimension");
        }

        Matrix Gij = Matrix.identityMatrix(v.dim);
        return innerProduct(v, w, Gij);
    }

    /**
     * Returns the inner product of two Vectors in a given inner product space
     * @param v the first Vector in the inner product
     * @param w the second Vector in the inner product
     * @param Gij the Matrix representing a given inner product
     * @return the inner product of v and w in the given inner product space
     * @throws IllegalArgumentException if v and w have different dimensions
     */
    public static ScalarWrapper innerProduct(Vector v, Vector w, Matrix Gij) throws IllegalArgumentException {
        if (v.dim != w.dim) {
            throw new IllegalArgumentException("Vectors must share dimension");
        }

        Rational sum = new Rational(0);
        Rational temp;
        for (int i = 0; i < v.dim; i++) {
            for (int j = 0; j < v.dim; j++) {
                temp = new Rational(v.get(i).multiply(w.get(i)).multiply(Gij.get(i, j)));
                sum = sum.add(temp);
            }
        }

        return new ScalarWrapper(sum);
    }

    /**
     * Returns the dot product of two Vectors
     * @param v the first Vector in the dot product
     * @param w the second Vector in the dot product
     * @return the dot product of v and w
     * @throws IllegalArgumentException if v and w have different dimensions
     */
    public static ScalarWrapper dotProduct(Vector v, Vector w) throws IllegalArgumentException {
        return innerProduct(v, w);
    }

    /**
     * Returns the cross product of two Vectors
     * @param v the first Vector in the cross product
     * @param w the second Vector in the cross product
     * @return the cross product of v and w
     * @throws IllegalArgumentException if v and w have different dimensions
     */
    public static Vector crossProduct(Vector v, Vector w) throws IllegalArgumentException {
        if (v.dim != 3 || w.dim != 3) {
            throw new IllegalArgumentException("Cross product can only be calculated in 3 dimensions");
        }

        int[] dim = {1, 2, 0, 1};
        ScalarWrapper[] product = new ScalarWrapper[3];
        ScalarWrapper temp;
        for (int i = 0; i < 3; i++) {
            temp = v.get(dim[i]).multiply(w.get(dim[i+1])).subtract(v.get(dim[i+1]).multiply(w.get(dim[i])));
            product[i] = temp.clone();
        }

        return new Vector(product);
    }

    /**
     * Returns the zero Vector of a given dimension
     * @param dimV the dimension of the Vector
     * @return the zero Vector of dimV
     */
    public static Vector zeroVector(int dimV) {
        int[] components = new int[dimV];
        return new Vector(components);
    }

    /* public static void main(String[] args) {
        int[] arr = {2, 5};
        ScalarWrapper[] testArr = ScalarWrapper.wrapArray(arr);
        Vector testVector = new Vector(arr);
        System.out.println(testVector);
    } */

}
