public class RadicalFunctionMV extends RadicalFunction implements MultivariableNonParameterized {
    
    public RadicalFunctionMV(NonParameterizedFunction innerFunction) {
        super(innerFunction.getDim());

        if (!innerFunction.is1D()) {
            this.innerFunction = innerFunction;
            this.isPositive = true;
        } else {
            throw new IllegalArgumentException("Inner function cannot be 1D");
        }
    }

    public RadicalFunctionMV(NonParameterizedFunction innerFunction, boolean isPositive) {
        super(innerFunction.getDim());

        if (!innerFunction.is1D()) {
            this.innerFunction = innerFunction;
            this.isPositive = isPositive;
        } else {
            throw new IllegalArgumentException("Inner function cannot be 1D");
        }
    }

    @Override
    public ScalarWrapper evaluate(ScalarWrapper[] variables) {
        if (this.innerFunction instanceof MultivariableNonParameterized) {
            return new ScalarWrapper(this.innerFunction.evaluate(variables));
        }
    }

    public Radical evaluateRadical(ScalarWrapper[] variables) {
        return new Radical(this.innerFunction.evaluate(variables));
    }

    @Override
    public RadicalFunctionMV evaluateOneVariable(int v, ScalarWrapper value) {
        return new RadicalFunctionMV(this.innerFunction.evaluateOneVariable(v, value));
    }

    @Override
    public RadicalFunctionMV evaluateOneVariable(int v, Function value) {
        
    }

    @Override
    public RadicalFunctionMV derivative(int v) {

    }

    @Override
    public RadicalFunctionMV multipleDerivative(int[] v) {

    }
    
    @Override
    public RadicalFunctionMV evaluateDerivative(int v, ScalarWrapper value) {

    }
    
    @Override
    public ScalarWrapper evaluateDerivative(int v, ScalarWrapper[] variables) {

    }

    @Override
    public RadicalFunctionMV antiderivative(int v) {

    }
    
    @Override
    public RadicalFunctionMV multipleAntiderivative(int v, int nAntiderivatives) {

    }
    
    @Override
    public RadicalFunctionMV evaluateAntiderivative(int v, ScalarWrapper value) {

    }
    
    @Override
    public RadicalFunctionMV evaluateAntiderivative(int v, Function value) {

    }
    
    @Override
    public ScalarWrapper evaluateAntiderivative(int v, ScalarWrapper[] variables) {

    }

    @Override
    public RadicalFunctionMV singleIntegrate(int v, ScalarWrapper a, ScalarWrapper b) {

    }
    
    @Override
    public RadicalFunctionMV singleIntegrate(int v, ScalarWrapper a, Function b) {

    }
    
    @Override
    public RadicalFunctionMV singleIntegrate(int v, Function a, ScalarWrapper b) {

    }
    
    @Override
    public RadicalFunctionMV singleIntegrate(int v, Function a, Function b) {

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
