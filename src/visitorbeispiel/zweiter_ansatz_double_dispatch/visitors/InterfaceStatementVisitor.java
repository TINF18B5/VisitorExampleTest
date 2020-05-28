package visitorbeispiel.zweiter_ansatz_double_dispatch.visitors;

import visitorbeispiel.zweiter_ansatz_double_dispatch.statements.*;

public interface InterfaceStatementVisitor {
    
    void visitStatmentExpression(StatementNodeExpression statementNodeExpression);
    
    void visitNodeVariable(StatementNodeVariable statementNodeVariable);
}
