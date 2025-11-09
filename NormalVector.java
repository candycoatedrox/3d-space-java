import java.util.Arrays;
import java.util.stream.Stream;

public class NormalVector extends Vector {

    private int divSqrt;

    // refuses to recognize Vector as a class and not a constructor???
    /* public NormalVector(Vector v) {
        Vector copy = v.clone();
        this.components = copy.components;
        this.dim = v.dim;
        this.divSqrt = v.mag2().getInt();
    }

    public NormalVector(Vector v, Matrix Gij) {
        Vector copy = v.clone();
        this.components = copy.components;
        this.dim = v.dim;
        this.divSqrt = v.mag2(Gij).getInt();
    } */

    /**
     * Constructs a normalized vector from a list of ScalarWrappers and the magnitude of the original vector
     * @param components
     * @param divSqrt
     */
    public NormalVector(ScalarWrapper[] components, int divSqrt) {
        super(components);
        this.divSqrt = divSqrt;
    }

    public NormalVector(int[] components, int divSqrt) {
        super(components);
        this.divSqrt = divSqrt;
    }

    public NormalVector(Integer[] components, int divSqrt) {
        super(components);
        this.divSqrt = divSqrt;
    }

    public NormalVector(double[] components, int divSqrt) {
        super(components);
        this.divSqrt = divSqrt;
    }

    public NormalVector(Double[] components, int divSqrt) {
        super(components);
        this.divSqrt = divSqrt;
    }

    public NormalVector(Rational[] components, int divSqrt) {
        super(components);
        this.divSqrt = divSqrt;
    }

    /**
     * Returns the non-normal Vector component of this NormalVector
     * @return the non-normal Vector component of this NormalVector
     */
    public Vector simpleVector() {
        return new Vector(this.components);
    }

    /**
     * Accessor for divSqrt
     * @return the divSqrt of this NormalVector
     */
    public int getDivSqrt() {
        return this.divSqrt;
    }

    /**
     * Returns the true Vector value of this NormalVector
     * @return the true Vector value of this NormalVector
     */
    public Vector trueValue() {
        double mag = Math.sqrt(this.divSqrt);
        Vector v = this.simpleVector().divideBy(mag);
        v.simplify();
        return v;
    }

    /**
     * Returns the magnitude-squared of this NormalVector
     * @return 1
     */
    @Override
    public ScalarWrapper mag2() {
        return new ScalarWrapper(1);
    }

    /**
     * Returns the magnitude-squared of this NormalVector in a given inner product space
     * @param Gij the Matrix representing a given inner product
     * @return 1
     */
    @Override
    public ScalarWrapper mag2(Matrix Gij) {
        return new ScalarWrapper(1);
    }

    /**
     * Returns the magnitude of this NormalVector
     * @return 1
     */
    @Override
    public ScalarWrapper mag() {
        return new ScalarWrapper(1);
    }

    /**
     * Returns the magnitude of this NormalVector in a given inner product space
     * @param Gij the Matrix representing a given inner product
     * @return 1
     */
    @Override
    public ScalarWrapper mag(Matrix Gij) {
        return new ScalarWrapper(1);
    }

    /**
     * Adds this NormalVector and a Vector
     * @param other the Vector to add to this NormalVector
     * @return the sum of this NormalVector and other
     */
    @Override
    public Vector add(Vector other) {
        return this.trueValue().add(other);
    }

    /**
     * Subtracts a Vector from this NormalVector
     * @param other the Vector to subtract from this NormalVector
     * @return the difference between this NormalVector and other
     */
    @Override
    public Vector subtract(Vector other) {
        return this.trueValue().subtract(other);
    }

    /**
     * Multiplies this NormalVector with an int
     * @param other the int to multiply with this NormalVector
     * @return the product of this Vector and other
     */
    @Override
    public Vector multiply(int other) {
        return this.trueValue().multiply(other);
    }

    /**
     * Multiplies this NormalVector with an Integer
     * @param other the Integer to multiply with this NormalVector
     * @return the product of this Vector and other
     */
    @Override
    public Vector multiply(Integer other) {
        return this.trueValue().multiply(other);
    }

    /**
     * Multiplies this NormalVector with a double
     * @param other the double to multiply with this NormalVector
     * @return the product of this Vector and other
     */
    @Override
    public Vector multiply(double other) {
        return this.trueValue().multiply(other);
    }

    /**
     * Multiplies this NormalVector with a Double
     * @param other the Double to multiply with this NormalVector
     * @return the product of this Vector and other
     */
    @Override
    public Vector multiply(Double other) {
        return this.trueValue().multiply(other);
    }

    /**
     * Multiplies this NormalVector with a Rational
     * @param other the Rational to multiply with this NormalVector
     * @return the product of this Vector and other
     */
    @Override
    public Vector multiply(Rational other) {
        return this.trueValue().multiply(other);
    }

    /**
     * Multiplies this NormalVector with a double
     * @param other the double to multiply with this NormalVector
     * @return the product of this Vector and other
     */
    @Override
    public Vector multiply(Radical other) {
        return this.trueValue().multiply(other);
    }

    /**
     * Divides this NormalVector by an int
     * @param other the int to divide this NormalVector by
     * @return the quotient of this Vector and other
     */
    @Override
    public Vector divideBy(int other) {
        return this.trueValue().divideBy(other);
    }

    /**
     * Divides this NormalVector by an Integer
     * @param other the Integer to divide this NormalVector by
     * @return the quotient of this Vector and other
     */
    @Override
    public Vector divideBy(Integer other) {
        return this.trueValue().divideBy(other);
    }

    /**
     * Divides this NormalVector by a double
     * @param other the double to divide this NormalVector by
     * @return the quotient of this Vector and other
     */
    @Override
    public Vector divideBy(double other) {
        return this.trueValue().divideBy(other);
    }

    /**
     * Divides this NormalVector by a Double
     * @param other the Double to divide this NormalVector by
     * @return the quotient of this Vector and other
     */
    @Override
    public Vector divideBy(Double other) {
        return this.trueValue().divideBy(other);
    }

    /**
     * Divides this NormalVector by a Rational
     * @param other the Rational to divide this NormalVector by
     * @return the quotient of this Vector and other
     */
    @Override
    public Vector divideBy(Rational other) {
        return this.trueValue().divideBy(other);
    }

    /**
     * Divides this NormalVector by a double
     * @param other the double to divide this NormalVector by
     * @return the quotient of this Vector and other
     */
    @Override
    public Vector divideBy(Radical other) {
        Radical divSqrtRad = new Radical(this.divSqrt);
        Radical radFactor = divSqrtRad.multiply(other);
        return this.simpleVector().divideBy(radFactor);
    }

    /**
     * Returns the projection of this NormalVector onto another Vector
     * @param other the Vector to project this NormalVector onto
     * @return the projection of this NormalVector and other
     */
    @Override
    public Vector projectionOnto(Vector other) {
        if (this.dim != other.dim) {
            throw new IllegalArgumentException("Vectors must share dimension");
        }
        
        Matrix Gij = Matrix.identityMatrix(this.dim);
        return other.projection(this.trueValue(), Gij);
    }

    /**
     * Returns the projection of this NormalVector onto another Vector in a given inner product space
     * @param other the Vector to project this NormalVector onto
     * @param Gij the Matrix representing a given inner product
     * @return the projection of this NormalVector and other in the given inner product space
     */
    @Override
    public Vector projectionOnto(Vector other, Matrix Gij) {
        if (this.dim != other.dim) {
            throw new IllegalArgumentException("Vectors must share dimension");
        }

        return other.projection(this.trueValue(), Gij);
    }

    /**
     * Creates and returns a deep copy of this NormalVector
     * @return a deep copy of this NormalVector
     */
    @Override
    public NormalVector clone() {
        Stream<ScalarWrapper> st = Arrays.stream(this.components);
        ScalarWrapper[] arr = st.map(val -> val.clone()).toArray(ScalarWrapper[]::new);
        return new NormalVector(arr, this.divSqrt);
    }

    /**
     * Returns a String representation of this NormalVector
     * @return a String representation of this NormalVector
     */
    @Override
    public String toString() {
        String s = String.format("(1/√%s)", this.divSqrt);
        s += super.toString();

        return s;
    }

    /**
     * Returns itself
     * @return this NormalVector
     */
    @Override
    public NormalVector normalize() {
        return this;
    }

    /**
     * Returns itself
     * @param Gij the Matrix representing a given inner product
     * @return this NormalVector
     */
    @Override
    public NormalVector normalize(Matrix Gij) {
        return this;
    }

    /**
     * Returns this NormalVector as a Matrix
     * @return the Matrix form of this NormalVector
     */
    @Override
    public Matrix toMatrix() {
        return new Matrix(this.trueValue());
    }

    public static void main(String[] args) {
        int[] arr = {2, 5};
        Vector testVector = new Vector(arr);
        NormalVector testNormal = testVector.normalize();
        System.out.println(testNormal);
    }

}
