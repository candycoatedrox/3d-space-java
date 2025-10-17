public class Rational {
    
    private int numerator;
    private int denominator;

    /**
     * Constructor
     * @param numerator the numerator of the rational number
     * @param denominator the denominator of the rational number
     */
    public Rational(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
        this.reduce();
    }

    /**
     * Constructor
     * @param numerator the numerator of the rational number (in Rational form)
     * @param denominator the denominator of the rational number
     */
    public Rational(Rational numerator, int denominator) {
        this.numerator = numerator.numerator;
        this.denominator = numerator.denominator * denominator;
        this.reduce();
    }

    /**
     * Constructor
     * @param numerator the numerator of the rational number
     * @param denominator the denominator of the rational number (in Rational form)
     */
    public Rational(int numerator, Rational denominator) {
        this.numerator = numerator * denominator.denominator;
        this.denominator = denominator.numerator;
        this.reduce();
    }

    /**
     * Constructor
     * @param numerator the numerator of the rational number (in Rational form)
     * @param denominator the denominator of the rational number (in Rational form)
     */
    public Rational(Rational numerator, Rational denominator) {
        this.numerator = numerator.numerator * denominator.denominator;
        this.denominator = numerator.denominator * denominator.numerator;
        this.reduce();
    }

    /**
     * Constructor
     * @param value the integer value of the rational number
     */
    public Rational(int value) {
        this.numerator = value;
        this.denominator = 1;
    }

    /**
     * Reduces a rational number to lowest terms
     */
    public void reduce() {
        if (this.numerator == this.denominator) {
            this.numerator = 1;
            this.denominator = 1;
        }

        else {
            int gcd = gcd(this.numerator, this.denominator);
            this.numerator /= gcd;
            this.denominator /= gcd;

            if (this.denominator < 0) {
                this.numerator *= -1;
                this.denominator *= -1;
            }
        }
    }

    /**
     * Accessor for numerator
     * @return the numerator of the rational number
     */
    public int getNumerator() {
        return this.numerator;
    }

    /**
     * Accessor for denominator
     * @return the numerator of the rational number
     */
    public int getDenominator() {
        return this.denominator;
    }

    /**
     * Returns an inverted version of a rational number
     * @return the inverted version of the rational number
     */
    public Rational invert() {
        return new Rational(this.denominator, this.numerator);
    }

    /**
     * Returns a rational number with its sign flipped
     * @return the negative version of the rational number
     */
    public Rational negative() {
        return new Rational(this.denominator * -1, this.numerator);
    }

    /**
     * Returns the absolute value of a rational number
     * @return the absolute value of the rational number
     */
    public Rational absolute() {
        if (this.numerator < 0) {
            return this.negative();
        }
        return this;
    }

    /**
     * Returns a boolean depending on whether the rational number is a whole number
     * @return true if the rational number is whole; false otherwise
     */
    public boolean isWhole() {
        Rational thisReduced = this;
        thisReduced.reduce();
        return thisReduced.denominator == 1;
    }

    /**
     * Returns the double value of this rational number
     * @return the double value of this rational number
     */
    public double value() {
        double numerDouble = this.numerator;
        return numerDouble / this.denominator;
    }

    /**
     * Returns the rounded integer value of this rational number
     * @return the rounded integer value of this rational number
     */
    public int intValue() {
        return this.numerator / this.denominator;
    }

    /**
     * Compares this Rational against another Rational
     * @param other the Rational to compare with
     * @return true if the two Rationals' values are equal to the same double; false otherwise
     */
    public boolean equals(Rational other) {
        return this.value() == other.value();
    }

    /**
     * Compares this Rational against an int
     * @param other the int to compare with
     * @return true if the Rational and int are equal to the same double; false otherwise
     */
    public boolean equals(int other) {
        double doubleOther = other;
        return this.value() == doubleOther;
    }

    /**
     * Compares this Rational against a double
     * @param other the double to compare with
     * @return true if the Rational's value equals the double; false otherwise
     */
    public boolean equals(double other) {
        return this.value() == other;
    }

    /**
     * Compares two Rationals' values and returns whether the first is less than the second
     * @param other the Rational to compare with
     * @return true if this Rational's value is less than other's value
     */
    public boolean lessThan(Rational other) {
        return this.value() < other.value();
    }

    /**
     * Compares a Rational to an int and returns whether the Rational's value is less than the int
     * @param other the int to compare with
     * @return true if this Rational's value is less than other
     */
    public boolean lessThan(int other) {
        double doubleOther = other;
        return this.value() < doubleOther;
    }

    /**
     * Compares a Rational to a double and returns whether the Rational's value is less than the double
     * @param other the double to compare with
     * @return true if this Rational's value is less than other
     */
    public boolean lessThan(double other) {
        return this.value() < other;
    }

    /**
     * Compares two Rationals' values and returns whether the first is less than or equal to the second
     * @param other the Rational to compare with
     * @return true if this Rational's value is less than or equal to other's value
     */
    public boolean lessThanOrEquals(Rational other) {
        return this.value() <= other.value();
    }

    /**
     * Compares a Rational to an int and returns whether the Rational's value is less than or equal to the int
     * @param other the int to compare with
     * @return true if this Rational's value is less than or equal to other
     */
    public boolean lessThanOrEquals(int other) {
        double doubleOther = other;
        return this.value() <= doubleOther;
    }

    /**
     * Compares a Rational to a double and returns whether the Rational's value is less than or equal to the double
     * @param other the double to compare with
     * @return true if this Rational's value is less than or equal to other
     */
    public boolean lessThanOrEquals(double other) {
        return this.value() <= other;
    }

    /**
     * Compares two Rationals' values and returns whether the first is greater than the second
     * @param other the Rational to compare with
     * @return true if this Rational's value is greater than other's value
     */
    public boolean greaterThan(Rational other) {
        return this.value() > other.value();
    }

    /**
     * Compares a Rational to an int and returns whether the Rational's value is less than the int
     * @param other the int to compare with
     * @return true if this Rational's value is less than other
     */
    public boolean greaterThan(int other) {
        double doubleOther = other;
        return this.value() > doubleOther;
    }

    /**
     * Compares a Rational to a double and returns whether the Rational's value is less than the double
     * @param other the double to compare with
     * @return true if this Rational's value is less than other
     */
    public boolean greaterThan(double other) {
        return this.value() > other;
    }

    /**
     * Compares two Rationals' values and returns whether the first is less than or equal to the second
     * @param other the Rational to compare with
     * @return true if this Rational's value is less than or equal to other's value
     */
    public boolean greaterThanOrEquals(Rational other) {
        return this.value() >= other.value();
    }

    /**
     * Compares a Rational to an int and returns whether the Rational's value is less than or equal to the int
     * @param other the int to compare with
     * @return true if this Rational's value is less than or equal to other
     */
    public boolean greaterThanOrEquals(int other) {
        double doubleOther = other;
        return this.value() >= doubleOther;
    }

    /**
     * Compares a Rational to a double and returns whether the Rational's value is less than or equal to the double
     * @param other the double to compare with
     * @return true if this Rational's value is less than or equal to other
     */
    public boolean greaterThanOrEquals(double other) {
        return this.value() >= other;
    }

    /**
     * Adds two Rationals together
     * @param other the Rational to add to this Rational
     * @return the sum of the two Rationals
     */
    public Rational add(Rational other) {
        if (this.denominator == other.denominator) {
            return new Rational(this.numerator + other.numerator, this.denominator);
        }

        int numer1 = this.numerator * other.denominator;
        int numer2 = other.numerator * this.denominator;
        int denom = this.denominator * other.denominator;
        return new Rational(numer1 + numer2, denom);
    }

    /**
     * Adds a Rational and an int
     * @param other the int to add to this Rational
     * @return the sum of the Rational and the int
     */
    public Rational add(int other) {
        int otherNumer = other * this.denominator;
        return new Rational(this.numerator + otherNumer, this.denominator);
    }

    /**
     * Subtracts a Rational from this Rational
     * @param other the Rational to subtract from this Rational
     * @return the difference of the two Rationals
     */
    public Rational subtract(Rational other) {
        return this.add(other.negative());
    }

    /**
     * Subtracts an int from a Rational
     * @param other the int to subtract from this Rational
     * @return the difference of the Rational and the int
     */
    public Rational subtract(int other) {
        int otherNumer = other * this.denominator;
        return new Rational(this.numerator - otherNumer, this.denominator);
    }

    /**
     * Subtracts a Rational from an int
     * @param other the int to subtract this Rational from
     * @return the difference of the int and the Rational
     */
    public Rational subtractFrom(int other) {
        return this.negative().add(other);
    }

    /**
     * Multiplies two Rationals together
     * @param other the Rational to multiply by this Rational
     * @return the product of the two Rationals
     */
    public Rational multiply(Rational other) {
        Rational product = new Rational(this.numerator * other.numerator, this.denominator * other.denominator);
        return product;
    }

    /**
     * Multiplies a Rational and an int together
     * @param other the int to multiply by this Rational
     * @return the product of the Rational and the int
     */
    public Rational multiply(int other) {
        return new Rational(this.numerator * other, this.denominator);
    }

    /**
     * Divides this Rational by another Rational
     * @param other the Rational to divide this Rational by
     * @return the quotient of the two Rationals
     */
    public Rational divide(Rational other) {
        Rational quotient = this.multiply(other.invert());
        return quotient;
    }

    /**
     * Divides a Rational by an int
     * @param other the int to divide this Rational by
     * @return the quotient of the Rational and the int
     */
    public Rational divide(int other) {
        return new Rational(this.numerator, this.denominator * other);
    }

    /**
     * Divides an int by a Rational
     * @param other the int to divide by this Rational
     * @return the quotient of the int and the Rational
     */
    public Rational divideBy(int other) {
        return this.invert().multiply(other);
    }

    /**
     * Returns a string representation of a Rational
     */
    public String toString() {
        return this.numerator + "/" + this.denominator;
    }

    /**
     * Returns the greatest common denominator of two integers
     * @param a an integer
     * @param b an integer
     * @return the greatest common denominator of the two integers
     */
    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
