import static org.junit.Assert.*;
import org.junit.Test;
import java.util.Arrays;

public class UtilTest {

    @Test
    public void gcd() {
        assertEquals(3, Util.gcd(6,9));
    }

    @Test
    public void lcmMax() {
        assertEquals(15, Util.lcm(3,5));
    }

    @Test
    public void lcmMultiple() {
        assertEquals(15, Util.lcm(5,15));
    }

    @Test
    public void lcmMid() {
        assertEquals(18, Util.lcm(6,9));
    }

    @Test
    public void perfectSquareWrapperTrue() {
        Rational rat = new Rational(16,25);
        ScalarWrapper wrapper = new ScalarWrapper(rat);
        assertTrue(Util.perfectSquare(wrapper));
    }

    @Test
    public void perfectSquareWrapperFalse() {
        Rational rat = new Rational(1,3);
        ScalarWrapper wrapper = new ScalarWrapper(rat);
        assertFalse(Util.perfectSquare(wrapper));
    }

    @Test
    public void perfectSquareIntTrue() {
        assertTrue(Util.perfectSquare(4));
    }

    @Test
    public void perfectSquareIntFalse() {
        assertFalse(Util.perfectSquare(3));
    }

    @Test
    public void perfectSquareDoubleTrue() {
        assertTrue(Util.perfectSquare(4.0));
    }

    @Test
    public void perfectSquareDoubleFalse() {
        assertFalse(Util.perfectSquare(1.5));
    }

    @Test
    public void perfectSquareRatTrue() {
        Rational rat = new Rational(16,25);
        assertTrue(Util.perfectSquare(rat));
    }

    @Test
    public void perfectSquareRatFalse() {
        Rational rat = new Rational(1,3);
        assertFalse(Util.perfectSquare(rat));
    }

    @Test
    public void getZeroToN() {
        int[] expected = {0,1,2,3,4};
        assertTrue(Arrays.equals(expected, Util.getZeroToN(5)));
    }

    @Test
    public void swap() {
        int[] arr = {1,4,7,0};
        Util.swap(arr,1,2);
        int[] expected = {1,7,4,0};
        assertTrue(Arrays.equals(expected, arr));
    }

    @Test
    public void firstEmptyIndex() {
        Integer[] arr = new Integer[3];
        arr[0] = 2;
        arr[2] = 1;
        Integer one = 1;
        assertEquals(one, Util.firstEmptyIndex(arr));
    }

    @Test
    public void firstEmptyIndexNull() {
        Integer[] arr = new Integer[3];
        arr[0] = 2;
        arr[1] = 4;
        arr[2] = 1;
        assertNull(Util.firstEmptyIndex(arr));
    }

}
