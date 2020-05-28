package visitorbeispiel.zweiter_ansatz_double_dispatch.expressions;


import visitorbeispiel.zweiter_ansatz_double_dispatch.visitors.*;

public class ExpressionNodeAdd extends ExpressionNode {
    public final ExpressionNode operandA, operandB;
    
    public ExpressionNodeAdd(ExpressionNode operandA, ExpressionNode operandB) {
        this.operandA = operandA;
        this.operandB = operandB;
    }
    
    @Override
    public <T> T accept(InterfaceExpressionVisitor<T> expressionVisitor) {
        return expressionVisitor.visitAdd(this);
    }
}
