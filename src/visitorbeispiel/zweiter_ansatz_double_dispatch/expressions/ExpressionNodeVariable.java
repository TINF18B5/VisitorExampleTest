package visitorbeispiel.zweiter_ansatz_double_dispatch.expressions;


import visitorbeispiel.zweiter_ansatz_double_dispatch.visitors.*;

public class ExpressionNodeVariable extends ExpressionNode {
    public final String variableName;
    
    public ExpressionNodeVariable(String variableName) {
        this.variableName = variableName;
    }
    
    @Override
    public <T> T accept(InterfaceExpressionVisitor<T> expressionVisitor) {
        return expressionVisitor.visitNodeVariable(this);
    }
}
