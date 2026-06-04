public interface MultivariablePolynomial extends MultivariableNonParameterized {

    public PolynomialFunction singleIntegrate(int v, ScalarWrapper a, PolynomialFunction b);
    public Polynomial singleIntegrate(int v, ScalarWrapper a, PolynomialFunctionTerm b);
    public PolynomialFunction singleIntegrate(int v, PolynomialFunction a, ScalarWrapper b);
    public Polynomial singleIntegrate(int v, PolynomialFunctionTerm a, ScalarWrapper b);
    public Polynomial singleIntegrate(int v, PolynomialFunction a, PolynomialFunction b);
    public Polynomial singleIntegrate(int v, PolynomialFunction a, PolynomialFunctionTerm b);
    public Polynomial singleIntegrate(int v, PolynomialFunctionTerm a, PolynomialFunction b);
    public Polynomial singleIntegrate(int v, PolynomialFunctionTerm a, PolynomialFunctionTerm b);
    public ScalarWrapper multipleIntegrate(int[] v, ScalarWrapper[] a, PolynomialFunction[] b);
    public ScalarWrapper multipleIntegrate(int[] v, ScalarWrapper[] a, PolynomialFunctionTerm[] b);
    public ScalarWrapper multipleIntegrate(int[] v, PolynomialFunction[] a, ScalarWrapper[] b);
    public ScalarWrapper multipleIntegrate(int[] v, PolynomialFunctionTerm[] a, ScalarWrapper[] b);
    public ScalarWrapper multipleIntegrate(int[] v, PolynomialFunction[] a, PolynomialFunction[] b);
    public ScalarWrapper multipleIntegrate(int[] v, PolynomialFunction[] a, PolynomialFunctionTerm[] b);
    public ScalarWrapper multipleIntegrate(int[] v, PolynomialFunctionTerm[] a, PolynomialFunction[] b);
    public ScalarWrapper multipleIntegrate(int[] v, PolynomialFunctionTerm[] a, PolynomialFunctionTerm[] b);

    @Override public Polynomial derivative(int v);
    @Override public Polynomial antiderivative(int v);
    @Override public Polynomial multipleAntiderivative(int v, int nAntiderivatives);
    @Override public Polynomial evaluateAntiderivative(int v, ScalarWrapper value);
    @Override public Polynomial singleIntegrate(int v, ScalarWrapper a, ScalarWrapper b);
    
}
