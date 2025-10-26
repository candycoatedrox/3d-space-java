import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;
public class Matrix {
    
    // Outer arrays = rows
    private ScalarWrapper[][] components;
    private final int k;
    private final int n;
    
    /**
     * Constructs an empty k x n Matrix
     * @param k the number of rows in the Matrix
     * @param n the number of columns in the Matrix
     */
    public Matrix(int k, int n) {
        this.components = new ScalarWrapper[k][n];
        this.k = k;
        this.n = n;
    }

    /**
     * Constructs a Matrix from a two-dimensional array of ScalarWrappers
     * @param components a two-dimensional array of the Matrix's components
     */
    public Matrix(ScalarWrapper[][] components) {
        this.components = components.clone();
        this.k = components.length;
        this.n = components[0].length;
    }

    /**
     * Constructs a Matrix from a two-dimensional array of ints
     * @param components a two-dimensional array of the Matrix's components
     */
    public Matrix(int[][] components) {
        ScalarWrapper[][] wrappedcomponents = ScalarWrapper.wrapArray(components);
        this.components = wrappedcomponents.clone();
        this.k = components.length;
        this.n = components[0].length;
    }

    /**
     * Constructs a Matrix from a two-dimensional array of Integers
     * @param components a two-dimensional array of the Matrix's components
     */
    public Matrix(Integer[][] components) {
        ScalarWrapper[][] wrappedcomponents = ScalarWrapper.wrapArray(components);
        this.components = wrappedcomponents.clone();
        this.k = components.length;
        this.n = components[0].length;
    }

    /**
     * Constructs a Matrix from a two-dimensional array of doubles
     * @param components a two-dimensional array of the Matrix's components
     */
    public Matrix(double[][] components) {
        ScalarWrapper[][] wrappedcomponents = ScalarWrapper.wrapArray(components);
        this.components = wrappedcomponents.clone();
        this.k = components.length;
        this.n = components[0].length;
    }

    /**
     * Constructs a Matrix from a two-dimensional array of Doubles
     * @param components a two-dimensional array of the Matrix's components
     */
    public Matrix(Double[][] components) {
        ScalarWrapper[][] wrappedcomponents = ScalarWrapper.wrapArray(components);
        this.components = wrappedcomponents.clone();
        this.k = components.length;
        this.n = components[0].length;
    }

    /**
     * Constructs a Matrix from a two-dimensional array of Rationals
     * @param components a two-dimensional array of the Matrix's components
     */
    public Matrix(Rational[][] components) {
        ScalarWrapper[][] wrappedcomponents = ScalarWrapper.wrapArray(components);
        this.components = wrappedcomponents.clone();
        this.k = components.length;
        this.n = components[0].length;
    }

    /**
     * Constructs a Matrix from an array of Vectors
     * @param vectors an array of Vectors that make up the Matrix's columns
     */
    public Matrix(Vector[] vectors) {
        this.k = vectors[0].dim;
        this.n = vectors.length;

        for (Vector v : vectors) {
            if (this.k != v.dim) {
                throw new RuntimeException("Inconsistent amount of rows");
            }
        }

        ScalarWrapper[][] matrix = new ScalarWrapper[this.k][this.n];
        ScalarWrapper[] row;
        Stream<ScalarWrapper> st;

        for (int r = 0; r < this.k; r++) {
            row = new ScalarWrapper[n];
            for (int c = 0; c < this.n; c++) {
                row[c] = vectors[c].get(r);
            }
            st = Arrays.stream(row);
            matrix[r] = st.map(val -> val.clone()).toArray(ScalarWrapper[]::new);
        }

        this.components = matrix;
    }

    /**
     * Constructs a Matrix from a Vector
     * @param vector the Vector to convert to a Matrix
     */
    public Matrix(Vector vector) {
        this.k = 1;
        this.n = vector.dim;

        ScalarWrapper[][] matrix = new ScalarWrapper[1][vector.dim];
        for (int i = 0; i < vector.dim; i++) {
            matrix[0][i] = vector.get(i);
        }

        this.components = matrix;
    }

    /**
     * Accessor for components
     * @return the components of this Matrix
     */
    public ScalarWrapper[][] getcomponents() {
        return this.components;
    }

    /**
     * Returns the ith row of this Matrix
     * @param i the index of the row
     * @return the components of the row
     */
    public ScalarWrapper[] getRow(int i) {
        return this.components[i];
    }

    /**
     * Returns the ith column of this Matrix
     * @param i the index of the column
     * @return the components of the column
     */
    public ScalarWrapper[] getCol(int i) {
        ScalarWrapper[] column = new ScalarWrapper[k];
        for (int row = 0; row < this.k; row++) {
            column[row] = this.components[row][i];
        }
        return column;
    }
    
    /**
     * Returns the ith/jth component of this Matrix
     * @param i the row index of the component
     * @param j the column index of the component
     * @return the ith/jth component of this Matrix
     */
    public ScalarWrapper get(int i, int j) {
        return this.components[i][j];
    }

    /**
     * Returns the ith row of this Matrix as a Vector
     * @param i the index of the row
     * @return the specified row as a Vector
     */
    public Vector getRowVector(int i) {
        return new Vector(this.getRow(i));
    }

    /**
     * Returns the ith column of this Matrix as a Vector
     * @param i the index of the column
     * @return the specified column as a Vector
     */
    public Vector getColVector(int i) {
        return new Vector(this.getCol(i));
    }

    /**
     * Returns a list of this Matrix's rows as Vectors
     * @return the rows of this Matrix, converted into Vectors
     */
    public ArrayList<Vector> getRowVectors() {
        ArrayList<Vector> vectors = new ArrayList<>();
        for (ScalarWrapper[] row : components) {
            vectors.add(new Vector(row));
        }
        return vectors;
    }

    /**
     * Returns a list of this Matrix's columns as Vectors
     * @return the columns of this Matrix, converted into Vectors
     */
    public ArrayList<Vector> getColumnVectors() {
        ArrayList<Vector> vectors = new ArrayList<>();
        for (int i = 0; i < this.n; i++) {
            vectors.add(new Vector(this.getCol(i)));
        }
        return vectors;
    }

    /**
     * Sets the ith/jth component of a Matrix to a given ScalarWrapper
     * @param i the row index of the component
     * @param j the column index of the component
     * @param newValue the value to set the component to
     */
    public void set(int i, int j, ScalarWrapper newValue) {
        this.components[i][j] = newValue;
    }

    /**
     * Sets the ith/jth component of a Matrix to a given int
     * @param i the row index of the component
     * @param j the column index of the component
     * @param newValue the value to set the component to
     */
    public void set(int i, int j, int newValue) {
        this.components[i][j] = new ScalarWrapper(newValue);
    }

    /**
     * Sets the ith/jth component of a Matrix to a given Integer
     * @param i the row index of the component
     * @param j the column index of the component
     * @param newValue the value to set the component to
     */
    public void set(int i, int j, Integer newValue) {
        this.components[i][j] = new ScalarWrapper(newValue);
    }

    /**
     * Sets the ith/jth component of a Matrix to a given double
     * @param i the row index of the component
     * @param j the column index of the component
     * @param newValue the value to set the component to
     */
    public void set(int i, int j, double newValue) {
        this.components[i][j] = new ScalarWrapper(newValue);
    }

    /**
     * Sets the ith/jth component of a Matrix to a given Double
     * @param i the row index of the component
     * @param j the column index of the component
     * @param newValue the value to set the component to
     */
    public void set(int i, int j, Double newValue) {
        this.components[i][j] = new ScalarWrapper(newValue);
    }

    /**
     * Sets the ith/jth component of a Matrix to a given Rational
     * @param i the row index of the component
     * @param j the column index of the component
     * @param newValue the value to set the component to
     */
    public void set(int i, int j, Rational newValue) {
        this.components[i][j] = new ScalarWrapper(newValue);
    }

    /**
     * Accessor for k
     * @return the number of rows in the Matrix
     */
    public int getK() {
        return this.k;
    }

    /**
     * Accessor for n
     * @return the number of columns in the Matrix
     */
    public int getN() {
        return this.n;
    }

    /**
     * Checks whether a Matrix is square
     * @return true if this.k == this.n; false otherwise
     */
    public boolean isSquare() {
        return this.k == this.n;
    }

    /**
     * Returns a version of this Matrix with all components reduced and simplified
     * @return a reduced and simplified version of this Matrix
     */
    public Matrix simplified() {
        Matrix copy = this.clone();
        copy.simplify();
        return copy;
    }

    /**
     * Reduces and simplifies all components of this Matrix
     */
    public void simplify() {
        for (int i = 0; i < this.k; i++) {
            for (int j = 0; j < this.n; j++) {
                this.get(i,j).simplify();
            }
        }
    }

    /**
     * Returns a version of this Matrix with all Rationals reduced to lowest terms
     * @return a reduced version of this Matrix
     */
    public Matrix reduced() {
        Matrix copy = this.clone();
        copy.reduce();
        return copy;
    }

    /**
     * Reduces all Rationals in this Matrix to lowest terms
     */
    public void reduce() {
        for (int i = 0; i < this.k; i++) {
            for (int j = 0; j < this.n; j++) {
                this.get(i,j).reduce();
            }
        }
    }

    public Matrix negative() {
        return this.multiply(-1);
    }

    /**
     * Returns the absolute value of this Matrix
     * @return the absolute value of this Matrix
     */
    public Matrix absolute() {
        Matrix copy = this.clone();
        for (int i = 0; i < this.k; i++) {
            for (int j = 0; j < this.n; j++) {
                copy.set(i, j, this.get(i,j).absolute());
            }
        }
        return copy;
    }

    /**
     * Checks whether this Matrix and another Matrix are the same size
     * @param other the Matrix to compare with
     * @return true if this.k == other.k and this.n == other.n; false otherwise
     */
    public boolean sameSize(Matrix other) {
        return this.k == other.k && this.n == other.n;
    }
    
    /**
     * Checks whether two Matrices are equal
     * @param other the Matrix to compare with
     * @return true if all components of this Matrix are equal to their counterparts in other; false otherwise
     */
    public boolean equals(Matrix other) {
        if (this.k != other.k || this.n != other.n) {
            return false;
        }

        for (int i = 0; i < this.k; i++) {
            for (int j = 0; j < this.n; j++) {
                if (!this.get(i,j).equals(other.get(i,j))) {
                    return false;
                }
            }
        }

        return true;
    }

    public Matrix add(Matrix other) {
        if (!this.sameSize(other)) {
            throw new IllegalArgumentException("Matrices must share dimension");
        }

        Matrix sum = new Matrix(this.k, this.n);
        for (int i = 0; i < this.k; i++) {
            for (int j = 0; j < this.n; j++) {
                sum.set(i, j, this.get(i,j).add(other.get(i,j)));
            }
        }

        return sum;
    }

    public Matrix subtract(Matrix other) {
        return this.add(other.negative());
    }

    /**
     * Multiplies this Matrix with another Matrix
     * @param other the Matrix to multiply with this Matrix
     * @return the product of this Matrix and other
     */
    public Matrix multiply(Matrix other) {
        if (this.k != other.n) {
            throw new IllegalArgumentException("Matrices are not compatible");
        }

        Matrix product = new Matrix(this.n, other.k);
        ScalarWrapper component;
        for (int i = 0; i < this.n; i++) {
            for (int k = 0; k < other.k; k++) {
                component = new ScalarWrapper(0);
                for (int j = 0; j < this.k; j++) {
                    component = component.add(this.get(i,j).multiply(other.get(j,k)));
                }
                product.set(i, k, component);
            }
        }

        return product;
    }
    
    /**
     * Multiplies this Matrix with a Vector
     * @param other the Vector to multiply with this Matrix
     * @return the product of this Matrix and other
     */
    public Vector multiply(Vector other) {
        if (this.k != other.dim) {
            throw new IllegalArgumentException("Vector's dimension must equal columns in Matrix");
        }

        Vector product = new Vector(other.dim);
        ScalarWrapper component;
        for (int i = 0; i < other.dim; i++) {
            component = new ScalarWrapper(0);
            for (int j = 0; j < other.dim; j++) {
                component = component.add(this.get(i, j).multiply(other.get(j)));
            }

            product.set(i, component);
        }

        return product;
    }

    /**
     * Multiplies this Matrix with a ScalarWrapper
     * @param other the ScalarWrapper to multiply with this Matrix
     * @return the product of this Matrix and other
     */
    public Matrix multiply(ScalarWrapper other) {
        Matrix product = new Matrix(this.k, this.n);
        for (int i = 0; i < this.k; i++) {
            for (int j = 0; j < this.n; j++) {
                product.set(i, j, this.get(i, j).multiply(other));
            }
        }

        return product;
    }

    /**
     * Multiplies this Matrix with an int
     * @param other the int to multiply with this Matrix
     * @return the product of this Matrix and other
     */
    public Matrix multiply(int other) {
        Matrix product = new Matrix(this.k, this.n);
        for (int i = 0; i < this.k; i++) {
            for (int j = 0; j < this.n; j++) {
                product.set(i, j, this.get(i, j).multiply(other));
            }
        }

        return product;
    }

    /**
     * Multiplies this Matrix with an Integer
     * @param other the Integer to multiply with this Matrix
     * @return the product of this Matrix and other
     */
    public Matrix multiply(Integer other) {
        Matrix product = new Matrix(this.k, this.n);
        for (int i = 0; i < this.k; i++) {
            for (int j = 0; j < this.n; j++) {
                product.set(i, j, this.get(i, j).multiply(other));
            }
        }

        return product;
    }

    /**
     * Multiplies this Matrix with a double
     * @param other the double to multiply with this Matrix
     * @return the product of this Matrix and other
     */
    public Matrix multiply(double other) {
        Matrix product = new Matrix(this.k, this.n);
        for (int i = 0; i < this.k; i++) {
            for (int j = 0; j < this.n; j++) {
                product.set(i, j, this.get(i, j).multiply(other));
            }
        }

        return product;
    }

    /**
     * Multiplies this Matrix with a Double
     * @param other the Double to multiply with this Matrix
     * @return the product of this Matrix and other
     */
    public Matrix multiply(Double other) {
        Matrix product = new Matrix(this.k, this.n);
        for (int i = 0; i < this.k; i++) {
            for (int j = 0; j < this.n; j++) {
                product.set(i, j, this.get(i, j).multiply(other));
            }
        }

        return product;
    }

    /**
     * Multiplies this Matrix with a Rational
     * @param other the Rational to multiply with this Matrix
     * @return the product of this Matrix and other
     */
    public Matrix multiply(Rational other) {
        Matrix product = new Matrix(this.k, this.n);
        for (int i = 0; i < this.k; i++) {
            for (int j = 0; j < this.n; j++) {
                product.set(i, j, this.get(i, j).multiply(other));
            }
        }

        return product;
    }

    /**
     * Divides this Matrix by a ScalarWrapper
     * @param other the ScalarWrapper to divide this Matrix by
     * @return the quotient of this Matrix and other
     */
    public Matrix divideBy(ScalarWrapper other) {
        if (other.isInt()) {
            return this.divideBy(other.getInt());
        } else if (other.isDouble()) {
            return this.divideBy(other.getDouble());
        } else {
            return this.divideBy(other.getRat());
        }
    }

    /**
     * Divides this Matrix by an int
     * @param other the int to divide this Matrix by
     * @return the quotient of this Matrix and other
     */
    public Matrix divideBy(int other) {
        return this.multiply(new Rational(1, other));
    }

    /**
     * Divides this Matrix by an Integer
     * @param other the Integer to divide this Matrix by
     * @return the quotient of this Matrix and other
     */
    public Matrix divideBy(Integer other) {
        return this.multiply(new Rational(1, other));
    }

    /**
     * Divides this Matrix by a double
     * @param other the double to divide this Matrix by
     * @return the quotient of this Matrix and other
     */
    public Matrix divideBy(double other) {
        double invert = 1 / other;
        return this.multiply(new Rational(invert));
    }

    /**
     * Divides this Matrix by a Double
     * @param other the Double to divide this Matrix by
     * @return the quotient of this Matrix and other
     */
    public Matrix divideBy(Double other) {
        double invert = 1 / other;
        return this.multiply(new Rational(invert));
    }

    /**
     * Divides this Matrix by a Rational
     * @param other the Rational to divide this Matrix by
     * @return the quotient of this Matrix and other
     */
    public Matrix divideBy(Rational other) {
        return this.multiply(other.invert());
    }

    /* public ScalarWrapper determinant() {
        if (!this.isSquare()) {
            throw new IllegalArgumentException("Matrix must be square");
        }

        ScalarWrapper det = new ScalarWrapper(0);
        ScalarWrapper temp;
    } */

    /**
     * Creates and returns a deep copy of this Matrix
     * @return a deep copy of this Matrix
     */
    @Override
    public Matrix clone() {
        ScalarWrapper[][] matrix = new ScalarWrapper[this.k][this.n];
        for (int i = 0; i < this.k; i++) {
            for (int j = 0; j < this.n; j++) {
                matrix[i][j] = this.get(i, j).clone();
            }
        }

        return new Matrix(matrix);
    }

    /**
     * Returns a String representation of this Matrix
     * @return a String representation of this Matrix
     */
    @Override
    public String toString() {
        String s = "";
        for (int j = 0; j < this.k; j++) {
            if (j != 0) {
                s += "\n";
            }
            s += "|";
            for (int i = 0; i < this.n; i++) {
                if (i != 0) {
                    s += " ";
                }
                s += this.get(j, i);
            }
            s += "|";
        }

        return s;
    }

    /**
     * Returns the zero k x n Matrix
     * @param k the number of rows in the Matrix
     * @param n the number of columns in the Matrix
     * @return the zero Matrix of dimension k x n
     */
    public static Matrix zeroMatrix(int k, int n) {
        ScalarWrapper[][] matrix = new ScalarWrapper[k][n];
        ScalarWrapper[] row;
        Stream<ScalarWrapper> st;
        ScalarWrapper zeroWrap = new ScalarWrapper(0);

        for (int r = 0; r < k; r++) {
            row = new ScalarWrapper[n];
            for (int c = 0; c < n; c++) {
                row[c] = zeroWrap;
            }
            st = Arrays.stream(row);
            matrix[r] = st.map(val -> val.clone()).toArray(ScalarWrapper[]::new);
        }

        return new Matrix(matrix);
    }

    /**
     * Returns the n x n identity Matrix
     * @param n the number of rows and columns in the Matrix
     * @return the identity Matrix of dimension n x n
     */
    public static Matrix identityMatrix(int n) {
        ScalarWrapper[][] matrix = new ScalarWrapper[n][n];
        ScalarWrapper[] row;
        Stream<ScalarWrapper> st;
        ScalarWrapper zeroWrap = new ScalarWrapper(0);
        ScalarWrapper oneWrap = new ScalarWrapper(1);

        for (int r = 0; r < n; r++) {
            row = new ScalarWrapper[n];
            for (int c = 0; c < n; c++) {
                if (r == c) {
                    row[c] = oneWrap;
                } else {
                    row[c] = zeroWrap;
                }
            }
            st = Arrays.stream(row);
            matrix[r] = st.map(val -> val.clone()).toArray(ScalarWrapper[]::new);
        }

        return new Matrix(matrix);
    }

    /* public static void main(String[] args) {
        ScalarWrapper[] r1 = {new ScalarWrapper(1), new ScalarWrapper(2)};
        ScalarWrapper[] r2 = {new ScalarWrapper(3), new ScalarWrapper(4)};
        ScalarWrapper[][] m = {r1, r2};

        Matrix newMatrix = new Matrix(m);
        System.out.println(newMatrix);

        Matrix z = zeroMatrix(3, 2);
        System.out.println(z);
    } */

}
