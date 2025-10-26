import static org.junit.Assert.*;
import org.junit.Test;

public class UtilTest {

    @Test
    public void firstEmptyIndexObject() {
        Integer[] arr = new Integer[3];
        arr[0] = 2;
        arr[2] = 1;
        Integer one = 1;
        assertEquals(one, Util.firstEmptyIndex(arr));
    }

}
