package visitorbeispiel.zweiter_ansatz_double_dispatch.expressions;


import visitorbeispiel.zweiter_ansatz_double_dispatch.visitors.*;

public abstract class ExpressionNode {
    
    protected ExpressionNode() {
    }
    
    public abstract <T> T accept(InterfaceExpressionVisitor<T> expressionVisitor);
}
