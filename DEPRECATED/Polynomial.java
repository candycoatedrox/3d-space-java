import java.util.ArrayList;

public abstract class Polynomial extends NonParameterizedFunction {
    
    public Polynomial(int dim) {
        super(dim);
    }

    @Override public abstract Polynomial negative();
    @Override public abstract Polynomial absolute();

    @Override public abstract Polynomial squared();
    @Override public abstract Polynomial toPower(int power);

    public abstract boolean includes(int v);
    public abstract ArrayList<Integer> includedVariables();
    public abstract int nVariablesIncluded();
    public abstract boolean isConstant();

    public abstract PolynomialFunction add(PolynomialFunction other);
    public abstract PolynomialFunction add(PolynomialFunctionTerm other);
    public abstract PolynomialFunction subtract(PolynomialFunction other);
    public abstract PolynomialFunction subtract(PolynomialFunctionTerm other);

    public abstract PolynomialFunction multiply(PolynomialFunction other);
    public abstract Polynomial multiply(PolynomialFunctionTerm other);
    @Override public abstract Polynomial multiply(ScalarWrapper other);
    @Override public abstract Polynomial multiply(int other);
    @Override public abstract Polynomial multiply(Integer other);
    @Override public abstract Polynomial multiply(double other);
    @Override public abstract Polynomial multiply(Double other);
    @Override public abstract Polynomial multiply(Rational other);

    public abstract Polynomial divideBy(PolynomialFunctionTerm other);
    @Override public abstract Polynomial divideBy(ScalarWrapper other);
    @Override public abstract Polynomial divideBy(int other);
    @Override public abstract Polynomial divideBy(Integer other);
    @Override public abstract Polynomial divideBy(double other);
    @Override public abstract Polynomial divideBy(Double other);
    @Override public abstract Polynomial divideBy(Rational other);

}
