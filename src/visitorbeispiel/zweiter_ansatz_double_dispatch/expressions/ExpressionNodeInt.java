package visitorbeispiel.zweiter_ansatz_double_dispatch.expressions;


import visitorbeispiel.zweiter_ansatz_double_dispatch.visitors.*;

public class ExpressionNodeInt extends ExpressionNode {
    public final int value;
    
    public ExpressionNodeInt(int value) {
        this.value = value;
    }
    
    @Override
    public <T> T accept(InterfaceExpressionVisitor<T> expressionVisitor) {
        return expressionVisitor.visitNodeInt(this);
    }
}
