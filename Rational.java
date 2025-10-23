
public class Rational implements Cloneable {

    // add constructors using Integer, double, Double, ScalarWrapper
    // add iadd, isub, imul, idiv equivalents
    
    private int numerator;
    private int denominator;
    private static final int contFractIterations = 7;

    /**
     * Constructs a Rational from two integers (ints)
     * @param numerator the numerator of the rational number
     * @param denominator the denominator of the rational number
     */
    public Rational(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
        this.reduce();
    }

    /**
     * Constructs a Rational from an integer (int) numerator and a Rational denominator
     * @param numerator the numerator of the rational number
     * @param denominator the denominator of the rational number (in Rational form)
     */
    public Rational(int numerator, Rational denominator) {
        this.numerator = numerator * denominator.denominator;
        this.denominator = denominator.numerator;
        this.reduce();
    }

    /**
     * Constructs a Rational from a Rational numerator and an integer (int) denominator
     * @param numerator the numerator of the rational number (in Rational form)
     * @param denominator the denominator of the rational number
     */
    public Rational(Rational numerator, int denominator) {
        this.numerator = numerator.numerator;
        this.denominator = numerator.denominator * denominator;
        this.reduce();
    }

    /**
     * Constructs a Rational from two other Rationals
     * @param numerator the numerator of the rational number (in Rational form)
     * @param denominator the denominator of the rational number (in Rational form)
     */
    public Rational(Rational numerator, Rational denominator) {
        this.numerator = numerator.numerator * denominator.denominator;
        this.denominator = numerator.denominator * denominator.numerator;
        this.reduce();
    }

    /**
     * Constructs a Rational from a ScalarWrapper
     * @param value the integer or rational value of the rational number
     */
    public Rational(ScalarWrapper value) {
        if (value.isInt()) {
            this.numerator = value.getInt();
            this.denominator = 1;
        }
        else if (value.isDouble()) {
            int[] contFract = continuedFraction(value.getDouble(), contFractIterations);
            this.numerator = contFract[0];
            this.denominator = contFract[1];
        }
        else {
            this.numerator = value.getRat().getNumerator();
            this.denominator = value.getRat().getDenominator();
        }

        this.reduce();
    }

    /**
     * Constructs a Rational from an integer (int)
     * @param value the integer value of the rational number
     */
    public Rational(int value) {
        this.numerator = value;
        this.denominator = 1;
    }
    
    public Rational(Integer value) {
        this.numerator = value;
        this.denominator = 1;
    }

    public Rational(double value) {
        int[] contFract = continuedFraction(value, contFractIterations);
        this.numerator = contFract[0];
        this.denominator = contFract[1];
        this.reduce();
    }

    public Rational(Double value) {
        int[] contFract = continuedFraction(value, contFractIterations);
        this.numerator = contFract[0];
        this.denominator = contFract[1];
        this.reduce();
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
     * Returns a rational number reduced to lowest terms
     * @return the reduced form of the Rational
     */
    public Rational reduced() {
        int numer = this.numerator;
        int denom = this.denominator;

        if (numer == denom) {
            numer = 1;
            denom = 1;
        }

        else {
            int gcd = gcd(numer, denom);
            numer /= gcd;
            denom /= gcd;

            if (denom < 0) {
                numer *= -1;
                denom *= -1;
            }
        }

        return new Rational(numer, denom);
    }

    /**
     * Returns true if this Rational is in its lowest terms
     * @return true if this Rational is reduced to lowest terms; false otherwise
     */
    public boolean isReduced() {
        return this == this.reduced();
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
        return new Rational(this.numerator * -1, this.denominator);
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
     * Compares this Rational against an Integer
     * @param other the Integer to compare with
     * @return true if the Rational and Integer are equal to the same double; false otherwise
     */
    public boolean equals(Integer other) {
        double doubleOther = other;
        return this.equals(doubleOther);
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
     * Compares this Rational against a Double
     * @param other the Double to compare with
     * @return true if the Rational's value equals the Double; false otherwise
     */
    public boolean equals(Double other) {
        return this.value() == other;
    }

    public boolean equals(ScalarWrapper other) {
        if (other.isInt()) {
            return this.equals(other.getInt());
        }
        else if (other.isDouble()) {
            return this.equals(other.getDouble());
        }
        return this.equals(other.getRat());
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

    public boolean lessThan(Integer other) {
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

    public boolean lessThan(Double other) {
        return this.value() < other;
    }

    public boolean lessThan(ScalarWrapper other) {
        if (other.isInt()) {
            return this.lessThan(other.getInt());
        }
        else if (other.isDouble()) {
            return this.lessThan(other.getDouble());
        }
        return this.lessThan(other.getRat());
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

    public boolean lessThanOrEquals(Integer other) {
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

    public boolean lessThanOrEquals(Double other) {
        return this.value() <= other;
    }

    public boolean lessThanOrEquals(ScalarWrapper other) {
        if (other.isInt()) {
            return this.lessThanOrEquals(other.getInt());
        }
        else if (other.isDouble()) {
            return this.lessThanOrEquals(other.getDouble());
        }
        return this.lessThanOrEquals(other.getRat());
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
    
    public boolean greaterThan(Integer other) {
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
    
    public boolean greaterThan(Double other) {
        return this.value() > other;
    }

    public boolean greaterThan(ScalarWrapper other) {
        if (other.isInt()) {
            return this.greaterThan(other.getInt());
        }
        else if (other.isDouble()) {
            return this.greaterThan(other.getDouble());
        }
        return this.greaterThan(other.getRat());
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
    
    public boolean greaterThanOrEquals(Integer other) {
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
    
    public boolean greaterThanOrEquals(Double other) {
        return this.value() >= other;
    }

    public boolean greaterThanOrEquals(ScalarWrapper other) {
        if (other.isInt()) {
            return this.greaterThanOrEquals(other.getInt());
        }
        else if (other.isDouble()) {
            return this.greaterThanOrEquals(other.getDouble());
        }
        return this.greaterThanOrEquals(other.getRat());
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

    public ScalarWrapper add(ScalarWrapper other) {
        if (other.isInt()) {
            Rational p = this.add(other.getInt());
            return new ScalarWrapper(p);
        }
        else if (other.isDouble()) {
            return new ScalarWrapper(this.add(other.getDouble()));
        }
        return new ScalarWrapper(this.add(other.getRat()));
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

    public Rational add(Integer other) {
        int intOther = other;
        return this.add(intOther);
    }

    public double add(double other) {
        return this.value() + other;
    }

    public double add(Double other) {
        return this.value() + other;
    }
    
    public Rational addRat(double other) {
        return new Rational(this.add(other));
    }
    
    public Rational addRat(Double other) {
        return new Rational(this.add(other));
    }

    /**
     * Subtracts a Rational from this Rational
     * @param other the Rational to subtract from this Rational
     * @return the difference of the two Rationals
     */
    public Rational subtract(Rational other) {
        return this.add(other.negative());
    }

    public ScalarWrapper subtract(ScalarWrapper other) {
        if (other.isInt()) {
            Rational p = this.subtract(other.getInt());
            return new ScalarWrapper(p);
        }
        else if (other.isDouble()) {
            return new ScalarWrapper(this.subtract(other.getDouble()));
        }
        return new ScalarWrapper(this.subtract(other.getRat()));
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

    public Rational subtract(Integer other) {
        int intOther = other;
        return this.subtract(intOther);
    }

    public double subtract(double other) {
        return this.value() - other;
    }

    public double subtract(Double other) {
        return this.value() - other;
    }
    
    public Rational subtractRat(double other) {
        return new Rational(this.subtract(other));
    }
    
    public Rational subtractRat(Double other) {
        return new Rational(this.subtract(other));
    }

    public Rational subtractFrom(Rational other) {
        return other.subtract(this);
    }

    public ScalarWrapper subtractFrom(ScalarWrapper other) {
        if (other.isInt()) {
            Rational p = this.subtractFrom(other.getInt());
            return new ScalarWrapper(p);
        }
        else if (other.isDouble()) {
            return new ScalarWrapper(this.subtractFrom(other.getDouble()));
        }
        return new ScalarWrapper(this.subtractFrom(other.getRat()));
    }

    /**
     * Subtracts a Rational from an int
     * @param other the int to subtract this Rational from
     * @return the difference of the int and the Rational
     */
    public Rational subtractFrom(int other) {
        return this.negative().add(other);
    }

    public Rational subtractFrom(Integer other) {
        int intOther = other;
        return this.subtractFrom(intOther);
    }

    public double subtractFrom(double other) {
        return other - this.value();
    }

    public double subtractFrom(Double other) {
        return other - this.value();
    }
    
    public Rational subtractFromRat(double other) {
        return new Rational(this.subtractFrom(other));
    }
    
    public Rational subtractFromRat(Double other) {
        return new Rational(this.subtractFrom(other));
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
     * Multiplies a Rational with a ScalarWrapper
     * @param other the ScalarWrapper to multiply by this Rational
     * @return the product of the Rational and the ScalarWrapper
     */
    public ScalarWrapper multiply(ScalarWrapper other) {
        if (other.isInt()) {
            Rational p = this.multiply(other.getInt());
            return new ScalarWrapper(p);
        }
        else if (other.isDouble()) {
            return new ScalarWrapper(this.multiply(other.getDouble()));
        }
        return new ScalarWrapper(this.multiply(other.getRat()));
    }

    /**
     * Multiplies a Rational with an int
     * @param other the int to multiply by this Rational
     * @return the product of the Rational and the int
     */
    public Rational multiply(int other) {
        return new Rational(this.numerator * other, this.denominator);
    }
    
    public Rational multiply(Integer other) {
        return new Rational(this.numerator * other, this.denominator);
    }

    public double multiply(double other) {
        return this.value() * other;
    }

    public double multiply(Double other) {
        return this.value() * other;
    }
    
    public Rational multiplyRat(double other) {
        return new Rational(this.multiply(other));
    }
    
    public Rational multiplyRat(Double other) {
        return new Rational(this.multiply(other));
    }

    /**
     * Divides this Rational by a ScalarWrapper
     * @param other the ScalarWrapper to divide this Rational by
     * @return the quotient of the Rational and the ScalarWrapper
     */
    public ScalarWrapper divideBy(ScalarWrapper other) {
        if (other.isInt()) {
            Rational p = this.divideBy(other.getInt());
            return new ScalarWrapper(p);
        }
        else if (other.isDouble()) {
            return new ScalarWrapper(this.divideBy(other.getDouble()));
        }
        return new ScalarWrapper(this.divideBy(other.getRat()));
    }

    /**
     * Divides this Rational by another Rational
     * @param other the Rational to divide this Rational by
     * @return the quotient of the two Rationals
     */
    public Rational divideBy(Rational other) {
        Rational quotient = this.multiply(other.invert());
        return quotient;
    }

    /**
     * Divides a Rational by an int
     * @param other the int to divide this Rational by
     * @return the quotient of the Rational and the int
     */
    public Rational divideBy(int other) {
        return new Rational(this.numerator, this.denominator * other);
    }

    public Rational divideBy(Integer other) {
        int intOther = other;
        return this.divideBy(intOther);
    }

    public double divideBy(double other) {
        return this.value() / other;
    }

    public double divideBy(Double other) {
        return this.value() / other;
    }
    
    public Rational divideByRat(double other) {
        return new Rational(this.divideBy(other));
    }
    
    public Rational divideByRat(Double other) {
        return new Rational(this.divideBy(other));
    }

    /**
     * Divides a ScalarWrapper by this Rational
     * @param other the ScalarWrapper to divide by this Rational
     * @return the quotient of the ScalarWrapper and this Rational 
     */
    public ScalarWrapper divide(ScalarWrapper other) {
        if (other.isInt()) {
            return new ScalarWrapper(this.divide(other.getInt()));
        }
        else if (other.isDouble()) {
            return new ScalarWrapper(this.divide(other.getDouble()));
        }
        return new ScalarWrapper(this.divide(other.getRat()));
    }

    /**
     * Divides a Rational by another Rational, reflected
     * @param other the Rational to divide by this Rational
     * @return the quotient of the two Rationals
     */
    public Rational divide(Rational other) {
        return this.invert().multiply(other);
    }

    /**
     * Divides an int by a Rational
     * @param other the int to divide by this Rational
     * @return the quotient of the int and the Rational
     */
    public Rational divide(int other) {
        return this.invert().multiply(other);
    }

    public Rational divide(Integer other) {
        int intOther = other;
        return this.divide(intOther);
    }

    public double divide(double other) {
        return other / this.value();
    }
    
    public Rational divideRat(double other) {
        return new Rational(this.divide(other));
    }

    @Override
    public Rational clone() {
        return new Rational(this.numerator, this.denominator);
    }

    /**
     * Returns a string representation of a Rational
     */
    @Override
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

    public static int[] continuedFraction(double value, int iterations) {
        double b0 = Math.floor(value);
        double err = value - b0;
        double numer = b0;
        double denom = 1;
        double prevN1 = b0;
        double prevD1 = 1;
        double prevN2 = 1;
        double prevD2 = 0;
        double[] prevIter;

        for (int i = 0; i < iterations; i++) {
            if (err == 0) {
                break;
            }

            prevIter = contFractIteration(err, prevN1, prevD1, prevN2, prevD2);
            numer = prevIter[0];
            denom = prevIter[1];
            err = prevIter[2];

            prevN2 = prevN1;
            prevD2 = prevD1;
            prevN1 = numer;
            prevD1 = denom;
        }

        int numerInt = (int)numer;
        int denomInt = (int)denom;
        int[] ratComponents = {numerInt, denomInt};
        return ratComponents;
    }

    public static double[] contFractIteration(double value, double prevN1, double prevD1, double prevN2, double prevD2) {
        // prevN1 = numerator for n-1, prevD2 = denominator for n-2, etc.
        double b = 1 / value;
        double bN = Math.floor(b);
        double err = b - bN;

        double numer = (bN * prevN1) + prevN2;
        double denom = (bN * prevD1) + prevD2;
        double[] output = {numer, denom, err};
        return output;
    }
}
