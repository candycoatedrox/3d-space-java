import java.util.ArrayList;

public class FunctionTemplate extends NonParameterizedFunction {
    

    @Override
    public boolean isConstant() {

    }

    @Override
    public ScalarWrapper getConstant() {
        if (this.isConstant()) {
            
        } else {
            throw new IllegalArgumentException("Function is not constant");
        }
    }

    @Override
    public boolean includes(int v) {

    }
    
    @Override
    public ArrayList<Integer> includedVariables() {

    }
    
    @Override
    public int nVariablesIncluded() {

    }
    
    @Override
    public NonParameterizedFunction negative() {

    }
    
    @Override
    public NonParameterizedFunction absolute() {

    }
    
    @Override
    public NonParameterizedFunction multiply(ScalarWrapper other) {

    }
    
    @Override
    public NonParameterizedFunction multiply(int other) {

    }
    
    @Override
    public NonParameterizedFunction multiply(Integer other) {

    }
    
    @Override
    public NonParameterizedFunction multiply(double other) {

    }
    
    @Override
    public NonParameterizedFunction multiply(Double other) {

    }
    
    @Override
    public NonParameterizedFunction multiply(Rational other) {

    }

    @Override
    public NonParameterizedFunction divideBy(ScalarWrapper other) {

    }
    
    @Override
    public NonParameterizedFunction divideBy(int other) {

    }
    
    @Override
    public NonParameterizedFunction divideBy(Integer other) {

    }
    
    @Override
    public NonParameterizedFunction divideBy(double other) {

    }
    
    @Override
    public NonParameterizedFunction divideBy(Double other) {

    }
    
    @Override
    public NonParameterizedFunction divideBy(Rational other) {

    }

    @Override
    public NonParameterizedFunction squared() {

    }
    
    @Override
    public NonParameterizedFunction toPower(int power) {

    }

}
