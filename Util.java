
public class Util {

    /**
     * Calculates n-factorial (n!), or the product of all integers 1 <= i <= n
     * @param n the integer to take the factorial of
     * @return n-factorial (n!)
     */
    public static int factorial(int n) {
        if (n < 1) {
            throw new IllegalArgumentException("n must be positive");
        }

        int result = 1;
        for (int factor = 2; factor <= n; factor++) {
            result *= factor;
        }

        return result;
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

    /**
     * Checks whether a ScalarWrapper is a perfect square
     * @param a the ScalarWrapper to check
     * @return true if a is a perfect square; false otherwise
     */
    public static boolean perfectSquare(ScalarWrapper a) {
        if (a.isInt()) {
            return perfectSquare(a.getInt());
        } else if (a.isDouble()) {
            return perfectSquare(a.getDouble());
        } else {
            return perfectSquare(a.getRat());
        }
    }
    
    /**
     * Checks whether an int is a perfect square
     * @param a the int to check
     * @return true if a is a perfect square; false otherwise
     */
    public static boolean perfectSquare(int a) {
        double root = Math.sqrt(a);
        return root % 1 == 0;
    }

    /**
     * Checks whether an Integer is a perfect square
     * @param a the Integer to check
     * @return true if a is a perfect square; false otherwise
     */
    public static boolean perfectSquare(Integer a) {
        return perfectSquare(a.intValue());
    }

    /**
     * Checks whether a double is a perfect square
     * @param a the double to check
     * @return true if a is a perfect square; false otherwise
     */
    public static boolean perfectSquare(double a) {
        double root = Math.sqrt(a);
        return root % 1 == 0;
    }

    /**
     * Checks whether a Double is a perfect square
     * @param a the Double to check
     * @return true if a is a perfect square; false otherwise
     */
    public static boolean perfectSquare(Double a) {
        return perfectSquare(a.doubleValue());
    }

    /**
     * Checks whether a Rational is a perfect square
     * @param a the Rational to check
     * @return true if a is a perfect square; false otherwise
     */
    public static boolean perfectSquare(Rational a) {
        double nRoot = Math.sqrt(a.getNumerator());
        double dRoot = Math.sqrt(a.getDenominator());
        return (nRoot % 1 == 0 && dRoot % 1 == 0);
    }

    /**
     * Creates and returns a deep copy of a given Integer
     * @param i the Integer to copy
     * @return a deep copy of i
     */
    public static Integer deepCopy(Integer i) {
        if (i == null) {
            return null;
        } else {
            int intValue = i.intValue();
            Integer copy = intValue;
            return copy;
        }
    }

    /**
     * Creates and returns a deep copy of a given Double
     * @param d the Double to copy
     * @return a deep copy of d
     */
    public static Double deepCopy(Double d) {
        if (d == null) {
            return null;
        } else {
            double doubleValue = d.doubleValue();
            Double copy = doubleValue;
            return copy;
        }
    }

    /**
     * Fallback method; returns the clone of an array of class T if deepCopy() is not defined for T[]
     * @param <T> the class of Object in the array
     * @param arr the array to copy
     * @return a clone of arr
     */
    public static <T> T[] deepCopy(T[] arr) {
        return arr.clone();
    }

    /**
     * Creates and returns a deep copy of a given array of ScalarWrappers
     * @param arr the array to copy
     * @return a deep copy of arr
     */
    public static ScalarWrapper[] deepCopy(ScalarWrapper[] arr) {
        ScalarWrapper[] copy = new ScalarWrapper[arr.length];
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == null) {
                copy[i] = null;
            } else {
                copy[i] = arr[i].clone();
            }
        }

        return copy;
    }

    /**
     * Creates and returns a deep copy of a given array of Integers
     * @param arr the array to copy
     * @return a deep copy of arr
     */
    public static Integer[] deepCopy(Integer[] arr) {
        Integer[] copy = new Integer[arr.length];

        for (int i = 0; i < arr.length; i++) {
            copy[i] = deepCopy(arr[i]);
        }

        return copy;
    }

    /**
     * Creates and returns a deep copy of a given array of Doubles
     * @param arr the array to copy
     * @return a deep copy of arr
     */
    public static Double[] deepCopy(Double[] arr) {
        Double[] copy = new Double[arr.length];
        
        for (int i = 0; i < arr.length; i++) {
            copy[i] = deepCopy(arr[i]);
        }

        return copy;
    }

    /**
     * Creates and returns a deep copy of a given array of Rationals
     * @param arr the array to copy
     * @return a deep copy of arr
     */
    public static Rational[] deepCopy(Rational[] arr) {
        Rational[] copy = new Rational[arr.length];
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == null) {
                copy[i] = null;
            } else {
                copy[i] = arr[i].clone();
            }
        }

        return copy;
    }

    /**
     * Creates and returns a deep copy of a given array of Radicals
     * @param arr the array to copy
     * @return a deep copy of arr
     */
    public static Radical[] deepCopy(Radical[] arr) {
        Radical[] copy = new Radical[arr.length];
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == null) {
                copy[i] = null;
            } else {
                copy[i] = arr[i].clone();
            }
        }

        return copy;
    }

    /**
     * Returns the array of all integers from 0 to n-1
     * @param n the length of the resulting array
     * @return the array of all integers from 0 to n-1
     */
    public static int[] getZeroToN(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }

        return arr;
    }

    /**
     * Swaps two elements in an array of ints
     * @param arr the array to modify
     * @param i the index of the first element to swap
     * @param j the index of the second element to swap
     */
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * Swaps two elements in an array of doubles
     * @param arr the array to modify
     * @param i the index of the first element to swap
     * @param j the index of the second element to swap
     */
    public static void swap(double[] arr, int i, int j) {
        double temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * Swaps two elements in an array of Objects
     * @param <T> the class of Object in the array
     * @param arr the array to modify
     * @param i the index of the first element to swap
     * @param j the index of the second element to swap
     */
    public static <T> void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    /**
     * Returns the first empty index of an array of Objects
     * @param arr the array to check
     * @return the first empty index of arr, or null if all indices are filled
     */
    public static Integer firstEmptyIndex(Object[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == null) {
                return i;
            }
        }

        return null;
    }

    /* public static boolean orderIsEven(ScalarWrapper[] targetOrder) {

    } */

}
