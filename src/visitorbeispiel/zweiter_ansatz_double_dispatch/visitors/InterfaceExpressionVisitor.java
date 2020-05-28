package visitorbeispiel.zweiter_ansatz_double_dispatch.visitors;

import visitorbeispiel.zweiter_ansatz_double_dispatch.expressions.*;

public interface InterfaceExpressionVisitor<T> {
    
    T visitAdd(ExpressionNodeAdd expressionNodeAdd);
    
    T visitNodeInt(ExpressionNodeInt expressionNodeInt);
    
    T visitNodeVariable(ExpressionNodeVariable expressionNodeVariable);
}
