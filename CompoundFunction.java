import java.util.ArrayList;

public class CompoundFunction extends NonParameterizedFunction {

    protected NonParameterizedFunction[] terms;

    public CompoundFunction(NonParameterizedFunction[] terms) {
        super(terms[0].getDim());

        if (allSameDimension(terms)) {
            this.terms = terms;
            this.simplify();
        } else {
            throw new IllegalArgumentException("All terms must share dimension");
        }
    }

    public CompoundFunction(NonParameterizedFunction f, NonParameterizedFunction g) {
        super(f.getDim());

        if (f.sameDimension(g)) {
            NonParameterizedFunction[] t = new NonParameterizedFunction[2];

            t[0] = f;
            t[1] = g;

            this.terms = t;
            this.simplify();
        } else {
            throw new IllegalArgumentException("All terms must share dimension");
        }
    }

    public CompoundFunction(NonParameterizedFunction f, CompoundFunction g) {
        super(f.getDim());

        if (f.sameDimension(g)) {
            NonParameterizedFunction[] t = new NonParameterizedFunction[g.nTerms() + 1];

            t[0] = f;
            for (int i = 0; i < g.nTerms(); i++) {
                t[i+1] = g.terms[i];
            }
            
            this.terms = t;
            this.simplify();
        } else {
            throw new IllegalArgumentException("All terms must share dimension");
        }
    }

    public CompoundFunction(CompoundFunction f, NonParameterizedFunction g) {
        super(f.getDim());

        if (f.sameDimension(g)) {
            NonParameterizedFunction[] t = new NonParameterizedFunction[f.nTerms() + 1];
            
            for (int i = 0; i < f.nTerms(); i++) {
                t[i] = f.terms[i];
            }
            t[f.nTerms()] = g;
            
            this.terms = t;
            this.simplify();
        } else {
            throw new IllegalArgumentException("All terms must share dimension");
        }
    }

    public CompoundFunction(CompoundFunction f, CompoundFunction g) {
        super(f.getDim());

        if (f.sameDimension(g)) {
            NonParameterizedFunction[] t = new NonParameterizedFunction[f.nTerms() + g.nTerms()];

            for (int i = 0; i < f.nTerms(); i++) {
                t[i] = f.terms[i];
            }

            for (int i = 0; i < g.nTerms(); i++) {
                t[i + f.nTerms()] = g.terms[i];
            }
            
            this.terms = t;
            this.simplify();
        } else {
            throw new IllegalArgumentException("All terms must share dimension");
        }
    }

    public CompoundFunction(NonParameterizedFunction f, ScalarWrapper g) {
        this(f, new ConstantFunction(g, f.getDim()));
    }

    public CompoundFunction(NonParameterizedFunction f, int g) {
        this(f, new ConstantFunction(g, f.getDim()));
    }

    public CompoundFunction(NonParameterizedFunction f, Integer g) {
        this(f, new ConstantFunction(g, f.getDim()));
    }

    public CompoundFunction(NonParameterizedFunction f, double g) {
        this(f, new ConstantFunction(g, f.getDim()));
    }

    public CompoundFunction(NonParameterizedFunction f, Double g) {
        this(f, new ConstantFunction(g, f.getDim()));
    }

    public CompoundFunction(NonParameterizedFunction f, Rational g) {
        this(f, new ConstantFunction(g, f.getDim()));
    }

    public CompoundFunction(ScalarWrapper f, NonParameterizedFunction g) {
        this(new ConstantFunction(f, g.getDim()), g);
    }

    public CompoundFunction(int f, NonParameterizedFunction g) {
        this(new ConstantFunction(f, g.getDim()), g);
    }

    public CompoundFunction(Integer f, NonParameterizedFunction g) {
        this(new ConstantFunction(f, g.getDim()), g);
    }

    public CompoundFunction(double f, NonParameterizedFunction g) {
        this(new ConstantFunction(f, g.getDim()), g);
    }

    public CompoundFunction(Double f, NonParameterizedFunction g) {
        this(new ConstantFunction(f, g.getDim()), g);
    }

    public CompoundFunction(Rational f, NonParameterizedFunction g) {
        this(new ConstantFunction(f, g.getDim()), g);
    }

    public void simplify() {
        this.combineLikeTerms();
        this.sortTerms();
    }

    public void combineLikeTerms() {
        // can at least combine constants? (ConstantFunctions)
        //placeholder
    }

    public void sortTerms() {
        //placeholder
    }

    public NonParameterizedFunction getTerm(int i) {
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
    public boolean isConstant() {
        for (NonParameterizedFunction f : this.terms) {
            if (!f.isConstant()) {
                return false;
            }
        }

        return true;
    }

    @Override
    public ScalarWrapper getConstant() {
        if (this.isConstant()) {
            ScalarWrapper c = new ScalarWrapper();

            for (NonParameterizedFunction f : this.terms) {
                c.add(f.getConstant());
            }

            return c;
        } else {
            throw new IllegalArgumentException("Function is not constant");
        }
    }

    @Override
    public boolean includes(int v) {
        for (NonParameterizedFunction f : this.terms) {
            if (!f.includes(v)) {
                return false;
            }
        }

        return true;
    }
    
    @Override
    public ArrayList<Integer> includedVariables() {
        ArrayList<Integer> included = new ArrayList<>();

        for (int v = 0; v < this.dim; v++) {
            if (this.includes(v)) {
                included.add(v);
            }
        }

        return included;
    }
    
    @Override
    public int nVariablesIncluded() {
        return this.includedVariables().size();
    }
    
    @Override
    public CompoundFunction negative() {
        NonParameterizedFunction[] c = new NonParameterizedFunction[this.nTerms()];

        for (int t = 0; t < this.nTerms(); t++) {
            c[t] = this.getTerm(t).negative();
        }

        return new CompoundFunction(c);
    }
    
    @Override
    public CompoundFunction absolute() {
        NonParameterizedFunction[] c = new NonParameterizedFunction[this.nTerms()];

        for (int t = 0; t < this.nTerms(); t++) {
            c[t] = this.getTerm(t).absolute();
        }

        return new CompoundFunction(c);
    }
    
    @Override
    public CompoundFunction multiply(ScalarWrapper other) {
        NonParameterizedFunction[] c = new NonParameterizedFunction[this.nTerms()];

        for (int t = 0; t < this.nTerms(); t++) {
            c[t] = this.getTerm(t).multiply(other);
        }

        return new CompoundFunction(c);
    }
    
    @Override
    public CompoundFunction multiply(int other) {
        NonParameterizedFunction[] c = new NonParameterizedFunction[this.nTerms()];

        for (int t = 0; t < this.nTerms(); t++) {
            c[t] = this.getTerm(t).multiply(other);
        }

        return new CompoundFunction(c);
    }
    
    @Override
    public CompoundFunction multiply(Integer other) {
        NonParameterizedFunction[] c = new NonParameterizedFunction[this.nTerms()];

        for (int t = 0; t < this.nTerms(); t++) {
            c[t] = this.getTerm(t).multiply(other);
        }

        return new CompoundFunction(c);
    }
    
    @Override
    public CompoundFunction multiply(double other) {
        NonParameterizedFunction[] c = new NonParameterizedFunction[this.nTerms()];

        for (int t = 0; t < this.nTerms(); t++) {
            c[t] = this.getTerm(t).multiply(other);
        }

        return new CompoundFunction(c);
    }
    
    @Override
    public CompoundFunction multiply(Double other) {
        NonParameterizedFunction[] c = new NonParameterizedFunction[this.nTerms()];

        for (int t = 0; t < this.nTerms(); t++) {
            c[t] = this.getTerm(t).multiply(other);
        }

        return new CompoundFunction(c);
    }
    
    @Override
    public CompoundFunction multiply(Rational other) {
        NonParameterizedFunction[] c = new NonParameterizedFunction[this.nTerms()];

        for (int t = 0; t < this.nTerms(); t++) {
            c[t] = this.getTerm(t).multiply(other);
        }

        return new CompoundFunction(c);
    }

    @Override
    public CompoundFunction divideBy(ScalarWrapper other) {
        NonParameterizedFunction[] c = new NonParameterizedFunction[this.nTerms()];

        for (int t = 0; t < this.nTerms(); t++) {
            c[t] = this.getTerm(t).divideBy(other);
        }

        return new CompoundFunction(c);
    }
    
    @Override
    public CompoundFunction divideBy(int other) {
        NonParameterizedFunction[] c = new NonParameterizedFunction[this.nTerms()];

        for (int t = 0; t < this.nTerms(); t++) {
            c[t] = this.getTerm(t).divideBy(other);
        }

        return new CompoundFunction(c);
    }
    
    @Override
    public CompoundFunction divideBy(Integer other) {
        NonParameterizedFunction[] c = new NonParameterizedFunction[this.nTerms()];

        for (int t = 0; t < this.nTerms(); t++) {
            c[t] = this.getTerm(t).divideBy(other);
        }

        return new CompoundFunction(c);
    }
    
    @Override
    public CompoundFunction divideBy(double other) {
        NonParameterizedFunction[] c = new NonParameterizedFunction[this.nTerms()];

        for (int t = 0; t < this.nTerms(); t++) {
            c[t] = this.getTerm(t).divideBy(other);
        }

        return new CompoundFunction(c);
    }
    
    @Override
    public CompoundFunction divideBy(Double other) {
        NonParameterizedFunction[] c = new NonParameterizedFunction[this.nTerms()];

        for (int t = 0; t < this.nTerms(); t++) {
            c[t] = this.getTerm(t).divideBy(other);
        }

        return new CompoundFunction(c);
    }
    
    @Override
    public CompoundFunction divideBy(Rational other) {
        NonParameterizedFunction[] c = new NonParameterizedFunction[this.nTerms()];

        for (int t = 0; t < this.nTerms(); t++) {
            c[t] = this.getTerm(t).divideBy(other);
        }

        return new CompoundFunction(c);
    }

    @Override
    public CompoundFunction squared() {
        // PLACEHOLDER
        return new CompoundFunction(new ConstantFunction(1, 2), new ConstantFunction(2, 2));
    }
    
    @Override
    public CompoundFunction toPower(int power) {
        // PLACEHOLDER
        return new CompoundFunction(new ConstantFunction(1, 2), new ConstantFunction(2, 2));
    }
    
}
