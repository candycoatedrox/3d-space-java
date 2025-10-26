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
        } else if (dec == null && rat == null) {
            this.Int = Int;
        } else if (Int == null && rat == null) {
            this.dec = dec;
        } else if (Int == null && dec == null) {
            if (rat.isWhole()) {
                this.Int = rat.intValue();
            } else {
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
        } else if (dec == null) {
            this.Int = Int;
        } else if (Int == null) {
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
        } else if (rat == null) {
            this.Int = Int;
        } else if (Int == null) {
            if (rat.isWhole()) {
                this.Int = rat.intValue();
            } else {
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
        } else if (rat == null) {
            this.dec = dec;
        } else if (dec == null) {
            if (rat.isWhole()) {
                this.Int = rat.intValue();
            } else {
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
        } else {
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
     * Sets the value of this ScalarWrapper to the value of the specified ScalarWrapper and removes any other type value
     * @param newValue the new value of the wrapper
     */
    public void set(ScalarWrapper newValue) {
        if (newValue.isInt()) {
            this.set(newValue.getInt());
        } else if (newValue.isDouble()) {
            this.set(newValue.getDouble());
        } else {
            this.set(newValue.getRat());
        }
    }

    /**
     * Sets the value of this ScalarWrapper to the specified int and removes any double or rational value
     * @param newInt the new integer value of the wrapper
     */
    public void set(int newInt) {
        this.Int = newInt;
        this.dec = null;
        this.rat = null;
    }

    /**
     * Sets the value of this ScalarWrapper to the specified Integer and removes any double or rational value
     * @param newInt the new integer value of the wrapper
     */
    public void set(Integer newInt) {
        this.Int = newInt;
        this.dec = null;
        this.rat = null;
    }

    /**
     * Sets the value of this ScalarWrapper to the specified double and removes any integer or rational value
     * @param newDec the new double value of the wrapper
     */
    public void set(double newDec) {
        this.Int = null;
        this.dec = newDec;
        this.rat = null;
    }

    /**
     * Sets the value of this ScalarWrapper to the specified Double and removes any integer or rational value
     * @param newDec the new double value of the wrapper
     */
    public void set(Double newDec) {
        this.Int = null;
        this.dec = newDec;
        this.rat = null;
    }

    /**
     * Sets the value of this ScalarWrapper to the specified Rational and removes any integer or double value
     * @param newRat the new Rational value of the wrapper
     */
    public void set(Rational newRat) {
        this.Int = null;
        this.dec = null;
        this.rat = newRat;
    }

    /**
     * Checks if this ScalarWrapper is valud (has only one type value set)
     * @return true if exactly one of this ScalarWrapper's values is not null; false otherwise
     */
    public boolean isValid() {
        boolean i = this.isInt();
        boolean d = this.isDouble();
        boolean r = this.isRat();
        
        if (i && !d && !r) {
            return true;
        } else if (!i && d && !r) {
            return true;
        } else if (!i && !d && r) {
            return true;
        }
        
        return false;
    }

    /**
     * Checks if this ScalarWrapper has a non-null integer value
     * @return true if this ScalarWrapper's integer value is not null; false otherwise
     */
    public boolean isInt() {
        if (this.Int == null) {
            return false;
        }
        return true;
    }
    
    /**
     * Checks if this ScalarWrapper has a non-null double value
     * @return true if this ScalarWrapper's double value is not null; false otherwise
     */
    public boolean isDouble() {
        if (this.dec == null) {
            return false;
        }
        return true;
    }
    
    /**
     * Checks if this ScalarWrapper has a non-null Rational value
     * @return true if this ScalarWrapper's Rational value is not null; false otherwise
     */
    public boolean isRat() {
        if (this.rat == null) {
            return false;
        }
        return true;
    }

    /**
     * Checks if this ScalarWrapper's value is equivalent to an integer
     * @return true if this ScalarWrapper's value is equivalent to an integer; false otherwise
     */
    public boolean isWhole() {
        if (this.isInt()) {
            return true;
        } else if (this.isDouble()) {
            return this.dec % 1 == 0;
        } else {
            return this.rat.isWhole();
        }
    }

    /**
     * Calculates the reduced and simplified form of this ScalarWrapper
     * @return the reduced and simplified form of this ScalarWrapper
     */
    public ScalarWrapper reduced() {
        if (!this.isRat()) {
            return this;
        }

        ScalarWrapper wrapper;
        if (this.isRat()) {
            wrapper = new ScalarWrapper(this.rat.reduced());
        } else {
            wrapper = new ScalarWrapper(this.dec);
        }

        if (wrapper.isWhole()) {
            wrapper.convertToInt();
        }
        return wrapper;
    }

    /**
     * Reduces and simplifies this ScalarWrapper
     */
    public void reduce() {
        if (this.isRat()) {
            this.set(this.rat.reduced());
        }

        if (this.isWhole()) {
            this.convertToInt();
        }
    }

    /**
     * Calculates the reduced form of this ScalarWrapper
     * @return the reduced form of this ScalarWrapper
     */
    public ScalarWrapper reducedPreserveType() {
        if (!this.isRat()) {
            return this;
        }

        return new ScalarWrapper(this.rat.reduced());
    }

    /**
     * Reduces this ScalarWrapper, if it is a Rational
     */
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
        } else if (this.isDouble()) {
            return 1;
        } else {
            return 2;
        }
    }

    /**
     * Converts the double or Rational value of this ScalarWrapper to an integer
     */
    public void convertToInt() {
        if (this.isDouble()) {
            this.set(this.dec.intValue());
        } else if (this.isRat()) {
            this.set(this.rat.intValue());
        }
    }

    /**
     * Converts the integer or Rational value of this ScalarWrapper to a double
     */
    public void convertToDouble() {
        if (this.isInt()) {
            double d = this.Int;
            this.set(d);
        } else if (this.isRat()) {
            this.set(this.rat.value());
        }
    }

    /**
     * Converts the integer or double value of this ScalarWrapper to a Rational
     */
    public void convertToRat() {
        if (this.isInt()) {
            this.set(new Rational(this.Int));
        } else if (this.isDouble()) {
            this.set(new Rational(this.dec));
        }
    }

    /**
     * Converts the double or Rational value of this ScalarWrapper to an integer if it is whole, or to a Rational otherwise
     */
    public void convertToIntOrRat() {
        if (this.isWhole()) {
            this.convertToInt();
        } else {
            this.convertToRat();
        }
    }

    /**
     * Returns the negative version of this ScalarWrapper
     * @return the negative version of this ScalarWrapper
     */
    public ScalarWrapper negative() {
        if (this.isInt()) {
            return new ScalarWrapper(this.Int * -1);
        } else if (this.isDouble()) {
            return new ScalarWrapper(this.dec * -1);
        } else {
            return new ScalarWrapper(this.rat.negative());
        }
    }

    /**
     * Returns the absolute value of this ScalarWrapper
     * @return the absolute value of this ScalarWrapper
     */
    public ScalarWrapper absolute() {
        if (this.isInt()) {
            return new ScalarWrapper(Math.abs(this.Int));
        } else if (this.isDouble()) {
            return new ScalarWrapper(Math.abs(this.dec));
        } else {
            return new ScalarWrapper(this.rat.negative());
        }
    }

    /**
     * Compares this ScalarWrapper to another ScalarWrapper
     * @param other the ScalarWrapper to compare to
     * @return true if the values of this ScalarWrapper and other are equal; false otherwise
     */
    public boolean equals(ScalarWrapper other) {
        if (other.isInt()) {
            return other.equals(this.Int);
        } else if (other.isDouble()) {
            return other.equals(this.dec);
        }
        return other.equals(this.rat);
    }

    /**
     * Compares this ScalarWrapper to an int
     * @param other the int to compare to
     * @return true if the value of this ScalarWrapper is equal to other; false otherwise
     */
    public boolean equals(int other) {
        if (this.isInt()) {
            return this.Int.equals(other);
        } else if (this.isDouble()) {
            return this.dec == other;
        }
        return this.rat.equals(other);
    }

    /**
     * Compares this ScalarWrapper to an Integer
     * @param other the Integer to compare to
     * @return true if the value of this ScalarWrapper is equal to other; false otherwise
     */
    public boolean equals(Integer other) {
        return this.equals(other.intValue());
    }

    /**
     * Compares this ScalarWrapper to a double
     * @param other the double to compare to
     * @return true if the value of this ScalarWrapper is equal to other; false otherwise
     */
    public boolean equals(double other) {
        if (this.isInt()) {
            return this.Int == other;
        } else if (this.isDouble()) {
            return this.dec.equals(other);
        }
        return this.rat.equals(other);
    }

    /**
     * Compares this ScalarWrapper to a Double
     * @param other the Double to compare to
     * @return true if the value of this ScalarWrapper is equal to other; false otherwise
     */
    public boolean equals(Double other) {
        return this.equals(other.doubleValue());
    }

    /**
     * Compares this ScalarWrapper to a Rational
     * @param other the Rational to compare to
     * @return true if the value of this ScalarWrapper is equal to other; false otherwise
     */
    public boolean equals(Rational other) {
        if (this.isInt()) {
            return other.equals(this.Int);
        } else if (this.isDouble()) {
            return other.equals(this.dec);
        }
        return this.rat.equals(other);
    }

    // Add less than, less than or equal to, greater than, greater than or equal to here

    /**
     * Adds this ScalarWrapper and another ScalarWrapper
     * @param other the ScalarWrapper to add to this ScalarWrapper
     * @return the sum of this ScalarWrapper and other
     */
    public ScalarWrapper add(ScalarWrapper other) {
        if (other.isInt()) {
            return other.add(this.Int);
        } else if (other.isDouble()) {
            return other.add(this.dec);
        }
        return other.add(this.rat);
    }

    /**
     * Adds this ScalarWrapper and an int
     * @param other the int to add to this ScalarWrapper
     * @return the sum of this ScalarWrapper and other
     */
    public ScalarWrapper add(int other) {
        if (this.isInt()) {
            return new ScalarWrapper(this.Int + other);
        } else if (this.isDouble()) {
            return new ScalarWrapper(this.dec + other);
        }
        Rational sum = this.rat.add(other);
        return new ScalarWrapper(sum);
    }

    /**
     * Adds this ScalarWrapper and an Integer
     * @param other the Integer to add to this ScalarWrapper
     * @return the sum of this ScalarWrapper and other
     */
    public ScalarWrapper add(Integer other) {
        return this.add(other.intValue());
    }

    /**
     * Adds this ScalarWrapper and a double
     * @param other the double to add to this ScalarWrapper
     * @return the sum of this ScalarWrapper and other
     */
    public ScalarWrapper add(double other) {
        if (this.isInt()) {
            return new ScalarWrapper(this.Int + other);
        } else if (this.isDouble()) {
            return new ScalarWrapper(this.dec + other);
        } else {
            return new ScalarWrapper(this.rat.add(other));
        }
    }

    /**
     * Adds this ScalarWrapper and a Double
     * @param other the Double to add to this ScalarWrapper
     * @return the sum of this ScalarWrapper and other
     */
    public ScalarWrapper add(Double other) {
        return this.add(other.doubleValue());
    }

    /**
     * Adds this ScalarWrapper and a Rational
     * @param other the Rational to add to this ScalarWrapper
     * @return the sum of this ScalarWrapper and other
     */
    public ScalarWrapper add(Rational other) {
        if (this.isInt()) {
            Rational sum = other.add(this.Int);
            return new ScalarWrapper(sum);
        } else if (this.isDouble()) {
            double sum = other.add(this.dec);
            return new ScalarWrapper(sum);
        } else
        {
            Rational sum = other.add(this.rat);
            return new ScalarWrapper(sum);
        }
    }

    /**
     * Subtracts a ScalarWrapper from this ScalarWrapper
     * @param other the ScalarWrapper to subtract from this ScalarWrapper
     * @return the difference between this ScalarWrapper and other
     */
    public ScalarWrapper subtract(ScalarWrapper other) {
        return this.add(other.negative());
    }

    /**
     * Subtracts an int from this ScalarWrapper
     * @param other the int to subtract from this ScalarWrapper
     * @return the difference between this ScalarWrapper and other
     */
    public ScalarWrapper subtract(int other) {
        return this.add(other * -1);
    }

    /**
     * Subtracts an Integer from this ScalarWrapper
     * @param other the Integer to subtract from this ScalarWrapper
     * @return the difference between this ScalarWrapper and other
     */
    public ScalarWrapper subtract(Integer other) {
        return this.add(other * -1);
    }

    /**
     * Subtracts a double from this ScalarWrapper
     * @param other the double to subtract from this ScalarWrapper
     * @return the difference between this ScalarWrapper and other
     */
    public ScalarWrapper subtract(double other) {
        return this.add(other * -1);
    }

    /**
     * Subtracts a Double from this ScalarWrapper
     * @param other the Double to subtract from this ScalarWrapper
     * @return the difference between this ScalarWrapper and other
     */
    public ScalarWrapper subtract(Double other) {
        return this.add(other * -1);
    }

    /**
     * Subtracts a Rational from this ScalarWrapper
     * @param other the Rational to subtract from this ScalarWrapper
     * @return the difference between this ScalarWrapper and other
     */
    public ScalarWrapper subtract(Rational other) {
        return this.add(other.negative());
    }

    /**
     * Subtracts this ScalarWrapper from another ScalarWrapper
     * @param other the ScalarWrapper to subtract this ScalarWrapper from
     * @return the difference between other and this ScalarWrapper
     */
    public ScalarWrapper subtractFrom(ScalarWrapper other) {
        return other.add(this.negative());
    }

    /**
     * Subtracts this ScalarWrapper from an int
     * @param other the int to subtract this ScalarWrapper from
     * @return the difference between other and this ScalarWrapper
     */
    public ScalarWrapper subtractFrom(int other) {
        return this.negative().add(other);
    }

    /**
     * Subtracts this ScalarWrapper from an Integer
     * @param other the Integer to subtract this ScalarWrapper from
     * @return the difference between other and this ScalarWrapper
     */
    public ScalarWrapper subtractFrom(Integer other) {
        return this.negative().add(other);
    }

    /**
     * Subtracts this ScalarWrapper from a double
     * @param other the double to subtract this ScalarWrapper from
     * @return the difference between other and this ScalarWrapper
     */
    public ScalarWrapper subtractFrom(double other) {
        return this.negative().add(other);
    }

    /**
     * Subtracts this ScalarWrapper from a Double
     * @param other the Double to subtract this ScalarWrapper from
     * @return the difference between other and this ScalarWrapper
     */
    public ScalarWrapper subtractFromDouble(Double other) {
        return this.negative().add(other);
    }

    /**
     * Subtracts this ScalarWrapper from a Rational
     * @param other the Rational to subtract this ScalarWrapper from
     * @return the difference between other and this ScalarWrapper
     */
    public ScalarWrapper subtractFrom(Rational other) {
        return this.negative().add(other);
    }

    /**
     * Multiplies this ScalarWrapper with another ScalarWrapper
     * @param other the ScalarWrapper to multiply by this ScalarWrapper
     * @return the product of this ScalarWrapper and other
     */
    public ScalarWrapper multiply(ScalarWrapper other) {
        if (other.isInt()) {
            return other.multiply(this.Int);
        } else if (other.isDouble()) {
            return other.multiply(this.dec);
        }
        return other.multiply(this.rat);
    }

    /**
     * Multiplies this ScalarWrapper with an int
     * @param other the int to multiply by this ScalarWrapper
     * @return the product of this ScalarWrapper and other
     */
    public ScalarWrapper multiply(int other) {
        if (this.isInt()) {
            return new ScalarWrapper(this.Int * other);
        } else if (this.isDouble()) {
            return new ScalarWrapper(this.dec * other);
        }
        return new ScalarWrapper(this.rat.multiply(other));
    }

    /**
     * Multiplies this ScalarWrapper with an Integer
     * @param other the Integer to multiply by this ScalarWrapper
     * @return the product of this ScalarWrapper and other
     */
    public ScalarWrapper multiply(Integer other) {
        return this.multiply(other.intValue());
    }
    
    /**
     * Multiplies this ScalarWrapper with a double
     * @param other the double to multiply by this ScalarWrapper
     * @return the product of this ScalarWrapper and other
     */
    public ScalarWrapper multiply(double other) {
        if (this.isInt()) {
            return new ScalarWrapper(this.Int * other);
        } else if (this.isDouble()) {
            return new ScalarWrapper(this.dec * other);
        }
        return new ScalarWrapper(this.rat.multiply(other));
    }

    /**
     * Multiplies this ScalarWrapper with a Double
     * @param other the Double to multiply by this ScalarWrapper
     * @return the product of this ScalarWrapper and other
     */
    public ScalarWrapper multiply(Double other) {
        return this.multiply(other.doubleValue());
    }

    /**
     * Multiplies this ScalarWrapper with a Rational
     * @param other the Rational to multiply by this ScalarWrapper
     * @return the product of this ScalarWrapper and other
     */
    public ScalarWrapper multiply(Rational other) {
        if (this.isInt()) {
            Rational product = other.multiply(this.Int);
            return new ScalarWrapper(product);
        } else if (this.isDouble()) {
            return new ScalarWrapper(other.multiply(this.dec));
        } else {
            Rational product = other.multiply(this.rat);
            return new ScalarWrapper(product);
        }
    }

    /**
     * Divides this ScalarWrapper by another ScalarWrapper
     * @param other the ScalarWrapper to divide this ScalarWrapper by
     * @return the quotient of this ScalarWrapper and other
     */
    public ScalarWrapper divideBy(ScalarWrapper other) {
        if (other.isInt()) {
            return this.divideBy(other.Int);
        } else if (other.isDouble()) {
            return this.divideBy(other.dec);
        } else {
            return this.divideBy(other.rat);
        }
    }

    /**
     * Divides this ScalarWrapper by an int
     * @param other the int to divide this ScalarWrapper by
     * @return the quotient of this ScalarWrapper and other
     */
    public ScalarWrapper divideBy(int other) {
        if (this.isInt()) {
            return new ScalarWrapper(this.Int / other);
        } else if (this.isDouble()) {
            return new ScalarWrapper(this.dec / other);
        }
        Rational quotient = this.rat.divideBy(other);
        return new ScalarWrapper(quotient);
    }

    /**
     * Divides this ScalarWrapper by an Integer
     * @param other the Integer to divide this ScalarWrapper by
     * @return the quotient of this ScalarWrapper and other
     */
    public ScalarWrapper divideBy(Integer other) {
        return this.divideBy(other.intValue());
    }

    /**
     * Divides this ScalarWrapper by a double
     * @param other the double to divide this ScalarWrapper by
     * @return the quotient of this ScalarWrapper and other
     */
    public ScalarWrapper divideBy(double other) {
        if (this.isInt()) {
            return new ScalarWrapper(this.Int / other);
        } else if (this.isDouble()) {
            return new ScalarWrapper(this.dec / other);
        }
        double quotient = this.rat.divideBy(other);
        return new ScalarWrapper(quotient);
    }

    /**
     * Divides this ScalarWrapper by a Double
     * @param other the Double to divide this ScalarWrapper by
     * @return the quotient of this ScalarWrapper and other
     */
    public ScalarWrapper divideBy(Double other) {
        return this.divideBy(other.doubleValue());
    }

    /**
     * Divides this ScalarWrapper by a Rational
     * @param other the Rational to divide this ScalarWrapper by
     * @return the quotient of this ScalarWrapper and other
     */
    public ScalarWrapper divideBy(Rational other) {
        if (this.isInt()) {
            Rational quotient = other.divide(this.Int);
            return new ScalarWrapper(quotient);
        } else if (this.isDouble()) {
            return new ScalarWrapper(other.divide(this.dec));         
        } else {
            Rational quotient = this.rat.divideBy(other);
            return new ScalarWrapper(quotient);
        }
    }

    /**
     * Divides another ScalarWrapper by this ScalarWrapper
     * @param other the ScalarWrapper to divide by this ScalarWrapper
     * @return the quotient of other and this ScalarWrapper
     */
    public ScalarWrapper divide(ScalarWrapper other) {
        return other.divideBy(this);
    }

    /**
     * Divides an int by this ScalarWrapper
     * @param other the int to divide by this ScalarWrapper
     * @return the quotient of other and this ScalarWrapper
     */
    public ScalarWrapper divide(int other) {
        if (this.isInt()) {
            return new ScalarWrapper(other / this.Int);
        } else if (this.isDouble()) {
            return new ScalarWrapper(other / this.dec);
        }
        Rational quotient = this.rat.divide(other);
        return new ScalarWrapper(quotient);
    }

    /**
     * Divides an Integer by this ScalarWrapper
     * @param other the Integer to divide by this ScalarWrapper
     * @return the quotient of other and this ScalarWrapper
     */
    public ScalarWrapper divide(Integer other) {
        return this.divide(other.intValue());
    }

    /**
     * Divides a double by this ScalarWrapper
     * @param other the double to divide by this ScalarWrapper
     * @return the quotient of other and this ScalarWrapper
     */
    public ScalarWrapper divide(double other) {
        if (this.isInt()) {
            return new ScalarWrapper(other / this.Int);
        } else if (this.isDouble()) {
            return new ScalarWrapper(other / this.dec);
        }
        double quotient = this.rat.divide(other);
        return new ScalarWrapper(quotient);
    }

    /**
     * Divides a Double by this ScalarWrapper
     * @param other the Double to divide by this ScalarWrapper
     * @return the quotient of other and this ScalarWrapper
     */
    public ScalarWrapper divide(Double other) {
        return this.divide(other.doubleValue());
    }

    /**
     * Divides a Rational by this ScalarWrapper
     * @param other the Rational to divide by this ScalarWrapper
     * @return the quotient of other and this ScalarWrapper
     */
    public ScalarWrapper divide(Rational other) {
        Rational quotient;
        if (this.isInt()) {
            quotient = other.divideBy(this.Int);
            return new ScalarWrapper(quotient);
        } else if (this.isDouble()) {
            return new ScalarWrapper(other.divideBy(this.dec));
        } else {
            quotient = this.rat.divide(other);
            return new ScalarWrapper(quotient);
        }
    }

    /**
     * Creates and returns a deep copy of this ScalarWrapper
     * @return a deep copy of this ScalarWrapper
     */
    @Override
    public ScalarWrapper clone() {
        if (this.isInt()) {
            return new ScalarWrapper(this.Int.intValue());
        } else if (this.isDouble()) {
            return new ScalarWrapper(this.dec.doubleValue());
        } else {
            return new ScalarWrapper(this.rat.clone());
        }
    }

    /**
     * Returns a String representation of this ScalarWrapper
     * @return a String representation of this ScalarWrapper
     */
    @Override
    public String toString() {
        if (this.isInt()) {
            return this.Int.toString();
        } else if (this.isDouble()) {
            return this.dec.toString();
        } else {
            return this.rat.toString();
        }
    }

    /**
     * Wraps each member of a list of Integers
     * @param values a list of Integers to wrap
     * @return a list of wrapped Integers
     */
    public static ScalarWrapper[] wrapArray(Integer[] values) {
        ScalarWrapper[] wrappedArray = new ScalarWrapper[values.length];
        for (int i = 0; i < values.length; i++) {
            wrappedArray[i] = new ScalarWrapper(values[i]);
        }

        return wrappedArray;
    }

    /**
     * Wraps each member of a list of ints
     * @param values a list of ints to wrap
     * @return a list of wrapped ints
     */
    public static ScalarWrapper[] wrapArray(int[] values) {
        ScalarWrapper[] wrappedArray = new ScalarWrapper[values.length];
        for (int i = 0; i < values.length; i++) {
            wrappedArray[i] = new ScalarWrapper(values[i]);
        }

        return wrappedArray;
    }

    /**
     * Wraps each member of a list of Doubles
     * @param values a list of Doubles to wrap
     * @return a list of wrapped Doubles
     */
    public static ScalarWrapper[] wrapArray(Double[] values) {
        ScalarWrapper[] wrappedArray = new ScalarWrapper[values.length];
        for (int i = 0; i < values.length; i++) {
            wrappedArray[i] = new ScalarWrapper(values[i]);
        }

        return wrappedArray;
    }

    /**
     * Wraps each member of a list of doubles
     * @param values a list of doubles to wrap
     * @return a list of wrapped doubles
     */
    public static ScalarWrapper[] wrapArray(double[] values) {
        ScalarWrapper[] wrappedArray = new ScalarWrapper[values.length];
        for (int i = 0; i < values.length; i++) {
            wrappedArray[i] = new ScalarWrapper(values[i]);
        }

        return wrappedArray;
    }

    /**
     * Wraps each member of a list of Rationals
     * @param values a list of Rationals to wrap
     * @return a list of wrapped Rationals
     */
    public static ScalarWrapper[] wrapArray(Rational[] values) {
        ScalarWrapper[] wrappedArray = new ScalarWrapper[values.length];
        for (int i = 0; i < values.length; i++) {
            wrappedArray[i] = new ScalarWrapper(values[i]);
        }

        return wrappedArray;
    }

}
