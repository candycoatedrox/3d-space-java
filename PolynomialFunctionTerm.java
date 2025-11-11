import java.util.ArrayList;
import java.util.Arrays;

public class PolynomialFunctionTerm extends Polynomial implements MultivariablePolynomial {
    
    private ScalarWrapper constantMultiple;
    private ScalarWrapper[] exponents;

    // also accepts a HashMap<Integer variable, ScalarWrapper exponent> that does NOT have to include all variables in dimension along with a dimension
    // ^ similarly also accepts a ScalarWrapper[][] where ScalarWrapper[2] = {variable, exponent}
    // exponent 0 = variable not present; if ALL exponents = 0, constant term

    public PolynomialFunctionTerm(ScalarWrapper constantMultiple, ScalarWrapper[] exponents) {
        super(exponents.length);
        this.constantMultiple = constantMultiple;
        this.exponents = exponents;
    }

    public PolynomialFunctionTerm(int constantMultiple, ScalarWrapper[] exponents) {
        this(new ScalarWrapper(constantMultiple), exponents);
    }

    public PolynomialFunctionTerm(Integer constantMultiple, ScalarWrapper[] exponents) {
        this(new ScalarWrapper(constantMultiple), exponents);
    }

    public PolynomialFunctionTerm(double constantMultiple, ScalarWrapper[] exponents) {
        this(new ScalarWrapper(constantMultiple), exponents);
    }

    public PolynomialFunctionTerm(Double constantMultiple, ScalarWrapper[] exponents) {
        this(new ScalarWrapper(constantMultiple), exponents);
    }

    public PolynomialFunctionTerm(Rational constantMultiple, ScalarWrapper[] exponents) {
        this(new ScalarWrapper(constantMultiple), exponents);
    }

    public PolynomialFunctionTerm(ScalarWrapper constantMultiple, int[] exponents) {
        this(constantMultiple, ScalarWrapper.wrapArray(exponents));
    }

    public PolynomialFunctionTerm(int constantMultiple, int[] exponents) {
        this(new ScalarWrapper(constantMultiple), ScalarWrapper.wrapArray(exponents));
    }

    public PolynomialFunctionTerm(Integer constantMultiple, int[] exponents) {
        this(new ScalarWrapper(constantMultiple), ScalarWrapper.wrapArray(exponents));
    }

    public PolynomialFunctionTerm(double constantMultiple, int[] exponents) {
        this(new ScalarWrapper(constantMultiple), ScalarWrapper.wrapArray(exponents));
    }

    public PolynomialFunctionTerm(Double constantMultiple, int[] exponents) {
        this(new ScalarWrapper(constantMultiple), ScalarWrapper.wrapArray(exponents));
    }

    public PolynomialFunctionTerm(Rational constantMultiple, int[] exponents) {
        this(new ScalarWrapper(constantMultiple), ScalarWrapper.wrapArray(exponents));
    }

    public PolynomialFunctionTerm(ScalarWrapper constant, int dim) {
        super(dim);
        this.constantMultiple = constant;

        this.exponents = new ScalarWrapper[dim];
        for (int i = 0; i < dim; i++) {
            this.exponents[i] = new ScalarWrapper();
        }
    }

    public PolynomialFunctionTerm(int constant, int dim) {
        super(dim);
        this.constantMultiple = new ScalarWrapper(constant);

        this.exponents = new ScalarWrapper[dim];
        for (int i = 0; i < dim; i++) {
            this.exponents[i] = new ScalarWrapper();
        }
    }

    public PolynomialFunctionTerm(Integer constant, int dim) {
        this(new ScalarWrapper(constant), dim);
    }

    public PolynomialFunctionTerm(double constant, int dim) {
        this(new ScalarWrapper(constant), dim);
    }

    public PolynomialFunctionTerm(Double constant, int dim) {
        this(new ScalarWrapper(constant), dim);
    }

    public PolynomialFunctionTerm(Rational constant, int dim) {
        this(new ScalarWrapper(constant), dim);
    }

    public PolynomialFunctionTerm(int dim) {
        this(new ScalarWrapper(), dim);
    }

    public ScalarWrapper getConstantMultiple() {
        return this.constantMultiple;
    }

    public ScalarWrapper getExponent(int v) {
        this.checkVariableIndex(v);
        return this.exponents[v];
    }

    private void setExponent(int v, ScalarWrapper newValue) {
        this.checkVariableIndex(v);
        this.exponents[v] = newValue;
    }

    private void setExponent(int v, int newValue) {
        this.checkVariableIndex(v);
        this.exponents[v] = new ScalarWrapper(newValue);
    }

    private void setExponent(int v, Integer newValue) {
        this.checkVariableIndex(v);
        this.exponents[v] = new ScalarWrapper(newValue);
    }

    private void setExponent(int v, double newValue) {
        this.checkVariableIndex(v);
        this.exponents[v] = new ScalarWrapper(newValue);
    }

    private void setExponent(int v, Double newValue) {
        this.checkVariableIndex(v);
        this.exponents[v] = new ScalarWrapper(newValue);
    }

    private void setExponent(int v, Rational newValue) {
        this.checkVariableIndex(v);
        this.exponents[v] = new ScalarWrapper(newValue);
    }

    private void setExponentZero(int v) {
        this.checkVariableIndex(v);
        this.exponents[v] = new ScalarWrapper();
    }

    public ScalarWrapper totalDegree() {
        ScalarWrapper degree = new ScalarWrapper();
        for (ScalarWrapper e : exponents) {
            degree = degree.add(e);
        }

        return degree;
    }

    /**
     * Returns the sign of this term as a String
     * @return "+" if this PolynomialFunctionTerm is positive; "-" otherwise
     */
    public String sign() {
        if (this.constantMultiple.isPositive()) {
            return "+";
        } else {
            return "-";
        }
    }

    @Override
    public boolean includes(int v) {
        this.checkVariableIndex(v);
        return this.exponents[v].equals(0);
    }

    @Override
    public ArrayList<Integer> includedVariables() {
        ArrayList<Integer> included = new ArrayList<>();

        for (int i = 0; i < this.dim; i++) {
            if (this.includes(i)) {
                included.add(i);
            }
        }

        return included;
    }

    @Override
    public int nVariablesIncluded() {
        return this.includedVariables().size();
    }

    @Override
    public boolean isConstant() {
        return this.nVariablesIncluded() == 0;
    }

    public boolean isLikeTerm(PolynomialFunctionTerm other) {
        return Arrays.equals(this.exponents, other.exponents);
    }

    /**
     * Checks whether a term is positive (or zero) or negative
     * @return true if the constant multiple of this PolynomialFunctionTerm is positive; false otherwise
     */
    public boolean isPositive() {
        return this.constantMultiple.isPositive();
    }

    @Override
    public PolynomialFunctionTerm negative() {
        return new PolynomialFunctionTerm(this.constantMultiple.negative(), this.exponents);
    }

    @Override
    public PolynomialFunctionTerm absolute() {
        if (this.isPositive()) {
            return this;
        } else {
            return this.negative();
        }
    }

    public boolean equals(PolynomialFunctionTerm other) {
        return this.constantMultiple.equals(other.constantMultiple) && this.isLikeTerm(other);
    }

    @Override
    public PolynomialFunction add(PolynomialFunctionTerm other) {
        PolynomialFunctionTerm[] sum = {this, other};
        return new PolynomialFunction(sum);
    }

    @Override
    public PolynomialFunction add(PolynomialFunction other) {
        return other.add(this);
    }

    public static PolynomialFunctionTerm addLikeTerms(PolynomialFunctionTerm a, PolynomialFunctionTerm b) {
        if (a.isLikeTerm(b)) {
            return new PolynomialFunctionTerm(a.constantMultiple.add(b.constantMultiple), a.exponents);
        } else {
            throw new IllegalArgumentException("Terms must have the same degree(s)");
        }
    }

    @Override
    public PolynomialFunction subtract(PolynomialFunctionTerm other) {
        return this.add(other.negative());
    }

    @Override
    public PolynomialFunction subtract(PolynomialFunction other) {
        return other.subtract(this);
    }

    public static PolynomialFunctionTerm subtractLikeTerms(PolynomialFunctionTerm a, PolynomialFunctionTerm b) {
        if (a.isLikeTerm(b)) {
            return new PolynomialFunctionTerm(a.constantMultiple.subtract(b.constantMultiple), a.exponents);
        } else {
            throw new IllegalArgumentException("Terms must have the same degree(s)");
        }
    }

    @Override
    public PolynomialFunction multiply(PolynomialFunction other) {
        return other.multiply(this);
    }

    @Override
    public PolynomialFunctionTerm multiply(PolynomialFunctionTerm other) {
        ScalarWrapper productConstantMultiple = this.constantMultiple.multiply(other.constantMultiple);
        ScalarWrapper[] productExponents = new ScalarWrapper[this.dim];
        for (int v = 0; v < this.dim; v++) {
            productExponents[v] = this.getExponent(v).add(other.getExponent(v));
        }

        return new PolynomialFunctionTerm(productConstantMultiple, productExponents);
    }

    @Override
    public PolynomialFunctionTerm multiply(ScalarWrapper other) {
        return new PolynomialFunctionTerm(this.constantMultiple.multiply(other), this.exponents);
    }

    @Override
    public PolynomialFunctionTerm multiply(int other) {
        return new PolynomialFunctionTerm(this.constantMultiple.multiply(other), this.exponents);
    }

    @Override
    public PolynomialFunctionTerm multiply(Integer other) {
        return new PolynomialFunctionTerm(this.constantMultiple.multiply(other), this.exponents);
    }

    @Override
    public PolynomialFunctionTerm multiply(double other) {
        return new PolynomialFunctionTerm(this.constantMultiple.multiply(other), this.exponents);
    }

    @Override
    public PolynomialFunctionTerm multiply(Double other) {
        return new PolynomialFunctionTerm(this.constantMultiple.multiply(other), this.exponents);
    }

    @Override
    public PolynomialFunctionTerm multiply(Rational other) {
        return new PolynomialFunctionTerm(this.constantMultiple.multiply(other), this.exponents);
    }

    @Override
    public PolynomialFunctionTerm divideBy(PolynomialFunctionTerm other) {
        ScalarWrapper quotientConstantMultiple = this.constantMultiple.divideBy(other.constantMultiple);
        ScalarWrapper[] quotientExponents = new ScalarWrapper[this.dim];
        for (int v = 0; v < this.dim; v++) {
            quotientExponents[v] = this.getExponent(v).subtract(other.getExponent(v));
        }

        return new PolynomialFunctionTerm(quotientConstantMultiple, quotientExponents);
    }

    @Override
    public PolynomialFunctionTerm divideBy(ScalarWrapper other) {
        return this.multiply(other.invert());
    }

    @Override
    public PolynomialFunctionTerm divideBy(int other) {
        return this.multiply(1 / other);
    }

    @Override
    public PolynomialFunctionTerm divideBy(Integer other) {
        return this.multiply(1 / other);
    }

    @Override
    public PolynomialFunctionTerm divideBy(double other) {
        return this.multiply(1 / other);
    }

    @Override
    public PolynomialFunctionTerm divideBy(Double other) {
        return this.multiply(1 / other);
    }

    @Override
    public PolynomialFunctionTerm divideBy(Rational other) {
        return this.multiply(other.invert());
    }

    @Override
    public PolynomialFunctionTerm squared() {
        return this.multiply(this);
    }

    @Override
    public PolynomialFunctionTerm toPower(int power) {
        if (power == 0) {
            return new PolynomialFunctionTerm(1, this.dim);
        } else if (power == 1) {
            return this;
        } else {
            PolynomialFunctionTerm product = this;
            for (int i = 0; i < power - 1; i++) {
                product = product.multiply(this);
            }

            return product;
        }
    }

    // allow all calculus functions to take all kinds of scalar arguments... guh

    @Override
    public ScalarWrapper evaluate(ScalarWrapper[] variables) {
        if (this.isOfLengthDim(variables)) {
            ScalarWrapper value = this.constantMultiple;
            for (int v : this.includedVariables()) {
                value = value.multiply(this.evaluateVariable(v, variables[v]));
            }
            return value;
        } else {
            throw new RuntimeException("Cannot evaluate with wrong number of variables");
        }
    }

    @Override
    public PolynomialFunctionTerm evaluateOneVariable(int v, ScalarWrapper value) {
        ScalarWrapper varValue = this.evaluateVariable(v, value);
        ScalarWrapper newConstantMultiple = this.constantMultiple.multiply(varValue);
        PolynomialFunctionTerm result = new PolynomialFunctionTerm(newConstantMultiple, this.exponents);
        result.setExponentZero(v);

        return result;
    }

    @Override
    public Polynomial evaluateOneVariable(int v, Function value) {
        if (value instanceof PolynomialFunction pValue) {
            return this.evaluateOneVariable(v, pValue);
        } else if (value instanceof PolynomialFunctionTerm pValue) {
            return this.evaluateOneVariable(v, pValue);
        } else {
            throw new IllegalArgumentException("Non-polynomials are currently unsupported");
        }
    }

    public PolynomialFunction evaluateOneVariable(int v, PolynomialFunction value) {
        PolynomialFunctionTerm remainingVariables = this.clone();
        remainingVariables.setExponentZero(v);
        PolynomialFunction varValue = this.evaluateVariable(v, value);

        return remainingVariables.multiply(varValue);
    }

    public PolynomialFunctionTerm evaluateOneVariable(int v, PolynomialFunctionTerm value) {
        PolynomialFunctionTerm remainingVariables = this.clone();
        remainingVariables.setExponentZero(v);
        PolynomialFunctionTerm varValue = this.evaluateVariable(v, value);

        return remainingVariables.multiply(varValue);
    }

    private ScalarWrapper evaluateVariable(int v, ScalarWrapper value) {
        return value.toPower(this.exponents[v]);
    }

    private PolynomialFunction evaluateVariable(int v, PolynomialFunction value) {
        if (this.exponents[v].isInt()) {
            return value.toPower(this.exponents[v].getInt());
        } else {
            throw new IllegalArgumentException("Exponent must be an integer");
        }
    }

    private PolynomialFunctionTerm evaluateVariable(int v, PolynomialFunctionTerm value) {
        if (this.exponents[v].isInt()) {
            return value.toPower(this.exponents[v].getInt());
        } else {
            throw new IllegalArgumentException("Exponent must be an integer");
        }
    }

    @Override
    public PolynomialFunctionTerm derivative(int v) {
        if (this.getExponent(v).equals(0)) {
            return new PolynomialFunctionTerm(this.dim); // return 0
        }

        ScalarWrapper newVExponent = this.getExponent(v).subtract(1);
        PolynomialFunctionTerm d = this.clone();
        if (!newVExponent.equals(0)) {
            d = d.multiply(newVExponent);
        }
        d.setExponent(v, newVExponent);

        return d;
    }

    @Override
    public PolynomialFunctionTerm multipleDerivative(int[] v) {
        PolynomialFunctionTerm prevTerm = this;
        PolynomialFunctionTerm currentTerm = this;
        
        for (int i = 0; i < v.length; i++) {
            currentTerm = prevTerm.derivative(v[i]);
            prevTerm = currentTerm.clone();
        }

        return currentTerm;
    }

    @Override
    public PolynomialFunctionTerm evaluateDerivative(int v, ScalarWrapper value) {
        PolynomialFunctionTerm derivative = this.derivative(v);
        return derivative.evaluateOneVariable(v, value);
    }

    @Override
    public ScalarWrapper evaluateDerivative(int v, ScalarWrapper[] variables) {
        PolynomialFunctionTerm derivative = this.derivative(v);
        return derivative.evaluate(variables);
    }

    @Override
    public PolynomialFunctionTerm antiderivative(int v) {
        ScalarWrapper newVExponent = this.getExponent(v).add(1);
        PolynomialFunctionTerm a = this.clone();
        if (!newVExponent.equals(0)) {
            a = a.divideBy(newVExponent);
        }
        a.setExponent(v, newVExponent);

        return a;
    }

    @Override
    public PolynomialFunctionTerm multipleAntiderivative(int v, int nAntiderivatives) {
        PolynomialFunctionTerm prevTerm = this;
        PolynomialFunctionTerm currentTerm = this;
        
        for (int i = 0; i < nAntiderivatives; i++) {
            currentTerm = prevTerm.antiderivative(v);
            prevTerm = currentTerm.clone();
        }

        return currentTerm;
    }

    @Override
    public PolynomialFunctionTerm evaluateAntiderivative(int v, ScalarWrapper value) {
        PolynomialFunctionTerm antiderivative = this.antiderivative(v);
        return antiderivative.evaluateOneVariable(v, value);
    }

    @Override
    public Polynomial evaluateAntiderivative(int v, Function value) {
        PolynomialFunctionTerm antiderivative = this.antiderivative(v);
        return antiderivative.evaluateOneVariable(v, value);
    }

    public PolynomialFunction evaluateAntiderivative(int v, PolynomialFunction value) {
        PolynomialFunctionTerm antiderivative = this.antiderivative(v);
        return antiderivative.evaluateOneVariable(v, value);
    }

    public PolynomialFunctionTerm evaluateAntiderivative(int v, PolynomialFunctionTerm value) {
        PolynomialFunctionTerm antiderivative = this.antiderivative(v);
        return antiderivative.evaluateOneVariable(v, value);
    }

    @Override
    public ScalarWrapper evaluateAntiderivative(int v, ScalarWrapper[] variables) {
        PolynomialFunctionTerm antiderivative = this.antiderivative(v);
        return antiderivative.evaluate(variables);
    }

    @Override
    public PolynomialFunctionTerm singleIntegrate(int v, ScalarWrapper a, ScalarWrapper b) {
        return subtractLikeTerms(this.evaluateAntiderivative(v, b), this.evaluateAntiderivative(v, a));
    }

    @Override
    public Polynomial singleIntegrate(int v, ScalarWrapper a, Function b) {
        if (b instanceof PolynomialFunction pb) {
            return this.singleIntegrate(v, a, pb);
        } else if (b instanceof PolynomialFunctionTerm pb) {
            return this.singleIntegrate(v, a, pb);
        } else {
            throw new IllegalArgumentException("Non-polynomials are currently unsupported");
        }
    }

    @Override
    public PolynomialFunction singleIntegrate(int v, ScalarWrapper a, PolynomialFunction b) {
        return this.evaluateAntiderivative(v, b).subtract(this.evaluateAntiderivative(v, a));
    }

    @Override
    public PolynomialFunction singleIntegrate(int v, ScalarWrapper a, PolynomialFunctionTerm b) {
        return this.evaluateAntiderivative(v, b).subtract(this.evaluateAntiderivative(v, a));
    }

    @Override
    public Polynomial singleIntegrate(int v, Function a, ScalarWrapper b) {
        if (a instanceof PolynomialFunction pa) {
            return this.singleIntegrate(v, pa, b);
        } else if (a instanceof PolynomialFunctionTerm pa) {
            return this.singleIntegrate(v, pa, b);
        } else {
            throw new IllegalArgumentException("Non-polynomials are currently unsupported");
        }
    }
    
    @Override
    public Polynomial singleIntegrate(int v, Function a, Function b) {
        if (a instanceof PolynomialFunction pa) {
            if (b instanceof PolynomialFunction pb) {
                return this.singleIntegrate(v, pa, pb);
            } else if (b instanceof PolynomialFunctionTerm pb) {
                return this.singleIntegrate(v, pa, pb);
            } else {
                throw new IllegalArgumentException("Non-polynomials are currently unsupported");
            }
        } else if (a instanceof PolynomialFunctionTerm pa) {
            if (b instanceof PolynomialFunction pb) {
                return this.singleIntegrate(v, pa, pb);
            } else if (b instanceof PolynomialFunctionTerm pb) {
                return this.singleIntegrate(v, pa, pb);
            } else {
                throw new IllegalArgumentException("Non-polynomials are currently unsupported");
            }
        } else {
            throw new IllegalArgumentException("Non-polynomials are currently unsupported");
        }
    }

    @Override
    public PolynomialFunction singleIntegrate(int v, PolynomialFunction a, ScalarWrapper b) {
        return this.evaluateAntiderivative(v, b).subtract(this.evaluateAntiderivative(v, a));
    }

    @Override
    public PolynomialFunction singleIntegrate(int v, PolynomialFunction a, PolynomialFunction b) {
        return this.evaluateAntiderivative(v, b).subtract(this.evaluateAntiderivative(v, a));
    }

    @Override
    public PolynomialFunction singleIntegrate(int v, PolynomialFunction a, PolynomialFunctionTerm b) {
        return this.evaluateAntiderivative(v, b).subtract(this.evaluateAntiderivative(v, a));
    }

    @Override
    public PolynomialFunction singleIntegrate(int v, PolynomialFunctionTerm a, ScalarWrapper b) {
        return this.evaluateAntiderivative(v, b).subtract(this.evaluateAntiderivative(v, a));
    }

    @Override
    public PolynomialFunction singleIntegrate(int v, PolynomialFunctionTerm a, PolynomialFunction b) {
        return this.evaluateAntiderivative(v, b).subtract(this.evaluateAntiderivative(v, a));
    }

    @Override
    public PolynomialFunction singleIntegrate(int v, PolynomialFunctionTerm a, PolynomialFunctionTerm b) {
        return this.evaluateAntiderivative(v, b).subtract(this.evaluateAntiderivative(v, a));
    }

    @Override
    public ScalarWrapper multipleIntegrate(int[] v, ScalarWrapper[] a, ScalarWrapper[] b) {
        if (!this.isOfLengthDim(v) || Util.containsDuplicates(v)) {
            throw new IllegalArgumentException("Must include all variables in order of integration");
        } else if (!this.isOfLengthDim(a) || !this.isOfLengthDim(b)) {
            throw new IllegalArgumentException("Must include bounds for all variables");
        } else {
            PolynomialFunction prevIntegration = new PolynomialFunction(this);
            PolynomialFunction currentIntegration = new PolynomialFunction(this);

            for (int i = 0; i < v.length; i++) {
                currentIntegration = prevIntegration.singleIntegrate(v[i], a[i], b[i]);
                prevIntegration = currentIntegration;
            }

            return currentIntegration.evaluate();
        }
    }

    @Override
    public ScalarWrapper multipleIntegrate(int[] v, ScalarWrapper[] a, Function[] b) {
        if (b instanceof PolynomialFunction[] pb) {
            return this.multipleIntegrate(v, a, pb);
        } else if (b instanceof PolynomialFunctionTerm[] pb) {
            return this.multipleIntegrate(v, a, pb);
        } else {
            throw new IllegalArgumentException("Non-polynomial functions are currently unsupported");
        }
    }

    @Override
    public ScalarWrapper multipleIntegrate(int[] v, ScalarWrapper[] a, PolynomialFunction[] b) {
        if (!this.isOfLengthDim(v) || Util.containsDuplicates(v)) {
            throw new IllegalArgumentException("Must include all variables in order of integration");
        } else if (!this.isOfLengthDim(a) || !this.isOfLengthDim(b)) {
            throw new IllegalArgumentException("Must include bounds for all variables");
        } else {
            // ensure that bounds for inner integrals are only in terms of outer integrals
            for (int i = 1; i < this.dim; i++) {
                for (int j = 1; j < i; j++) {
                    if (b[i].includes(v[j])) {
                        throw new IllegalArgumentException("Variable bounds cannot be in terms of an already-integrated variable");
                    }
                }
            }
        }

        PolynomialFunction prevIntegration = new PolynomialFunction(this);
        PolynomialFunction currentIntegration = new PolynomialFunction(this);

        for (int i = 0; i < v.length; i++) {
            currentIntegration = prevIntegration.singleIntegrate(v[i], a[i], b[i]);
            prevIntegration = currentIntegration;
        }

        return currentIntegration.evaluate();
    }

    @Override
    public ScalarWrapper multipleIntegrate(int[] v, ScalarWrapper[] a, PolynomialFunctionTerm[] b) {
        if (!this.isOfLengthDim(v) || Util.containsDuplicates(v)) {
            throw new IllegalArgumentException("Must include all variables in order of integration");
        } else if (!this.isOfLengthDim(a) || !this.isOfLengthDim(b)) {
            throw new IllegalArgumentException("Must include bounds for all variables");
        } else {
            // ensure that bounds for inner integrals are only in terms of outer integrals
            for (int i = 1; i < this.dim; i++) {
                for (int j = 1; j < i; j++) {
                    if (b[i].includes(v[j])) {
                        throw new IllegalArgumentException("Variable bounds cannot be in terms of an already-integrated variable");
                    }
                }
            }
        }

        PolynomialFunction prevIntegration = new PolynomialFunction(this);
        PolynomialFunction currentIntegration = new PolynomialFunction(this);

        for (int i = 0; i < v.length; i++) {
            currentIntegration = prevIntegration.singleIntegrate(v[i], a[i], b[i]);
            prevIntegration = currentIntegration;
        }

        return currentIntegration.evaluate();
    }

    @Override
    public ScalarWrapper multipleIntegrate(int[] v, Function[] a, ScalarWrapper[] b) {
        if (a instanceof PolynomialFunction[] pa) {
            return this.multipleIntegrate(v, pa, b);
        } else if (a instanceof PolynomialFunctionTerm[] pa) {
            return this.multipleIntegrate(v, pa, b);
        } else {
            throw new IllegalArgumentException("Non-polynomial functions are currently unsupported");
        }
    }

    @Override
    public ScalarWrapper multipleIntegrate(int[] v, PolynomialFunction[] a, ScalarWrapper[] b) {
        if (!this.isOfLengthDim(v) || Util.containsDuplicates(v)) {
            throw new IllegalArgumentException("Must include all variables in order of integration");
        } else if (!this.isOfLengthDim(a) || !this.isOfLengthDim(b)) {
            throw new IllegalArgumentException("Must include bounds for all variables");
        } else {
            // ensure that bounds for inner integrals are only in terms of outer integrals
            for (int i = 1; i < this.dim; i++) {
                for (int j = 1; j < i; j++) {
                    if (a[i].includes(v[j])) {
                        throw new IllegalArgumentException("Variable bounds cannot be in terms of an already-integrated variable");
                    }
                }
            }
        }

        PolynomialFunction prevIntegration = new PolynomialFunction(this);
        PolynomialFunction currentIntegration = new PolynomialFunction(this);

        for (int i = 0; i < v.length; i++) {
            currentIntegration = prevIntegration.singleIntegrate(v[i], a[i], b[i]);
            prevIntegration = currentIntegration;
        }

        return currentIntegration.evaluate();
    }

    @Override
    public ScalarWrapper multipleIntegrate(int[] v, PolynomialFunctionTerm[] a, ScalarWrapper[] b) {
        if (!this.isOfLengthDim(v) || Util.containsDuplicates(v)) {
            throw new IllegalArgumentException("Must include all variables in order of integration");
        } else if (!this.isOfLengthDim(a) || !this.isOfLengthDim(b)) {
            throw new IllegalArgumentException("Must include bounds for all variables");
        } else {
            // ensure that bounds for inner integrals are only in terms of outer integrals
            for (int i = 1; i < this.dim; i++) {
                for (int j = 1; j < i; j++) {
                    if (a[i].includes(v[j])) {
                        throw new IllegalArgumentException("Variable bounds cannot be in terms of an already-integrated variable");
                    }
                }
            }
        }

        PolynomialFunction prevIntegration = new PolynomialFunction(this);
        PolynomialFunction currentIntegration = new PolynomialFunction(this);

        for (int i = 0; i < v.length; i++) {
            currentIntegration = prevIntegration.singleIntegrate(v[i], a[i], b[i]);
            prevIntegration = currentIntegration;
        }

        return currentIntegration.evaluate();
    }

    @Override
    public ScalarWrapper multipleIntegrate(int[] v, Function[] a, Function[] b) {
        if (a instanceof PolynomialFunction[] pa) {
            if (b instanceof PolynomialFunction[] pb) {
                return this.multipleIntegrate(v, pa, pb);
            } else if (b instanceof PolynomialFunctionTerm[] pb) {
                return this.multipleIntegrate(v, pa, pb);
            } else {
                throw new IllegalArgumentException("Non-polynomial functions are currently unsupported");
            }
        } else if (a instanceof PolynomialFunctionTerm[] pa) {
            if (b instanceof PolynomialFunction[] pb) {
                return this.multipleIntegrate(v, pa, pb);
            } else if (b instanceof PolynomialFunctionTerm[] pb) {
                return this.multipleIntegrate(v, pa, pb);
            } else {
                throw new IllegalArgumentException("Non-polynomial functions are currently unsupported");
            }
        } else {
            throw new IllegalArgumentException("Non-polynomial functions are currently unsupported");
        }
    }

    @Override
    public ScalarWrapper multipleIntegrate(int[] v, PolynomialFunction[] a, PolynomialFunction[] b) {
        if (!this.isOfLengthDim(v) || Util.containsDuplicates(v)) {
            throw new IllegalArgumentException("Must include all variables in order of integration");
        } else if (!this.isOfLengthDim(a) || !this.isOfLengthDim(b)) {
            throw new IllegalArgumentException("Must include bounds for all variables");
        } else {
            // ensure that bounds for inner integrals are only in terms of outer integrals
            for (int i = 1; i < this.dim; i++) {
                for (int j = 1; j < i; j++) {
                    if (a[i].includes(v[j]) || b[i].includes(v[j])) {
                        throw new IllegalArgumentException("Variable bounds cannot be in terms of an already-integrated variable");
                    }
                }
            }
        }

        PolynomialFunction prevIntegration = new PolynomialFunction(this);
        PolynomialFunction currentIntegration = new PolynomialFunction(this);

        for (int i = 0; i < v.length; i++) {
            currentIntegration = prevIntegration.singleIntegrate(v[i], a[i], b[i]);
            prevIntegration = currentIntegration;
        }

        return currentIntegration.evaluate();
    }

    @Override
    public ScalarWrapper multipleIntegrate(int[] v, PolynomialFunction[] a, PolynomialFunctionTerm[] b) {
        if (!this.isOfLengthDim(v) || Util.containsDuplicates(v)) {
            throw new IllegalArgumentException("Must include all variables in order of integration");
        } else if (!this.isOfLengthDim(a) || !this.isOfLengthDim(b)) {
            throw new IllegalArgumentException("Must include bounds for all variables");
        } else {
            // ensure that bounds for inner integrals are only in terms of outer integrals
            for (int i = 1; i < this.dim; i++) {
                for (int j = 1; j < i; j++) {
                    if (a[i].includes(v[j]) || b[i].includes(v[j])) {
                        throw new IllegalArgumentException("Variable bounds cannot be in terms of an already-integrated variable");
                    }
                }
            }
        }

        PolynomialFunction prevIntegration = new PolynomialFunction(this);
        PolynomialFunction currentIntegration = new PolynomialFunction(this);

        for (int i = 0; i < v.length; i++) {
            currentIntegration = prevIntegration.singleIntegrate(v[i], a[i], b[i]);
            prevIntegration = currentIntegration;
        }

        return currentIntegration.evaluate();
    }

    @Override
    public ScalarWrapper multipleIntegrate(int[] v, PolynomialFunctionTerm[] a, PolynomialFunction[] b) {
        if (!this.isOfLengthDim(v) || Util.containsDuplicates(v)) {
            throw new IllegalArgumentException("Must include all variables in order of integration");
        } else if (!this.isOfLengthDim(a) || !this.isOfLengthDim(b)) {
            throw new IllegalArgumentException("Must include bounds for all variables");
        } else {
            // ensure that bounds for inner integrals are only in terms of outer integrals
            for (int i = 1; i < this.dim; i++) {
                for (int j = 1; j < i; j++) {
                    if (a[i].includes(v[j]) || b[i].includes(v[j])) {
                        throw new IllegalArgumentException("Variable bounds cannot be in terms of an already-integrated variable");
                    }
                }
            }
        }

        PolynomialFunction prevIntegration = new PolynomialFunction(this);
        PolynomialFunction currentIntegration = new PolynomialFunction(this);

        for (int i = 0; i < v.length; i++) {
            currentIntegration = prevIntegration.singleIntegrate(v[i], a[i], b[i]);
            prevIntegration = currentIntegration;
        }

        return currentIntegration.evaluate();
    }

    @Override
    public ScalarWrapper multipleIntegrate(int[] v, PolynomialFunctionTerm[] a, PolynomialFunctionTerm[] b) {
        if (!this.isOfLengthDim(v) || Util.containsDuplicates(v)) {
            throw new IllegalArgumentException("Must include all variables in order of integration");
        } else if (!this.isOfLengthDim(a) || !this.isOfLengthDim(b)) {
            throw new IllegalArgumentException("Must include bounds for all variables");
        } else {
            // ensure that bounds for inner integrals are only in terms of outer integrals
            for (int i = 1; i < this.dim; i++) {
                for (int j = 1; j < i; j++) {
                    if (a[i].includes(v[j]) || b[i].includes(v[j])) {
                        throw new IllegalArgumentException("Variable bounds cannot be in terms of an already-integrated variable");
                    }
                }
            }
        }

        PolynomialFunction prevIntegration = new PolynomialFunction(this);
        PolynomialFunction currentIntegration = new PolynomialFunction(this);

        for (int i = 0; i < v.length; i++) {
            currentIntegration = prevIntegration.singleIntegrate(v[i], a[i], b[i]);
            prevIntegration = currentIntegration;
        }

        return currentIntegration.evaluate();
    }

    @Override
    public PolynomialFunctionTerm clone() {
        return new PolynomialFunctionTerm(this.constantMultiple.clone(), Util.deepCopy(this.exponents));
    }

    @Override
    public String toString() {
        // don't include the sign - that's what the sign() function is for, PolynomialFunction handles it
        String s = this.constantMultiple.absolute().toString();
        ArrayList<Integer> included = this.includedVariables();

        if (included.size() == 1) {
            s += variableNames[included.get(0)] + "^" + this.exponents[included.get(0)];
        } else if (included.size() > 1) {
            for (int v : included) {
                s += "(" + variableNames[v] + "^" + this.exponents[v] + ")";
            }
        }

        return s;
    }

}
