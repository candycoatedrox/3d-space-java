public interface MultivariablePolynomial extends MultivariableFunction {

    public abstract PolynomialFunction singleIntegrate(int v, ScalarWrapper a, PolynomialFunction b);
    public abstract Polynomial singleIntegrate(int v, ScalarWrapper a, PolynomialFunctionTerm b);
    public abstract PolynomialFunction singleIntegrate(int v, PolynomialFunction a, ScalarWrapper b);
    public abstract Polynomial singleIntegrate(int v, PolynomialFunctionTerm a, ScalarWrapper b);
    public abstract Polynomial singleIntegrate(int v, PolynomialFunction a, PolynomialFunction b);
    public abstract Polynomial singleIntegrate(int v, PolynomialFunction a, PolynomialFunctionTerm b);
    public abstract Polynomial singleIntegrate(int v, PolynomialFunctionTerm a, PolynomialFunction b);
    public abstract Polynomial singleIntegrate(int v, PolynomialFunctionTerm a, PolynomialFunctionTerm b);
    public abstract ScalarWrapper multipleIntegrate(int[] v, ScalarWrapper[] a, PolynomialFunction[] b);
    public abstract ScalarWrapper multipleIntegrate(int[] v, ScalarWrapper[] a, PolynomialFunctionTerm[] b);
    public abstract ScalarWrapper multipleIntegrate(int[] v, PolynomialFunction[] a, ScalarWrapper[] b);
    public abstract ScalarWrapper multipleIntegrate(int[] v, PolynomialFunctionTerm[] a, ScalarWrapper[] b);
    public abstract ScalarWrapper multipleIntegrate(int[] v, PolynomialFunction[] a, PolynomialFunction[] b);
    public abstract ScalarWrapper multipleIntegrate(int[] v, PolynomialFunction[] a, PolynomialFunctionTerm[] b);
    public abstract ScalarWrapper multipleIntegrate(int[] v, PolynomialFunctionTerm[] a, PolynomialFunction[] b);
    public abstract ScalarWrapper multipleIntegrate(int[] v, PolynomialFunctionTerm[] a, PolynomialFunctionTerm[] b);

    @Override public abstract Polynomial derivative(int v);
    @Override public abstract Polynomial antiderivative(int v);
    @Override public abstract Polynomial multipleAntiderivative(int v, int nAntiderivatives);
    @Override public abstract Polynomial evaluateAntiderivative(int v, ScalarWrapper value);
    @Override public abstract Polynomial singleIntegrate(int v, ScalarWrapper a, ScalarWrapper b);
    
}
