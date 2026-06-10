public class Matrix2x2 {

    public static final Matrix2x2 ZERO = new Matrix2x2(0, 0, 0, 0);
    public static final Matrix2x2 GIJ = new Matrix2x2(1, 0, 0, 1);
    
    // Outer arrays = rows
    private double[][] components;

    // --- CONSTRUCTORS ---

    public Matrix2x2() {
        components = new double[2][2];
    }

    public Matrix2x2(double a, double b, double c, double d) {
        double[][] comps = {{a,b},{c,d}};
        components = comps;
    }

    public Matrix2x2(int a, int b, int c, int d) {
        double[][] comps = {{a,b},{c,d}};
        components = comps;
    }

    public Matrix2x2(Rational a, Rational b, Rational c, Rational d) {
        double[][] comps = {{a.doubleValue(), b.doubleValue()}, {c.doubleValue(), d.doubleValue()}};
        components = comps;
    }

    // --- GETTERS & SETTERS ---

    public double[][] getComponents() {
        return components;
    }

    public double[] getComponentsFlat() {
        double[] comps = {get(0,0), get(0,1), get(1,0), get(1,1)};
        return comps;
    }

    public double[] getRow(int i) {
        return components[i];
    }

    public double[] getCol(int i) {
        double[] col = {components[0][i], components[1][i]};
        return col;
    }

    /**
     * Returns the ith/jth component of this Matrix
     * @param i the column index of the component
     * @param j the row index of the component
     * @return the ith/jth component of this Matrix
     */
    public double get(int i, int j) {
        return components[j][i];
    }

    public void set(int i, int j, double value) {
        components[j][i] = value;
    }

    public void set(int i, int j, int value) {
        components[j][i] = value;
    }

    public void set(int i, int j, Rational value) {
        components[j][i] = value.doubleValue();
    }

    public Vector2D getRowVector(int i) {
        return new Vector2D(components[i][0], components[i][1]);
    }

    public Vector2D[] getRowVectors() {
        Vector2D[] vectors = {
            new Vector2D(components[0][0], components[0][1]),
            new Vector2D(components[1][0], components[1][1])
        };
        return vectors;
    }

    public Vector2D getColVector(int i) {
        return new Vector2D(components[0][i], components[1][i]);
    }

    public Vector2D[] getColVectors() {
        Vector2D[] vectors = {
            new Vector2D(components[0][0], components[1][0]),
            new Vector2D(components[0][1], components[1][1])
        };
        return vectors;
    }

    // --- COMPARISONS ---

    public boolean equals(Matrix2x2 other) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                if (get(i,j) != other.get(i,j)) return false;
            }
        }
        
        return true;
    }

    // --- BASIC OPERATIONS ---

    public Matrix2x2 negative() {
        return multiply(-1);
    }

    public Matrix2x2 absolute() {
        return new Matrix2x2(Math.abs(components[0][0]), Math.abs(components[0][1]), Math.abs(components[1][0]), Math.abs(components[1][1]));
    }

    public Matrix2x2 add(Matrix2x2 other) {
        double[] thisComps = getComponentsFlat();
        double[] otherComps = other.getComponentsFlat();
        double[] sum = new double[4];
        for (int i = 0; i < 4; i++) {
            sum[i] = thisComps[i] + otherComps[i];
        }

        return new Matrix2x2(sum[0], sum[1], sum[2], sum[3]);
    }

    public void addToThis(Matrix2x2 other) {
        components[0][0] += other.components[0][0];
        components[0][1] += other.components[0][1];
        components[1][0] += other.components[1][0];
        components[1][1] += other.components[1][1];
    }

    public Matrix2x2 subtract(Matrix2x2 other) {
        double[] thisComps = getComponentsFlat();
        double[] otherComps = other.getComponentsFlat();
        double[] sum = new double[4];
        for (int i = 0; i < 4; i++) {
            sum[i] = thisComps[i] - otherComps[i];
        }

        return new Matrix2x2(sum[0], sum[1], sum[2], sum[3]);
    }

    public void subtractFromThis(Matrix2x2 other) {
        components[0][0] -= other.components[0][0];
        components[0][1] -= other.components[0][1];
        components[1][0] -= other.components[1][0];
        components[1][1] -= other.components[1][1];
    }

    public Matrix2x2 multiply(int other) {
        return new Matrix2x2(components[0][0]*other, components[0][1]*other, components[1][0]*other, components[1][1]*other);
    }

    public Matrix2x2 multiply(double other) {
        return new Matrix2x2(components[0][0]*other, components[0][1]*other, components[1][0]*other, components[1][1]*other);
    }

    public Matrix2x2 multiply(Rational other) {
        return new Matrix2x2(components[0][0]*other.doubleValue(), components[0][1]*other.doubleValue(), components[1][0]*other.doubleValue(), components[1][1]*other.doubleValue());
    }

    public void multiplyBy(int other) {
        components[0][0] *= other;
        components[0][1] *= other;
        components[1][0] *= other;
        components[1][1] *= other;
    }

    public void multiplyBy(double other) {
        components[0][0] *= other;
        components[0][1] *= other;
        components[1][0] *= other;
        components[1][1] *= other;
    }

    public void multiplyBy(Rational other) {
        components[0][0] *= other.doubleValue();
        components[0][1] *= other.doubleValue();
        components[1][0] *= other.doubleValue();
        components[1][1] *= other.doubleValue();
    }

    public Matrix2x2 divide(int other) {
        return new Matrix2x2(components[0][0]/other, components[0][1]/other, components[1][0]/other, components[1][1]/other);
    }

    public Matrix2x2 divide(double other) {
        return new Matrix2x2(components[0][0]/other, components[0][1]/other, components[1][0]/other, components[1][1]/other);
    }

    public Matrix2x2 divide(Rational other) {
        return new Matrix2x2(components[0][0]/other.doubleValue(), components[0][1]/other.doubleValue(), components[1][0]/other.doubleValue(), components[1][1]/other.doubleValue());
    }

    public void divideBy(int other) {
        components[0][0] /= other;
        components[0][1] /= other;
        components[1][0] /= other;
        components[1][1] /= other;
    }

    public void divideBy(double other) {
        components[0][0] /= other;
        components[0][1] /= other;
        components[1][0] /= other;
        components[1][1] /= other;
    }

    public void divideBy(Rational other) {
        components[0][0] /= other.doubleValue();
        components[0][1] /= other.doubleValue();
        components[1][0] /= other.doubleValue();
        components[1][1] /= other.doubleValue();
    }

    // TODO: matrix, Vector multiplication

}
