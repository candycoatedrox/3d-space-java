import java.util.Arrays;
import java.util.stream.Stream;

public class Vector implements Cloneable {

    // ADD DOUBLE SUPPORT

    protected ScalarWrapper[] values;
    protected int dim;

    public Vector(ScalarWrapper[] values) {
        this.values = values;
        this.dim = values.length;
    }

    public Vector(int[] values) {
        this.values = ScalarWrapper.wrapArray(values);
        this.dim = values.length;
    }

    public Vector(double[] values) {
        this.values = ScalarWrapper.wrapArray(values);
        this.dim = values.length;
    }

    public Vector(Rational[] values) {
        this.values = ScalarWrapper.wrapArray(values);
        this.dim = values.length;
    }

    public ScalarWrapper[] getValues() {
        return this.values;
    }

    public ScalarWrapper get(int i) {
        return this.values[i];
    }

    public void set(int i, ScalarWrapper newValue) {
        this.values[i] = newValue;
    }

    public void set(int i, int newValue) {
        this.values[i] = new ScalarWrapper(newValue);
    }

    public void set(int i, Integer newValue) {
        this.values[i] = new ScalarWrapper(newValue);
    }

    public void set(int i, double newValue) {
        this.values[i] = new ScalarWrapper(newValue);
    }

    public void set(int i, Double newValue) {
        this.values[i] = new ScalarWrapper(newValue);
    }

    public void set(int i, Rational newValue) {
        this.values[i] = new ScalarWrapper(newValue);
    }

    public int getDim() {
        return this.dim;
    }

    public Vector reduced() {
        Vector copy = this.clone();
        copy.reduce();
        return copy;
    }

    /**
     * Reduces all Rationals in a Vector to lowest terms
     */
    public void reduce() {
        for (int i = 0; i < this.dim; i++) {
            this.get(i).reduce();
        }
    }

    public Vector reducedPreserveType() {
        Vector copy = this.clone();
        copy.reducePreserveType();
        return copy;
    }

    public void reducePreserveType() {
        for (int i = 0; i < this.dim; i++) {
            this.get(i).reducePreserveType();
        }
    }

    public void convertToDoubles() {
        for (ScalarWrapper component : this.values) {
            component.convertToDouble();
        }
    }

    public void convertToRationals() {
        for (ScalarWrapper component : this.values) {
            component.convertToRat();
        }
    }

    public void convertToIntsOrRationals() {
        for (ScalarWrapper component : this.values) {
            component.convertToIntOrRat();
        }
    }

    public ScalarWrapper mag2() {
        Matrix Gij = Matrix.identityMatrix(this.dim);
        return innerProduct(this, this, Gij);
    }

    public ScalarWrapper mag2(Matrix Gij) {
        return innerProduct(this, this, Gij);
    }
    
    public ScalarWrapper mag() {
        Matrix Gij = Matrix.identityMatrix(this.dim);
        return this.mag(Gij);
    }

    public ScalarWrapper mag(Matrix Gij) {
        ScalarWrapper mag2 = this.mag2(Gij);
        mag2.convertToDouble();
        double root = Math.sqrt(mag2.getDouble());
        return new ScalarWrapper(root);
    }

    /* public boolean isScalarMultOf(Vector other) {
        if (this.dim != other.dim) {
            throw new IllegalArgumentException("Vectors must share dimension");
        }

        Matrix Gij = Matrix.identityMatrix(this.dim);
        return this.isScalarMultOf(other, Gij);
    }

    public boolean isScalarMultOf(Vector other, Matrix Gij) {
        if (this.dim != other.dim) {
            throw new IllegalArgumentException("Vectors must share dimension");
        }

        NormalVector thisNormal = this.normalize(Gij);
        NormalVector otherNormal = other.normalize(Gij);
        return thisNormal.trueValue() == otherNormal.trueValue();
    }
    */

    public Vector negative() {
        return this.multiply(-1);
    }

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

    public Vector subtract(Vector other) {
        return this.add(other.negative());
    }

    public Vector multiply(ScalarWrapper other) {
        if (other.isInt()) {
            return this.multiply(other.getInt());
        } else if (other.isDouble()) {
            return this.multiply(other.getDouble());
        }
        return this.multiply(other.getRat());
    }

    public Vector multiply(int other) {
        ScalarWrapper[] product = new ScalarWrapper[this.dim];
        for (int i = 0; i < this.dim; i++) {
            product[i] = this.get(i).multiply(other);
        }
        return new Vector(product);
    }

    public Vector multiply(Integer other) {
        return this.multiply(other.intValue());
    }

    public Vector multiply(double other) {
        ScalarWrapper[] product = new ScalarWrapper[this.dim];
        for (int i = 0; i < this.dim; i++) {
            product[i] = this.get(i).multiply(other);
        }
        return new Vector(product);
    }

    public Vector multiply(Double other) {
        return this.multiply(other.intValue());
    }

    public Vector multiply(Rational other) {
        ScalarWrapper[] product = new ScalarWrapper[this.dim];
        for (int i = 0; i < this.dim; i++) {
            product[i] = this.get(i).multiply(other);
        }
        return new Vector(product);
    }

    /* public Matrix multiply(Matrix other) {

    }
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

    public Vector divideBy(int other) {
        return this.multiply(new Rational(1, other));
    }

    public Vector divideBy(Integer other) {
        return this.divideBy(other.intValue());
    }

    public Vector divideBy(double other) {
        double invert = 1 / other;
        return this.multiply(new Rational(invert));
    }

    public Vector divideBy(Rational other) {
        return this.multiply(other.invert());
    }

    public boolean orthogonalTo(Vector other) {
        if (this.dim != other.dim) {
            throw new IllegalArgumentException("Vectors must share dimension");
        }

        Matrix Gij = Matrix.identityMatrix(this.dim);
        return (innerProduct(this, other, Gij).equals(0));
    }

    public boolean orthogonalTo(Vector other, Matrix Gij) {
        return (innerProduct(this, other, Gij).equals(0));
    }

    /* public double cosAngle(Vector other) {

    }

    public double angle(Vector other) {
        
    }
    */

    public Vector clone() {
        Stream<ScalarWrapper> st = Arrays.stream(this.values);
        ScalarWrapper[] arr = st.map(val -> val.clone()).toArray(ScalarWrapper[]::new);
        return new Vector(arr);
    }

    /* public NormalVector normalize() {
        Matrix Gij = Matrix.identityMatrix(this.dim);
        return this.normalize(Gij);
    }

    public NormalVector normalize(Matrix Gij) {
        Vector v = this;
        // add that part getting rid of fractional components from the Python ver here
        ScalarWrapper mag2 = v.mag2(Gij);
        return new NormalVector(this.values, mag2);
    }
    */

    public Matrix toMatrix() {
        Vector[] arr = {this};
        return new Matrix(arr);
    }

    public static ScalarWrapper innerProduct(Vector v, Vector w) throws IllegalArgumentException {
        if (v.dim != w.dim) {
            throw new IllegalArgumentException("Vectors must share dimension");
        }

        Matrix Gij = Matrix.identityMatrix(v.dim);
        return innerProduct(v, w, Gij);
    }

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

    public static ScalarWrapper dotProduct(Vector v, Vector w) {
        return innerProduct(v, w);
    }

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

    public static Vector zeroVector(int dimV) {
        int[] values = new int[dimV];
        return new Vector(values);
    }
    
    public static boolean perfectSquare(int a) {
        double root = Math.sqrt(a);
        return root % 1 == 0;
    }

    public static void main(String[] args) {
        int[] arr = {2, 5};
        ScalarWrapper[] testArr = ScalarWrapper.wrapArray(arr);
        Vector testVector = new Vector(arr);
        System.out.println(testVector);
    }

}
