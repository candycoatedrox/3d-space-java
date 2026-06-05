import java.util.ArrayList;
import java.util.Arrays;

public class ArrayPermutation {

    /**
     * Returns an ArrayList containing all permutations of an array of ints, including duplicates
     * @param arr the array to permute
     * @return all permutations of arr, including duplicates
     */
    public static ArrayList<int[]> permutations(int[] arr) {
        ArrayList<int[]> permutations = new ArrayList<>();
        return permute(arr, permutations, 0);
    }

    /**
     * Recursively permutes an array of ints until it has an ArrayList of all permutations of the array, including duplicates
     * @param arr the array to permute at this level of recursion
     * @param permutations the ArrayList of permutations
     * @param start the index to begin permuting arr at at this level of recursion
     * @return all permutations of arr found so far, including duplicates
     */
    private static ArrayList<int[]> permute(int[] arr, ArrayList<int[]> permutations, int start) {
        int[] permutation = Arrays.copyOf(arr, arr.length);

        for (int i = start; i < arr.length; i++) {
            Util.swap(permutation, start, i);
            permutations = permute(permutation, permutations, start + 1);
            Util.swap(permutation, start, i);
        }

        if (start == arr.length - 1) {
            permutations.add(permutation);
        }

        return permutations;
    }

    /**
     * Returns an ArrayList containing all unique permutations of an array of ints
     * @param arr the array to permute
     * @return all unique permutations of arr
     */
    public static ArrayList<int[]> uniquePermutations(int[] arr) {
        ArrayList<int[]> permutations = new ArrayList<>();
        return permuteUnique(arr, permutations, 0);
    }

    /**
     * Recursively permutes an array of ints until it has an ArrayList of all unique permutations of the array
     * @param arr the array to permute at this level of recursion
     * @param permutations the ArrayList of permutations
     * @param start the index to begin permuting arr at at this level of recursion
     * @return all unique permutations of arr found so far
     */
    private static ArrayList<int[]> permuteUnique(int[] arr, ArrayList<int[]> permutations, int start) {
        int[] permutation = Arrays.copyOf(arr, arr.length);

        for (int i = start; i < arr.length; i++) {
            Util.swap(permutation, start, i);
            permutations = permute(permutation, permutations, start + 1);
            Util.swap(permutation, start, i);
        }

        if (start == arr.length - 1) {
            if (!containsPermutation(permutations, permutation)) {
                permutations.add(permutation);
            }
        }

        return permutations;
    }

    /**
     * Checks if an ArrayList of permutations of an array of ints already contains a given permutation
     * @param list the ArrayList of permutations to check
     * @param perm the permutation to check for
     * @return true if list contains an identical permutation to perm; false otherwise
     */
    private static boolean containsPermutation(ArrayList<int[]> list, int[] perm) {
        for (int i = 0; i < list.size(); i++) {
            if (Arrays.equals(list.get(i), perm)) {
                return true;
            }
        }

        return false;
    }

    /**
     * Returns an ArrayList containing all permutations of an array of doubles, including duplicates
     * @param arr the array to permute
     * @return all permutations of arr, including duplicates
     */
    public static ArrayList<double[]> permutations(double[] arr) {
        ArrayList<double[]> permutations = new ArrayList<>();
        return permute(arr, permutations, 0);
    }

    /**
     * Recursively permutes an array of doubles until it has an ArrayList of all permutations of the array, including duplicates
     * @param arr the array to permute at this level of recursion
     * @param permutations the ArrayList of permutations
     * @param start the index to begin permuting arr at at this level of recursion
     * @return all permutations of arr found so far, including duplicates
     */
    private static ArrayList<double[]> permute(double[] arr, ArrayList<double[]> permutations, int start) {
        double[] permutation = Arrays.copyOf(arr, arr.length);

        for (int i = start; i < arr.length; i++) {
            Util.swap(permutation, start, i);
            permutations = permute(permutation, permutations, start + 1);
            Util.swap(permutation, start, i);
        }

        if (start == arr.length - 1) {
            permutations.add(permutation);
        }

        return permutations;
    }

    /**
     * Returns an ArrayList containing all unique permutations of an array of doubles
     * @param arr the array to permute
     * @return all unique permutations of arr
     */
    public static ArrayList<double[]> uniquePermutations(double[] arr) {
        ArrayList<double[]> permutations = new ArrayList<>();
        return permuteUnique(arr, permutations, 0);
    }

    /**
     * Recursively permutes an array of doubles until it has an ArrayList of all unique permutations of the array
     * @param arr the array to permute at this level of recursion
     * @param permutations the ArrayList of permutations
     * @param start the index to begin permuting arr at at this level of recursion
     * @return all unique permutations of arr found so far
     */
    private static ArrayList<double[]> permuteUnique(double[] arr, ArrayList<double[]> permutations, int start) {
        double[] permutation = Arrays.copyOf(arr, arr.length);

        for (int i = start; i < arr.length; i++) {
            Util.swap(permutation, start, i);
            permutations = permute(permutation, permutations, start + 1);
            Util.swap(permutation, start, i);
        }

        if (start == arr.length - 1) {
            if (!containsPermutation(permutations, permutation)) {
                permutations.add(permutation);
            }
        }

        return permutations;
    }

    /**
     * Checks if an ArrayList of permutations of an array of doubles already contains a given permutation
     * @param list the ArrayList of permutations to check
     * @param perm the permutation to check for
     * @return true if list contains an identical permutation to perm; false otherwise
     */
    private static boolean containsPermutation(ArrayList<double[]> list, double[] perm) {
        for (int i = 0; i < list.size(); i++) {
            if (Arrays.equals(list.get(i), perm)) {
                return true;
            }
        }

        return false;
    }

    /**
     * Returns an ArrayList containing all permutations of an array of Objects of class T, including duplicates
     * @param arr the array to permute
     * @return all permutations of arr, including duplicates
     */
    public static <T> ArrayList<T[]> permutations(T[] arr) {
        ArrayList<T[]> permutations = new ArrayList<>();
        return permute(arr, permutations, 0);
    }

    /**
     * Recursively permutes an array of Objects of class T until it has an ArrayList of all permutations of the array, including duplicates
     * @param arr the array to permute at this level of recursion
     * @param permutations the ArrayList of permutations
     * @param start the index to begin permuting arr at at this level of recursion
     * @return all permutations of arr found so far, including duplicates
     */
    private static <T> ArrayList<T[]> permute(T[] arr, ArrayList<T[]> permutations, int start) {
        T[] permutation = Util.deepCopy(arr);

        for (int i = start; i < arr.length; i++) {
            Util.swap(permutation, start, i);
            permutations = permute(permutation, permutations, start + 1);
            Util.swap(permutation, start, i);
        }

        if (start == arr.length - 1) {
            permutations.add(permutation);
        }

        return permutations;
    }

    /**
     * Returns an ArrayList containing all unique permutations of an array of Objects of class T
     * @param arr the array to permute
     * @return all unique permutations of arr
     */
    public static <T> ArrayList<T[]> uniquePermutations(T[] arr) {
        ArrayList<T[]> permutations = new ArrayList<>();
        return permuteUnique(arr, permutations, 0);
    }

    /**
     * Recursively permutes an array of Objects of class T until it has an ArrayList of all unique permutations of the array
     * @param arr the array to permute at this level of recursion
     * @param permutations the ArrayList of permutations
     * @param start the index to begin permuting arr at at this level of recursion
     * @return all unique permutations of arr found so far
     */
    private static <T> ArrayList<T[]> permuteUnique(T[] arr, ArrayList<T[]> permutations, int start) {
        T[] permutation = Util.deepCopy(arr);

        for (int i = start; i < arr.length; i++) {
            Util.swap(permutation, start, i);
            permutations = permute(permutation, permutations, start + 1);
            Util.swap(permutation, start, i);
        }

        if (start == arr.length - 1) {
            if (!containsPermutation(permutations, permutation)) {
                permutations.add(permutation);
            }
        }

        return permutations;
    }

    /**
     * Checks if an ArrayList of permutations of an array of Objects of class T already contains a given permutation
     * @param list the ArrayList of permutations to check
     * @param perm the permutation to check for
     * @return true if list contains an identical permutation to perm; false otherwise
     */
    private static <T> boolean containsPermutation(ArrayList<T[]> list, T[] perm) {
        for (int i = 0; i < list.size(); i++) {
            if (Arrays.equals(list.get(i), perm)) {
                return true;
            }
        }

        return false;
    }
    
    /**
     * Checks whether an array of ScalarWrappers is in order
     * @param arr the array to check
     * @return true if indices is in order; false otherwise
     */
    public static boolean inOrder(ScalarWrapper[] arr) {
        ScalarWrapper[] target = Arrays.copyOf(arr, arr.length);
        Arrays.sort(target);

        if (Arrays.equals(arr, target)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Checks whether a given ordering of an array of ScalarWrappers is an even or odd number of swaps away from being in order
     * @param arr the array to check
     * @return true if arr is an even number of swaps away from being in order; false otherwise
     */
    public static boolean orderIsEven(ScalarWrapper[] arr) {
        ScalarWrapper[] arrCopy = Arrays.copyOf(arr, arr.length);
        int swaps = 0;

        while (!inOrder(arrCopy)) {
            for (int i = 0; i < arrCopy.length - 1; i++) {
                if (arrCopy[i].greaterThan(arrCopy[i+1])) {
                    swaps += 1;
                    Util.swap(arrCopy, i, i+1);
                }
            }
        }

        if (swaps % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * Checks whether an array of ints is in order
     * @param arr the array to check
     * @return true if indices is in order; false otherwise
     */
    public static boolean inOrder(int[] arr) {
        int[] target = Arrays.copyOf(arr, arr.length);
        Arrays.sort(target);

        if (Arrays.equals(arr, target)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Checks whether a given ordering of an array of ints is an even or odd number of swaps away from being in order
     * @param arr the array to check
     * @return true if arr is an even number of swaps away from being in order; false otherwise
     */
    public static boolean orderIsEven(int[] arr) {
        int[] arrCopy = Arrays.copyOf(arr, arr.length);
        int swaps = 0;

        while (!inOrder(arrCopy)) {
            for (int i = 0; i < arrCopy.length - 1; i++) {
                if (arrCopy[i] > arrCopy[i+1]) {
                    swaps += 1;
                    Util.swap(arrCopy, i, i+1);
                }
            }
        }

        if (swaps % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Checks whether an array of Integers is in order
     * @param arr the array to check
     * @return true if indices is in order; false otherwise
     */
    public static boolean inOrder(Integer[] arr) {
        Integer[] target = Arrays.copyOf(arr, arr.length);
        Arrays.sort(target);

        if (Arrays.equals(arr, target)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Checks whether a given ordering of an array of Integers is an even or odd number of swaps away from being in order
     * @param arr the array to check
     * @return true if arr is an even number of swaps away from being in order; false otherwise
     */
    public static boolean orderIsEven(Integer[] arr) {
        Integer[] arrCopy = Arrays.copyOf(arr, arr.length);
        int swaps = 0;

        while (!inOrder(arrCopy)) {
            for (int i = 0; i < arrCopy.length - 1; i++) {
                if (arrCopy[i] > arrCopy[i+1]) {
                    swaps += 1;
                    Util.swap(arrCopy, i, i+1);
                }
            }
        }

        if (swaps % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Checks whether an array of doubles is in order
     * @param arr the array to check
     * @return true if indices is in order; false otherwise
     */
    public static boolean inOrder(double[] arr) {
        double[] target = Arrays.copyOf(arr, arr.length);
        Arrays.sort(target);

        if (Arrays.equals(arr, target)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Checks whether a given ordering of an array of doubles is an even or odd number of swaps away from being in order
     * @param arr the array to check
     * @return true if arr is an even number of swaps away from being in order; false otherwise
     */
    public static boolean orderIsEven(double[] arr) {
        double[] arrCopy = Arrays.copyOf(arr, arr.length);
        int swaps = 0;

        while (!inOrder(arrCopy)) {
            for (int i = 0; i < arrCopy.length - 1; i++) {
                if (arrCopy[i] > arrCopy[i+1]) {
                    swaps += 1;
                    Util.swap(arrCopy, i, i+1);
                }
            }
        }

        if (swaps % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Checks whether an array of Doubles is in order
     * @param arr the array to check
     * @return true if indices is in order; false otherwise
     */
    public static boolean inOrder(Double[] arr) {
        Double[] target = Arrays.copyOf(arr, arr.length);
        Arrays.sort(target);

        if (Arrays.equals(arr, target)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Checks whether a given ordering of an array of Doubles is an even or odd number of swaps away from being in order
     * @param arr the array to check
     * @return true if arr is an even number of swaps away from being in order; false otherwise
     */
    public static boolean orderIsEven(Double[] arr) {
        Double[] arrCopy = Arrays.copyOf(arr, arr.length);
        int swaps = 0;

        while (!inOrder(arrCopy)) {
            for (int i = 0; i < arrCopy.length - 1; i++) {
                if (arrCopy[i] > arrCopy[i+1]) {
                    swaps += 1;
                    Util.swap(arrCopy, i, i+1);
                }
            }
        }

        if (swaps % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Checks whether an array of Rationals is in order
     * @param arr the array to check
     * @return true if indices is in order; false otherwise
     */
    public static boolean inOrder(Rational[] arr) {
        Rational[] target = Arrays.copyOf(arr, arr.length);
        Arrays.sort(target);

        if (Arrays.equals(arr, target)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Checks whether a given ordering of an array of Rationals is an even or odd number of swaps away from being in order
     * @param arr the array to check
     * @return true if arr is an even number of swaps away from being in order; false otherwise
     */
    public static boolean orderIsEven(Rational[] arr) {
        Rational[] arrCopy = Arrays.copyOf(arr, arr.length);
        int swaps = 0;

        while (!inOrder(arrCopy)) {
            for (int i = 0; i < arrCopy.length - 1; i++) {
                if (arrCopy[i].greaterThan(arrCopy[i+1])) {
                    swaps += 1;
                    Util.swap(arrCopy, i, i+1);
                }
            }
        }

        if (swaps % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Checks whether an array of Radicals is in order
     * @param arr the array to check
     * @return true if indices is in order; false otherwise
     */
    public static boolean inOrder(Radical[] arr) {
        Radical[] target = Arrays.copyOf(arr, arr.length);
        Arrays.sort(target);

        if (Arrays.equals(arr, target)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Checks whether a given ordering of an array of Radicals is an even or odd number of swaps away from being in order
     * @param arr the array to check
     * @return true if arr is an even number of swaps away from being in order; false otherwise
     */
    public static boolean orderIsEven(Radical[] arr) {
        Radical[] arrCopy = Arrays.copyOf(arr, arr.length);
        int swaps = 0;

        while (!inOrder(arrCopy)) {
            for (int i = 0; i < arrCopy.length - 1; i++) {
                if (arrCopy[i].greaterThan(arrCopy[i+1])) {
                    swaps += 1;
                    Util.swap(arrCopy, i, i+1);
                }
            }
        }

        if (swaps % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Returns a string representation of a given ArrayList of arrays of ints
     * @param arr the ArrayList to convert to a String
     * @return a string representation of a given ArrayList of arrays of ints
     */
    public static String nestListArrayIntString(ArrayList<int[]> arr) {
        String s = "<";
        for (int i = 0; i < arr.size(); i++) {
            if (i != 0) {
                s += ",";
            }
            s += Arrays.toString(arr.get(i));
        }
        s += ">";

        return s;
    }

    /**
     * Returns a string representation of a given ArrayList of arrays of doubles
     * @param arr the ArrayList to convert to a String
     * @return a string representation of a given ArrayList of arrays of doubles
     */
    public static String nestListArrayDoubleString(ArrayList<double[]> arr) {
        String s = "<";
        for (int i = 0; i < arr.size(); i++) {
            if (i != 0) {
                s += ",";
            }
            s += Arrays.toString(arr.get(i));
        }
        s += ">";

        return s;
    }

    /**
     * Returns a string representation of a given ArrayList of arrays of Objects of class T
     * @param arr the ArrayList to convert to a String
     * @return a string representation of a given ArrayList of arrays of Objects of class T
     */
    public static <T> String nestListArrayString(ArrayList<T[]> arr) {
        String s = "<";
        for (int i = 0; i < arr.size(); i++) {
            if (i != 0) {
                s += ",";
            }
            s += Arrays.toString(arr.get(i));
        }
        s += ">";

        return s;
    }

    /* public static void main(String[] args){
        ScalarWrapper wrap1 = new ScalarWrapper(1.5);
        ScalarWrapper wrap2 = new ScalarWrapper(2.3);
        ScalarWrapper wrap3 = new ScalarWrapper(3.77);
        ScalarWrapper[] arr = {wrap1, wrap2, wrap3};
        System.out.println(nestListArrayString(permutations(arr)));
    } */


}
