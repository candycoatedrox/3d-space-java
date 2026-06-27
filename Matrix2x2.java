public class Matrix2x2 {

    public static final Matrix2x2 ZERO = new Matrix2x2(0,0,0,0);
    public static final Matrix2x2 GIJ = new Matrix2x2(1,0,0,1);
    
    // Outer arrays = rows
    private final double[][] components;

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
    
    public double getA() {
        return components[0][0];
    }
    
    public double getB() {
        return components[0][1];
    }
    
    public double getC() {
        return components[1][0];
    }
    
    public double getD() {
        return components[1][1];
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

    // --- MATRIX MULTIPLICATION ---

    public Matrix2x2 multiply(Matrix2x2 other) {
        double a = (getA()*other.getA()) + (getB()*other.getC());
        double b = (getA()*other.getB()) + (getB()*other.getD());
        double c = (getC()*other.getA()) + (getD()*other.getC());
        double d = (getC()*other.getB()) + (getD()*other.getD());

        return new Matrix2x2(a, b, c, d);
    }

    public Vector2D multiply(Vector2D other) {
        double a = (getA()*other.getX()) + (getB()*other.getY());
        double b = (getC()*other.getX()) + (getD()*other.getY());

        return new Vector2D(a, b);
    }

    public double determinant() {
        // det L = ad - bc
        return (getA()*getD()) - (getB()*getC());
    }

    // --- ALGORITHMS ---

    public Vector2D solveSystemOfEquations(int rightX, int rightY) {
        return solveSystemOfEquations(new Vector2D(rightX, rightY));
    }

    public Vector2D solveSystemOfEquations(int rightX, double rightY) {
        return solveSystemOfEquations(new Vector2D(rightX, rightY));
    }

    public Vector2D solveSystemOfEquations(int rightX, Rational rightY) {
        return solveSystemOfEquations(new Vector2D(rightX, rightY));
    }

    public Vector2D solveSystemOfEquations(double rightX, int rightY) {
        return solveSystemOfEquations(new Vector2D(rightX, rightY));
    }

    public Vector2D solveSystemOfEquations(double rightX, double rightY) {
        return solveSystemOfEquations(new Vector2D(rightX, rightY));
    }

    public Vector2D solveSystemOfEquations(double rightX, Rational rightY) {
        return solveSystemOfEquations(new Vector2D(rightX, rightY));
    }

    public Vector2D solveSystemOfEquations(Rational rightX, int rightY) {
        return solveSystemOfEquations(new Vector2D(rightX, rightY));
    }

    public Vector2D solveSystemOfEquations(Rational rightX, double rightY) {
        return solveSystemOfEquations(new Vector2D(rightX, rightY));
    }

    public Vector2D solveSystemOfEquations(Rational rightX, Rational rightY) {
        return solveSystemOfEquations(new Vector2D(rightX, rightY));
    }

    public Vector2D solveSystemOfEquations(Vector2D rightSide) {
        double[] eqA = {getA(), getB(), rightSide.getX()};
        double[] eqB = {getC(), getD(), rightSide.getY()};
        double[][] equations = {eqA, eqB};

        double[] result = gaussJordan(equations);
        if (result.length == 2) {
            return new Vector2D(result[0], result[1]);
        } else {
            return null;
        }
    }

    public static double[] gaussJordan(double[][] equations) {
        // each in equations is a Vector of dimension n+1, where n is the number of variables
        // ex. n = 3; <1, 2, 3, 8> --> x + 2y + 3z = 8
        // outputs a Vector of dimension n
        
        double[][] currentEquations = equations;
        for (int i = 0; i < equations.length; i++) {
            currentEquations = gaussJordanIteration(currentEquations, i);
        }

        // check if each vector has one non-zero component before the final component
        // make sure each non-zero component is UNIQUE from other equations
        // (ex. if one has a value of x, no other equation has a nonzero value for x)
        // if not, return empty double[], if true, return those components

        int n = 2; // dimension of equations
        boolean foundValueInEquation;
        boolean[] hasValue = new boolean[n];
        double[] values = new double[n];
        for (double[] equation : currentEquations) {
            foundValueInEquation = false;

            for (int i = 0; i < n; i++) {
                if (equation[i] != 0) {
                    if (foundValueInEquation) {
                        return new double[0];
                    } else if (hasValue[i]) {
                        return new double[0];
                    }

                    foundValueInEquation = true;
                    hasValue[i] = true;
                    values[i] = equation[n];
                }
            }
        }

        for (boolean varHasValue : hasValue) {
            if (!varHasValue) return new double[0];
        }

        return values;
    }

    private static double[][] gaussJordanIteration(double[][] equations, int start) {
        // somehow make sure it looks for the first variable with a non-zero coefficient. hmmm
        int n = equations[start].length;
        double[][] eq = new double[3][2]; // 2 double[]s each of length 3

        double leadingCoefficient = equations[start][start];
        double[] leadingEquation = new double[3];
        for (int i = 0; i < n; i++) {
            leadingEquation[i] = equations[start][i] / leadingCoefficient;
        }

        for (int i = 0; i < equations.length; i++) {
            if (i == start) {
                eq[i] = leadingEquation;
            } else {
                leadingCoefficient = equations[i][start];
                for (int j = 0; j < n; j++) {
                    eq[i][j] = equations[i][j] - (equations[start][j] / leadingCoefficient);
                }
            }
        }

        return eq;
    }

    // --- ROTATION ---

    public static Matrix2x2 rotationMatrixMultipleOfPi(double radiansMultiple) {
        return rotationMatrix(radiansMultiple*Math.PI, true);
    }

    public static Matrix2x2 rotationMatrixMultipleOfPi(double radiansMultiple, boolean counterclockwise) {
        return rotationMatrix(radiansMultiple*Math.PI, true);
    }

    public static Matrix2x2 rotationMatrixMultipleOfPi(Rational radiansMultiple) {
        return rotationMatrix(radiansMultiple.doubleValue()*Math.PI, true);
    }

    public static Matrix2x2 rotationMatrixMultipleOfPi(Rational radiansMultiple, boolean counterclockwise) {
        return rotationMatrix(radiansMultiple.doubleValue()*Math.PI, true);
    }

    public static Matrix2x2 rotationMatrix(double radians) {
        return rotationMatrix(radians, true);
    }

    public static Matrix2x2 rotationMatrix(double radians, boolean counterclockwise) {
        // clamp radians between 0 and 2pi
        if (radians < 0) {
            radians *= -1;
            counterclockwise = !counterclockwise;
        }
        if (radians > Util.TAU) radians = radians % Util.TAU;
        if (!counterclockwise) radians = Util.TAU - radians;

        return new Matrix2x2(Math.cos(radians), -Math.sin(radians), Math.sin(radians), Math.cos(radians));
    }

    // --- MISC ---

    @Override
    public String toString() {
        return "|" + getA() + " " + getB() + "|\n|" + getC() + " " + getD() + "|";
    }

}
