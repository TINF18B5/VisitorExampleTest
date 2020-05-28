package visitorbeispiel.zweiter_ansatz_double_dispatch.visitors.statement;

import visitorbeispiel.zweiter_ansatz_double_dispatch.statements.*;
import visitorbeispiel.zweiter_ansatz_double_dispatch.symbols.*;
import visitorbeispiel.zweiter_ansatz_double_dispatch.visitors.*;
import visitorbeispiel.zweiter_ansatz_double_dispatch.visitors.expression.*;

public class StatementVisitorCodeGen implements InterfaceStatementVisitor {
    
    private final PseudoLaufContext laufContext;
    private final InterfaceExpressionVisitor<Integer> visitor;
    
    public StatementVisitorCodeGen(PseudoLaufContext laufContext) {
        this.laufContext = laufContext;
        this.visitor = new ExpresisonVisitorCodeGen(laufContext);
    }
    
    @Override
    public void visitStatmentExpression(StatementNodeExpression statementNodeExpression) {
        statementNodeExpression.expression.accept(visitor);
    }
    
    @Override
    public void visitNodeVariable(StatementNodeVariable statementNodeVariable) {
        final Integer wert = statementNodeVariable.initializer.accept(visitor);
        laufContext.setzeVariablenWert(statementNodeVariable.name, wert);
    }
}
