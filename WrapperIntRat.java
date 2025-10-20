public class WrapperIntRat {

    private Integer Int = null;
    private Rational rat = null;

    /**
     * Wraps an Integer and a Rational
     * @param Int the possible integer value of the wrapper
     * @param rat the possible Rational value of the wrapper
     */
    public WrapperIntRat(Integer Int, Rational rat) {
        if (Int == null && rat == null) {
            throw new NullPointerException();
        }
        if (rat == null) {
            this.Int = Int;
        }
        if (Int == null) {
            this.rat = rat;
        }
    }

    /**
     * Wraps an Integer
     * @param Int the integer value of the wrapper
     */
    public WrapperIntRat(Integer Int) {
        this.Int = Int;
    }

    /**
     * Wraps a Rational
     * @param rat the Rational value of the wrapper
     */
    public WrapperIntRat(Rational rat) {
        this.rat = rat;
    }

    /**
     * Accessor for Int
     * @return the integer value of the wrapper
     */
    public int getInt() {
        return this.Int;
    }

    /**
     * Accessor for rat
     * @return the Rational value of the wrapper
     */
    public Rational getRat() {
        return this.rat;
    }

}
