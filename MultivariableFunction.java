public interface MultivariableFunction {

    ScalarWrapper evaluate(ScalarWrapper[] variables);
    Function evaluateOneVariable(int v, ScalarWrapper value);
    Function evaluateOneVariable(int v, Function value);

    Function derivative(int v);
    Function multipleDerivative(int[] v);
    Function evaluateDerivative(int v, ScalarWrapper value);
    ScalarWrapper evaluateDerivative(int v, ScalarWrapper[] variables);

    Function antiderivative(int v);
    Function multipleAntiderivative(int v, int nAntiderivatives);
    Function evaluateAntiderivative(int v, ScalarWrapper value);
    Function evaluateAntiderivative(int v, Function value);
    ScalarWrapper evaluateAntiderivative(int v, ScalarWrapper[] variables);

    Function singleIntegrate(int v, ScalarWrapper a, ScalarWrapper b);
    Function singleIntegrate(int v, ScalarWrapper a, Function b);
    Function singleIntegrate(int v, Function a, ScalarWrapper b);
    Function singleIntegrate(int v, Function a, Function b);
    ScalarWrapper multipleIntegrate(int[] v, ScalarWrapper[] a, ScalarWrapper[] b);
    ScalarWrapper multipleIntegrate(int[] v, ScalarWrapper[] a, Function[] b);
    ScalarWrapper multipleIntegrate(int[] v, Function[] a, ScalarWrapper[] b);
    ScalarWrapper multipleIntegrate(int[] v, Function[] a, Function[] b);
    
}
