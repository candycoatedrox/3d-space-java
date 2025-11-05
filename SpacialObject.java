public abstract class SpacialObject implements Cloneable {
    
    protected final int dim;

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

}
