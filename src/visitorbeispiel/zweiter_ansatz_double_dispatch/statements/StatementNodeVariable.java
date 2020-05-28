package visitorbeispiel.zweiter_ansatz_double_dispatch.statements;

import visitorbeispiel.zweiter_ansatz_double_dispatch.expressions.*;
import visitorbeispiel.zweiter_ansatz_double_dispatch.visitors.*;

public class StatementNodeVariable extends StatementNode {
    public final ExpressionNode initializer;
    public final String name;
    
    public StatementNodeVariable(String name, ExpressionNode initializer) {
        this.initializer = initializer;
        this.name = name;
    }
    
    @Override
    public void accept(InterfaceStatementVisitor visitor) {
        visitor.visitNodeVariable(this);
    }
}
