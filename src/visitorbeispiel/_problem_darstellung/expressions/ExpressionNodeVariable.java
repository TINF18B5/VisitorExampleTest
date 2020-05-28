package visitorbeispiel._problem_darstellung.expressions;

public class ExpressionNodeVariable extends ExpressionNode {
    public final String variableName;
    
    public ExpressionNodeVariable(String variableName) {
        this.variableName = variableName;
    }
}
