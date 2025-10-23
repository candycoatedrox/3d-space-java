public class NormalVector extends Vector {

    private int divSqrt;

    /**
     * Constructs a normalized vector
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

    //@Override
    public NormalVector normalize() {
        return this;
    }

    //@Override
    public NormalVector normalize(Matrix Gij) {
        return this;
    }

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

}
