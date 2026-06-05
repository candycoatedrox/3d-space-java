public class RadicalFunction extends NonParameterizedFunction implements AbstractRadical {
    
    protected NonParameterizedFunction innerValue;

    public RadicalFunction(NonParameterizedFunction innerFunction) {
        super(innerFunction.getDim());
        this.innerValue = innerFunction;
    }

}