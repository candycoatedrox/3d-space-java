import java.util.HashMap;

public class PolynomialFunction1D extends Polynomial implements Function1D {
    
    // has a HashMap <ScalarWrapper exponent --> ScalarWrapper constantMultiple>
    // exponent 0 OR null = constant (x^0 = 1)

    // figure out how to order them from highest --> lowest exponent
    private ScalarWrapper[] constantMultiples;
    private ScalarWrapper[] exponents;

    // use LinkedHashSet to confirm that all constant multiples are unique, then addAll to the array

    public PolynomialFunction1D(ScalarWrapper[][] constants) {
        // inputs are ScalarWrapper[2] = {constantMultiple, exponent}
        super(1);
        this.components = new HashMap<>();

        if (constants.length == 0) {
            this.components.put(null, new ScalarWrapper(0));
        } else {
            for (ScalarWrapper[] term : constants) {
                if (term.length != 2) {
                    throw new IllegalArgumentException("All constant pairs must be of length 2");
                }

            }
        }
    }

    public PolynomialFunction1D(ScalarWrapper[] constantMultiples, ScalarWrapper[] exponents) {
        super(1);
        
        //pass
    }

    @Override
    public ScalarWrapper evaluate(ScalarWrapper[] variables) {
        if (this.isOfLengthDim(variables)) {
            return this.evaluate(variables[0]);
        } else {
            throw new RuntimeException("Cannot evaluate with wrong number of variables");
        }
    }

    // public ScalarWrapper evaluate(ScalarWrapper variable)

    @Override
    public PolynomialFunction1D derivative(int v) {

    }

    public PolynomialFunction1D derivative() {

    }

    @Override
    public PolynomialFunction1D antiderivative(int v) {
        
    }

    public PolynomialFunction1D antiderivative() {
        
    }

    @Override
    public PolynomialFunction multipleAntiderivative(int v, int nAntiderivatives) {

    }

    @Override
    public PolynomialFunction singleIntegrate(int v, ScalarWrapper a, ScalarWrapper b) {
        
    }

    @Override
    public ScalarWrapper multipleIntegrate(int[] v, ScalarWrapper a, ScalarWrapper b) {
        
    }

    @Override
    public ScalarWrapper integrate(int v, ScalarWrapper a, ScalarWrapper b) {
        
    }

    public ScalarWrapper integrate(ScalarWrapper a, ScalarWrapper b) {
        
    }

    // public String toString()
    // public String toString(int variable)

}
