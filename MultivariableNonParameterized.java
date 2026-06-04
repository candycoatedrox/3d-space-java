public interface MultivariableNonParameterized extends MultivariableFunction {
    
    @Override public ScalarWrapper evaluate(ScalarWrapper[] variables);
    @Override public NonParameterizedFunction evaluateOneVariable(int v, ScalarWrapper value);
    @Override public NonParameterizedFunction evaluateOneVariable(int v, Function value);

    @Override public NonParameterizedFunction derivative(int v);
    @Override public NonParameterizedFunction multipleDerivative(int[] v);
    @Override public NonParameterizedFunction evaluateDerivative(int v, ScalarWrapper value);
    @Override public ScalarWrapper evaluateDerivative(int v, ScalarWrapper[] variables);

    @Override public NonParameterizedFunction antiderivative(int v);
    @Override public NonParameterizedFunction multipleAntiderivative(int v, int nAntiderivatives);
    @Override public NonParameterizedFunction evaluateAntiderivative(int v, ScalarWrapper value);
    @Override public NonParameterizedFunction evaluateAntiderivative(int v, Function value);
    @Override public ScalarWrapper evaluateAntiderivative(int v, ScalarWrapper[] variables);

    @Override public NonParameterizedFunction singleIntegrate(int v, ScalarWrapper a, ScalarWrapper b);
    @Override public NonParameterizedFunction singleIntegrate(int v, ScalarWrapper a, Function b);
    @Override public NonParameterizedFunction singleIntegrate(int v, Function a, ScalarWrapper b);
    @Override public NonParameterizedFunction singleIntegrate(int v, Function a, Function b);
    @Override public ScalarWrapper multipleIntegrate(int[] v, ScalarWrapper[] a, ScalarWrapper[] b);
    @Override public ScalarWrapper multipleIntegrate(int[] v, ScalarWrapper[] a, Function[] b);
    @Override public ScalarWrapper multipleIntegrate(int[] v, Function[] a, ScalarWrapper[] b);
    @Override public ScalarWrapper multipleIntegrate(int[] v, Function[] a, Function[] b);

}
