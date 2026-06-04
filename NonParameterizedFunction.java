public abstract class NonParameterizedFunction extends Function {
    
    public NonParameterizedFunction(int dim) {
        super(dim);
    }

    public abstract ScalarWrapper getConstant();

    @Override public abstract NonParameterizedFunction negative();
    @Override public abstract NonParameterizedFunction absolute();

    public CompoundFunction add(NonParameterizedFunction other) {
        return new CompoundFunction(this, other);
    }

    public CompoundFunction subtract(NonParameterizedFunction other) {
        return new CompoundFunction(this, other.negative());
    }

    @Override public abstract NonParameterizedFunction multiply(ScalarWrapper other);
    @Override public abstract NonParameterizedFunction multiply(int other);
    @Override public abstract NonParameterizedFunction multiply(Integer other);
    @Override public abstract NonParameterizedFunction multiply(double other);
    @Override public abstract NonParameterizedFunction multiply(Double other);
    @Override public abstract NonParameterizedFunction multiply(Rational other);

    @Override public abstract NonParameterizedFunction divideBy(ScalarWrapper other);
    @Override public abstract NonParameterizedFunction divideBy(int other);
    @Override public abstract NonParameterizedFunction divideBy(Integer other);
    @Override public abstract NonParameterizedFunction divideBy(double other);
    @Override public abstract NonParameterizedFunction divideBy(Double other);
    @Override public abstract NonParameterizedFunction divideBy(Rational other);

    @Override public abstract NonParameterizedFunction squared();
    @Override public abstract NonParameterizedFunction toPower(int power);

}
