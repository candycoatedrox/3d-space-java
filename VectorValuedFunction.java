public class VectorValuedFunction extends Function implements AbstractVector, MultivariableFunction {
    
    protected NonParameterizedFunction[] components;
    protected static final String[] VARNAMES = {"t", "s", "q", "r", "p", "o", "n", "m", "l", "k", "j", "i", "h", "g", "f", "e", "d", "c", "b", "a", "z", "y", "x", "w", "v", "u"};

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
    public boolean isConstant() {
        for (NonParameterizedFunction f : this.components) {
            if (!f.isConstant()) {
                return false;
            }
        }

        return true;
    }

    public Vector getConstant() {
        if (this.isConstant()) {
            ScalarWrapper[] c = new ScalarWrapper[this.dim];

            for (int i = 0; i < this.dim; i++) {
                c[i] = this.get(i).getConstant();
            }

            return new Vector(c);
        } else {
            throw new IllegalArgumentException("Function is not constant");
        }
    }

    @Override
    public int nVariables() {
        
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

    @Override
    public Vector evaluate(ScalarWrapper[] variables) {
        ScalarWrapper[] c = new ScalarWrapper[this.dim];

        for (int i = 0; i < this.dim; i++) {
            c[i] = this.get(i).evaluate(variables);
        }

        return new Vector(c);
    }

    @Override
    public VectorValuedFunction evaluateOneVariable(int v, ScalarWrapper value) {
        
    }

    @Override
    public VectorValuedFunction evaluateOneVariable(int v, Function value) {
        
    }

    @Override
    public VectorValuedFunction derivative(int v) {

    }

    @Override
    public VectorValuedFunction multipleDerivative(int[] v) {

    }
    
    @Override
    public VectorValuedFunction evaluateDerivative(int v, ScalarWrapper value) {

    }
    
    @Override
    public ScalarWrapper evaluateDerivative(int v, ScalarWrapper[] variables) {

    }

    @Override
    public VectorValuedFunction antiderivative(int v) {

    }
    
    @Override
    public VectorValuedFunction multipleAntiderivative(int v, int nAntiderivatives) {

    }
    
    @Override
    public VectorValuedFunction evaluateAntiderivative(int v, ScalarWrapper value) {

    }
    
    @Override
    public VectorValuedFunction evaluateAntiderivative(int v, Function value) {

    }
    
    @Override
    public ScalarWrapper evaluateAntiderivative(int v, ScalarWrapper[] variables) {

    }

    @Override
    public VectorValuedFunction singleIntegrate(int v, ScalarWrapper a, ScalarWrapper b) {

    }
    
    @Override
    public VectorValuedFunction singleIntegrate(int v, ScalarWrapper a, Function b) {

    }
    
    @Override
    public VectorValuedFunction singleIntegrate(int v, Function a, ScalarWrapper b) {

    }
    
    @Override
    public VectorValuedFunction singleIntegrate(int v, Function a, Function b) {

    }
    
    @Override
    public ScalarWrapper multipleIntegrate(int[] v, ScalarWrapper[] a, ScalarWrapper[] b) {

    }
    
    @Override
    public ScalarWrapper multipleIntegrate(int[] v, ScalarWrapper[] a, Function[] b) {

    }
    
    @Override
    public ScalarWrapper multipleIntegrate(int[] v, Function[] a, ScalarWrapper[] b) {

    }
    
    @Override
    public ScalarWrapper multipleIntegrate(int[] v, Function[] a, Function[] b) {

    }

}
