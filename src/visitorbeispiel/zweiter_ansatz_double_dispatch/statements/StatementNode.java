package visitorbeispiel.zweiter_ansatz_double_dispatch.statements;


import visitorbeispiel.zweiter_ansatz_double_dispatch.visitors.*;

public abstract class StatementNode {
    
    public abstract void accept(InterfaceStatementVisitor visitor);
}
