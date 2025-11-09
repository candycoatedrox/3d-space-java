public abstract class SpacialObject implements Cloneable {
    
    protected final int dim;
    // usually nothing past w should be used, but IF NECESSARY I have included the entire alphabet...
    protected static final String[] variableNames = {"x", "y", "z", "w", "u", "v", "t", "s", "r", "q", "p", "o", "n", "m", "l", "k", "j", "i", "h", "g", "f", "e", "d", "c", "b", "a"};

    public SpacialObject(int dim) {
        this.dim = dim;
    }

    /**
     * Accessor for dim
     * @return the dimension of this SpacialObject
     */
    public int getDim() {
        return this.dim;
    }

    /**
     * Checks whether this SpacialObject is of a given dimension
     * @param n the target dimension
     * @return true if this SpacialObject is of dimension n; false otherwise
     */
    public boolean isDim(int n) {
        return this.dim == n;
    }

    /**
     * Checks whether this SpacialObject is 2D
     * @return true if this SpacialObject is 2D; false otherwise
     */
    public boolean is2D() {
        return this.dim == 2;
    }

    /**
     * Checks whether this SpacialObject is 3D
     * @return true if this SpacialObject is 3D; false otherwise
     */
    public boolean is3D() {
        return this.dim == 3;
    }

    /**
     * Checks whether this SpacialObject's dimension is greater than or equal to a given number
     * @param n the minimum dimension
     * @return true if the dimension of this SpacialObject is greater than or equal to n; false otherwise
     */
    public boolean dimAtLeast(int n) {
        return this.dim >= n;
    }

    /**
     * Checks whether this SpacialObject's dimension is less than a given number
     * @param n the maximum dimension
     * @return true if the dimension of this SpacialObject is less than n; false otherwise
     */
    public boolean dimLessThan(int n) {
        return this.dim < n;
    }

    /**
     * Checks whether two SpacialObjects are of the same dimension
     * @param other the other SpacialObject to check against
     * @return true if this SpacialObject and other have the same dimension; false otherwise
     */
    public boolean sameDimension(SpacialObject other) {
        return this.dim == other.dim;
    }

    /**
     * Checks whether this SpacialObject is of a higher dimension than another
     * @param other the other SpacialObject to check against
     * @return true if this SpacialObject has a higher dimension than other; false otherwise
     */
    public boolean lowerDimension(SpacialObject other) {
        return this.dim < other.dim;
    }

    /**
     * Checks whether this SpacialObject is of a lower dimension than another
     * @param other the other SpacialObject to check against
     * @return true if this SpacialObject has a lower dimension than other; false otherwise
     */
    public boolean higherDimension(SpacialObject other) {
        return this.dim > other.dim;
    }

    /**
     * Checks whether a given variable index is valid for this SpacialObject
     * @param v the variable index to check
     * @return true if v is 0 or positive and less than the dimension of this SpacialObject; false otherwise
     */
    protected boolean validVariableIndex(int v) {
        if (v < 0) {
            return false;
        } else if (this.dim <= v) {
            return false;
        }
        
        return true;
    }

    /**
     * Checks whether a given variable index is valid, and throws an appropriate Exception if it is not
     * @param v the variable index to check
     * @throws IllegalArgumentException if v is negative
     * @throws IndexOutOfBoundsException if v is greater than or equal to the dimension of this SpacialObject
     */
    protected void checkVariableIndex(int v) {
        if (v < 0) {
            throw new IllegalArgumentException("Variable index cannot be negative");
        } else if (this.dim <= v) {
            throw new IndexOutOfBoundsException("Variable index must be within dimension of the SpacialObject");
        }
    }

    /**
     * Checks whether the length of an array of ints is equal to the dimension of this SpacialObject
     * @param arr the array to check
     * @return true if the length of arr is equal to the dimension of this SpacialObject; false otherwise
     */
    protected boolean isOfLengthDim(int[] arr) {
        return arr.length == this.dim;
    }

    /**
     * Checks whether the length of an array of doubles is equal to the dimension of this SpacialObject
     * @param arr the array to check
     * @return true if the length of arr is equal to the dimension of this SpacialObject; false otherwise
     */
    protected boolean isOfLengthDim(double[] arr) {
        return arr.length == this.dim;
    }

    /**
     * Checks whether the length of an array of Objects is equal to the dimension of this SpacialObject
     * @param arr the array to check
     * @return true if the length of arr is equal to the dimension of this SpacialObject; false otherwise
     */
    protected <T> boolean isOfLengthDim(T[] arr) {
        return arr.length == this.dim;
    }

}
