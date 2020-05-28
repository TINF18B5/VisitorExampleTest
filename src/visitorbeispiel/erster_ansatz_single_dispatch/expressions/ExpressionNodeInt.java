package visitorbeispiel.erster_ansatz_single_dispatch.expressions;

import visitorbeispiel.erster_ansatz_single_dispatch.symbols.*;

public class ExpressionNodeInt extends ExpressionNode{
    public final int value;
    
    public ExpressionNodeInt(int value) {
        this.value = value;
    }
    
    @Override
    public TypInformation inferTypes(SymbolTabelle symbolTabelle) {
        return new TypInformation(int.class);
    }
    
    @Override
    public int lassLaufen(PseudoLaufContext laufContext) {
        return value;
    }
}
