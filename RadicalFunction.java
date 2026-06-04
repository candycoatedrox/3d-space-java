import java.util.ArrayList;

public class RadicalFunction extends NonParameterizedFunction implements AbstractRadical {
    
    protected NonParameterizedFunction innerFunction;
    protected boolean isPositive;

    public RadicalFunction(NonParameterizedFunction innerFunction, boolean isPositive) {
        super(innerFunction.getDim());
        this.innerFunction = innerFunction;
        this.isPositive = isPositive;
    }

    public RadicalFunction(NonParameterizedFunction innerFunction) {
        this(innerFunction, true);
    }

    protected RadicalFunction(int dim) {
        super(dim);
    }

    public NonParameterizedFunction getInnerValue() {
        return this.innerFunction;
    }

    @Override
    public boolean isConstant() {
        return innerFunction.isConstant();
    }

    @Override
    public ScalarWrapper getConstant() {
        ScalarWrapper wrapper = this.innerFunction.getConstant();
        return new ScalarWrapper(wrapper.sqrt());
    }

    public Radical getConstantRadical() {
        ScalarWrapper wrapper = this.innerFunction.getConstant();
        return new Radical(wrapper);
    }

    @Override
    public boolean includes(int v) {
        return innerFunction.includes(v);
    }

    @Override
    public ArrayList<Integer> includedVariables() {
        return innerFunction.includedVariables();
    }

    @Override
    public int nVariablesIncluded() {
        return innerFunction.nVariablesIncluded();
    }

    @Override
    public RadicalFunction negative() {
        return new RadicalFunction(this.innerFunction, !this.isPositive);
    }

    @Override
    public RadicalFunction absolute() {
        return new RadicalFunction(this.innerFunction);
    }

    @Override
    public RadicalFunction multiply(Radical other) {
        return new RadicalFunction(innerFunction.multiply(other.getInnerValue()));
    }

    @Override
    public RadicalFunction multiply(ScalarWrapper other) {
        ScalarWrapper factorSquare = other.squared();
        NonParameterizedFunction inner = this.innerFunction.multiply(factorSquare);
        return new RadicalFunction(inner);
    }

    @Override
    public RadicalFunction multiply(int other) {
        int factorSquare = other * other;
        NonParameterizedFunction inner = this.innerFunction.multiply(factorSquare);
        return new RadicalFunction(inner);
    }

    @Override
    public RadicalFunction multiply(Integer other) {
        return this.multiply(other.intValue());
    }

    @Override
    public RadicalFunction multiply(double other) {
        double factorSquare = other * other;
        NonParameterizedFunction inner = this.innerFunction.multiply(factorSquare);
        return new RadicalFunction(inner);
    }

    @Override
    public RadicalFunction multiply(Double other) {
        return this.multiply(other.doubleValue());
    }

    @Override
    public RadicalFunction multiply(Rational other) {
        Rational factorSquare = other.squared();
        NonParameterizedFunction inner = this.innerFunction.multiply(factorSquare);
        return new RadicalFunction(inner);
    }

    @Override
    public RadicalFunction divideBy(Radical other) {
        return new RadicalFunction(innerFunction.divideBy(other.getInnerValue()));
    }

    @Override
    public RadicalFunction divideBy(ScalarWrapper other) {
        ScalarWrapper factorSquare = other.squared();
        NonParameterizedFunction inner = this.innerFunction.divideBy(factorSquare);
        return new RadicalFunction(inner);
    }

    @Override
    public RadicalFunction divideBy(int other) {
        int factorSquare = other * other;
        NonParameterizedFunction inner = this.innerFunction.divideBy(factorSquare);
        return new RadicalFunction(inner);
    }

    @Override
    public RadicalFunction divideBy(Integer other) {
        return this.divideBy(other.intValue());
    }

    @Override
    public RadicalFunction divideBy(double other) {
        double factorSquare = other * other;
        NonParameterizedFunction inner = this.innerFunction.divideBy(factorSquare);
        return new RadicalFunction(inner);
    }

    @Override
    public RadicalFunction divideBy(Double other) {
        return this.divideBy(other.doubleValue());
    }

    @Override
    public RadicalFunction divideBy(Rational other) {
        Rational factorSquare = other.squared();
        NonParameterizedFunction inner = this.innerFunction.divideBy(factorSquare);
        return new RadicalFunction(inner);
    }

    @Override
    public NonParameterizedFunction squared() {
        return this.innerFunction;
    }

    @Override
    public RadicalFunction toPower(int power) {
        return new RadicalFunction(this.innerFunction.toPower(power));
    }

}