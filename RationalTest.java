import static org.junit.Assert.*;
import org.junit.Test;

public class RationalTest {
    
    /**
     * Create a new Rational from two ints with the given numerator
     */
    @Test
    public void constructorIINumer() {
        Rational testRat = new Rational(2, 3);
        assertEquals(2, testRat.getNumerator(), 0.01);
    }

    /**
     * Create a new Rational from two ints with the given denominator
     */
    @Test
    public void constructorIIDenom() {
        Rational testRat = new Rational(2, 3);
        assertEquals(3, testRat.getDenominator(), 0.01);
    }
    
    /**
     * Create a new Rational from an int and a Rational with the given numerator
     */
    @Test
    public void constructorIRNumer() {
        Rational denom = new Rational(2, 3);
        Rational testRat = new Rational(1, denom);
        assertEquals(3, testRat.getNumerator(), 0.01);
    }

    /**
     * Create a new Rational from an int and a Rational with the given denominator
     */
    @Test
    public void constructorIRDenom() {
        Rational denom = new Rational(2, 3);
        Rational testRat = new Rational(1, denom);
        assertEquals(2, testRat.getDenominator(), 0.01);
    }
    
    /**
     * Create a new Rational from a Rational and an int with the given numerator
     */
    @Test
    public void constructorRINumer() {
        Rational numer = new Rational(2, 3);
        Rational testRat = new Rational(numer, 4);
        assertEquals(1, testRat.getNumerator(), 0.01);
    }

    /**
     * Create a new Rational from a Rational and an int with the given denominator
     */
    @Test
    public void constructorRIDenom() {
        Rational numer = new Rational(2, 3);
        Rational testRat = new Rational(numer, 4);
        assertEquals(6, testRat.getDenominator(), 0.01);
    }
    
    /**
     * Create a new Rational from two Rationals with the given numerator
     */
    @Test
    public void constructorRRNumer() {
        Rational numer = new Rational(1, 4);
        Rational denom = new Rational(2, 3);
        Rational testRat = new Rational(numer, denom);
        assertEquals(3, testRat.getNumerator(), 0.01);
    }

    /**
     * Create a new Rational from two Rationals with the given denominator
     */
    @Test
    public void constructorRRDenom() {
        Rational numer = new Rational(1, 4);
        Rational denom = new Rational(2, 3);
        Rational testRat = new Rational(numer, denom);
        assertEquals(8, testRat.getDenominator(), 0.01);
    }
    
    /**
     * Create a new Rational from one int with the given numerator
     */
    @Test
    public void constructorINumer() {
        Rational testRat = new Rational(3);
        assertEquals(3, testRat.getNumerator(), 0.01);
    }

    /**
     * Create a new Rational from one int with the denominator 1
     */
    @Test
    public void constructorIDenom() {
        Rational testRat = new Rational(3);
        assertEquals(1, testRat.getDenominator(), 0.01);
    }

    /**
     * Reduce a rational number to its lowest terms
     */
    @Test
    public void reduce() {
        Rational testRat = new Rational(4, 6);
        assertEquals(2, testRat.getNumerator(), 0.01);
        assertEquals(3, testRat.getDenominator(), 0.01);
    }

    /**
     * Reduce a whole rational number to 1/1
     */
    @Test
    public void reduceWhole() {
        Rational testRat = new Rational(3, 3);
        assertEquals(1, testRat.getNumerator(), 0.01);
        assertEquals(1, testRat.getDenominator(), 0.01);
    }

    /**
     * Reduce a rational number with a negative denominator by flipping the signs of both attributes
     */
    @Test
    public void reduceFlippedSigns() {
        Rational testRat = new Rational(2, -3);
        assertEquals(-2, testRat.getNumerator(), 0.01);
        assertEquals(3, testRat.getDenominator(), 0.01);
    }

    /**
     * Return the flipped version of a Rational
     */
    @Test
    public void invert() {
        Rational testRat = new Rational(2, 3);
        Rational testInvert = testRat.invert();
        assertEquals(3, testInvert.getNumerator(), 0.01);
        assertEquals(2, testInvert.getDenominator(), 0.01);
    }

    /**
     * Return the negative version of a Rational
     */
    @Test
    public void negative() {
        Rational testRat = new Rational(2, 3);
        Rational testNegative = testRat.negative();
        assertEquals(-2, testNegative.getNumerator(), 0.01);
        assertEquals(3, testNegative.getDenominator(), 0.01);
    }

    @Test
    public void absolutePos() {
        Rational testRat = new Rational(2, 3);
        Rational testAbs = testRat.absolute();
        assertTrue(testAbs.doubleValue() > 0);
    }

    @Test
    public void absoluteNeg() {
        Rational testRat = new Rational(-2, 3);
        Rational testAbs = testRat.absolute();
        assertTrue(testAbs.doubleValue() > 0);
    }

    @Test
    public void isWholeTrue() {
        Rational testRat = new Rational(3, 3);
        assertTrue(testRat.isWhole());
    }

    @Test
    public void isWholeFalse() {
        Rational testRat = new Rational(2, 3);
        assertFalse(testRat.isWhole());
    }

    @Test
    public void doubleValue() {
        Rational testRat = new Rational(3, 2);
        assertEquals(1.5, testRat.doubleValue(), 0.01);
    }

    @Test
    public void intValue() {
        Rational testRat = new Rational(3, 2);
        assertEquals(1, testRat.intValue(), 0.01);
    }

    /**
     * Finds two Rationals to be equal
     */
    @Test
    public void equalsRatTrue() {
        Rational testRat = new Rational(2, 3);
        Rational testRat2 = new Rational(4, 6);
        assertTrue(testRat.equals(testRat2));
    }

    /**
     * Finds two Rationals to not be equal
     */
    @Test
    public void equalsRatFalse() {
        Rational testRat = new Rational(2, 3);
        Rational testRat2 = new Rational(5, 6);
        assertFalse(testRat.equals(testRat2));
    }

    /**
     * Finds a Rational and an int to be equal
     */
    @Test
    public void equalsIntTrue() {
        Rational testRat = new Rational(8, 2);
        assertTrue(testRat.equals(4));
    }

    /**
     * Finds a Rational and an int to not be equal
     */
    @Test
    public void equalsIntFalse() {
        Rational testRat = new Rational(7, 2);
        assertFalse(testRat.equals(4));
    }

    /**
     * Finds a Rational and a double to be equal
     */
    @Test
    public void equalsDoubleTrue() {
        Rational testRat = new Rational(5, 2);
        assertTrue(testRat.equals(2.5));
    }

    /**
     * Finds a Rational and a double to not be equal
     */
    @Test
    public void equalsDoubleFalse() {
        Rational testRat = new Rational(6, 2);
        assertFalse(testRat.equals(2.5));
    }

    @Test
    public void lessThanRatTrue() {
        Rational testRat = new Rational(2, 3);
        Rational testRat2 = new Rational(5, 4);
        assertTrue(testRat.lessThan(testRat2));
    }

    @Test
    public void lessThanRatEquals() {
        Rational testRat = new Rational(2, 3);
        Rational testRat2 = new Rational(4, 6);
        assertFalse(testRat.lessThan(testRat2));
    }

    @Test
    public void lessThanRatFalse() {
        Rational testRat = new Rational(2, 3);
        Rational testRat2 = new Rational(1, 6);
        assertFalse(testRat.lessThan(testRat2));
    }

    // finish lessThan, lessThanOrEquals, greaterThan, greaterThanOrEquals tests here

    /**
     * Add two Rationals with the same denominator
     */
    @Test
    public void addRatSimple() {
        Rational testRat = new Rational(2, 5);
        Rational testRat2 = new Rational(1, 5);
        Rational expected = new Rational(3, 5);
        assertTrue(expected.equals(testRat.add(testRat2)));
    }

    /**
     * Add two Rationals with different denominators
     */
    @Test
    public void addRatComplex() {
        Rational testRat = new Rational(2, 3);
        Rational testRat2 = new Rational(1, 5);
        Rational expected = new Rational(13, 15);
        assertTrue(expected.equals(testRat.add(testRat2)));
    }

    /**
     * Add a positive and negative Rational
     */
    @Test
    public void addRatNeg() {
        Rational testRat = new Rational(2, 5);
        Rational testRat2 = new Rational(-1, 5);
        Rational expected = new Rational(1, 5);
        assertTrue(expected.equals(testRat.add(testRat2)));
    }

    /**
     * Add a Rational and an int
     */
    @Test
    public void addInt() {
        Rational testRat = new Rational(2, 3);
        Rational expected = new Rational(8, 3);
        assertTrue(expected.equals(testRat.add(2)));
    }

    /**
     * Subtract one rational from another with the same denominator
     */
    @Test
    public void subtractRatSimple() {
        Rational testRat = new Rational(3, 5);
        Rational testRat2 = new Rational(1, 5);
        Rational expected = new Rational(2, 5);
        assertTrue(expected.equals(testRat.subtract(testRat2)));
    }

    /**
     * Subtract one Rational from another with a different denominator
     */
    @Test
    public void subtractRatComplex() {
        Rational testRat = new Rational(2, 3);
        Rational testRat2 = new Rational(1, 5);
        Rational expected = new Rational(7, 15);
        assertTrue(expected.equals(testRat.subtract(testRat2)));
    }

    /**
     * Subtract a negative Rational from a positive Rational
     */
    @Test
    public void subtractRatNeg() {
        Rational testRat = new Rational(3, 5);
        Rational testRat2 = new Rational(-1, 5);
        Rational expected = new Rational(4, 5);
        assertTrue(expected.equals(testRat.subtract(testRat2)));
    }

    /**
     * Subtract an int from a Rational
     */
    @Test
    public void subtractInt() {
        Rational testRat = new Rational(2, 3);
        Rational expected = new Rational(-4, 3);
        assertTrue(expected.equals(testRat.subtract(2)));
    }

    /**
     * Subtract a Rational from an int
     */
    @Test
    public void subtractFromInt() {
        Rational testRat = new Rational(2, 3);
        Rational expected = new Rational(4, 3);
        assertTrue(expected.equals(testRat.subtractFrom(2)));
    }

    /**
     * Multiply two Rationals together
     */
    @Test
    public void multiplyRat() {
        Rational testRat = new Rational(2, 5);
        Rational testRat2 = new Rational(3, 7);
        Rational expected = new Rational(6, 35);
        assertTrue(expected.equals(testRat.multiply(testRat2)));
    }

    /**
     * Multiply a Rational with an int
     */
    @Test
    public void multiplyInt() {
        Rational testRat = new Rational(2, 3);
        Rational expected = new Rational(4, 3);
        assertTrue(expected.equals(testRat.multiply(2)));
    }

    /**
     * Divide one rational by another
     */
    @Test
    public void divideByRat() {
        Rational testRat = new Rational(2, 5);
        Rational testRat2 = new Rational(7, 3);
        Rational expected = new Rational(6, 35);
        assertTrue(expected.equals(testRat.divideBy(testRat2)));
    }

    /**
     * Divide a Rational by an int
     */
    @Test
    public void divideByInt() {
        Rational testRat = new Rational(2, 3);
        Rational expected = new Rational(1, 3);
        assertTrue(expected.equals(testRat.divideBy(2)));
    }

    /**
     * Divide an int by a Rational
     */
    @Test
    public void divideInt() {
        Rational testRat = new Rational(3, 2);
        Rational expected = new Rational(10, 3);
        assertTrue(expected.equals(testRat.divide(5)));
    }

    @Test
    public void string() {
        Rational testRat = new Rational(2, 3);
        assertEquals("2/3", testRat.toString());
    }

    @Test
    public void stringNeg() {
        Rational testRat = new Rational(-2, 3);
        assertEquals("-2/3", testRat.toString());
    }

}