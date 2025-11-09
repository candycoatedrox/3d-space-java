import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.stream.Stream;

public class PolynomialFunction extends Polynomial implements MultivariablePolynomial {
    
    // extends Function
    // for each variable, has a PolynomialFunctionTerm
    // also accepts a ScalarWrapper[][] as input (array of ScalarWrapper[2] = {constantMultiple, {variable, exponent}}) for only one term per variable

    private PolynomialFunctionTerm[] terms;

    public PolynomialFunction(PolynomialFunctionTerm[] terms) {
        super(terms[0].getDim());
        this.terms = terms;
        this.simplify();
    }

    public PolynomialFunction(ArrayList<PolynomialFunctionTerm> terms) {
        super(terms.get(0).getDim());
        this.terms = terms.toArray(new PolynomialFunctionTerm[0]);
        this.simplify();
    }

    public PolynomialFunction(PolynomialFunctionTerm term) {
        super(term.getDim());
        PolynomialFunctionTerm[] terms = {term};
        this.terms = terms;
        this.simplify();
    }

    public final void simplify() {
        this.combineLikeTerms();
        this.sortTerms();
    }

    public final void combineLikeTerms() {
        if (this.nTerms() == 1) {
            return;
        }

        ArrayList<PolynomialFunctionTerm> remainingTerms = new ArrayList<>(Arrays.asList(this.terms));
        ArrayList<PolynomialFunctionTerm> newTerms = new ArrayList<>();
        PolynomialFunctionTerm currentTerm;

        for (int i = 0; i < remainingTerms.size() - 1; i++) {
            currentTerm = remainingTerms.get(i);

            for (int j = i+1; j < remainingTerms.size(); j++) {
                if (currentTerm.isLikeTerm(remainingTerms.get(j))) {
                    currentTerm = PolynomialFunctionTerm.addLikeTerms(currentTerm, remainingTerms.get(j));
                    remainingTerms.remove(j);
                }
            }

            newTerms.add(currentTerm.clone());
        }

        this.terms = newTerms.toArray(new PolynomialFunctionTerm[0]);
    }

    public final void sortTerms() {
        ScalarWrapper[] totalDegrees = this.totalDegrees();
        boolean isInOrder = false;

        // bubble sort because idk how else to do it
        while (!isInOrder) {
            isInOrder = true;
            for (int i = 0; i < this.nTerms() - 1; i++) {
                if (totalDegrees[i].lessThan(totalDegrees[i+1])) {
                    isInOrder = false;
                    Util.swap(this.terms, i, i+1);
                    Util.swap(totalDegrees, i, i+1);
                }
                
                else if (totalDegrees[i].equals(totalDegrees[i+1])) {
                    for (int v = 0; v < this.dim; v++) {
                        if (this.terms[i].getExponent(v).greaterThan(this.terms[i+1].getExponent(v))) {
                            isInOrder = false;
                            Util.swap(this.terms, i, i+1);
                            Util.swap(totalDegrees, i, i+1);
                            break;
                        }
                    }
                }
            }
        }
    }

    private ScalarWrapper[] totalDegrees() {
        ScalarWrapper[] degrees = new ScalarWrapper[this.nTerms()];
        for (int i = 0; i < this.nTerms(); i++) {
            degrees[i] = this.terms[i].totalDegree();
        }

        return degrees;
    }

    public PolynomialFunctionTerm getTerm(int i) {
        return this.terms[i];
    }

    public int nTerms() {
        return this.terms.length;
    }

    public boolean isSingleTerm() {
        if (this.nTerms() == 1) {
            return true;
        }

        return false;
    }

    @Override
    public boolean includes(int v) {
        this.checkVariableIndex(v);

        Integer objV = v;
        return this.includedVariables().contains(objV);
    }

    @Override
    public ArrayList<Integer> includedVariables() {
        LinkedHashSet<Integer> included = new LinkedHashSet<>();

        for (int t = 0; t < this.nTerms(); t++) {
            included.addAll(this.getTerm(t).includedVariables());
        }

        ArrayList<Integer> includedList = new ArrayList<>(included);
        return includedList;
    }

    @Override
    public int nVariablesIncluded() {
        return this.includedVariables().size();
    }

    @Override
    public boolean isConstant() {
        for (int t = 0; t < this.nTerms(); t++) {
            if (!this.getTerm(t).isConstant()) {
                return false;
            }
        }

        return true;
    }

    @Override
    public PolynomialFunction negative() {
        PolynomialFunctionTerm[] newTerms = new PolynomialFunctionTerm[this.nTerms()];
        for (int t = 0; t < this.nTerms(); t++) {
            newTerms[t] = this.terms[t].negative();
        }

        return new PolynomialFunction(newTerms);
    }

    @Override
    public PolynomialFunction absolute() {
        PolynomialFunctionTerm[] newTerms = new PolynomialFunctionTerm[this.nTerms()];
        for (int t = 0; t < this.nTerms(); t++) {
            newTerms[t] = this.terms[t].absolute();
        }

        return new PolynomialFunction(newTerms);
    }

    @Override
    public PolynomialFunction add(PolynomialFunction other) {
        PolynomialFunctionTerm[] sumTerms = Stream.concat(Arrays.stream(this.terms), Arrays.stream(other.terms)).toArray(PolynomialFunctionTerm[]::new);
        // like terms will be combined and organized in the constructor!
        return new PolynomialFunction(sumTerms);
    }

    @Override
    public PolynomialFunction add(PolynomialFunctionTerm other) {
        PolynomialFunctionTerm[] sumTerms = new PolynomialFunctionTerm[this.nTerms() + 1];
        for (int t = 0; t < this.nTerms(); t++) {
            sumTerms[t] = this.getTerm(t);
        }
        sumTerms[this.nTerms()] = other;
        
        // like terms will be combined and organized in the constructor!
        return new PolynomialFunction(sumTerms);
    }

    @Override
    public PolynomialFunction subtract(PolynomialFunction other) {
        return this.add(other.negative());
    }

    @Override
    public PolynomialFunction subtract(PolynomialFunctionTerm other) {
        return this.add(other.negative());
    }

    @Override
    public PolynomialFunction multiply(PolynomialFunction other) {
        ArrayList<PolynomialFunctionTerm> newTerms = new ArrayList<>();
        for (int i = 0; i < this.nTerms(); i++) {
            for (int j = 0; j < other.nTerms(); j++) {
                newTerms.add(this.getTerm(i).multiply(other.getTerm(j)));
            }
        }

        return new PolynomialFunction(newTerms.toArray(new PolynomialFunctionTerm[0]));
    }

    @Override
    public PolynomialFunction multiply(PolynomialFunctionTerm other) {
        PolynomialFunctionTerm[] newTerms = new PolynomialFunctionTerm[this.nTerms()];
        for (int i = 0; i < this.nTerms(); i++) {
            newTerms[i] = this.getTerm(i).multiply(other);
        }

        return new PolynomialFunction(newTerms);
    }

    @Override
    public PolynomialFunction multiply(ScalarWrapper other) {
        if (other.isInt()) {
            return this.multiply(other.getInt());
        } else if (other.isDouble()) {
            return this.multiply(other.getDouble());
        } else {
            return this.multiply(other.getRat());
        }
    }

    @Override
    public PolynomialFunction multiply(int other) {
        PolynomialFunctionTerm[] newTerms = new PolynomialFunctionTerm[this.nTerms()];
        for (int t = 0; t < this.nTerms(); t++) {
            newTerms[t] = this.terms[t].multiply(other);
        }

        return new PolynomialFunction(newTerms);
    }

    @Override
    public PolynomialFunction multiply(Integer other) {
        PolynomialFunctionTerm[] newTerms = new PolynomialFunctionTerm[this.nTerms()];
        for (int t = 0; t < this.nTerms(); t++) {
            newTerms[t] = this.terms[t].multiply(other);
        }

        return new PolynomialFunction(newTerms);
    }

    @Override
    public PolynomialFunction multiply(double other) {
        PolynomialFunctionTerm[] newTerms = new PolynomialFunctionTerm[this.nTerms()];
        for (int t = 0; t < this.nTerms(); t++) {
            newTerms[t] = this.terms[t].multiply(other);
        }

        return new PolynomialFunction(newTerms);
    }

    @Override
    public PolynomialFunction multiply(Double other) {
        PolynomialFunctionTerm[] newTerms = new PolynomialFunctionTerm[this.nTerms()];
        for (int t = 0; t < this.nTerms(); t++) {
            newTerms[t] = this.terms[t].multiply(other);
        }

        return new PolynomialFunction(newTerms);
    }

    @Override
    public PolynomialFunction multiply(Rational other) {
        PolynomialFunctionTerm[] newTerms = new PolynomialFunctionTerm[this.nTerms()];
        for (int t = 0; t < this.nTerms(); t++) {
            newTerms[t] = this.terms[t].multiply(other);
        }

        return new PolynomialFunction(newTerms);
    }

    @Override
    public PolynomialFunction divideBy(PolynomialFunctionTerm other) {
        PolynomialFunctionTerm[] newTerms = new PolynomialFunctionTerm[this.nTerms()];
        for (int i = 0; i < this.nTerms(); i++) {
            newTerms[i] = this.getTerm(i).divideBy(other);
        }

        return new PolynomialFunction(newTerms);
    }

    @Override
    public PolynomialFunction divideBy(ScalarWrapper other) {
        return this.multiply(other.invert());
    }

    @Override
    public PolynomialFunction divideBy(int other) {
        return this.multiply(1 / other);
    }

    @Override
    public PolynomialFunction divideBy(Integer other) {
        return this.multiply(1 / other);
    }

    @Override
    public PolynomialFunction divideBy(double other) {
        return this.multiply(1 / other);
    }

    @Override
    public PolynomialFunction divideBy(Double other) {
        return this.multiply(1 / other);
    }

    @Override
    public PolynomialFunction divideBy(Rational other) {
        return this.multiply(other.invert());
    }

    @Override
    public PolynomialFunction squared() {
        return this.multiply(this);
    }

    @Override
    public PolynomialFunction toPower(int power) {
        if (power == 0) {
            PolynomialFunctionTerm constant1 = new PolynomialFunctionTerm(1, this.dim);
            return new PolynomialFunction(constant1);
        } else if (power == 1) {
            return this;
        } else {
            PolynomialFunction product = this;
            for (int i = 0; i < power - 1; i++) {
                product = product.multiply(this);
            }

            return product;
        }
    }

    @Override
    public ScalarWrapper evaluate(ScalarWrapper[] variables) {
        if (this.isOfLengthDim(variables)) {
            ScalarWrapper value = new ScalarWrapper();

            for (PolynomialFunctionTerm term : this.terms) {
                value = value.add(term.evaluate(variables));
            }
            
            return value;
        } else {
            throw new RuntimeException("Cannot evaluate with wrong number of variables");
        }
    }

    public ScalarWrapper evaluate() {
        if (this.isConstant()) {
            return this.getTerm(0).getConstantMultiple();
        } else {
            throw new RuntimeException("Function is not a constant");
        }
    }

    @Override
    public PolynomialFunction evaluateOneVariable(int v, ScalarWrapper value) {
        PolynomialFunctionTerm[] newTerms = new PolynomialFunctionTerm[this.nTerms()];

        for (int t = 0; t < this.nTerms(); t++) {
            newTerms[t] = this.getTerm(t).evaluateOneVariable(v, value);
        }
        
        return new PolynomialFunction(newTerms);
    }

    @Override
    public PolynomialFunction evaluateOneVariable(int v, Function value) {
        if (value instanceof PolynomialFunction pValue) {
            return this.evaluateOneVariable(v, pValue);
        } else if (value instanceof PolynomialFunctionTerm pValue) {
            return this.evaluateOneVariable(v, pValue);
        } else {
            throw new IllegalArgumentException("Non-polynomials are currently unsupported");
        }
    }

    public PolynomialFunction evaluateOneVariable(int v, PolynomialFunction value) {
        ArrayList<PolynomialFunctionTerm> newTerms = new ArrayList<>();
        PolynomialFunction currentTerm;

        for (int t = 0; t < this.nTerms(); t++) {
            currentTerm = this.getTerm(t).evaluateOneVariable(v, value);
            newTerms.addAll(Arrays.asList(currentTerm.terms));
        }
        
        return new PolynomialFunction(newTerms);
    }

    public PolynomialFunction evaluateOneVariable(int v, PolynomialFunctionTerm value) {
        PolynomialFunctionTerm[] newTerms = new PolynomialFunctionTerm[this.nTerms()];

        for (int t = 0; t < this.nTerms(); t++) {
            newTerms[t] = this.getTerm(t).evaluateOneVariable(v, value);
        }
        
        return new PolynomialFunction(newTerms);
    }

    @Override
    public PolynomialFunction derivative(int v) {
        PolynomialFunctionTerm[] dTerms = new PolynomialFunctionTerm[this.nTerms()];
        for (int t = 0; t < this.nTerms(); t++) {
            dTerms[t] = this.getTerm(t).derivative(v);
        }

        return new PolynomialFunction(dTerms);
    }

    @Override
    public PolynomialFunction evaluateDerivative(int v, ScalarWrapper value) {
        PolynomialFunction derivative = this.derivative(v);
        return derivative.evaluateOneVariable(v, value);
    }

    @Override
    public ScalarWrapper evaluateDerivative(int v, ScalarWrapper[] variables) {
        PolynomialFunction derivative = this.derivative(v);
        return derivative.evaluate(variables);
    }

    @Override
    public PolynomialFunction multipleDerivative(int[] v) {
        PolynomialFunction prevFunction = this;
        PolynomialFunction currentFunction = this;
        
        for (int i = 0; i < v.length; i++) {
            currentFunction = prevFunction.derivative(v[i]);
            prevFunction = currentFunction.clone();
        }

        return currentFunction;
    }

    @Override
    public PolynomialFunction antiderivative(int v) {
        PolynomialFunctionTerm[] aTerms = new PolynomialFunctionTerm[this.nTerms()];
        for (int t = 0; t < this.nTerms(); t++) {
            aTerms[t] = this.getTerm(t).antiderivative(v);
        }

        return new PolynomialFunction(aTerms);
    }

    @Override
    public PolynomialFunction multipleAntiderivative(int v, int nAntiderivatives) {
        PolynomialFunction prevFunction = this;
        PolynomialFunction currentFunction = this;
        
        for (int i = 0; i < nAntiderivatives; i++) {
            currentFunction = prevFunction.antiderivative(v);
            prevFunction = currentFunction.clone();
        }

        return currentFunction;
    }

    @Override
    public PolynomialFunction evaluateAntiderivative(int v, ScalarWrapper value) {
        PolynomialFunction antiderivative = this.antiderivative(v);
        return antiderivative.evaluateOneVariable(v, value);
    }

    @Override
    public PolynomialFunction evaluateAntiderivative(int v, Function value) {
        if (value instanceof PolynomialFunction pValue) {
            return this.evaluateAntiderivative(v, pValue);
        } else if (value instanceof PolynomialFunctionTerm pValue) {
            return this.evaluateAntiderivative(v, pValue);
        } else {
            throw new IllegalArgumentException("Non-polynomials are currently unsupported");
        }
    }

    public PolynomialFunction evaluateAntiderivative(int v, PolynomialFunction value) {
        PolynomialFunction antiderivative = this.antiderivative(v);
        return antiderivative.evaluateOneVariable(v, value);
    }

    public PolynomialFunction evaluateAntiderivative(int v, PolynomialFunctionTerm value) {
        PolynomialFunction antiderivative = this.antiderivative(v);
        return antiderivative.evaluateOneVariable(v, value);
    }

    @Override
    public ScalarWrapper evaluateAntiderivative(int v, ScalarWrapper[] variables) {
        PolynomialFunction antiderivative = this.antiderivative(v);
        return antiderivative.evaluate(variables);
    }

    @Override
    public PolynomialFunction singleIntegrate(int v, ScalarWrapper a, ScalarWrapper b) {
        return this.evaluateAntiderivative(v, b).subtract(this.evaluateAntiderivative(v, b));
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
    public PolynomialFunction singleIntegrate(int v, Function a, ScalarWrapper b) {
        if (a instanceof PolynomialFunction pa) {
            return this.singleIntegrate(v, pa, b);
        } else if (a instanceof PolynomialFunctionTerm pa) {
            return this.singleIntegrate(v, pa, b);
        } else {
            throw new IllegalArgumentException("Non-polynomials are currently unsupported");
        }
    }
    
    @Override
    public PolynomialFunction singleIntegrate(int v, Function a, Function b) {
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
            PolynomialFunction prevIntegration = this;
            PolynomialFunction currentIntegration = this;

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

        PolynomialFunction prevIntegration = this;
        PolynomialFunction currentIntegration = this;

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

        PolynomialFunction prevIntegration = this;
        PolynomialFunction currentIntegration = this;

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

        PolynomialFunction prevIntegration = this;
        PolynomialFunction currentIntegration = this;

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

        PolynomialFunction prevIntegration = this;
        PolynomialFunction currentIntegration = this;

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

        PolynomialFunction prevIntegration = this;
        PolynomialFunction currentIntegration = this;

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

        PolynomialFunction prevIntegration = this;
        PolynomialFunction currentIntegration = this;

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

        PolynomialFunction prevIntegration = this;
        PolynomialFunction currentIntegration = this;

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

        PolynomialFunction prevIntegration = this;
        PolynomialFunction currentIntegration = this;

        for (int i = 0; i < v.length; i++) {
            currentIntegration = prevIntegration.singleIntegrate(v[i], a[i], b[i]);
            prevIntegration = currentIntegration;
        }

        return currentIntegration.evaluate();
    }

    @Override
    public PolynomialFunction clone() {
        return new PolynomialFunction(Util.deepCopy(this.terms));
    }

    @Override
    public String toString() {
        String s = terms[0].sign();

        for (int i = 0; i < this.terms.length; i++) {
            if (i != 0) {
                s += " " + terms[i].sign() + " ";
            }
            s += terms[i];
        }

        return s;
    }

}
