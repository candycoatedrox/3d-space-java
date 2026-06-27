public class Vector2D {

    public static final Vector2D X_AXIS = new Vector2D(1,0);
    public static final Vector2D Y_AXIS = new Vector2D(0,1);

    private double x;
    private double y;

    // --- CONSTRUCTORS ---

    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Vector2D(double x, int y) {
        this.x = x;
        this.y = y;
    }

    public Vector2D(double x, Rational y) {
        this.x = x;
        this.y = y.doubleValue();
    }

    public Vector2D(int x, double y) {
        this.x = x;
        this.y = y;
    }

    public Vector2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Vector2D(int x, Rational y) {
        this.x = x;
        this.y = y.doubleValue();
    }

    public Vector2D(Rational x, double y) {
        this.x = x.doubleValue();
        this.y = y;
    }

    public Vector2D(Rational x, int y) {
        this.x = x.doubleValue();
        this.y = y;
    }

    public Vector2D(Rational x, Rational y) {
        this.x = x.doubleValue();
        this.y = y.doubleValue();
    }

    // --- GETTERS & SETTERS ---

    public double[] getComponents() {
        double[] components = {x, y};
        return components;
    }

    public void setComponents(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void setComponents(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setComponents(Rational x, Rational y) {
        this.x = x.doubleValue();
        this.y = y.doubleValue();
    }

    public double getX() {
        return x;
    }

    public void setX(double value) {
        x = value;
    }

    public void setX(int value) {
        x = value;
    }

    public void setX(Rational value) {
        x = value.doubleValue();
    }

    public double getY() {
        return x;
    }

    public void setY(double value) {
        y = value;
    }

    public void setY(int value) {
        y = value;
    }

    public void setY(Rational value) {
        y = value.doubleValue();
    }

    // --- BASIC CALCULATIONS ---

    public double magnitudeSq() {
        return innerProduct(this, this, Matrix2x2.GIJ);
    }

    public double magnitudeSq(Matrix2x2 Gij) {
        return innerProduct(this, this, Gij);
    }

    public double magnitude() {
        return Math.sqrt(magnitudeSq());
    }

    public double magnitude(Matrix2x2 Gij) {
        return Math.sqrt(magnitudeSq(Gij));
    }

    public double slope() {
        return y/x;
    }

    public Rational slopeRational() {
        return new Rational(y, x);
    }

    public Vector2D projection(Vector2D other) {
        return projection(other, Matrix2x2.GIJ);
    }

    public Vector2D projection(Vector2D other, Matrix2x2 Gij) {
        double scalarFactor = innerProduct(this, other, Gij) / magnitudeSq(Gij);
        return this.multiply(scalarFactor);
    }

    public Vector2D projectionOnto(Vector2D other) {
        return other.projection(this, Matrix2x2.GIJ);
    }

    public Vector2D projectionOnto(Vector2D other, Matrix2x2 Gij) {
        return other.projection(this, Gij);
    }

    // --- COMPARISONS ---

    public boolean equals(Vector2D other) {
        return x == other.x && y == other.y;
    }

    public boolean isScalarMultOf(Vector2D other) {
        return x / other.x == y / other.y;
    }

    public boolean isOrthogonal(Vector2D other) {
        return isOrthogonal(other, Matrix2x2.GIJ);
    }

    public boolean isOrthogonal(Vector2D other, Matrix2x2 Gij) {
        return innerProduct(this, other, Gij) == 0;
    }

    // --- BASIC OPERATIONS ---

    public Vector2D negative() {
        return multiply(-1);
    }

    public Vector2D absolute() {
        return new Vector2D(Math.abs(x), Math.abs(y));
    }

    public Vector2D add(Vector2D other) {
        return new Vector2D(x + other.x, y + other.y);
    }

    public void addToThis(Vector2D other) {
        x += other.x;
        y += other.y;
    }

    public Vector2D subtract(Vector2D other) {
        return new Vector2D(x - other.x, y - other.y);
    }

    public void subtractFromThis(Vector2D other) {
        x -= other.x;
        y -= other.y;
    }

    public Vector2D multiply(int other) {
        return new Vector2D(x * other, y * other);
    }

    public Vector2D multiply(double other) {
        return new Vector2D(x * other, y * other);
    }

    public Vector2D multiply(Rational other) {
        return new Vector2D(x * other.doubleValue(), y * other.doubleValue());
    }

    public void multiplyBy(int other) {
        x *= other;
        y *= other;
    }

    public void multiplyBy(double other) {
        x *= other;
        y *= other;
    }

    public void multiplyBy(Rational other) {
        x *= other.doubleValue();
        y *= other.doubleValue();
    }

    public Vector2D divide(int other) {
        return new Vector2D(x / other, y / other);
    }

    public Vector2D divide(double other) {
        return new Vector2D(x / other, y / other);
    }

    public Vector2D divide(Rational other) {
        return new Vector2D(x / other.doubleValue(), y / other.doubleValue());
    }

    public void divideBy(int other) {
        x /= other;
        y /= other;
    }

    public void divideBy(double other) {
        x /= other;
        y /= other;
    }

    public void divideBy(Rational other) {
        x /= other.doubleValue();
        y /= other.doubleValue();
    }

    // --- INNER PRODUCT ---

    public static double innerProduct(Vector2D v, Vector2D w) {
        return innerProduct(v, w, Matrix2x2.GIJ);
    }

    public static double innerProduct(Vector2D v, Vector2D w, Matrix2x2 Gij) {
        return Gij.get(0,0)*v.x*w.x + Gij.get(0,1)*v.x*w.y + Gij.get(1,0)*v.y*w.x + Gij.get(1,1)*v.y*w.y;
    }

    // --- VECTOR ARITHMETIC ---

    public double cosAngle() {
        return cosAngle(X_AXIS, Matrix2x2.GIJ);
    }

    public double cosAngle(Matrix2x2 Gij) {
        return cosAngle(X_AXIS, Gij);
    }

    public double cosAngle(Vector2D other) {
        return cosAngle(other, Matrix2x2.GIJ);
    }

    public double cosAngle(Vector2D other, Matrix2x2 Gij) {
        return innerProduct(this, other, Gij) / (this.magnitude(Gij) * other.magnitude(Gij));
    }

    public double angle() {
        return angle(X_AXIS, Matrix2x2.GIJ);
    }

    public double angle(Matrix2x2 Gij) {
        return angle(X_AXIS, Gij);
    }

    public double angle(Vector2D other) {
        return angle(other, Matrix2x2.GIJ);
    }

    public double angle(Vector2D other, Matrix2x2 Gij) {
        return Math.acos(cosAngle(other, Gij));
    }

    public double angleMultipleOfPi() {
        return cosAngle(X_AXIS, Matrix2x2.GIJ);
    }

    public double angleMultipleOfPi(Matrix2x2 Gij) {
        return cosAngle(X_AXIS, Gij);
    }

    public double angleMultipleOfPi(Vector2D other) {
        return angleMultipleOfPi(other, Matrix2x2.GIJ);
    }

    public double angleMultipleOfPi(Vector2D other, Matrix2x2 Gij) {
        return angle(other, Gij) / Math.PI;
    }

    public Rational angleRatMultipleOfPi() {
        return angleRatMultipleOfPi(X_AXIS, Matrix2x2.GIJ);
    }

    public Rational angleRatMultipleOfPi(Matrix2x2 Gij) {
        return angleRatMultipleOfPi(X_AXIS, Gij);
    }

    public Rational angleRatMultipleOfPi(Vector2D other) {
        return angleRatMultipleOfPi(other, Matrix2x2.GIJ);
    }

    public Rational angleRatMultipleOfPi(Vector2D other, Matrix2x2 Gij) {
        return new Rational(angleMultipleOfPi(other, Gij));
    }

    // --- NORMAL VECTORS ---

    // --- MISC ---

    @Override
    public String toString() {
        return "<" + x + " " + y + ">";
    }
    
}
