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
     * Accessor for innerValue
     * @return the innerValue of this Radical
     */
    public ScalarWrapper getInnerValue() {
        return this.innerValue;
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
    public double trueValue() {
        return this.innerValue.sqrt();
    }
    
    /**
     * Compares this Radical to another Radical
     * @param other the Radical to compare with
     * @return true if the value of this Radical is equal to the value of other; false otherwise
     */
    public boolean equals(Radical other) {
        return this.trueValue() == other.trueValue();
    }
    
    /**
     * Compares this Radical to a ScalarWrapper
     * @param other the ScalarWrapper to compare with
     * @return true if the value of this Radical is equal to the value of other; false otherwise
     */
    public boolean equals(ScalarWrapper other) {
        return this.trueValue() == other.doubleValue();
    }
    
    /**
     * Compares this Radical to an int
     * @param other the int to compare with
     * @return true if the value of this Radical is equal to other; false otherwise
     */
    public boolean equals(int other) {
        return this.trueValue() == other;
    }
    
    /**
     * Compares this Radical to an Integer
     * @param other the Integer to compare with
     * @return true if the value of this Radical is equal to other; false otherwise
     */
    public boolean equals(Integer other) {
        return this.trueValue() == other;
    }
    
    /**
     * Compares this Radical to a double
     * @param other the double to compare with
     * @return true if the value of this Radical is equal to other; false otherwise
     */
    public boolean equals(double other) {
        return this.trueValue() == other;
    }
    
    /**
     * Compares this Radical to a Double
     * @param other the Double to compare with
     * @return true if the value of this Radical is equal to other; false otherwise
     */
    public boolean equals(Double other) {
        return this.trueValue() == other;
    }
    
    /**
     * Compares this Radical to a Rational
     * @param other the Rational to compare with
     * @return true if the value of this Radical is equal to the value of other; false otherwise
     */
    public boolean equals(Rational other) {
        return this.trueValue() == other.value();
    }
    
    /**
     * Compares this Radical to another Radical
     * @param other the Radical to compare with
     * @return true if the value of this Radical is less than the value of other; false otherwise
     */
    public boolean lessThan(Radical other) {
        return this.trueValue() < other.trueValue();
    }
    
    /**
     * Compares this Radical to a ScalarWrapper
     * @param other the ScalarWrapper to compare with
     * @return true if the value of this Radical is less than the value of other; false otherwise
     */
    public boolean lessThan(ScalarWrapper other) {
        return this.trueValue() < other.doubleValue();
    }
    
    /**
     * Compares this Radical to an int
     * @param other the int to compare with
     * @return true if the value of this Radical is less than other; false otherwise
     */
    public boolean lessThan(int other) {
        return this.trueValue() < other;
    }
    
    /**
     * Compares this Radical to an Integer
     * @param other the Integer to compare with
     * @return true if the value of this Radical is less than other; false otherwise
     */
    public boolean lessThan(Integer other) {
        return this.trueValue() < other;
    }
    
    /**
     * Compares this Radical to a double
     * @param other the double to compare with
     * @return true if the value of this Radical is less than other; false otherwise
     */
    public boolean lessThan(double other) {
        return this.trueValue() < other;
    }
    
    /**
     * Compares this Radical to a Double
     * @param other the Double to compare with
     * @return true if the value of this Radical is less than other; false otherwise
     */
    public boolean lessThan(Double other) {
        return this.trueValue() < other;
    }
    
    /**
     * Compares this Radical to a Rational
     * @param other the Rational to compare with
     * @return true if the value of this Radical is less than the value of other; false otherwise
     */
    public boolean lessThan(Rational other) {
        return this.trueValue() < other.value();
    }
    
    /**
     * Compares this Radical to another Radical
     * @param other the Radical to compare with
     * @return true if the value of this Radical is less than or equal to the value of other; false otherwise
     */
    public boolean lessThanOrEquals(Radical other) {
        return this.trueValue() <= other.trueValue();
    }
    
    /**
     * Compares this Radical to a ScalarWrapper
     * @param other the ScalarWrapper to compare with
     * @return true if the value of this Radical is less than or equal to the value of other; false otherwise
     */
    public boolean lessThanOrEquals(ScalarWrapper other) {
        return this.trueValue() <= other.doubleValue();
    }
    
    /**
     * Compares this Radical to an int
     * @param other the int to compare with
     * @return true if the value of this Radical is less than or equal to other; false otherwise
     */
    public boolean lessThanOrEquals(int other) {
        return this.trueValue() <= other;
    }
    
    /**
     * Compares this Radical to an Integer
     * @param other the Integer to compare with
     * @return true if the value of this Radical is less than or equal to other; false otherwise
     */
    public boolean lessThanOrEquals(Integer other) {
        return this.trueValue() <= other;
    }
    
    /**
     * Compares this Radical to a double
     * @param other the double to compare with
     * @return true if the value of this Radical is less than or equal to other; false otherwise
     */
    public boolean lessThanOrEquals(double other) {
        return this.trueValue() <= other;
    }
    
    /**
     * Compares this Radical to a Double
     * @param other the Double to compare with
     * @return true if the value of this Radical is less than or equal to other; false otherwise
     */
    public boolean lessThanOrEquals(Double other) {
        return this.trueValue() <= other;
    }
    
    /**
     * Compares this Radical to a Rational
     * @param other the Rational to compare with
     * @return true if the value of this Radical is less than or equal to the value of other; false otherwise
     */
    public boolean lessThanOrEquals(Rational other) {
        return this.trueValue() <= other.value();
    }
    
    /**
     * Compares this Radical to another Radical
     * @param other the Radical to compare with
     * @return true if the value of this Radical is greater than the value of other; false otherwise
     */
    public boolean greaterThan(Radical other) {
        return this.trueValue() > other.trueValue();
    }
    
    /**
     * Compares this Radical to a ScalarWrapper
     * @param other the ScalarWrapper to compare with
     * @return true if the value of this Radical is greater than the value of other; false otherwise
     */
    public boolean greaterThan(ScalarWrapper other) {
        return this.trueValue() > other.doubleValue();
    }
    
    /**
     * Compares this Radical to an int
     * @param other the int to compare with
     * @return true if the value of this Radical is greater than other; false otherwise
     */
    public boolean greaterThan(int other) {
        return this.trueValue() > other;
    }
    
    /**
     * Compares this Radical to an Integer
     * @param other the Integer to compare with
     * @return true if the value of this Radical is greater than other; false otherwise
     */
    public boolean greaterThan(Integer other) {
        return this.trueValue() > other;
    }
    
    /**
     * Compares this Radical to a double
     * @param other the double to compare with
     * @return true if the value of this Radical is greater than other; false otherwise
     */
    public boolean greaterThan(double other) {
        return this.trueValue() > other;
    }
    
    /**
     * Compares this Radical to a Double
     * @param other the Double to compare with
     * @return true if the value of this Radical is greater than other; false otherwise
     */
    public boolean greaterThan(Double other) {
        return this.trueValue() > other;
    }
    
    /**
     * Compares this Radical to a Rational
     * @param other the Rational to compare with
     * @return true if the value of this Radical is greater than the value of other; false otherwise
     */
    public boolean greaterThan(Rational other) {
        return this.trueValue() > other.value();
    }
    
    /**
     * Compares this Radical to another Radical
     * @param other the Radical to compare with
     * @return true if the value of this Radical is greater than or equal to the value of other; false otherwise
     */
    public boolean greaterThanOrEquals(Radical other) {
        return this.trueValue() >= other.trueValue();
    }
    
    /**
     * Compares this Radical to a ScalarWrapper
     * @param other the ScalarWrapper to compare with
     * @return true if the value of this Radical is greater than or equal to the value of other; false otherwise
     */
    public boolean greaterThanOrEquals(ScalarWrapper other) {
        return this.trueValue() >= other.doubleValue();
    }
    
    /**
     * Compares this Radical to an int
     * @param other the int to compare with
     * @return true if the value of this Radical is greater than or equal to other; false otherwise
     */
    public boolean greaterThanOrEquals(int other) {
        return this.trueValue() >= other;
    }
    
    /**
     * Compares this Radical to an Integer
     * @param other the Integer to compare with
     * @return true if the value of this Radical is greater than or equal to other; false otherwise
     */
    public boolean greaterThanOrEquals(Integer other) {
        return this.trueValue() >= other;
    }
    
    /**
     * Compares this Radical to a double
     * @param other the double to compare with
     * @return true if the value of this Radical is greater than or equal to other; false otherwise
     */
    public boolean greaterThanOrEquals(double other) {
        return this.trueValue() >= other;
    }
    
    /**
     * Compares this Radical to a Double
     * @param other the Double to compare with
     * @return true if the value of this Radical is greater than or equal to other; false otherwise
     */
    public boolean greaterThanOrEquals(Double other) {
        return this.trueValue() >= other;
    }
    
    /**
     * Compares this Radical to a Rational
     * @param other the Rational to compare with
     * @return true if the value of this Radical is greater than or equal to the value of other; false otherwise
     */
    public boolean greaterThanOrEquals(Rational other) {
        return this.trueValue() >= other.value();
    }

    /**
     * Multiplies this Radical with another Radical
     * @param other the Radical to multiply with
     * @return the product of this Radical and other
     */
    public Radical multiply(Radical other) {
        ScalarWrapper wrapper = this.innerValue.multiply(other.innerValue);
        return new Radical(wrapper);
    }

    /**
     * Multiplies this Radical with a ScalarWrapper
     * @param other the ScalarWrapper to multiply with
     * @return the product of this Radical and other
     */
    public Radical multiply(ScalarWrapper other) {
        ScalarWrapper factorSquare = this.innerValue.squared();
        ScalarWrapper wrapper = this.innerValue.multiply(factorSquare);
        return new Radical(wrapper);
    }

    /**
     * Multiplies this Radical with an int
     * @param other the int to multiply with
     * @return the product of this Radical and other
     */
    public Radical multiply(int other) {
        ScalarWrapper factorSquare = this.innerValue.squared();
        ScalarWrapper wrapper = this.innerValue.multiply(factorSquare);
        return new Radical(wrapper);
    }

    /**
     * Multiplies this Radical with an Integer
     * @param other the Integer to multiply with
     * @return the product of this Radical and other
     */
    public Radical multiply(Integer other) {
        ScalarWrapper factorSquare = this.innerValue.squared();
        ScalarWrapper wrapper = this.innerValue.multiply(factorSquare);
        return new Radical(wrapper);
    }

    /**
     * Multiplies this Radical with a double
     * @param other the double to multiply with
     * @return the product of this Radical and other
     */
    public Radical multiply(double other) {
        ScalarWrapper factorSquare = this.innerValue.squared();
        ScalarWrapper wrapper = this.innerValue.multiply(factorSquare);
        return new Radical(wrapper);
    }

    /**
     * Multiplies this Radical with a Double
     * @param other the Double to multiply with
     * @return the product of this Radical and other
     */
    public Radical multiply(Double other) {
        ScalarWrapper factorSquare = this.innerValue.squared();
        ScalarWrapper wrapper = this.innerValue.multiply(factorSquare);
        return new Radical(wrapper);
    }

    /**
     * Multiplies this Radical with a Rational
     * @param other the Rational to multiply with
     * @return the product of this Radical and other
     */
    public Radical multiply(Rational other) {
        ScalarWrapper factorSquare = this.innerValue.squared();
        ScalarWrapper wrapper = this.innerValue.multiply(factorSquare);
        return new Radical(wrapper);
    }

    /**
     * Multiplies this Radical with a ScalarWrapper
     * @param other the ScalarWrapper to multiply with
     * @return the true value of the product of this Radical and other
     */
    public ScalarWrapper trueMultiply(ScalarWrapper other) {
        Radical radical = this.multiply(other);
        return radical.value();
    }

    /**
     * Multiplies this Radical with an int
     * @param other the int to multiply with
     * @return the true value of the product of this Radical and other
     */
    public ScalarWrapper trueMultiply(int other) {
        Radical radical = this.multiply(other);
        return radical.value();
    }

    /**
     * Multiplies this Radical with an Integer
     * @param other the Integer to multiply with
     * @return the true value of the product of this Radical and other
     */
    public ScalarWrapper trueMultiply(Integer other) {
        Radical radical = this.multiply(other);
        return radical.value();
    }

    /**
     * Multiplies this Radical with a double
     * @param other the double to multiply with
     * @return the true value of the product of this Radical and other
     */
    public ScalarWrapper trueMultiply(double other) {
        Radical radical = this.multiply(other);
        return radical.value();
    }

    /**
     * Multiplies this Radical with a Double
     * @param other the Double to multiply with
     * @return the true value of the product of this Radical and other
     */
    public ScalarWrapper trueMultiply(Double other) {
        Radical radical = this.multiply(other);
        return radical.value();
    }

    /**
     * Multiplies this Radical with a Rational
     * @param other the Rational to multiply with
     * @return the true value of the product of this Radical and other
     */
    public ScalarWrapper trueMultiply(Rational other) {
        Radical radical = this.multiply(other);
        return radical.value();
    }

    /**
     * Divides this Radical by another Radical
     * @param other the Radical to divide by
     * @return the quotient of this Radical and other
     */
    public Radical divideBy(Radical other) {
        ScalarWrapper wrapper = this.innerValue.divideBy(other.innerValue);
        return new Radical(wrapper);
    }

    /**
     * Divides this Radical by a ScalarWrapper
     * @param other the ScalarWrapper to divide by
     * @return the quotient of this Radical and other
     */
    public Radical divideBy(ScalarWrapper other) {
        ScalarWrapper wrapper = this.innerValue.divideBy(other);
        return new Radical(wrapper);
    }

    /**
     * Divides this Radical by an int
     * @param other the int to divide by
     * @return the quotient of this Radical and other
     */
    public Radical divideBy(int other) {
        ScalarWrapper wrapper = this.innerValue.divideBy(other);
        return new Radical(wrapper);
    }

    /**
     * Divides this Radical by an Integer
     * @param other the Integer to divide by
     * @return the quotient of this Radical and other
     */
    public Radical divideBy(Integer other) {
        ScalarWrapper wrapper = this.innerValue.divideBy(other);
        return new Radical(wrapper);
    }

    /**
     * Divides this Radical by a double
     * @param other the double to divide by
     * @return the quotient of this Radical and other
     */
    public Radical divideBy(double other) {
        ScalarWrapper wrapper = this.innerValue.divideBy(other);
        return new Radical(wrapper);
    }

    /**
     * Divides this Radical by a Double
     * @param other the Double to divide by
     * @return the quotient of this Radical and other
     */
    public Radical divideBy(Double other) {
        ScalarWrapper wrapper = this.innerValue.divideBy(other);
        return new Radical(wrapper);
    }

    /**
     * Divides this Radical by a Rational
     * @param other the Rational to divide by
     * @return the quotient of this Radical and other
     */
    public Radical divideBy(Rational other) {
        ScalarWrapper wrapper = this.innerValue.divideBy(other);
        return new Radical(wrapper);
    }

    /**
     * Divides this Radical by a ScalarWrapper
     * @param other the ScalarWrapper to divide by
     * @return the true value of the quotient of this Radical and other
     */
    public ScalarWrapper trueDivideBy(ScalarWrapper other) {
        Radical radical = this.multiply(other);
        return radical.value();
    }

    /**
     * Divides this Radical by an int
     * @param other the int to divide by
     * @return the true value of the quotient of this Radical and other
     */
    public ScalarWrapper trueDivideBy(int other) {
        Radical radical = this.multiply(other);
        return radical.value();
    }

    /**
     * Divides this Radical by an Integer
     * @param other the Integer to divide by
     * @return the true value of the quotient of this Radical and other
     */
    public ScalarWrapper trueDivideBy(Integer other) {
        Radical radical = this.multiply(other);
        return radical.value();
    }

    /**
     * Divides this Radical by a double
     * @param other the double to divide by
     * @return the true value of the quotient of this Radical and other
     */
    public ScalarWrapper trueDivideBy(double other) {
        Radical radical = this.multiply(other);
        return radical.value();
    }

    /**
     * Divides this Radical by a Double
     * @param other the Double to divide by
     * @return the true value of the quotient of this Radical and other
     */
    public ScalarWrapper trueDivideBy(Double other) {
        Radical radical = this.multiply(other);
        return radical.value();
    }

    /**
     * Divides this Radical by a Rational
     * @param other the Rational to divide by
     * @return the true value of the quotient of this Radical and other
     */
    public ScalarWrapper trueDivideBy(Rational other) {
        Radical radical = this.multiply(other);
        return radical.value();
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
