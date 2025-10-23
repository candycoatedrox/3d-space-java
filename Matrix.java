import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;
public class Matrix {
    
    // outer arrays = rows
    private ScalarWrapper[][] values;
    private int k;
    private int n;

    public Matrix(ScalarWrapper[][] values) {
        this.values = values.clone();
        this.k = values.length;
        this.n = values[0].length;
    }

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

        this.values = matrix;
    }

    public ScalarWrapper[][] getValues() {
        return this.values;
    }

    public ScalarWrapper[] getRow(int i) {
        return this.values[i];
    }

    public ScalarWrapper[] getCol(int i) {
        ScalarWrapper[] column = new ScalarWrapper[k];
        for (int row = 0; row < this.k; row++) {
            column[row] = this.values[row][i];
        }
        return column;
    }
    
    public ScalarWrapper get(int i, int j) {
        return this.values[i][j];
    }

    public ArrayList<Vector> getRowVectors() {
        ArrayList<Vector> vectors = new ArrayList<>();
        for (ScalarWrapper[] value : values) {
            vectors.add(new Vector(value));
        }
        return vectors;
    }

    public ArrayList<Vector> getColumnVectors() {
        ArrayList<Vector> vectors = new ArrayList<>();
        for (int i = 0; i < this.n; i++) {
            vectors.add(new Vector(this.getCol(i)));
        }
        return vectors;
    }

    public void set(int i, int j, ScalarWrapper newValue) {
        this.values[i][j] = newValue;
    }

    public void set(int i, int j, int newValue) {
        this.values[i][j] = new ScalarWrapper(newValue);
    }

    public void set(int i, int j, Rational newValue) {
        this.values[i][j] = new ScalarWrapper(newValue);
    }

    public int getK() {
        return this.k;
    }

    public int getN() {
        return this.n;
    }

    public void reduce() {
        for (int i = 0; i < this.k; i++) {
            for (int j = 0; j < this.n; j++) {
                this.get(i, j).reduce();
            }
        }
    }

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
                }
                else {
                    row[c] = zeroWrap;
                }
            }
            st = Arrays.stream(row);
            matrix[r] = st.map(val -> val.clone()).toArray(ScalarWrapper[]::new);
        }

        return new Matrix(matrix);
    }

    public static void main(String[] args) {
        ScalarWrapper[] r1 = {new ScalarWrapper(1), new ScalarWrapper(2)};
        ScalarWrapper[] r2 = {new ScalarWrapper(3), new ScalarWrapper(4)};
        ScalarWrapper[][] m = {r1, r2};

        Matrix newMatrix = new Matrix(m);
        //System.out.println(newMatrix);

        Matrix z = zeroMatrix(3, 2);
        System.out.println(z);
    }

}
