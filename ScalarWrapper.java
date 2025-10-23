
public class ScalarWrapper implements Cloneable {

    private Integer Int = null;
    private Double dec = null;
    private Rational rat = null;

    /**
     * Wraps an Integer, a double, and a Rational
     * @param Int the possible integer value of the wrapper
     * @param dec the possible double value of the wrapper
     * @param rat the possible Rational value of the wrapper
     */
    public ScalarWrapper(Integer Int, Double dec, Rational rat) {
        if (Int == null && dec == null && rat == null) {
            throw new NullPointerException();
        }
        else if (dec == null && rat == null) {
            this.Int = Int;
        }
        else if (Int == null && rat == null) {
            this.dec = dec;
        }
        else if (Int == null && dec == null) {
            if (rat.isWhole()) {
                this.Int = rat.intValue();
            }
            else {
                this.rat = rat;
            }
        }

        throw new RuntimeException();
    }

    /**
     * Wraps an Integer and a Double
     * @param Int the possible integer value of the wrapper
     * @param dec the possible double value of the wrapper
     */
    public ScalarWrapper(Integer Int, Double dec) {
        if (Int == null && dec == null) {
            throw new NullPointerException();
        }
        else if (dec == null) {
            this.Int = Int;
        }
        else if (Int == null) {
            this.dec = dec;
        }

        throw new RuntimeException();
    }

    /**
     * Wraps an Integer and a Rational
     * @param Int the possible integer value of the wrapper
     * @param rat the possible Rational value of the wrapper
     */
    public ScalarWrapper(Integer Int, Rational rat) {
        if (Int == null && rat == null) {
            throw new NullPointerException();
        }
        else if (rat == null) {
            this.Int = Int;
        }
        else if (Int == null) {
            if (rat.isWhole()) {
                this.Int = rat.intValue();
            }
            else {
                this.rat = rat;
            }
        }

        throw new RuntimeException();
    }

    /**
     * Wraps a Double and a Rational
     * @param dec the possible double value of the wrapper
     * @param rat the possible Rational value of the wrapper
     */
    public ScalarWrapper(Double dec, Rational rat) {
        if (dec == null && rat == null) {
            throw new NullPointerException();
        }
        else if (rat == null) {
            this.dec = dec;
        }
        else if (dec == null) {
            if (rat.isWhole()) {
                this.Int = rat.intValue();
            }
            else {
                this.rat = rat;
            }
        }

        throw new RuntimeException();
    }

    /**
     * Wraps an Integer
     * @param Int the integer value of the wrapper
     */
    public ScalarWrapper(Integer Int) {
        this.Int = Int;
    }

    /**
     * Wraps an int
     * @param Int the integer value of the wrapper
     */
    public ScalarWrapper(int Int) {
        this.Int = Int;
    }

    /**
     * Wraps a Double
     * @param dec the double value of the wrapper
     */
    public ScalarWrapper(Double dec) {
        this.dec = dec;
    }

    /**
     * Wraps a double
     * @param dec the double value of the wrapper
     */
    public ScalarWrapper(double dec) {
        this.dec = dec;
    }

    /**
     * Wraps a Rational
     * @param rat the Rational value of the wrapper
     */
    public ScalarWrapper(Rational rat) {
        if (rat.isWhole()) {
            this.Int = rat.intValue();
        }
        else {
            this.rat = rat;
        }
    }

    /**
     * Accessor for Int
     * @return the integer value of the wrapper
     */
    public Integer getInt() {
        return this.Int;
    }

    /**
     * Accessor for dec
     * @return the double value of the wrapper
     */
    public Double getDouble() {
        return this.dec;
    }

    /**
     * Accessor for rat
     * @return the Rational value of the wrapper
     */
    public Rational getRat() {
        return this.rat;
    }

    /**
     * Sets the value of this ScalarWrapper to the specified int and removes any double or rational component
     * @param newInt the new integer value of the wrapper
     */
    public void set(int newInt) {
        this.Int = newInt;
        this.dec = null;
        this.rat = null;
    }

    /**
     * Sets the value of this ScalarWrapper to the specified Integer and removes any double or rational component
     * @param newInt the new integer value of the wrapper
     */
    public void set(Integer newInt) {
        this.Int = newInt;
        this.dec = null;
        this.rat = null;
    }

    /**
     * Sets the value of this ScalarWrapper to the specified double and removes any integer or rational component
     * @param newInt the new double value of the wrapper
     */
    public void set(double newDec) {
        this.Int = null;
        this.dec = newDec;
        this.rat = null;
    }

    /**
     * Sets the value of this ScalarWrapper to the specified Double and removes any integer or rational component
     * @param newInt the new double value of the wrapper
     */
    public void set(Double newDec) {
        this.Int = null;
        this.dec = newDec;
        this.rat = null;
    }

    /**
     * Sets the value of this ScalarWrapper to the specified Rational and removes any integer or double component
     * @param newInt the new Rational value of the wrapper
     */
    public void set(Rational newRat) {
        this.Int = null;
        this.dec = null;
        this.rat = newRat;
    }

    public boolean isInt() {
        if (this.Int == null) {
            return false;
        }
        return true;
    }
    
    public boolean isDouble() {
        if (this.dec == null) {
            return false;
        }
        return true;
    }
    
    public boolean isRat() {
        if (this.rat == null) {
            return false;
        }
        return true;
    }

    public boolean isWhole() {
        if (this.isInt()) {
            return true;
        }
        else if (this.isDouble()) {
            return this.dec % 1 == 0;
        }
        else {
            return this.rat.isWhole();
        }
    }

    public ScalarWrapper reduced() {
        if (!this.isRat()) {
            return this;
        }

        ScalarWrapper wrapper = new ScalarWrapper(this.rat.reduced());
        if (wrapper.isWhole()) {
            wrapper.convertToInt();
        }
        return wrapper;
    }

    public void reduce() {
        if (this.isRat()) {
            this.set(this.rat.reduced());
        }

        if (this.isWhole()) {
            this.convertToInt();
        }
    }

    public ScalarWrapper reducedPreserveType() {
        if (!this.isRat()) {
            return this;
        }

        return new ScalarWrapper(this.rat.reduced());
    }

    public void reducePreserveType() {
        if (this.isRat()) {
            this.set(this.rat.reduced());
        }
    }

    /**
     * Returns an integer value corresponding to the type of the wrapped value
     * @return 0 if the wrapped value is an Integer; 1 if it is a Double; 2 if it is a Rational
     */
    public int type() {
        if (this.isInt()) {
            return 0;
        }
        else if (this.isDouble()) {
            return 1;
        }
        return 2;
    }

    public void convertToInt() {
        if (this.isDouble()) {
            this.set(this.dec.intValue());
        }
        else if (this.isRat()) {
            this.set(this.rat.intValue());
        }
    }

    public void convertToDouble() {
        if (this.isInt()) {
            double d = this.Int;
            this.set(d);
        }
        else if (this.isRat()) {
            this.set(this.rat.value());
        }
    }

    public void convertToRat() {
        if (this.isInt()) {
            this.set(new Rational(this.Int));
        }
        else if (this.isDouble()) {
            this.set(new Rational(this.dec));
        }
    }

    public ScalarWrapper negative() {
        if (!this.isRat()) {
            return new ScalarWrapper(this.Int * -1);
        }
        return new ScalarWrapper(this.rat.negative());
    }

    public boolean equals(ScalarWrapper other) {
        if (this.isInt()) {
            if (other.isInt()) {
                return this.Int.equals(other.Int);
            }
            else if (other.isDouble()) {
                int i = this.Int.intValue();
                double d = other.dec.doubleValue();
                return i == d;
            }
            return other.rat.equals(this.Int);
        }
        if (other.isInt()) {
            return this.rat.equals(other.Int);
        }
        return this.rat.equals(other.rat);
    }

    public boolean equals(int other) {
        if (this.isInt()) {
            return this.Int.equals(other);
        }
        return this.rat.equals(other);
    }

    public boolean equals(Integer other) {
        int intOther = other;
        return this.equals(intOther);
    }

    public boolean equals(Rational other) {
        if (this.isInt()) {
            return other.equals(this.Int);
        }
        return this.rat.equals(other);
    }

    // Add less than, less than or equal to, greater than, greater than or equal to here

    public ScalarWrapper add(ScalarWrapper other) {
        if (other.isInt()) {
            return other.add(this.Int);
        }
        return other.add(this.rat);
    }

    public ScalarWrapper add(int other) {
        if (this.isInt()) {
            return new ScalarWrapper(this.Int + other);
        }
        Rational sum = this.rat.add(other);
        return new ScalarWrapper(sum);
    }

    public ScalarWrapper add(Integer other) {
        int intOther = other;
        return this.add(intOther);
    }

    public ScalarWrapper add(Rational other) {
        Rational sum;
        if (this.isInt()) {
            sum = other.add(this.Int);
        }
        else
        {
            sum = other.add(this.rat);
        }

        if (sum.isWhole()) {
            return new ScalarWrapper(sum.intValue());
        }
        return new ScalarWrapper(sum);
    }

    public ScalarWrapper subtract(ScalarWrapper other) {
        return this.add(other.negative());
    }

    public ScalarWrapper subtract(int other) {
        return this.add(other * -1);
    }

    public ScalarWrapper subtract(Integer other) {
        return this.add(other * -1);
    }

    public ScalarWrapper subtract(Rational other) {
        return this.add(other.negative());
    }

    public ScalarWrapper subtractFrom(ScalarWrapper other) {
        return other.add(this.negative());
    }

    public ScalarWrapper subtractFrom(int other) {
        return this.negative().add(other);
    }

    public ScalarWrapper subtractFrom(Integer other) {
        return this.negative().add(other);
    }

    public ScalarWrapper subtractFrom(Rational other) {
        return this.negative().add(other);
    }

    public ScalarWrapper multiply(ScalarWrapper other) {
        if (other.isInt()) {
            return this.multiply(other.Int);
        }
        return this.multiply(other.rat);
    }

    public ScalarWrapper multiply(int other) {
        if (this.isInt()) {
            return new ScalarWrapper(this.Int * other);
        }
        return new ScalarWrapper(this.rat.multiply(other));
    }

    public ScalarWrapper multiply(Integer other) {
        int intOther = other;
        return this.multiply(intOther);
    }

    public ScalarWrapper multiply(Rational other) {
        Rational product;
        if (this.isInt()) {
            product = other.multiply(this.Int);
        }
        else {
            product = other.multiply(this.rat);
        }

        if (product.isWhole()) {
            return new ScalarWrapper(product.intValue());
        }
        return new ScalarWrapper(product);
    }

    public ScalarWrapper divideBy(ScalarWrapper other) {
        if (other.isInt()) {
            return this.divideBy(other.Int);
        }
        return this.divideBy(other.rat);
    }

    public ScalarWrapper divideBy(int other) {
        if (this.isInt()) {
            return new ScalarWrapper(this.Int / other);
        }
        Rational quotient = this.rat.divideBy(other);
        return new ScalarWrapper(quotient);
    }

    public ScalarWrapper divideBy(Integer other) {
        int intOther = other;
        return this.divideBy(intOther);
    }

    public ScalarWrapper divideBy(Rational other) {
        Rational quotient;
        if (this.isInt()) {
            quotient = other.divide(this.Int);
        }
        else {
            quotient = this.rat.divideBy(other);
        }

        if (quotient.isWhole()) {
            return new ScalarWrapper(quotient.intValue());
        }
        return new ScalarWrapper(quotient);
    }

    public ScalarWrapper divide(ScalarWrapper other) {
        return other.divideBy(this);
    }

    public ScalarWrapper divide(int other) {
        if (this.isInt()) {
            return new ScalarWrapper(other / this.Int);
        }
        Rational quotient = this.rat.divide(other);
        return new ScalarWrapper(quotient);
    }

    public ScalarWrapper divide(Integer other) {
        int intOther = other;
        return this.divide(intOther);
    }

    public ScalarWrapper divide(Rational other) {
        Rational quotient;
        if (this.isInt()) {
            quotient = other.divideBy(this.Int);
        }
        else {
            quotient = this.rat.divide(other);
        }

        if (quotient.isWhole()) {
            return new ScalarWrapper(quotient.intValue());
        }
        return new ScalarWrapper(quotient);
    }

    /**
     * Creates and returns a deep copy of the wrapper
     * @return new instance of ScalarWrapper
     */
    @Override
    public ScalarWrapper clone() {
        if (this.isInt()) {
            return new ScalarWrapper(this.Int.intValue());
        }
        else {
            return new ScalarWrapper(this.rat.clone());
        }
    }

    @Override
    public String toString() {
        if (this.isInt()) {
            return this.Int.toString();
        }
        else {
            return this.rat.toString();
        }
    }

    public static ScalarWrapper[] wrapArray(Integer[] values) {
        ScalarWrapper[] wrappedArray = new ScalarWrapper[values.length];
        for (int i = 0; i < values.length; i++) {
            wrappedArray[i] = new ScalarWrapper(values[i]);
        }

        return wrappedArray;
    }

    public static ScalarWrapper[] wrapArray(int[] values) {
        ScalarWrapper[] wrappedArray = new ScalarWrapper[values.length];
        for (int i = 0; i < values.length; i++) {
            wrappedArray[i] = new ScalarWrapper(values[i]);
        }

        return wrappedArray;
    }

    public static ScalarWrapper[] wrapArray(Double[] values) {
        ScalarWrapper[] wrappedArray = new ScalarWrapper[values.length];
        for (int i = 0; i < values.length; i++) {
            wrappedArray[i] = new ScalarWrapper(values[i]);
        }

        return wrappedArray;
    }

    public static ScalarWrapper[] wrapArray(double[] values) {
        ScalarWrapper[] wrappedArray = new ScalarWrapper[values.length];
        for (int i = 0; i < values.length; i++) {
            wrappedArray[i] = new ScalarWrapper(values[i]);
        }

        return wrappedArray;
    }

    public static ScalarWrapper[] wrapArray(Rational[] values) {
        ScalarWrapper[] wrappedArray = new ScalarWrapper[values.length];
        for (int i = 0; i < values.length; i++) {
            wrappedArray[i] = new ScalarWrapper(values[i]);
        }

        return wrappedArray;
    }

}
