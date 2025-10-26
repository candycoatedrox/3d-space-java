public class Rational implements Cloneable {

    // add constructors using Integer, double, Double, ScalarWrapper
    // add iadd, isub, imul, idiv equivalents
    
    private int numerator;
    private int denominator;
    private static final int contFractIterations = 7;

    /**
     * Constructs a Rational from two ScalarWrappers
     * @param numerator the numerator of the Rational
     * @param denominator the denominator of the Rational
     */
    public Rational(ScalarWrapper numerator, ScalarWrapper denominator) {
        if (numerator.isInt() && denominator.isInt()) {
            this.numerator = numerator.getInt();
            this.denominator = denominator.getInt();
        } else if (numerator.isDouble() || denominator.isDouble()) { // if either is double
            double value;
            if (numerator.isDouble()) {
                if (denominator.isInt()) {
                    value = numerator.getDouble() / denominator.getInt();
                } else if (denominator.isDouble()) {
                    value = numerator.getDouble() / denominator.getDouble();
                } else {
                    value = denominator.getRat().divide(numerator.getDouble());
                }
            }
            else {
                if (numerator.isInt()) {
                    value = numerator.getInt() / denominator.getDouble();
                } else {
                    value = numerator.getRat().divideBy(denominator.getDouble());
                }
            }

            int[] contFract = continuedFraction(value, contFractIterations);
            this.numerator = contFract[0];
            this.denominator = contFract[1];
        } else { // if either is a Rational, but neither is double
            int numer;
            int denom;
            if (numerator.isRat() && denominator.isInt()) {
                numer = numerator.getRat().numerator;
                denom = numerator.getRat().denominator * denominator.getInt();
            } else if (numerator.isInt() && denominator.isRat()) {
                numer = numerator.getInt() * denominator.getRat().denominator;
                denom = denominator.getRat().numerator;
            } else { // both are Rationals
                numer = numerator.getRat().numerator * denominator.getRat().denominator;
                denom = numerator.getRat().denominator * denominator.getRat().numerator;
            }
            
            this.numerator = numer;
            this.denominator = denom;
        }

        this.reduce();
    }

    /**
     * Constructs a Rational from a ScalarWrapper numerator and an int denominator
     * @param numerator the numerator of the Rational
     * @param denominator the denominator of the Rational
     */
    public Rational(ScalarWrapper numerator, int denominator) {
        if (numerator.isInt()) {
            this.numerator = numerator.getInt();
            this.denominator = denominator;
        } else if (numerator.isDouble()) {
            double value = numerator.getDouble() / denominator;
            int[] contFract = continuedFraction(value, contFractIterations);
            this.numerator = contFract[0];
            this.denominator = contFract[1];
        } else {
            this.numerator = numerator.getRat().numerator;
            this.denominator = numerator.getRat().denominator * denominator;
        }

        this.reduce();
    }

    /**
     * Constructs a Rational from a ScalarWrapper numerator and an Integer denominator
     * @param numerator the numerator of the Rational
     * @param denominator the denominator of the Rational
     */
    public Rational(ScalarWrapper numerator, Integer denominator) {
        if (numerator.isInt()) {
            this.numerator = numerator.getInt();
            this.denominator = denominator;
        } else if (numerator.isDouble()) {
            double value = numerator.getDouble() / denominator;
            int[] contFract = continuedFraction(value, contFractIterations);
            this.numerator = contFract[0];
            this.denominator = contFract[1];
        } else {
            this.numerator = numerator.getRat().numerator;
            this.denominator = numerator.getRat().denominator * denominator;
        }

        this.reduce();
    }

    /**
     * Constructs a Rational from a ScalarWrapper numerator and a double denominator
     * @param numerator the numerator of the Rational
     * @param denominator the denominator of the Rational
     */
    public Rational(ScalarWrapper numerator, double denominator) {
        double value;
        if (numerator.isInt()) {
            value = numerator.getInt() / denominator;
        } else if (numerator.isDouble()) {
            value = numerator.getDouble() / denominator;
        } else {
            value = numerator.getRat().divideBy(denominator);
        }
        int[] contFract = continuedFraction(value, contFractIterations);
        this.numerator = contFract[0];
        this.denominator = contFract[1];

        this.reduce();
    }

    /**
     * Constructs a Rational from a ScalarWrapper numerator and a Double denominator
     * @param numerator the numerator of the Rational
     * @param denominator the denominator of the Rational
     */
    public Rational(ScalarWrapper numerator, Double denominator) {
        double value;
        if (numerator.isInt()) {
            value = numerator.getInt() / denominator;
        } else if (numerator.isDouble()) {
            value = numerator.getDouble() / denominator;
        } else {
            value = numerator.getRat().divideBy(denominator);
        }
        int[] contFract = continuedFraction(value, contFractIterations);
        this.numerator = contFract[0];
        this.denominator = contFract[1];

        this.reduce();
    }

    /**
     * Constructs a Rational from a ScalarWrapper numerator and a Rational denominator
     * @param numerator the numerator of the Rational
     * @param denominator the denominator of the Rational
     */
    public Rational(ScalarWrapper numerator, Rational denominator) {
        if (numerator.isInt()) {
            this.numerator = numerator.getInt() * denominator.denominator;
            this.denominator = denominator.numerator;
        } else if (numerator.isDouble()) {
            Rational value = denominator.divideRat(numerator.getDouble());
            this.numerator = value.numerator;
            this.denominator = value.denominator;
        } else {
            this.numerator = numerator.getRat().numerator * denominator.denominator;
            this.denominator = numerator.getRat().denominator * denominator.numerator;
        }

        this.reduce();
    }

    /**
     * Constructs a Rational from an int numerator and a ScalarWrapper denominator
     * @param numerator the numerator of the Rational
     * @param denominator the denominator of the Rational
     */
    public Rational(int numerator, ScalarWrapper denominator) {
        if (denominator.isInt()) {
            this.numerator = numerator;
            this.denominator = denominator.getInt();
        } else if (denominator.isDouble()) {
            double value = numerator / denominator.getDouble();
            int[] contFract = continuedFraction(value, contFractIterations);
            this.numerator = contFract[0];
            this.denominator = contFract[1];
        } else {
            this.numerator = numerator * denominator.getRat().denominator;
            this.denominator = denominator.getRat().numerator;
        }

        this.reduce();
    }

    /**
     * Constructs a Rational from two ints
     * @param numerator the numerator of the Rational
     * @param denominator the denominator of the Rational
     */
    public Rational(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
        this.reduce();
    }
    
    /**
     * Constructs a Rational from an int and an Integer
     * @param numerator the numerator of the Rational
     * @param denominator the denominator of the Rational
     */
    public Rational(int numerator, Integer denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
        this.reduce();
    }

    /**
     * Constructs a Rational from an int numerator and a double denominator
     * @param numerator the numerator of the Rational
     * @param denominator the denominator of the Rational
     */
    public Rational(int numerator, double denominator) {
        double value = numerator / denominator;
        int[] contFract = continuedFraction(value, contFractIterations);
        this.numerator = contFract[0];
        this.denominator = contFract[1];
        this.reduce();
    }

    /**
     * Constructs a Rational from an int numerator and a Double denominator
     * @param numerator the numerator of the Rational
     * @param denominator the denominator of the Rational
     */
    public Rational(int numerator, Double denominator) {
        double value = numerator / denominator;
        int[] contFract = continuedFraction(value, contFractIterations);
        this.numerator = contFract[0];
        this.denominator = contFract[1];
        this.reduce();
    }

    /**
     * Constructs a Rational from an int numerator and a Rational denominator
     * @param numerator the numerator of the Rational
     * @param denominator the denominator of the Rational
     */
    public Rational(int numerator, Rational denominator) {
        this.numerator = numerator * denominator.denominator;
        this.denominator = denominator.numerator;
        this.reduce();
    }

    /**
     * Constructs a Rational from an Integer numerator and a ScalarWrapper denominator
     * @param numerator the numerator of the Rational
     * @param denominator the denominator of the Rational
     */
    public Rational(Integer numerator, ScalarWrapper denominator) {
        if (denominator.isInt()) {
            this.numerator = numerator;
            this.denominator = denominator.getInt();
        } else if (denominator.isDouble()) {
            double value = numerator / denominator.getDouble();
            int[] contFract = continuedFraction(value, contFractIterations);
            this.numerator = contFract[0];
            this.denominator = contFract[1];
        } else {
            this.numerator = numerator * denominator.getRat().denominator;
            this.denominator = denominator.getRat().numerator;
        }

        this.reduce();
    }

    /**
     * Constructs a Rational from an Integer and an int
     * @param numerator the numerator of the Rational
     * @param denominator the denominator of the Rational
     */
    public Rational(Integer numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
        this.reduce();
    }
    
    /**
     * Constructs a Rational from two Integers
     * @param numerator the numerator of the Rational
     * @param denominator the denominator of the Rational
     */
    public Rational(Integer numerator, Integer denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
        this.reduce();
    }

    /**
     * Constructs a Rational from an Integer numerator and a double denominator
     * @param numerator the numerator of the Rational
     * @param denominator the denominator of the Rational
     */
    public Rational(Integer numerator, double denominator) {
        double value = numerator / denominator;
        int[] contFract = continuedFraction(value, contFractIterations);
        this.numerator = contFract[0];
        this.denominator = contFract[1];
        this.reduce();
    }

    /**
     * Constructs a Rational from an Integer numerator and a Double denominator
     * @param numerator the numerator of the Rational
     * @param denominator the denominator of the Rational
     */
    public Rational(Integer numerator, Double denominator) {
        double value = numerator / denominator;
        int[] contFract = continuedFraction(value, contFractIterations);
        this.numerator = contFract[0];
        this.denominator = contFract[1];
        this.reduce();
    }

    /**
     * Constructs a Rational from an Integer numerator and a Rational denominator
     * @param numerator the numerator of the Rational
     * @param denominator the denominator of the Rational
     */
    public Rational(Integer numerator, Rational denominator) {
        this.numerator = numerator * denominator.denominator;
        this.denominator = denominator.numerator;
        this.reduce();
    }

    /**
     * Constructs a Rational from a double numerator and a ScalarWrapper denominator
     * @param numerator the numerator of the Rational
     * @param denominator the denominator of the Rational
     */
    public Rational(double numerator, ScalarWrapper denominator) {
        double value;
        if (denominator.isInt()) {
            value = numerator / denominator.getInt();
        } else if (denominator.isDouble()) {
            value = numerator / denominator.getDouble();
        } else {
            value = denominator.getRat().divide(numerator);
        }

        int[] contFract = continuedFraction(value, contFractIterations);
        this.numerator = contFract[0];
        this.denominator = contFract[1];
        this.reduce();
    }

    /**
     * Constructs a Rational from a double numerator and an int denominator
     * @param numerator the numerator of the Rational
     * @param denominator the denominator of the Rational
     */
    public Rational(double numerator, int denominator) {
        double value = numerator / denominator;
        int[] contFract = continuedFraction(value, contFractIterations);
        this.numerator = contFract[0];
        this.denominator = contFract[1];
        this.reduce();
    }

    /**
     * Constructs a Rational from a double numerator and an Integer denominator
     * @param numerator the numerator of the Rational
     * @param denominator the denominator of the Rational
     */
    public Rational(double numerator, Integer denominator) {
        double value = numerator / denominator;
        int[] contFract = continuedFraction(value, contFractIterations);
        this.numerator = contFract[0];
        this.denominator = contFract[1];
        this.reduce();
    }

    /**
     * Constructs a Rational from two doubles
     * @param numerator the numerator of the Rational
     * @param denominator the denominator of the Rational
     */
    public Rational(double numerator, double denominator) {
        double value = numerator / denominator;
        int[] contFract = continuedFraction(value, contFractIterations);
        this.numerator = contFract[0];
        this.denominator = contFract[1];
        this.reduce();
    }

    /**
     * Constructs a Rational from a double numerator and a Double denominator
     * @param numerator the numerator of the Rational
     * @param denominator the denominator of the Rational
     */
    public Rational(double numerator, Double denominator) {
        double value = numerator / denominator;
        int[] contFract = continuedFraction(value, contFractIterations);
        this.numerator = contFract[0];
        this.denominator = contFract[1];
        this.reduce();
    }

    /**
     * Constructs a Rational from a double numerator and a Rational denominator
     * @param numerator the numerator of the Rational
     * @param denominator the denominator of the Rational
     */
    public Rational(double numerator, Rational denominator) {
        Rational value = denominator.divideRat(numerator);
        this.numerator = value.numerator;
        this.denominator = value.denominator;
        this.reduce();
    }

    /**
     * Constructs a Rational from a Double numerator and a ScalarWrapper denominator
     * @param numerator the numerator of the Rational
     * @param denominator the denominator of the Rational
     */
    public Rational(Double numerator, ScalarWrapper denominator) {
        double value;
        if (denominator.isInt()) {
            value = numerator / denominator.getInt();
        } else if (denominator.isDouble()) {
            value = numerator / denominator.getDouble();
        } else {
            value = denominator.getRat().divide(numerator);
        }

        int[] contFract = continuedFraction(value, contFractIterations);
        this.numerator = contFract[0];
        this.denominator = contFract[1];
        this.reduce();
    }

    /**
     * Constructs a Rational from a Double numerator and an int denominator
     * @param numerator the numerator of the Rational
     * @param denominator the denominator of the Rational
     */
    public Rational(Double numerator, int denominator) {
        double value = numerator / denominator;
        int[] contFract = continuedFraction(value, contFractIterations);
        this.numerator = contFract[0];
        this.denominator = contFract[1];
        this.reduce();
    }

    /**
     * Constructs a Rational from a Double numerator and an Integer denominator
     * @param numerator the numerator of the Rational
     * @param denominator the denominator of the Rational
     */
    public Rational(Double numerator, Integer denominator) {
        double value = numerator / denominator;
        int[] contFract = continuedFraction(value, contFractIterations);
        this.numerator = contFract[0];
        this.denominator = contFract[1];
        this.reduce();
    }

    /**
     * Constructs a Rational from a Double numerator and a double denominator
     * @param numerator the numerator of the Rational
     * @param denominator the denominator of the Rational
     */
    public Rational(Double numerator, double denominator) {
        double value = numerator / denominator;
        int[] contFract = continuedFraction(value, contFractIterations);
        this.numerator = contFract[0];
        this.denominator = contFract[1];
        this.reduce();
    }

    /**
     * Constructs a Rational from two Doubles
     * @param numerator the numerator of the Rational
     * @param denominator the denominator of the Rational
     */
    public Rational(Double numerator, Double denominator) {
        double value = numerator / denominator;
        int[] contFract = continuedFraction(value, contFractIterations);
        this.numerator = contFract[0];
        this.denominator = contFract[1];
        this.reduce();
    }

    /**
     * Constructs a Rational from a Double numerator and a Rational denominator
     * @param numerator the numerator of the Rational
     * @param denominator the denominator of the Rational
     */
    public Rational(Double numerator, Rational denominator) {
        Rational value = denominator.divideRat(numerator);
        this.numerator = value.numerator;
        this.denominator = value.denominator;
        this.reduce();
    }

    /**
     * Constructs a Rational from a Rational numerator and a ScalarWrapper denominator
     * @param numerator the numerator of the Rational
     * @param denominator the denominator of the Rational
     */
    public Rational(Rational numerator, ScalarWrapper denominator) {
        if (denominator.isInt()) {
            this.numerator = numerator.numerator;
            this.denominator = numerator.denominator * denominator.getInt();
        } else if (denominator.isDouble()) {
            Rational value = numerator.divideByRat(denominator.getDouble());
            this.numerator = value.numerator;
            this.denominator = value.denominator;
        } else {
            this.numerator = numerator.numerator * denominator.getRat().denominator;
            this.denominator = numerator.denominator * denominator.getRat().numerator;
        }

        this.reduce();
    }

    /**
     * Constructs a Rational from a Rational numerator and an int denominator
     * @param numerator the numerator of the Rational
     * @param denominator the denominator of the Rational
     */
    public Rational(Rational numerator, int denominator) {
        this.numerator = numerator.numerator;
        this.denominator = numerator.denominator * denominator;
        this.reduce();
    }

    /**
     * Constructs a Rational from a Rational numerator and an Integer denominator
     * @param numerator the numerator of the Rational
     * @param denominator the denominator of the Rational
     */
    public Rational(Rational numerator, Integer denominator) {
        this.numerator = numerator.numerator;
        this.denominator = numerator.denominator * denominator;
        this.reduce();
    }

    /**
     * Constructs a Rational from a Rational numerator and a double denominator
     * @param numerator the numerator of the Rational
     * @param denominator the denominator of the Rational
     */
    public Rational(Rational numerator, double denominator) {
        Rational value = numerator.divideByRat(denominator);
        this.numerator = value.numerator;
        this.denominator = value.denominator;
        this.reduce();
    }

    /**
     * Constructs a Rational from a Rational numerator and a Double denominator
     * @param numerator the numerator of the Rational
     * @param denominator the denominator of the Rational
     */
    public Rational(Rational numerator, Double denominator) {
        Rational value = numerator.divideByRat(denominator);
        this.numerator = value.numerator;
        this.denominator = value.denominator;
        this.reduce();
    }

    /**
     * Constructs a Rational from two other Rationals
     * @param numerator the numerator of the Rational
     * @param denominator the denominator of the Rational
     */
    public Rational(Rational numerator, Rational denominator) {
        this.numerator = numerator.numerator * denominator.denominator;
        this.denominator = numerator.denominator * denominator.numerator;
        this.reduce();
    }

    /**
     * Constructs a Rational from a ScalarWrapper
     * @param value the integer, double, or rational value of the Rational
     */
    public Rational(ScalarWrapper value) {
        if (value.isInt()) {
            this.numerator = value.getInt();
            this.denominator = 1;
        } else if (value.isDouble()) {
            int[] contFract = continuedFraction(value.getDouble(), contFractIterations);
            this.numerator = contFract[0];
            this.denominator = contFract[1];
        } else {
            this.numerator = value.getRat().getNumerator();
            this.denominator = value.getRat().getDenominator();
        }

        this.reduce();
    }

    /**
     * Constructs a Rational from an int
     * @param value the integer value of the Rational
     */
    public Rational(int value) {
        this.numerator = value;
        this.denominator = 1;
    }
    
    /**
     * Constructs a Rational from an Integer
     * @param value the integer value of the Rational
     */
    public Rational(Integer value) {
        this.numerator = value;
        this.denominator = 1;
    }

    /**
     * Constructs a Rational from a double
     * @param value the double value of the Rational
     */
    public Rational(double value) {
        int[] contFract = continuedFraction(value, contFractIterations);
        this.numerator = contFract[0];
        this.denominator = contFract[1];
        this.reduce();
    }

    /**
     * Constructs a Rational from a Double
     * @param value the double value of the Rational
     */
    public Rational(Double value) {
        int[] contFract = continuedFraction(value, contFractIterations);
        this.numerator = contFract[0];
        this.denominator = contFract[1];
        this.reduce();
    }

    /**
     * Reduces this Rational to lowest terms
     */
    public void reduce() {
        if (this.numerator == this.denominator) {
            this.numerator = 1;
            this.denominator = 1;
        } else {
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
     * Returns this Rational reduced to lowest terms
     * @return the reduced form of this Rational
     */
    public Rational reduced() {
        int numer = this.numerator;
        int denom = this.denominator;

        if (numer == denom) {
            numer = 1;
            denom = 1;
        } else {
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
     * @return the numerator of this Rational
     */
    public int getNumerator() {
        return this.numerator;
    }

    /**
     * Accessor for denominator
     * @return the denominator of this Rational
     */
    public int getDenominator() {
        return this.denominator;
    }

    /**
     * Returns an inverted version of this Rational
     * @return the inverted version of this Rational
     */
    public Rational invert() {
        return new Rational(this.denominator, this.numerator);
    }

    /**
     * Returns this Rational with its sign flipped
     * @return the negative version of this Rational
     */
    public Rational negative() {
        return new Rational(this.numerator * -1, this.denominator);
    }

    /**
     * Returns the absolute value of this Rational
     * @return the absolute value of this Rational
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
        Rational thisReduced = this.reduced();
        return thisReduced.denominator == 1;
    }

    /**
     * Returns the double value of this Rational
     * @return the double value of this Rational
     */
    public double value() {
        double numerDouble = this.numerator;
        return numerDouble / this.denominator;
    }

    /**
     * Returns the double value of this Rational, rounded to the nearest integer
     * @return the double value of this Rational, rounded to the nearest integer
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
     * @return true if this Rational and int are equal to the same double; false otherwise
     */
    public boolean equals(int other) {
        double doubleOther = other;
        return this.value() == doubleOther;
    }

    /**
     * Compares this Rational against an Integer
     * @param other the Integer to compare with
     * @return true if this Rational and Integer are equal to the same double; false otherwise
     */
    public boolean equals(Integer other) {
        double doubleOther = other;
        return this.equals(doubleOther);
    }

    /**
     * Compares this Rational against a double
     * @param other the double to compare with
     * @return true if this Rational's value equals the double; false otherwise
     */
    public boolean equals(double other) {
        return this.value() == other;
    }

    /**
     * Compares this Rational against a Double
     * @param other the Double to compare with
     * @return true if this Rational's value equals the Double; false otherwise
     */
    public boolean equals(Double other) {
        return this.value() == other;
    }

    /**
     * Compares this Rational against a ScalarWrapper
     * @param other the ScalarWrapper to compare with
     * @return true if this Rational's value equals the ScalarWrapper; false otherwise
     */
    public boolean equals(ScalarWrapper other) {
        if (other.isInt()) {
            return this.equals(other.getInt());
        } else if (other.isDouble()) {
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
     * Compares this Rational to an int and returns whether this Rational's value is less than the int
     * @param other the int to compare with
     * @return true if this Rational's value is less than other
     */
    public boolean lessThan(int other) {
        double doubleOther = other;
        return this.value() < doubleOther;
    }

    /**
     * Compares this Rational to an Integer and returns whether this Rational's value is less than the Integer
     * @param other the Integer to compare with
     * @return true if this Rational's value is less than other
     */
    public boolean lessThan(Integer other) {
        double doubleOther = other;
        return this.value() < doubleOther;
    }

    /**
     * Compares this Rational to a double and returns whether this Rational's value is less than the double
     * @param other the double to compare with
     * @return true if this Rational's value is less than other
     */
    public boolean lessThan(double other) {
        return this.value() < other;
    }

    /**
     * Compares this Rational to a Double and returns whether this Rational's value is less than the Double
     * @param other the Double to compare with
     * @return true if this Rational's value is less than other
     */
    public boolean lessThan(Double other) {
        return this.value() < other;
    }

    /**
     * Compares this Rational to a ScalarWrapper and returns whether this Rational's value is less than the ScalarWrapper
     * @param other the ScalarWrapper to compare with
     * @return true if this Rational's value is less than other
     */
    public boolean lessThan(ScalarWrapper other) {
        if (other.isInt()) {
            return this.lessThan(other.getInt());
        } else if (other.isDouble()) {
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
     * Compares this Rational to an int and returns whether this Rational's value is less than or equal to the int
     * @param other the int to compare with
     * @return true if this Rational's value is less than or equal to other
     */
    public boolean lessThanOrEquals(int other) {
        double doubleOther = other;
        return this.value() <= doubleOther;
    }

    /**
     * Compares this Rational to an Integer and returns whether this Rational's value is less than or equal to the Integer
     * @param other the Integer to compare with
     * @return true if this Rational's value is less than or equal to other
     */
    public boolean lessThanOrEquals(Integer other) {
        double doubleOther = other;
        return this.value() <= doubleOther;
    }

    /**
     * Compares this Rational to a double and returns whether this Rational's value is less than or equal to the double
     * @param other the double to compare with
     * @return true if this Rational's value is less than or equal to other
     */
    public boolean lessThanOrEquals(double other) {
        return this.value() <= other;
    }

    /**
     * Compares this Rational to a Double and returns whether this Rational's value is less than or equal to the Double
     * @param other the Double to compare with
     * @return true if this Rational's value is less than or equal to other
     */
    public boolean lessThanOrEquals(Double other) {
        return this.value() <= other;
    }

    /**
     * Compares this Rational to a ScalarWrapper and returns whether this Rational's value is less than or equal to the ScalarWrapper
     * @param other the ScalarWrapper to compare with
     * @return true if this Rational's value is less than or equal to other
     */
    public boolean lessThanOrEquals(ScalarWrapper other) {
        if (other.isInt()) {
            return this.lessThanOrEquals(other.getInt());
        } else if (other.isDouble()) {
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
     * Compares this Rational to an int and returns whether this Rational's value is less than the int
     * @param other the int to compare with
     * @return true if this Rational's value is less than other
     */
    public boolean greaterThan(int other) {
        double doubleOther = other;
        return this.value() > doubleOther;
    }
    
    /**
     * Compares this Rational to an Integer and returns whether this Rational's value is less than the Integer
     * @param other the Integer to compare with
     * @return true if this Rational's value is less than other
     */
    public boolean greaterThan(Integer other) {
        double doubleOther = other;
        return this.value() > doubleOther;
    }

    /**
     * Compares this Rational to a double and returns whether this Rational's value is less than the double
     * @param other the double to compare with
     * @return true if this Rational's value is less than other
     */
    public boolean greaterThan(double other) {
        return this.value() > other;
    }
    
    /**
     * Compares this Rational to a Double and returns whether this Rational's value is less than the Double
     * @param other the Double to compare with
     * @return true if this Rational's value is less than other
     */
    public boolean greaterThan(Double other) {
        return this.value() > other;
    }

    /**
     * Compares this Rational to a ScalarWrapper and returns whether this Rational's value is less than the ScalarWrapper
     * @param other the ScalarWrapper to compare with
     * @return true if this Rational's value is less than other
     */
    public boolean greaterThan(ScalarWrapper other) {
        if (other.isInt()) {
            return this.greaterThan(other.getInt());
        } else if (other.isDouble()) {
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
     * Compares this Rational to an int and returns whether this Rational's value is less than or equal to the int
     * @param other the int to compare with
     * @return true if this Rational's value is less than or equal to other
     */
    public boolean greaterThanOrEquals(int other) {
        double doubleOther = other;
        return this.value() >= doubleOther;
    }
    
    /**
     * Compares this Rational to an Integer and returns whether this Rational's value is less than or equal to the Integer
     * @param other the Integer to compare with
     * @return true if this Rational's value is less than or equal to other
     */
    public boolean greaterThanOrEquals(Integer other) {
        double doubleOther = other;
        return this.value() >= doubleOther;
    }

    /**
     * Compares this Rational to a double and returns whether this Rational's value is less than or equal to the double
     * @param other the double to compare with
     * @return true if this Rational's value is less than or equal to other
     */
    public boolean greaterThanOrEquals(double other) {
        return this.value() >= other;
    }
    
    /**
     * Compares this Rational to a Double and returns whether this Rational's value is less than or equal to the Double
     * @param other the Double to compare with
     * @return true if this Rational's value is less than or equal to other
     */
    public boolean greaterThanOrEquals(Double other) {
        return this.value() >= other;
    }

    /**
     * Compares this Rational to a ScalarWrapper and returns whether this Rational's value is less than or equal to the ScalarWrapper
     * @param other the ScalarWrapper to compare with
     * @return true if this Rational's value is less than or equal to other
     */
    public boolean greaterThanOrEquals(ScalarWrapper other) {
        if (other.isInt()) {
            return this.greaterThanOrEquals(other.getInt());
        } else if (other.isDouble()) {
            return this.greaterThanOrEquals(other.getDouble());
        }
        return this.greaterThanOrEquals(other.getRat());
    }

    /**
     * Adds two Rationals together
     * @param other the Rational to add to this Rational
     * @return the sum of this Rational and other
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
     * Adds this Rational and a ScalarWrapper
     * @param other the ScalarWrapper to add to this Rational
     * @return the sum of this Rational and other
     */
    public ScalarWrapper add(ScalarWrapper other) {
        if (other.isInt()) {
            Rational p = this.add(other.getInt());
            return new ScalarWrapper(p);
        } else if (other.isDouble()) {
            return new ScalarWrapper(this.add(other.getDouble()));
        }
        return new ScalarWrapper(this.add(other.getRat()));
    }

    /**
     * Adds this Rational and an int
     * @param other the int to add to this Rational
     * @return the sum of this Rational and other
     */
    public Rational add(int other) {
        int otherNumer = other * this.denominator;
        return new Rational(this.numerator + otherNumer, this.denominator);
    }

    /**
     * Adds this Rational and an Integer
     * @param other the Integer to add to this Rational
     * @return the sum of this Rational and other
     */
    public Rational add(Integer other) {
        return this.add(other.intValue());
    }

    /**
     * Adds this Rational and a double
     * @param other the double to add to this Rational
     * @return the sum of this Rational and other as a double
     */
    public double add(double other) {
        return this.value() + other;
    }

    /**
     * Adds this Rational and a Double
     * @param other the Double to add to this Rational
     * @return the sum of this Rational and other as a double
     */
    public double add(Double other) {
        return this.value() + other;
    }
    
    /**
     * Adds this Rational and a double
     * @param other the double to add to this Rational
     * @return the sum of this Rational and other as a Rational
     */
    public Rational addRat(double other) {
        return new Rational(this.add(other));
    }
    
    /**
     * Adds this Rational and a Double
     * @param other the Double to add to this Rational
     * @return the sum of this Rational and other as a Rational
     */
    public Rational addRat(Double other) {
        return new Rational(this.add(other));
    }

    /**
     * Subtracts a Rational from this Rational and returns a Rational
     * @param other the Rational to subtract from this Rational
     * @return the difference between this Rational and other
     */
    public Rational subtract(Rational other) {
        return this.add(other.negative());
    }

    /**
     * Subtracts a ScalarWrapper from this Rational and returns a Rational
     * @param other the ScalarWrapper to subtract from this Rational
     * @return the difference between this Rational and other
     */
    public ScalarWrapper subtract(ScalarWrapper other) {
        if (other.isInt()) {
            Rational p = this.subtract(other.getInt());
            return new ScalarWrapper(p);
        } else if (other.isDouble()) {
            return new ScalarWrapper(this.subtract(other.getDouble()));
        }
        return new ScalarWrapper(this.subtract(other.getRat()));
    }

    /**
     * Subtracts an int from this Rational
     * @param other the int to subtract from this Rational
     * @return the difference between this Rational and other
     */
    public Rational subtract(int other) {
        int otherNumer = other * this.denominator;
        return new Rational(this.numerator - otherNumer, this.denominator);
    }

    /**
     * Subtracts an Integer from this Rational
     * @param other the Integer to subtract from this Rational
     * @return the difference between this Rational and other
     */
    public Rational subtract(Integer other) {
        return this.subtract(other.intValue());
    }

    /**
     * Subtracts a double from this Rational
     * @param other the double to subtract from this Rational
     * @return the difference between this Rational and other as a double
     */
    public double subtract(double other) {
        return this.value() - other;
    }

    /**
     * Subtracts a Double from this Rational
     * @param other the Double to subtract from this Rational
     * @return the difference between this Rational and other as a double
     */
    public double subtract(Double other) {
        return this.value() - other;
    }
    
    /**
     * Subtracts a double from this Rational and returns a Rational
     * @param other the double to subtract from this Rational
     * @return the difference between this Rational and other as a Rational
     */
    public Rational subtractRat(double other) {
        return new Rational(this.subtract(other));
    }
    
    /**
     * Subtracts a Double from this Rational and returns a Rational
     * @param other the Double to subtract from this Rational
     * @return the difference between this Rational and other as a Rational
     */
    public Rational subtractRat(Double other) {
        return new Rational(this.subtract(other));
    }

    /**
     * Subtracts this Rational from a Rational
     * @param other the Rational to subtract this from
     * @return the difference between this Rational and other
     */
    public Rational subtractFrom(Rational other) {
        return other.subtract(this);
    }

    /**
     * Subtracts this Rational from a ScalarWrapper
     * @param other the ScalarWrapper to subtract this from
     * @return the difference between this Rational and other
     */
    public ScalarWrapper subtractFrom(ScalarWrapper other) {
        if (other.isInt()) {
            Rational p = this.subtractFrom(other.getInt());
            return new ScalarWrapper(p);
        } else if (other.isDouble()) {
            return new ScalarWrapper(this.subtractFrom(other.getDouble()));
        }
        return new ScalarWrapper(this.subtractFrom(other.getRat()));
    }

    /**
     * Subtracts this Rational from an int
     * @param other the int to subtract this from
     * @return the difference between this Rational and other
     */
    public Rational subtractFrom(int other) {
        return this.negative().add(other);
    }

    /**
     * Subtracts this Rational from an Integer
     * @param other the Integer to subtract this from
     * @return the difference between this Rational and other
     */
    public Rational subtractFrom(Integer other) {
        return this.subtractFrom(other.intValue());
    }

    /**
     * Subtracts this Rational from a double
     * @param other the double to subtract this from
     * @return the difference between this Rational and other as a double
     */
    public double subtractFrom(double other) {
        return other - this.value();
    }

    /**
     * Subtracts this Rational from a Double
     * @param other the Double to subtract this from
     * @return the difference between this Rational and other as a double
     */
    public double subtractFrom(Double other) {
        return other - this.value();
    }
    
    /**
     * Subtracts this Rational from a double and returns a Rational
     * @param other the double to subtract this from
     * @return the difference between this Rational and other as a Rational
     */
    public Rational subtractFromRat(double other) {
        return new Rational(this.subtractFrom(other));
    }
    
    /**
     * Subtracts this Rational from a Double and returns a Rational
     * @param other the Double to subtract this from
     * @return the difference between this Rational and other as a Rational
     */
    public Rational subtractFromRat(Double other) {
        return new Rational(this.subtractFrom(other));
    }

    /**
     * Multiplies two Rationals together
     * @param other the Rational to multiply with this Rational
     * @return the product of this Rational and other
     */
    public Rational multiply(Rational other) {
        Rational product = new Rational(this.numerator * other.numerator, this.denominator * other.denominator);
        return product;
    }

    /**
     * Multiplies this Rational with a ScalarWrapper
     * @param other the ScalarWrapper to multiply with this Rational
     * @return the product of this Rational and other
     */
    public ScalarWrapper multiply(ScalarWrapper other) {
        if (other.isInt()) {
            Rational p = this.multiply(other.getInt());
            return new ScalarWrapper(p);
        } else if (other.isDouble()) {
            return new ScalarWrapper(this.multiply(other.getDouble()));
        }
        return new ScalarWrapper(this.multiply(other.getRat()));
    }

    /**
     * Multiplies this Rational with an int
     * @param other the int to multiply with this Rational
     * @return the product of this Rational and other
     */
    public Rational multiply(int other) {
        return new Rational(this.numerator * other, this.denominator);
    }
    
    /**
     * Multiplies this Rational with an Integer
     * @param other the Integer to multiply with this Rational
     * @return the product of this Rational and other
     */
    public Rational multiply(Integer other) {
        return new Rational(this.numerator * other, this.denominator);
    }

    /**
     * Multiplies this Rational with a double
     * @param other the double to multiply with this Rational
     * @return the product of this Rational and other as a double
     */
    public double multiply(double other) {
        return this.value() * other;
    }

    /**
     * Multiplies this Rational with a Double
     * @param other the Double to multiply with this Rational
     * @return the product of this Rational and other as a double
     */
    public double multiply(Double other) {
        return this.value() * other;
    }
    
    /**
     * Multiplies this Rational with a double and returns a Rational
     * @param other the double to multiply with this Rational
     * @return the product of this Rational and other as a Rational
     */
    public Rational multiplyRat(double other) {
        return new Rational(this.multiply(other));
    }
    
    /**
     * Multiplies this Rational with a Double and returns a Rational
     * @param other the Double to multiply with this Rational
     * @return the product of this Rational and other as a Rational
     */
    public Rational multiplyRat(Double other) {
        return new Rational(this.multiply(other));
    }

    /**
     * Divides this Rational by a ScalarWrapper
     * @param other the ScalarWrapper to divide this Rational by
     * @return the quotient of this Rational and other
     */
    public ScalarWrapper divideBy(ScalarWrapper other) {
        if (other.isInt()) {
            Rational p = this.divideBy(other.getInt());
            return new ScalarWrapper(p);
        } else if (other.isDouble()) {
            return new ScalarWrapper(this.divideBy(other.getDouble()));
        }
        return new ScalarWrapper(this.divideBy(other.getRat()));
    }

    /**
     * Divides this Rational by another Rational
     * @param other the Rational to divide this Rational by
     * @return the quotient of this Rational and other
     */
    public Rational divideBy(Rational other) {
        Rational quotient = this.multiply(other.invert());
        return quotient;
    }

    /**
     * Divides this Rational by an int
     * @param other the int to divide this Rational by
     * @return the quotient of this Rational and other
     */
    public Rational divideBy(int other) {
        return new Rational(this.numerator, this.denominator * other);
    }

    /**
     * Divides this Rational by an Integer
     * @param other the Integer to divide this Rational by
     * @return the quotient of this Rational and other
     */
    public Rational divideBy(Integer other) {
        return this.divideBy(other.intValue());
    }

    /**
     * Divides this Rational by a double
     * @param other the double to divide this Rational by
     * @return the quotient of this Rational and other as a double
     */
    public double divideBy(double other) {
        return this.value() / other;
    }

    /**
     * Divides this Rational by a Double
     * @param other the Double to divide this Rational by
     * @return the quotient of this Rational and other as a double
     */
    public double divideBy(Double other) {
        return this.value() / other;
    }
    
    /**
     * Divides this Rational by a double and returns a Rational
     * @param other the double to divide this Rational by
     * @return the quotient of this Rational and other as a Rational
     */
    public Rational divideByRat(double other) {
        return new Rational(this.divideBy(other));
    }
    
    /**
     * Divides this Rational by a Double and returns a Rational
     * @param other the Double to divide this Rational by
     * @return the quotient of this Rational and other as a Rational
     */
    public Rational divideByRat(Double other) {
        return new Rational(this.divideBy(other));
    }

    /**
     * Divides a ScalarWrapper by this Rational
     * @param other the ScalarWrapper to divide by this Rational
     * @return the quotient of this Rational and other
     */
    public ScalarWrapper divide(ScalarWrapper other) {
        if (other.isInt()) {
            return new ScalarWrapper(this.divide(other.getInt()));
        } else if (other.isDouble()) {
            return new ScalarWrapper(this.divide(other.getDouble()));
        }
        return new ScalarWrapper(this.divide(other.getRat()));
    }

    /**
     * Divides this Rational by another Rational, reflected
     * @param other the Rational to divide by this Rational
     * @return the quotient of other and this Rational
     */
    public Rational divide(Rational other) {
        return this.invert().multiply(other);
    }

    /**
     * Divides an int by this Rational
     * @param other the int to divide by this Rational
     * @return the quotient of other and this Rational
     */
    public Rational divide(int other) {
        return this.invert().multiply(other);
    }

    /**
     * Divides an Integer by this Rational
     * @param other the Integer to divide by this Rational
     * @return the quotient of this Rational and other
     */
    public Rational divide(Integer other) {
        return this.divide(other.intValue());
    }

    /**
     * Divides a double by this Rational
     * @param other the double to divide by this Rational
     * @return the quotient of this Rational and other as a double
     */
    public double divide(double other) {
        return other / this.value();
    }

    /**
     * Divides a Double by this Rational
     * @param other the Double to divide by this Rational
     * @return the quotient of this Rational and other as a double
     */
    public double divide(Double other) {
        return other / this.value();
    }
    
    /**
     * Divides a double by this Rational and returns a Rational
     * @param other the double to divide by this Rational
     * @return the quotient of this Rational and other as a Rational
     */
    public Rational divideRat(double other) {
        return new Rational(this.divide(other));
    }
    
    /**
     * Divides a Double by this Rational and returns a Rational
     * @param other the Double to divide by this Rational
     * @return the quotient of this Rational and other as a Rational
     */
    public Rational divideRat(Double other) {
        return new Rational(this.divide(other));
    }

    /**
     * Calculates the square root of this Rational as a double
     * @return the square root of this Rational as a double
     */
    public double sqrt() {
        return Math.sqrt(this.value());
    }

    /**
     * Calculates the square root of this Rational as either a Rational or a double
     * @return the square root of this Rational as either a Rational or a double
     */
    public ScalarWrapper root() {
        if (Vector.perfectSquare(this)) {
            int numer = (int)Math.sqrt(this.numerator);
            int denom = (int)Math.sqrt(this.denominator);
            Rational rat = new Rational(numer, denom);
            return new ScalarWrapper(rat);
        } else {
            return new ScalarWrapper(this.sqrt());
        }
    }

    /**
     * Creates and returns a deep copy of this Rational
     * @return a deep copy of this Rational
     */
    @Override
    public Rational clone() {
        return new Rational(this.numerator, this.denominator);
    }

    /**
     * Returns a String representation of this Rational
     * @return a String representation of this Rational
     */
    @Override
    public String toString() {
        return this.numerator + "/" + this.denominator;
    }

    /**
     * Calculates the Rational form of a double, using the continued fraction method
     * @param value the double value to convert to a Rational
     * @param iterations the number of iterations of the continued fractions formula to run
     * @return the numerator and denominator of the double in Rational form
     */
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

    /**
     * Runs a single iteration of the continued fraction formula
     * @param value the double value to convert to a Rational
     * @param prevN1 the numerator of the previous iteration of the formula
     * @param prevD1 the denominator of the previous iteration of the formula
     * @param prevN2 the numerator of the second-to-last iteration of the formula
     * @param prevD2 the denominator of the second-to-last iteration of the formula
     * @return the numerator and denominator of the Rational form of value, along with the remainder
     */
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

    /**
     * Returns the greatest common denominator of two integers
     * @param a an integer
     * @param b an integer
     * @return the greatest common denominator of the two integers
     */
    public static int gcd(int a, Integer b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    /**
     * Returns the greatest common denominator of two integers
     * @param a an integer
     * @param b an integer
     * @return the greatest common denominator of the two integers
     */
    public static int gcd(Integer a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    /**
     * Returns the greatest common denominator of two integers
     * @param a an integer
     * @param b an integer
     * @return the greatest common denominator of the two integers
     */
    public static int gcd(Integer a, Integer b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    /**
     * Returns the least common multiple of two integers
     * @param a an integer
     * @param b an integer
     * @return the least common multiple of the two integers
     */
    public static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }

    /**
     * Returns the least common multiple of two integers
     * @param a an integer
     * @param b an integer
     * @return the least common multiple of the two integers
     */
    public static int lcm(int a, Integer b) {
        return (a * b) / gcd(a, b);
    }

    /**
     * Returns the least common multiple of two integers
     * @param a an integer
     * @param b an integer
     * @return the least common multiple of the two integers
     */
    public static int lcm(Integer a, int b) {
        return (a * b) / gcd(a, b);
    }

    /**
     * Returns the least common multiple of two integers
     * @param a an integer
     * @param b an integer
     * @return the least common multiple of the two integers
     */
    public static int lcm(Integer a, Integer b) {
        return (a * b) / gcd(a, b);
    }
}
