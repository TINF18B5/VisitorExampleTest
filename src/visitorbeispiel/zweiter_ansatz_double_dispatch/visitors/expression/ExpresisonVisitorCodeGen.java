package visitorbeispiel.zweiter_ansatz_double_dispatch.visitors.expression;

import visitorbeispiel.zweiter_ansatz_double_dispatch.expressions.*;
import visitorbeispiel.zweiter_ansatz_double_dispatch.symbols.*;
import visitorbeispiel.zweiter_ansatz_double_dispatch.visitors.*;

public class ExpresisonVisitorCodeGen implements InterfaceExpressionVisitor<Integer> {
    private final PseudoLaufContext laufContext;
    
    public ExpresisonVisitorCodeGen(PseudoLaufContext laufContext) {
        this.laufContext = laufContext;
    }
    
    @Override
    public Integer visitAdd(ExpressionNodeAdd expressionNodeAdd) {
        final Integer wertA = expressionNodeAdd.operandA.accept(this);
        final Integer wertB = expressionNodeAdd.operandB.accept(this);
        return wertA + wertB;
    }
    
    @Override
    public Integer visitNodeInt(ExpressionNodeInt expressionNodeInt) {
        return expressionNodeInt.value;
    }
    
    @Override
    public Integer visitNodeVariable(ExpressionNodeVariable expressionNodeVariable) {
        return laufContext.liesVariablenWert(expressionNodeVariable.variableName);
    }
}
