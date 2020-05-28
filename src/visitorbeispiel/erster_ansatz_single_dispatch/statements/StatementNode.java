package visitorbeispiel.erster_ansatz_single_dispatch.statements;

import visitorbeispiel.erster_ansatz_single_dispatch.symbols.*;

public abstract class StatementNode {
    
    public abstract void fillSymbolTable(SymbolTabelle symbolTabelle);
    
    public abstract void inferTypes(SymbolTabelle symbolTabelle);
    
    public abstract void lassLaufen(PseudoLaufContext laufContext);
}
