package visitorbeispiel.erster_ansatz_single_dispatch.expressions;

import visitorbeispiel.erster_ansatz_single_dispatch.symbols.*;

public class ExpressionNodeVariable extends ExpressionNode {
    public final String variableName;
    
    public ExpressionNodeVariable(String variableName) {
        this.variableName = variableName;
    }
    
    @Override
    public TypInformation inferTypes(SymbolTabelle symbolTabelle) {
        return symbolTabelle.getSymbol(variableName);
    }
    
    @Override
    public int lassLaufen(PseudoLaufContext laufContext) {
        return laufContext.liesVariablenWert(variableName);
    }
}
