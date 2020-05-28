package visitorbeispiel.erster_ansatz_single_dispatch.statements;

import visitorbeispiel.erster_ansatz_single_dispatch.expressions.*;
import visitorbeispiel.erster_ansatz_single_dispatch.symbols.*;

public class StatementNodeVariable extends StatementNode {
    public final ExpressionNode initializer;
    public final String name;
    
    public StatementNodeVariable(String name, ExpressionNode initializer) {
        this.initializer = initializer;
        this.name = name;
    }
    
    @Override
    public void fillSymbolTable(SymbolTabelle symbolTabelle) {
        symbolTabelle.registriereSymbol(name);
    }
    
    @Override
    public void inferTypes(SymbolTabelle symbolTabelle) {
        final TypInformation typInformation = initializer.inferTypes(symbolTabelle);
        symbolTabelle.setzeSymbolInformationen(name, typInformation);
    }
    
    @Override
    public void lassLaufen(PseudoLaufContext laufContext) {
        final int wert = initializer.lassLaufen(laufContext);
        laufContext.setzeVariablenWert(name, wert);
    }
}
