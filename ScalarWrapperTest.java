import static org.junit.Assert.*;
import org.junit.Test;

public class ScalarWrapperTest {

    @Test
    public void wrapCompoundInt() {
        Double nDouble = null;
        Rational nRat = null;
        ScalarWrapper testWrapper = new ScalarWrapper(3, nDouble, nRat);
        assertTrue(testWrapper.isInt() && testWrapper.isValid());
        assertEquals(3, testWrapper.getInt(), 0.01);
    }

    @Test
    public void wrapCompoundDouble() {
        Integer nInt = null;
        Rational nRat = null;
        ScalarWrapper testWrapper = new ScalarWrapper(nInt, 2.5, nRat);
        assertTrue(testWrapper.isDouble() && testWrapper.isValid());
        assertEquals(2.5, testWrapper.getDouble(), 0.01);
    }

    @Test
    public void wrapCompoundRat() {
        Integer nInt = null;
        Double nDouble = null;
        Rational rat = new Rational(1,5);
        ScalarWrapper testWrapper = new ScalarWrapper(nInt, nDouble, rat);
        assertTrue(testWrapper.isRat() && testWrapper.isValid());
        assertEquals(testWrapper.toString(), "1/5");
    }

    @Test
    public void wrapCompoundNone() {
        Integer nInt = null;
        Double nDouble = null;
        Rational nRat = null;

        boolean thrown = false;
        try {
            ScalarWrapper testWrapper = new ScalarWrapper(nInt, nDouble, nRat);
        } catch (NullPointerException e) {
            thrown = true;
        }

        assertTrue(thrown);
    }

    @Test
    public void wrapCompoundMultiple() {
        Integer nInt = 3;
        Double nDouble = 2.5;
        Rational nRat = null;

        boolean thrown = false;
        try {
            ScalarWrapper testWrapper = new ScalarWrapper(nInt, nDouble, nRat);
        } catch (RuntimeException e) {
            thrown = true;
        }

        assertTrue(thrown);
    }

    @Test
    public void wrapInt() {
        ScalarWrapper testWrapper = new ScalarWrapper(3);
        assertTrue(testWrapper.isInt() && testWrapper.isValid());
        assertEquals(3, testWrapper.getInt(), 0.01);
    }

    @Test
    public void wrapDouble() {
        ScalarWrapper testWrapper = new ScalarWrapper(2.5);
        assertTrue(testWrapper.isDouble() && testWrapper.isValid());
        assertEquals(2.5, testWrapper.getDouble(), 0.01);
    }

    @Test
    public void wrapRat() {
        Rational rat = new Rational(1,5);
        ScalarWrapper testWrapper = new ScalarWrapper(rat);
        assertTrue(testWrapper.isRat() && testWrapper.isValid());
        assertEquals(testWrapper.toString(), "1/5");
    }

    @Test
    public void wrapRad() {
        Radical rad = new Radical(4);
        ScalarWrapper testWrapper = new ScalarWrapper(rad);
        assertTrue(testWrapper.isInt() && testWrapper.isValid());
        assertEquals(2, testWrapper.getInt(), 0.01);
    }

    @Test
    public void setWrapper() {
        ScalarWrapper testWrapper = new ScalarWrapper(3);
        ScalarWrapper target = new ScalarWrapper(2.5);

        testWrapper.set(target);
        assertTrue(testWrapper.isDouble() && testWrapper.isValid());
        assertEquals(2.5, testWrapper.getDouble(), 0.01);
    }

    @Test
    public void setInt() {
        ScalarWrapper testWrapper = new ScalarWrapper(2.5);

        testWrapper.set(3);
        assertTrue(testWrapper.isInt() && testWrapper.isValid());
        assertEquals(3, testWrapper.getInt(), 0.01);
    }

    @Test
    public void setDouble() {
        ScalarWrapper testWrapper = new ScalarWrapper(3);

        testWrapper.set(2.5);
        assertTrue(testWrapper.isDouble() && testWrapper.isValid());
        assertEquals(2.5, testWrapper.getDouble(), 0.01);
    }

    @Test
    public void setRat() {
        ScalarWrapper testWrapper = new ScalarWrapper(2.5);

        Rational rat = new Rational(1,5);
        testWrapper.set(rat);
        assertTrue(testWrapper.isRat() && testWrapper.isValid());
        assertEquals(testWrapper.toString(), "1/5");
    }

    @Test
    public void setRad() {
        ScalarWrapper testWrapper = new ScalarWrapper(2.5);

        Radical rad = new Radical(4);
        testWrapper.set(rad);
        assertTrue(testWrapper.isInt() && testWrapper.isValid());
        assertEquals(2, testWrapper.getInt(), 0.01);
    }

    @Test
    public void isWholeInt() {
        ScalarWrapper testWrapper = new ScalarWrapper(3);
        assertTrue(testWrapper.isWhole());
    }

    @Test
    public void isWholeDoubleTrue() {
        ScalarWrapper testWrapper = new ScalarWrapper(2.0);
        assertTrue(testWrapper.isWhole());
    }

    @Test
    public void isWholeDoubleFalse() {
        ScalarWrapper testWrapper = new ScalarWrapper(2.5);
        assertFalse(testWrapper.isWhole());
    }

    @Test
    public void isWholeRatTrue() {
        Rational rat = new Rational(10,5);
        ScalarWrapper testWrapper = new ScalarWrapper(rat);
        assertTrue(testWrapper.isWhole());
    }

    @Test
    public void isWholeRatFalse() {
        Rational rat = new Rational(1,5);
        ScalarWrapper testWrapper = new ScalarWrapper(rat);
        assertFalse(testWrapper.isWhole());
    }

    @Test
    public void reduceInt() {
        ScalarWrapper testWrapper = new ScalarWrapper(3);
        testWrapper.reduce();
        assertTrue(testWrapper.equals(3));
    }

    @Test
    public void reduceDouble() {
        ScalarWrapper testWrapper = new ScalarWrapper(2.5);
        testWrapper.reduce();
        assertTrue(testWrapper.equals(2.5));
    }

    @Test
    public void reduceRat() {
        Rational rat = new Rational(2,4,"DEBUG");
        ScalarWrapper testWrapper = new ScalarWrapper(rat);
        testWrapper.reduce();
        assertEquals(testWrapper.toString(), "1/2");
    }

    @Test
    public void simplifyInt() {
        ScalarWrapper testWrapper = new ScalarWrapper(3);
        testWrapper.simplify();
        assertTrue(testWrapper.equals(3));
    }

    @Test
    public void simplifyRatNoChange() {
        Rational rat = new Rational(1,5);
        ScalarWrapper testWrapper = new ScalarWrapper(rat);
        testWrapper.simplify();
        assertTrue(testWrapper.isRat() && testWrapper.isValid());
        assertEquals(testWrapper.toString(), "1/5");
    }

    @Test
    public void simplifyRatReduce() {
        Rational rat = new Rational(2,10,"DEBUG");
        ScalarWrapper testWrapper = new ScalarWrapper(rat);
        testWrapper.simplify();
        assertTrue(testWrapper.isRat() && testWrapper.isValid());
        assertEquals(testWrapper.toString(), "1/5");
    }

    @Test
    public void simplifyRatToInt() {
        Rational rat = new Rational(15,5);
        ScalarWrapper testWrapper = new ScalarWrapper(rat);
        testWrapper.simplify();
        assertTrue(testWrapper.isInt() && testWrapper.isValid());
        assertTrue(testWrapper.equals(3));
    }

    @Test
    public void simplifyDoubleNoChange() {
        ScalarWrapper testWrapper = new ScalarWrapper(Vector.PI);
        testWrapper.simplify();
        assertTrue(testWrapper.isDouble() && testWrapper.isValid());
        assertTrue(testWrapper.equals(Vector.PI));
    }

    @Test
    public void simplifyDoubleToRat() {
        ScalarWrapper testWrapper = new ScalarWrapper(2.5);
        testWrapper.simplify();
        assertTrue(testWrapper.isRat() && testWrapper.isValid());
        assertEquals(testWrapper.toString(), "5/2");
    }

    @Test
    public void simplifyDoubleToInt() {
        ScalarWrapper testWrapper = new ScalarWrapper(4.0);
        testWrapper.simplify();
        assertTrue(testWrapper.isInt() && testWrapper.isValid());
        assertTrue(testWrapper.equals(4));
    }

    @Test
    public void intValueInt() {
        ScalarWrapper testWrapper = new ScalarWrapper(3);
        assertEquals(3, testWrapper.intValue(), 0.01);
    }

    @Test
    public void intValueDouble() {
        ScalarWrapper testWrapper = new ScalarWrapper(2.5);
        assertEquals(2, testWrapper.intValue(), 0.01);
    }

    @Test
    public void intValueRat() {
        Rational rat = new Rational(3,2);
        ScalarWrapper testWrapper = new ScalarWrapper(rat);
        assertEquals(1, testWrapper.intValue(), 0.01);
    }

    @Test
    public void doubleValueInt() {
        ScalarWrapper testWrapper = new ScalarWrapper(3);
        assertEquals(3, testWrapper.doubleValue(), 0.01);
    }

    @Test
    public void doubleValueDouble() {
        ScalarWrapper testWrapper = new ScalarWrapper(2.5);
        assertEquals(2.5, testWrapper.doubleValue(), 0.01);
    }

    @Test
    public void convertToDoubleRat() {
        Rational rat = new Rational(1,5);
        ScalarWrapper testWrapper = new ScalarWrapper(rat);
        assertEquals(0.2, testWrapper.doubleValue(), 0.01);
    }

    @Test
    public void ratValueInt() {
        ScalarWrapper testWrapper = new ScalarWrapper(3);
        assertEquals(testWrapper.ratValue().toString(), "3/1");
    }

    @Test
    public void ratValueDouble() {
        ScalarWrapper testWrapper = new ScalarWrapper(2.5);
        assertEquals(testWrapper.ratValue().toString(), "5/2");
    }

    @Test
    public void ratValueRat() {
        Rational rat = new Rational(1,5);
        ScalarWrapper testWrapper = new ScalarWrapper(rat);
        assertEquals(testWrapper.ratValue().toString(), "1/5");
    }

    @Test
    public void convertToIntOrRatInt() {
        ScalarWrapper testWrapper = new ScalarWrapper(3);
        testWrapper.convertToIntOrRat();
        assertTrue(testWrapper.isInt() && testWrapper.isValid());
        assertTrue(testWrapper.equals(3));
    }

    @Test
    public void convertToIntOrRatRatNoChange() {
        Rational rat = new Rational(1,5);
        ScalarWrapper testWrapper = new ScalarWrapper(rat);
        testWrapper.convertToIntOrRat();
        assertTrue(testWrapper.isRat() && testWrapper.isValid());
        assertEquals(testWrapper.toString(), "1/5");
    }

    @Test
    public void convertToIntOrRatRatToInt() {
        Rational rat = new Rational(15,5);
        ScalarWrapper testWrapper = new ScalarWrapper(rat);
        testWrapper.convertToIntOrRat();
        assertTrue(testWrapper.isInt() && testWrapper.isValid());
        assertTrue(testWrapper.equals(3));
    }

    @Test
    public void convertToIntOrRatDoubleToRat() {
        ScalarWrapper testWrapper = new ScalarWrapper(2.5);
        testWrapper.convertToIntOrRat();
        assertTrue(testWrapper.isRat() && testWrapper.isValid());
        assertEquals(testWrapper.toString(), "5/2");
    }

    @Test
    public void convertToIntOrRatDoubleToInt() {
        ScalarWrapper testWrapper = new ScalarWrapper(3.0);
        testWrapper.convertToIntOrRat();
        assertTrue(testWrapper.isInt() && testWrapper.isValid());
        assertTrue(testWrapper.equals(3));
    }

    @Test
    public void negativeInt() {
        ScalarWrapper testWrapper = new ScalarWrapper(3);
        assertTrue(testWrapper.negative().equals(-3));
    }

    @Test
    public void negativeDouble() {
        ScalarWrapper testWrapper = new ScalarWrapper(2.5);
        assertTrue(testWrapper.negative().equals(-2.5));
    }

    @Test
    public void negativeRat() {
        Rational rat = new Rational(1,5);
        ScalarWrapper testWrapper = new ScalarWrapper(rat);
        assertEquals(testWrapper.negative().toString(), "-1/5");
    }

    @Test
    public void absoluteIntPos() {
        ScalarWrapper testWrapper = new ScalarWrapper(3);
        assertTrue(testWrapper.absolute().equals(3));
    }

    @Test
    public void absoluteIntNeg() {
        ScalarWrapper testWrapper = new ScalarWrapper(-3);
        assertTrue(testWrapper.absolute().equals(3));
    }

    @Test
    public void absoluteDoublePos() {
        ScalarWrapper testWrapper = new ScalarWrapper(2.5);
        assertTrue(testWrapper.absolute().equals(2.5));
    }

    @Test
    public void absoluteDoubleNeg() {
        ScalarWrapper testWrapper = new ScalarWrapper(-2.5);
        assertTrue(testWrapper.absolute().equals(2.5));
    }

    @Test
    public void absoluteRatPos() {
        Rational rat = new Rational(1,5);
        ScalarWrapper testWrapper = new ScalarWrapper(rat);
        assertEquals(testWrapper.absolute().toString(), "1/5");
    }

    @Test
    public void absoluteRatNeg() {
        Rational rat = new Rational(1,5);
        ScalarWrapper testWrapper = new ScalarWrapper(rat);
        assertEquals(testWrapper.absolute().toString(), "1/5");
    }

    @Test
    public void equalsOtherScalarWrapperTrue() {
        ScalarWrapper testWrapper1 = new ScalarWrapper(2.5);
        Rational rat = new Rational(5,2);
        ScalarWrapper testWrapper2 = new ScalarWrapper(rat);
        assertTrue(testWrapper1.equals(testWrapper2));
    }

    @Test
    public void equalsOtherScalarWrapperFalse() {
        ScalarWrapper testWrapper1 = new ScalarWrapper(2.5);
        Rational rat = new Rational(8,3);
        ScalarWrapper testWrapper2 = new ScalarWrapper(rat);
        assertFalse(testWrapper1.equals(testWrapper2));
    }

    @Test
    public void equalsOtherIntTrue() {
        ScalarWrapper testWrapper1 = new ScalarWrapper(2.0);
        assertTrue(testWrapper1.equals(2));
    }

    @Test
    public void equalsOtherIntFalse() {
        ScalarWrapper testWrapper1 = new ScalarWrapper(2.0);
        assertFalse(testWrapper1.equals(3));
    }

    @Test
    public void equalsOtherDoubleTrue() {
        ScalarWrapper testWrapper1 = new ScalarWrapper(2);
        assertTrue(testWrapper1.equals(2.0));
    }

    @Test
    public void equalsOtherDoubleFalse() {
        ScalarWrapper testWrapper1 = new ScalarWrapper(2);
        assertFalse(testWrapper1.equals(3.0));
    }

    @Test
    public void equalsOtherRatTrue() {
        ScalarWrapper testWrapper1 = new ScalarWrapper(2.5);
        Rational rat = new Rational(5,2);
        assertTrue(testWrapper1.equals(rat));
    }

    @Test
    public void equalsOtherRatFalse() {
        ScalarWrapper testWrapper1 = new ScalarWrapper(2.5);
        Rational rat = new Rational(8,3);
        assertFalse(testWrapper1.equals(rat));
    }

    @Test
    public void lessThanOtherScalarWrapperTrue() {
        ScalarWrapper testWrapper1 = new ScalarWrapper(2.5);
        Rational rat = new Rational(7,2);
        ScalarWrapper testWrapper2 = new ScalarWrapper(rat);
        assertTrue(testWrapper1.lessThan(testWrapper2));
    }

    @Test
    public void lessThanOtherScalarWrapperFalse() {
        ScalarWrapper testWrapper1 = new ScalarWrapper(2.5);
        Rational rat = new Rational(5,2);
        ScalarWrapper testWrapper2 = new ScalarWrapper(rat);
        assertFalse(testWrapper1.lessThan(testWrapper2));
    }

    @Test
    public void lessThanOtherIntTrue() {
        ScalarWrapper testWrapper1 = new ScalarWrapper(2.0);
        assertTrue(testWrapper1.lessThan(3));
    }

    @Test
    public void lessThanOtherIntFalse() {
        ScalarWrapper testWrapper1 = new ScalarWrapper(2.0);
        assertFalse(testWrapper1.lessThan(2));
    }

    @Test
    public void lessThanOtherDoubleTrue() {
        ScalarWrapper testWrapper1 = new ScalarWrapper(2);
        assertTrue(testWrapper1.lessThan(3.0));
    }

    @Test
    public void lessThanOtherDoubleFalse() {
        ScalarWrapper testWrapper1 = new ScalarWrapper(2);
        assertFalse(testWrapper1.lessThan(2.0));
    }

    @Test
    public void lessThanOtherRatTrue() {
        ScalarWrapper testWrapper1 = new ScalarWrapper(2.5);
        Rational rat = new Rational(7,2);
        assertTrue(testWrapper1.lessThan(rat));
    }

    @Test
    public void lessThanOtherRatFalse() {
        ScalarWrapper testWrapper1 = new ScalarWrapper(2.5);
        Rational rat = new Rational(5,2);
        assertFalse(testWrapper1.lessThan(rat));
    }

    // fill in lessThanOrEquals, greaterThan, greaterThanOrEquals tests here!!!

    @Test
    public void addWrapper() {
        ScalarWrapper testWrapper1 = new ScalarWrapper(3);
        ScalarWrapper testWrapper2 = new ScalarWrapper(2.5);
        assertTrue(testWrapper1.add(testWrapper2).equals(5.5));
    }

    @Test
    public void addInt() {
        ScalarWrapper testWrapper1 = new ScalarWrapper(2.5);
        assertTrue(testWrapper1.add(3).equals(5.5));
    }

    @Test
    public void addDouble() {
        ScalarWrapper testWrapper1 = new ScalarWrapper(3);
        assertTrue(testWrapper1.add(2.5).equals(5.5));
    }

    @Test
    public void addRat() {
        ScalarWrapper testWrapper1 = new ScalarWrapper(2.5);
        Rational rat = new Rational(1,5);
        assertTrue(testWrapper1.add(rat).equals(2.7));
    }

    @Test
    public void subtractWrapper() {
        ScalarWrapper testWrapper1 = new ScalarWrapper(3);
        ScalarWrapper testWrapper2 = new ScalarWrapper(2.5);
        assertTrue(testWrapper1.subtract(testWrapper2).equals(0.5));
    }

    @Test
    public void subtractInt() {
        ScalarWrapper testWrapper1 = new ScalarWrapper(2.5);
        assertTrue(testWrapper1.subtract(2).equals(0.5));
    }

    @Test
    public void subtractDouble() {
        ScalarWrapper testWrapper1 = new ScalarWrapper(3);
        assertTrue(testWrapper1.subtract(2.5).equals(0.5));
    }

    @Test
    public void subtractRat() {
        ScalarWrapper testWrapper1 = new ScalarWrapper(2.5);
        Rational rat = new Rational(1,5);
        assertTrue(testWrapper1.subtract(rat).equals(2.3));
    }

    @Test
    public void subtractFromWrapper() {
        ScalarWrapper testWrapper1 = new ScalarWrapper(2.5);
        ScalarWrapper testWrapper2 = new ScalarWrapper(3);
        assertTrue(testWrapper1.subtractFrom(testWrapper2).equals(0.5));
    }

    @Test
    public void subtractFromInt() {
        ScalarWrapper testWrapper1 = new ScalarWrapper(2.5);
        assertTrue(testWrapper1.subtractFrom(3).equals(0.5));
    }

    @Test
    public void subtractFromDouble() {
        ScalarWrapper testWrapper1 = new ScalarWrapper(2);
        assertTrue(testWrapper1.subtractFrom(2.5).equals(0.5));
    }

    @Test
    public void subtractFromRat() {
        ScalarWrapper testWrapper1 = new ScalarWrapper(0.5);
        Rational rat = new Rational(3,2);
        assertTrue(testWrapper1.subtractFrom(rat).equals(1));
    }

    @Test
    public void multiplyWrapper() {
        ScalarWrapper testWrapper1 = new ScalarWrapper(2.5);
        ScalarWrapper testWrapper2 = new ScalarWrapper(3);
        assertTrue(testWrapper1.multiply(testWrapper2).equals(7.5));
    }

    @Test
    public void multiplyInt() {
        ScalarWrapper testWrapper1 = new ScalarWrapper(2.5);
        assertTrue(testWrapper1.multiply(3).equals(7.5));
    }

    @Test
    public void multiplyDouble() {
        ScalarWrapper testWrapper1 = new ScalarWrapper(2);
        assertTrue(testWrapper1.multiply(2.5).equals(5));
    }

    @Test
    public void multiplyRat() {
        ScalarWrapper testWrapper1 = new ScalarWrapper(2);
        Rational rat = new Rational(5,2);
        assertTrue(testWrapper1.multiply(rat).equals(5));
    }

    @Test
    public void divideByWrapper() {
        ScalarWrapper testWrapper1 = new ScalarWrapper(3);
        ScalarWrapper testWrapper2 = new ScalarWrapper(1.5);
        assertTrue(testWrapper1.divideBy(testWrapper2).equals(2));
    }

    @Test
    public void divideByInt() {
        ScalarWrapper testWrapper1 = new ScalarWrapper(1.5);
        assertTrue(testWrapper1.divideBy(3).equals(0.5));
    }

    @Test
    public void divideByDouble() {
        ScalarWrapper testWrapper1 = new ScalarWrapper(5);
        assertTrue(testWrapper1.divideBy(2.5).equals(2));
    }

    @Test
    public void divideByRat() {
        ScalarWrapper testWrapper1 = new ScalarWrapper(3);
        Rational rat = new Rational(3,2);
        assertTrue(testWrapper1.divideBy(rat).equals(2));
    }

    @Test
    public void divideWrapper() {
        ScalarWrapper testWrapper1 = new ScalarWrapper(1.5);
        ScalarWrapper testWrapper2 = new ScalarWrapper(3);
        assertTrue(testWrapper1.divide(testWrapper2).equals(2));
    }

    @Test
    public void divideInt() {
        ScalarWrapper testWrapper1 = new ScalarWrapper(1.5);
        assertTrue(testWrapper1.divide(3).equals(2));
    }

    @Test
    public void divideDouble() {
        ScalarWrapper testWrapper1 = new ScalarWrapper(3);
        assertTrue(testWrapper1.divide(1.5).equals(0.5));
    }

    @Test
    public void divideRat() {
        ScalarWrapper testWrapper1 = new ScalarWrapper(2);
        Rational rat = new Rational(5,2);
        assertEquals(testWrapper1.divide(rat).toString(), "5/4");
    }

    @Test
    public void modWrapper() {
        ScalarWrapper testWrapper1 = new ScalarWrapper(3.5);
        ScalarWrapper testWrapper2 = new ScalarWrapper(3);
        assertTrue(testWrapper1.mod(testWrapper2).equals(0.5));
    }

    @Test
    public void modInt() {
        ScalarWrapper testWrapper1 = new ScalarWrapper(3.5);
        assertTrue(testWrapper1.mod(3).equals(0.5));
    }

    @Test
    public void modDouble() {
        ScalarWrapper testWrapper1 = new ScalarWrapper(3);
        assertTrue(testWrapper1.mod(0.4).equals(3 % 0.4));
    }

    @Test
    public void modRat() {
        ScalarWrapper testWrapper1 = new ScalarWrapper(2);
        Rational rat = new Rational(3,2);
        assertEquals(testWrapper1.mod(rat).toString(), "1/2");
    }

    @Test
    public void squaredInt() {
        ScalarWrapper testWrapper = new ScalarWrapper(2);
        assertTrue(testWrapper.squared().equals(4));
    }

    @Test
    public void squaredDouble() {
        ScalarWrapper testWrapper = new ScalarWrapper(1.5);
        assertTrue(testWrapper.squared().equals(2.25));
    }

    @Test
    public void squaredRat() {
        Rational rat = new Rational(4,5);
        ScalarWrapper testWrapper = new ScalarWrapper(rat);
        Rational expected = new Rational(16,25);
        assertEquals(testWrapper.squared().toString(), "16/25");
    }

    @Test
    public void sqrtInt() {
        ScalarWrapper testWrapper = new ScalarWrapper(4);
        assertEquals(2.0, testWrapper.sqrt(), 0.01);
    }

    @Test
    public void sqrtDouble() {
        ScalarWrapper testWrapper = new ScalarWrapper(2.25);
        assertEquals(1.5, testWrapper.sqrt(), 0.01);
    }

    @Test
    public void sqrtRat() {
        Rational rat = new Rational(16,25);
        ScalarWrapper testWrapper = new ScalarWrapper(rat);
        assertEquals(0.8, testWrapper.sqrt(), 0.01);
    }

    @Test
    public void rootIntWhole() {
        ScalarWrapper testWrapper = new ScalarWrapper(4);
        ScalarWrapper root = testWrapper.root();
        assertTrue(root.isInt());
        assertTrue(root.equals(2));
    }

    @Test
    public void rootIntDouble() {
        ScalarWrapper testWrapper = new ScalarWrapper(2);
        ScalarWrapper root = testWrapper.root();
        double expected = Math.sqrt(2);
        assertTrue(root.equals(expected));
    }

    @Test
    public void rootDoubleWhole() {
        ScalarWrapper testWrapper = new ScalarWrapper(4.0);
        ScalarWrapper root = testWrapper.root();
        assertTrue(root.isInt());
        assertTrue(root.equals(2));
    }

    @Test
    public void rootDoubleDouble() {
        ScalarWrapper testWrapper = new ScalarWrapper(2.5);
        ScalarWrapper root = testWrapper.root();
        double expected = Math.sqrt(2.5);
        assertTrue(root.equals(expected));
    }

    @Test
    public void rootDoubleRat() {
        ScalarWrapper testWrapper = new ScalarWrapper(2.25);
        ScalarWrapper root = testWrapper.root();
        assertEquals(root.toString(), "3/2");
    }

    @Test
    public void rootRatWhole() {
        Rational rat = new Rational(4,1);
        ScalarWrapper testWrapper = new ScalarWrapper(rat);
        ScalarWrapper root = testWrapper.root();
        assertTrue(root.isInt());
        assertTrue(root.equals(2));
    }

    @Test
    public void rootRatDouble() {
        Rational rat = new Rational(5,2);
        ScalarWrapper testWrapper = new ScalarWrapper(rat);
        ScalarWrapper root = testWrapper.root();
        double expected = Math.sqrt(2.5);
        assertTrue(root.equals(expected));
    }

    @Test
    public void rootRatRat() {
        Rational rat = new Rational(16,25);
        ScalarWrapper testWrapper = new ScalarWrapper(rat);
        ScalarWrapper root = testWrapper.root();
        assertEquals(root.toString(), "4/5");
    }

    @Test
    public void deepCopy() {
        Rational rat = new Rational(4,5);
        ScalarWrapper testWrapper = new ScalarWrapper(rat);
        ScalarWrapper clone = testWrapper.clone();
        clone.set(3);
        assertFalse(testWrapper.equals(clone));
    }

}
