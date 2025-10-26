public class Radical {

    private ScalarWrapper innerValue;

    /**
     * Constructs a Radical from a ScalarWrapper
     * @param value the ScalarWrapper inside the Radical
     */
    public Radical(ScalarWrapper value) {
        this.innerValue = value;
    }

    /**
     * Constructs a Radical from an int
     * @param value the integer inside the Radical
     */
    public Radical(int value) {
        this.innerValue = new ScalarWrapper(value);
    }

    /**
     * Constructs a Radical from an Integer
     * @param value the integer inside the Radical
     */
    public Radical(Integer value) {
        this.innerValue = new ScalarWrapper(value);
    }

    /**
     * Constructs a Radical from a double
     * @param value the double inside the Radical
     */
    public Radical(double value) {
        this.innerValue = new ScalarWrapper(value);
    }

    /**
     * Constructs a Radical from a Double
     * @param value the double inside the Radical
     */
    public Radical(Double value) {
        this.innerValue = new ScalarWrapper(value);
    }

    /**
     * Constructs a Radical from a Rational
     * @param value the Rational inside the Radical
     */
    public Radical(Rational value) {
        this.innerValue = new ScalarWrapper(value);
    }

    /**
     * Returns true value of this Radical, simplified
     * @return the true value of this Radical, simplified
     */
    public ScalarWrapper value() {
        return this.innerValue.root();
    }

    /**
     * Returns true value of this Radical
     * @return the true value of this Radical
     */
    public double doubleValue() {
        return this.innerValue.sqrt();
    }

    /**
     * Creates and returns a deep copy of this Radical
     * @return a deep copy of this Radical
     */
    @Override
    public Radical clone() {
        return new Radical(innerValue.clone());
    }

    /**
     * Returns a String representation of this Radical
     * @return a String representation of this Radical
     */
    @Override
    public String toString() {
        return "√" + this.innerValue;
    }

}
