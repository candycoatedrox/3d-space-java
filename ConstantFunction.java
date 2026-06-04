import java.util.ArrayList;

public class ConstantFunction extends NonParameterizedFunction {

    private ScalarWrapper value;
    
    public ConstantFunction(ScalarWrapper value, int dim) {
        super(dim);
        this.value = value;
    }

    public ConstantFunction(int value, int dim) {
        super(dim);
        this.value = new ScalarWrapper(value);
    }

    public ConstantFunction(Integer value, int dim) {
        super(dim);
        this.value = new ScalarWrapper(value);
    }

    public ConstantFunction(double value, int dim) {
        super(dim);
        this.value = new ScalarWrapper(value);
    }

    public ConstantFunction(Double value, int dim) {
        super(dim);
        this.value = new ScalarWrapper(value);
    }

    public ConstantFunction(Rational value, int dim) {
        super(dim);
        this.value = new ScalarWrapper(value);
    }

    public ConstantFunction(NonParameterizedFunction f) {
        super(f.getDim());
        if (f.isConstant()) {
            this.value = f.getConstant();
        }
    }

    @Override
    public ScalarWrapper getConstant() {
        return this.value;
    }

    @Override
    public boolean isConstant() {
        return true;
    }

    @Override
    public boolean includes(int v) {
        return false;
    }
    
    @Override
    public ArrayList<Integer> includedVariables() {
        return new ArrayList<>();
    }
    
    @Override
    public int nVariablesIncluded() {
        return 0;
    }

    @Override
    public ConstantFunction negative() {
        return new ConstantFunction(this.value.negative(), this.dim);
    }
    
    @Override
    public ConstantFunction absolute() {
        return new ConstantFunction(this.value.absolute(), this.dim);
    }
    
    @Override
    public ConstantFunction multiply(ScalarWrapper other) {
        return new ConstantFunction(this.value.multiply(other), this.dim);
    }
    
    @Override
    public ConstantFunction multiply(int other) {
        return new ConstantFunction(this.value.multiply(other), this.dim);
    }
    
    @Override
    public ConstantFunction multiply(Integer other) {
        return new ConstantFunction(this.value.multiply(other), this.dim);
    }
    
    @Override
    public ConstantFunction multiply(double other) {
        return new ConstantFunction(this.value.multiply(other), this.dim);
    }
    
    @Override
    public ConstantFunction multiply(Double other) {
        return new ConstantFunction(this.value.multiply(other), this.dim);
    }
    
    @Override
    public ConstantFunction multiply(Rational other) {
        return new ConstantFunction(this.value.multiply(other), this.dim);
    }

    @Override
    public ConstantFunction divideBy(ScalarWrapper other) {
        return new ConstantFunction(this.value.divideBy(other), this.dim);
    }
    
    @Override
    public ConstantFunction divideBy(int other) {
        return new ConstantFunction(this.value.divideBy(other), this.dim);
    }
    
    @Override
    public ConstantFunction divideBy(Integer other) {
        return new ConstantFunction(this.value.divideBy(other), this.dim);
    }
    
    @Override
    public ConstantFunction divideBy(double other) {
        return new ConstantFunction(this.value.divideBy(other), this.dim);
    }
    
    @Override
    public ConstantFunction divideBy(Double other) {
        return new ConstantFunction(this.value.divideBy(other), this.dim);
    }
    
    @Override
    public ConstantFunction divideBy(Rational other) {
        return new ConstantFunction(this.value.divideBy(other), this.dim);
    }

    @Override
    public ConstantFunction squared() {
        return new ConstantFunction(this.value.squared(), this.dim);
    }
    
    @Override
    public ConstantFunction toPower(int power) {
        return new ConstantFunction(this.value.toPower(power), this.dim);
    }

}
