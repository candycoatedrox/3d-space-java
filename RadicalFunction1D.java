public class RadicalFunction1D extends RadicalFunction implements Function1D {
    
    public RadicalFunction1D(NonParameterizedFunction innerFunction) {
        super(innerFunction.getDim());

        if (innerFunction.is1D()) {
            this.innerFunction = innerFunction;
            this.isPositive = true;
        } else {
            throw new IllegalArgumentException("Inner function must be 1D");
        }
    }

    public RadicalFunction1D(NonParameterizedFunction innerFunction, boolean isPositive) {
        super(innerFunction.getDim());

        if (innerFunction.is1D()) {
            this.innerFunction = innerFunction;
            this.isPositive = isPositive;
        } else {
            throw new IllegalArgumentException("Inner function must be 1D");
        }
    }

    public RadicalFunction1D derivative() {
        
    }

    public ScalarWrapper evaluateDerivative(ScalarWrapper value) {
        
    }

    public RadicalFunction1D multipleDerivative(int n) {
        
    }

    public ScalarWrapper evaluateMultipleDerivative(ScalarWrapper value) {
        
    }

    public RadicalFunction1D antiderivative() {
        
    }

    public ScalarWrapper evaluateAntiderivative(ScalarWrapper value) {
        
    }

    public RadicalFunction1D multipleAntiderivative(int nAntiderivatives) {
        
    }

    public ScalarWrapper evaluateMultipleAntiderivative(ScalarWrapper value) {
        
    }

    public ScalarWrapper integrate(ScalarWrapper a, ScalarWrapper b) {
        
    }

    
}
