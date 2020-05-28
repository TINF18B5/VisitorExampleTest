package visitorbeispiel.zweiter_ansatz_double_dispatch.visitors.statement;

import visitorbeispiel.zweiter_ansatz_double_dispatch.symbols.*;
import visitorbeispiel.zweiter_ansatz_double_dispatch.statements.*;
import visitorbeispiel.zweiter_ansatz_double_dispatch.visitors.*;
import visitorbeispiel.zweiter_ansatz_double_dispatch.visitors.expression.*;

public class StatementVisitorTypInferenz implements InterfaceStatementVisitor {
    
    private final SymbolTabelle symbolTabelle;
    private final InterfaceExpressionVisitor<TypInformation> expressionVisitor;
    
    public StatementVisitorTypInferenz(SymbolTabelle symbolTabelle) {
        this.symbolTabelle = symbolTabelle;
        this.expressionVisitor = new ExpressionVisitorTypInferenz(symbolTabelle);
    }
    
    @Override
    public void visitStatmentExpression(StatementNodeExpression statementNodeExpression) {
        statementNodeExpression.expression.accept(expressionVisitor);
    }
    
    @Override
    public void visitNodeVariable(StatementNodeVariable statementNodeVariable) {
        TypInformation information = statementNodeVariable.initializer.accept(expressionVisitor);
        symbolTabelle.setzeSymbolInformationen(statementNodeVariable.name, information);
    }
}
