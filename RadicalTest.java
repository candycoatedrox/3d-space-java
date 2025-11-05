import static org.junit.Assert.*;
import org.junit.Test;

public class RadicalTest {

    @Test
    public void constructWrapper() {
        ScalarWrapper wrapper = new ScalarWrapper(2.5);
        Radical testRad = new Radical(wrapper);
        assertTrue(testRad.getInnerValue().isDouble() && testRad.getInnerValue().isValid());
        assertTrue(testRad.getInnerValue().equals(2.5));
    }

    @Test
    public void constructInt() {
        Radical testRad = new Radical(3);
        assertTrue(testRad.getInnerValue().isInt() && testRad.getInnerValue().isValid());
        assertTrue(testRad.getInnerValue().equals(3));
    }

    @Test
    public void constructDouble() {
        Radical testRad = new Radical(2.5);
        assertTrue(testRad.getInnerValue().isDouble() && testRad.getInnerValue().isValid());
        assertTrue(testRad.getInnerValue().equals(2.5));
    }

    @Test
    public void constructRat() {
        Rational rat = new Rational(1,5);
        Radical testRad = new Radical(rat);
        assertTrue(testRad.getInnerValue().isRat() && testRad.getInnerValue().isValid());
        assertTrue(testRad.getInnerValue().equals(0.2));
    }

    @Test
    public void valueSimplifiedInt() {
        Radical testRad = new Radical(4);
        ScalarWrapper value = testRad.value();

        assertTrue(value.isInt() && value.isValid());
        assertTrue(value.equals(2));
    }

    @Test
    public void valueSimplifiedDouble() {
        Radical testRad = new Radical(4.0);
        ScalarWrapper value = testRad.value();

        assertTrue(value.isInt() && value.isValid());
        assertTrue(value.equals(2));
    }

    @Test
    public void valueSimplifiedRat() {
        Rational rat = new Rational(16,25);
        Radical testRad = new Radical(rat);
        ScalarWrapper value = testRad.value();

        Rational target = new Rational(4,5);
        assertTrue(value.isRat() && value.isValid());
        assertTrue(value.equals(target));
    }

    @Test
    public void doubleValueInt() {
        Radical testRad = new Radical(4);
        assertEquals(2.0, testRad.doubleValue(), 0.01);
    }

    @Test
    public void doubleValueDouble() {
        Radical testRad = new Radical(2.25);
        assertEquals(1.5, testRad.doubleValue(), 0.01);
    }

    @Test
    public void doubleValueRat() {
        Rational rat = new Rational(16,25);
        Radical testRad = new Radical(rat);
        assertEquals(0.8, testRad.doubleValue(), 0.01);
    }

    @Test
    public void intValueInt() {
        Radical testRad = new Radical(4);
        assertEquals(2, testRad.intValue(), 0.01);
    }

    @Test
    public void intValueDouble() {
        Radical testRad = new Radical(2.25);
        assertEquals(1, testRad.intValue(), 0.01);
    }

    @Test
    public void intValueRat() {
        Rational rat = new Rational(16,25);
        Radical testRad = new Radical(rat);
        assertEquals(0, testRad.intValue(), 0.01);
    }

    @Test
    public void equalsRad() {
        Rational rat1 = new Rational(16,25);
        Radical testRad1 = new Radical(rat1);
        Rational rat2 = new Rational(16,25);
        Radical testRad2 = new Radical(rat2);

        assertTrue(testRad1.equals(testRad2));
    }

    @Test
    public void equalsWrapper() {
        Radical testRad1 = new Radical(2.25);
        ScalarWrapper wrapper = new ScalarWrapper(1.5);
        assertTrue(testRad1.equals(wrapper));
    }

    @Test
    public void equalsInt() {
        Radical testRad1 = new Radical(4);
        assertTrue(testRad1.equals(2));
    }

    @Test
    public void equalsDouble() {
        Radical testRad1 = new Radical(2.25);
        assertTrue(testRad1.equals(1.5));
    }

    @Test
    public void equalsRat() {
        Rational rat = new Rational(16,25);
        Radical testRad = new Radical(rat);
        Rational expected = new Rational(4,5);

        assertTrue(testRad.equals(expected));
    }

    // I cannot be bothered to do less than/greater than tests there's SO MANY OF THEM

    @Test
    public void multiplyRad() {
        Radical testRad1 = new Radical(3);
        Radical testRad2 = new Radical(5);
        assertTrue(testRad1.multiply(testRad2).getInnerValue().equals(15));
    }

    @Test
    public void multiplyWrapper() {
        Radical testRad = new Radical(3);
        ScalarWrapper wrapper = new ScalarWrapper(1.5);
        assertTrue(testRad.multiply(wrapper).getInnerValue().equals(6.75));
    }

    @Test
    public void multiplyInt() {
        Radical testRad = new Radical(3);
        assertTrue(testRad.multiply(2).getInnerValue().equals(12));
    }

    @Test
    public void multiplyDouble() {
        Radical testRad = new Radical(3);
        assertTrue(testRad.multiply(1.5).getInnerValue().equals(6.75));
    }

    @Test
    public void multiplyRat() {
        Radical testRad = new Radical(3);
        Rational rat = new Rational(1,5);
        Rational expected = new Rational(3,25);
        assertTrue(testRad.multiply(rat).getInnerValue().equals(expected));
    }

    @Test
    public void trueMultiplyWrapper() {
        Radical testRad = new Radical(3);
        ScalarWrapper wrapper = new ScalarWrapper(2);
        double expected = Math.sqrt(12);
        assertTrue(testRad.trueMultiply(wrapper).equals(expected));
    }

    @Test
    public void trueMultiplyInt() {
        Radical testRad = new Radical(3);
        double expected = Math.sqrt(12);
        assertTrue(testRad.trueMultiply(2).equals(expected));
    }

    @Test
    public void trueMultiplyDouble() {
        Radical testRad = new Radical(3);
        double expected = Math.sqrt(6.75);
        assertTrue(testRad.trueMultiply(1.5).equals(expected));
    }

    @Test
    public void trueMultiplyRat() {
        Radical testRad = new Radical(3);
        Rational rat = new Rational(1,5);
        Rational expectedRat = new Rational(3,25);
        double expected = expectedRat.sqrt();
        assertTrue(testRad.trueMultiply(rat).equals(expected));
    }

    @Test
    public void divideByRad() {
        Radical testRad1 = new Radical(6);
        Radical testRad2 = new Radical(3);
        assertTrue(testRad1.divideBy(testRad2).getInnerValue().equals(2));
    }

    @Test
    public void divideByWrapper() {
        Radical testRad = new Radical(18);
        ScalarWrapper wrapper = new ScalarWrapper(3);
        assertTrue(testRad.divideBy(wrapper).getInnerValue().equals(2));
    }

    @Test
    public void divideByInt() {
        Radical testRad = new Radical(18);
        assertTrue(testRad.divideBy(3).getInnerValue().equals(2));
    }

    @Test
    public void divideByDouble() {
        Radical testRad = new Radical(6.75);
        assertTrue(testRad.divideBy(1.5).getInnerValue().equals(3));
    }

    @Test
    public void divideByRat() {
        Radical testRad = new Radical(3);
        Rational rat = new Rational(3,5);
        Rational expected = new Rational(25,3);
        assertTrue(testRad.divideBy(rat).getInnerValue().equals(expected));
    }

    @Test
    public void trueDivideByWrapper() {
        Radical testRad = new Radical(18);
        ScalarWrapper wrapper = new ScalarWrapper(3);
        double expected = Math.sqrt(2);
        assertTrue(testRad.trueDivideBy(wrapper).equals(expected));
    }

    @Test
    public void trueDivideByInt() {
        Radical testRad = new Radical(18);
        double expected = Math.sqrt(2);
        assertTrue(testRad.trueDivideBy(3).equals(expected));
    }

    @Test
    public void trueDivideByDouble() {
        Radical testRad = new Radical(6.75);
        double expected = Math.sqrt(3);
        assertTrue(testRad.trueDivideBy(1.5).equals(expected));
    }

    @Test
    public void trueDivideByRat() {
        Radical testRad = new Radical(3);
        Rational rat = new Rational(3,5);
        Rational expectedRat = new Rational(25,3);
        double expected = expectedRat.sqrt();
        assertTrue(testRad.trueDivideBy(rat).equals(expected));
    }

    @Test
    public void string() {
        Radical testRad = new Radical(3);
        assertEquals(testRad.toString(), "√3");
    }

}
