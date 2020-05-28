package visitorbeispiel.zweiter_ansatz_double_dispatch.visitors.expression;

import visitorbeispiel.zweiter_ansatz_double_dispatch.expressions.*;
import visitorbeispiel.zweiter_ansatz_double_dispatch.symbols.*;
import visitorbeispiel.zweiter_ansatz_double_dispatch.visitors.*;

public class ExpressionVisitorTypInferenz implements InterfaceExpressionVisitor<TypInformation> {
    
    private final SymbolTabelle symbolTabelle;
    
    public ExpressionVisitorTypInferenz(SymbolTabelle symbolTabelle) {
        this.symbolTabelle = symbolTabelle;
    }
    
    @Override
    public TypInformation visitAdd(ExpressionNodeAdd expressionNodeAdd) {
        final TypInformation typA = expressionNodeAdd.operandA.accept(this);
        final TypInformation typB = expressionNodeAdd.operandB.accept(this);
        
        if(!typA.equals(typB)) {
            throw new IllegalArgumentException("Operanten sind nicht vom gleichen Typ: " + typA + " + " + typB);
        }
        return typA;
    }
    
    @Override
    public TypInformation visitNodeInt(ExpressionNodeInt expressionNodeInt) {
        return new TypInformation(int.class);
    }
    
    @Override
    public TypInformation visitNodeVariable(ExpressionNodeVariable expressionNodeVariable) {
        return symbolTabelle.getTyp(expressionNodeVariable.variableName);
    }
}
