public interface Function1D {

    Function derivative();
    ScalarWrapper evaluateDerivative(ScalarWrapper value);
    Function multipleDerivative(int n);
    ScalarWrapper evaluateMultipleDerivative(ScalarWrapper value);

    Function antiderivative();
    ScalarWrapper evaluateAntiderivative(ScalarWrapper value);
    Function multipleAntiderivative(int nAntiderivatives);
    ScalarWrapper evaluateMultipleAntiderivative(ScalarWrapper value);

    ScalarWrapper integrate(ScalarWrapper a, ScalarWrapper b);

}
