public class VectorValuedFunction extends Function implements AbstractVector, MultivariableFunction {
    
    protected NonParameterizedFunction[] components;

    public VectorValuedFunction(NonParameterizedFunction[] components) {
        super(components.length);
        this.components = components;
    }

    @Override
    public NonParameterizedFunction[] getComponents() {
        return this.components;
    }

    @Override
    public NonParameterizedFunction get(int i) {
        return this.components[i];
    }

    @Override
    public NonParameterizedFunction mag2() {
        
    }

    @Override
    public RadicalFunction mag() {
        return new RadicalFunction(this.mag2());
    }

    @Override
    public VectorValuedFunction negative() {
        
    }

    @Override
    public VectorValuedFunction absolute() {
        
    }

    @Override
    public VectorValuedFunction multiply(ScalarWrapper other) {
        
    }
    
    @Override
    public VectorValuedFunction multiply(int other) {
        
    }
    
    @Override
    public VectorValuedFunction multiply(Integer other) {
        
    }
    
    @Override
    public VectorValuedFunction multiply(double other) {
        
    }
    
    @Override
    public VectorValuedFunction multiply(Double other) {
        
    }
    
    @Override
    public VectorValuedFunction multiply(Rational other) {
        
    }

    @Override
    public VectorValuedFunction divideBy(ScalarWrapper other) {
        
    }
    
    @Override
    public VectorValuedFunction divideBy(int other) {
        
    }
    
    @Override
    public VectorValuedFunction divideBy(Integer other) {
        
    }
    
    @Override
    public VectorValuedFunction divideBy(double other) {
        
    }
    
    @Override
    public VectorValuedFunction divideBy(Double other) {
        
    }
    
    @Override
    public VectorValuedFunction divideBy(Rational other) {
        
    }

    @Override
    public VectorValuedFunction squared() {
        
    }
    
    @Override
    public VectorValuedFunction toPower(int power) {
        
    }

}
