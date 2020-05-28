package visitorbeispiel.erster_ansatz_single_dispatch.statements;

import visitorbeispiel.erster_ansatz_single_dispatch.expressions.*;
import visitorbeispiel.erster_ansatz_single_dispatch.symbols.*;

public class StatementNodeExpression extends StatementNode {
    public final ExpressionNode expression;
    
    public StatementNodeExpression(ExpressionNode expression) {
        this.expression = expression;
    }
    
    @Override
    public void fillSymbolTable(SymbolTabelle symbolTabelle) {
        //Brauchen wir hier nicht
    }
    
    @Override
    public void inferTypes(SymbolTabelle symbolTabelle) {
        expression.inferTypes(symbolTabelle);
    }
    
    @Override
    public void lassLaufen(PseudoLaufContext laufContext) {
        expression.lassLaufen(laufContext);
    }
}
