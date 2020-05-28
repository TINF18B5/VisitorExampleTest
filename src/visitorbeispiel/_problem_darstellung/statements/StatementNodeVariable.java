package visitorbeispiel._problem_darstellung.statements;

import visitorbeispiel._problem_darstellung.expressions.*;

public class StatementNodeVariable extends StatementNode {
    public final ExpressionNode initializer;
    public final String name;
    
    public StatementNodeVariable(String name, ExpressionNode initializer) {
        this.initializer = initializer;
        this.name = name;
    }
}
