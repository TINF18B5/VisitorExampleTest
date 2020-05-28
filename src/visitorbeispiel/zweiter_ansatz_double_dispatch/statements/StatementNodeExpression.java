package visitorbeispiel.zweiter_ansatz_double_dispatch.statements;

import visitorbeispiel.zweiter_ansatz_double_dispatch.expressions.*;
import visitorbeispiel.zweiter_ansatz_double_dispatch.visitors.*;

public class StatementNodeExpression extends StatementNode {
    public final ExpressionNode expression;
    
    public StatementNodeExpression(ExpressionNode expression) {
        this.expression = expression;
    }
    
    @Override
    public void accept(InterfaceStatementVisitor visitor) {
        visitor.visitStatmentExpression(this);
    }
}
