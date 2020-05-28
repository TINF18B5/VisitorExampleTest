package visitorbeispiel.erster_ansatz_single_dispatch.expressions;

import visitorbeispiel.erster_ansatz_single_dispatch.symbols.*;

public abstract class ExpressionNode {
    
    protected ExpressionNode() {
    }
    
    public abstract TypInformation inferTypes(SymbolTabelle symbolTabelle);
    
    public abstract int lassLaufen(PseudoLaufContext laufContext);
}
