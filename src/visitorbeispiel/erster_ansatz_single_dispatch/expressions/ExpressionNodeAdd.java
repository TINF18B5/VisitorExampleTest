package visitorbeispiel.erster_ansatz_single_dispatch.expressions;

import visitorbeispiel.erster_ansatz_single_dispatch.symbols.*;

public class ExpressionNodeAdd extends ExpressionNode{
    public final ExpressionNode operandA, operandB;
    
    public ExpressionNodeAdd(ExpressionNode operandA, ExpressionNode operandB) {
        this.operandA = operandA;
        this.operandB = operandB;
    }
    
    @Override
    public TypInformation inferTypes(SymbolTabelle symbolTabelle) {
        final TypInformation typeA = operandA.inferTypes(symbolTabelle);
        final TypInformation typeB = operandB.inferTypes(symbolTabelle);
        if(!typeA.equals(typeB)) {
            throw new IllegalArgumentException("Operanten sind nicht vom gleichen Typ: " + operandA + " + " + operandB);
        }
        
        return typeA;
    }
    
    @Override
    public int lassLaufen(PseudoLaufContext laufContext) {
        final int wertA = operandA.lassLaufen(laufContext);
        final int wertB = operandB.lassLaufen(laufContext);
        return wertA + wertB;
    }
}
