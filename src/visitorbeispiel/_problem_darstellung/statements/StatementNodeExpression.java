package visitorbeispiel._problem_darstellung.statements;

import visitorbeispiel._problem_darstellung.expressions.*;

public class StatementNodeExpression extends StatementNode {
    public final ExpressionNode expression;
    
    public StatementNodeExpression(ExpressionNode expression) {
        this.expression = expression;
    }
}
