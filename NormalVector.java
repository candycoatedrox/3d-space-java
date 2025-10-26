import java.util.Arrays;
import java.util.stream.Stream;

public class NormalVector extends Vector {

    private int divSqrt;

    // refuses to recognize Vector as a class and not a constructor???
    /* public NormalVector(Vector v) {
        Vector copy = v.clone();
        this.values = copy.values;
        this.dim = v.dim;
        this.divSqrt = v.mag2().getInt();
    }

    public NormalVector(Vector v, Matrix Gij) {
        Vector copy = v.clone();
        this.values = copy.values;
        this.dim = v.dim;
        this.divSqrt = v.mag2(Gij).getInt();
    } */

    /**
     * Constructs a normalized vector from a list of ScalarWrappers and the magnitude of the original vector
     * @param values
     * @param divSqrt
     */
    public NormalVector(ScalarWrapper[] values, int divSqrt) {
        super(values);
        this.divSqrt = divSqrt;
    }

    public NormalVector(int[] values, int divSqrt) {
        super(values);
        this.divSqrt = divSqrt;
    }

    public NormalVector(Integer[] values, int divSqrt) {
        super(values);
        this.divSqrt = divSqrt;
    }

    public NormalVector(double[] values, int divSqrt) {
        super(values);
        this.divSqrt = divSqrt;
    }

    public NormalVector(Double[] values, int divSqrt) {
        super(values);
        this.divSqrt = divSqrt;
    }

    public NormalVector(Rational[] values, int divSqrt) {
        super(values);
        this.divSqrt = divSqrt;
    }

    public Vector simpleVector() {
        return new Vector(this.values);
    }

    // IMPLEMENT TRUEVALUE() ONCE VECTOR SUPPORTS DOUBLES
    public Vector trueValue() {
        double mag = Math.sqrt(this.divSqrt);
        return this.simpleVector().divideBy(mag);
    }

    @Override
    public NormalVector normalize() {
        return this;
    }

    @Override
    public NormalVector normalize(Matrix Gij) {
        return this;
    }

    /**
     * Creates and returns a deep copy of this NormalVector
     * @return a deep copy of this NormalVector
     */
    @Override
    public NormalVector clone() {
        Stream<ScalarWrapper> st = Arrays.stream(this.values);
        ScalarWrapper[] arr = st.map(val -> val.clone()).toArray(ScalarWrapper[]::new);
        return new NormalVector(arr, this.divSqrt);
    }

    /**
     * Returns a String representation of this NormalVector
     * @return a String representation of this NormalVector
     */
    @Override
    public String toString() {
        String s = String.format("(1/√%s)(", this.divSqrt);
        for (int i = 0; i < this.dim; i++) {
            if (i != 0) {
                s += " ";
            }
            s += this.get(i);
        }
        s += ")";

        return s;
    }

    public static void main(String[] args) {
        int[] arr = {2, 5};
        Vector testVector = new Vector(arr);
        NormalVector testNormal = testVector.normalize();
        System.out.println(testNormal);
    }

}
