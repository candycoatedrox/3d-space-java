public class Matrix2x2Test {
    
    public static void main(String[] args) {
        Matrix2x2 m = new Matrix2x2(-0.5,1,0,0.5);
        Matrix2x2 n = new Matrix2x2(1,8,6,0);

        System.out.println(m.multiply(n));
    }

}
