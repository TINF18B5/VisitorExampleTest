package visitorbeispiel._problem_darstellung.expressions;

public class ExpressionNodeAdd extends ExpressionNode{
    public final ExpressionNode operandA, operandB;
    
    public ExpressionNodeAdd(ExpressionNode operandA, ExpressionNode operandB) {
        this.operandA = operandA;
        this.operandB = operandB;
    }
}
