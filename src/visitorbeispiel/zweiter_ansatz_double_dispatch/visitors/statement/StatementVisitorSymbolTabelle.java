package visitorbeispiel.zweiter_ansatz_double_dispatch.visitors.statement;

import visitorbeispiel.zweiter_ansatz_double_dispatch.symbols.*;
import visitorbeispiel.zweiter_ansatz_double_dispatch.statements.*;
import visitorbeispiel.zweiter_ansatz_double_dispatch.visitors.*;

public class StatementVisitorSymbolTabelle implements InterfaceStatementVisitor {
    
    private final SymbolTabelle symbolTabelle;
    
    public StatementVisitorSymbolTabelle(SymbolTabelle symbolTabelle) {
        this.symbolTabelle = symbolTabelle;
    }
    
    @Override
    public void visitStatmentExpression(StatementNodeExpression statementNodeExpression) {
        //Hier müssen wir nichts machen
    }
    
    @Override
    public void visitNodeVariable(StatementNodeVariable statementNodeVariable) {
        symbolTabelle.registriereSymbol(statementNodeVariable.name);
    }
}
