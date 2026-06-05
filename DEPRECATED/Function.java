public abstract class Function extends SpacialObject {

    // somehow figure out how to get this to take any function of n variables
        
    public Function(int dim) {
        super(dim);
    }

    public abstract Function negative();
    public abstract Function absolute();

    public abstract Function multiply(ScalarWrapper other);
    public abstract Function multiply(int other);
    public abstract Function multiply(Integer other);
    public abstract Function multiply(double other);
    public abstract Function multiply(Double other);
    public abstract Function multiply(Rational other);

    public abstract Function divideBy(ScalarWrapper other);
    public abstract Function divideBy(int other);
    public abstract Function divideBy(Integer other);
    public abstract Function divideBy(double other);
    public abstract Function divideBy(Double other);
    public abstract Function divideBy(Rational other);

    public abstract Function squared();
    public abstract Function toPower(int power);
    
}