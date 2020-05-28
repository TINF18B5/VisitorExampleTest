package visitorbeispiel.zweiter_ansatz_double_dispatch;

import visitorbeispiel.zweiter_ansatz_double_dispatch.expressions.*;
import visitorbeispiel.zweiter_ansatz_double_dispatch.statements.*;
import visitorbeispiel.zweiter_ansatz_double_dispatch.symbols.*;
import visitorbeispiel.zweiter_ansatz_double_dispatch.visitors.statement.*;

@SuppressWarnings("DuplicatedCode")
public class StarterDoubleDispatchAnsatz {
    
    //var x = 10;
    //var y = 20;
    //var z = x + y;
    public static void main(String[] args) {
        //Ersetzt jetzt mal unseren Parser, Stell Dir vor
        // das Ding liest das Beispiel da oben ^^.
        final StatementNode[] statementNodes = readStatements();
    
        //Zustände:
        // - FillSymbolTable (was für Symbole [variablen, ...] gibt es)
        // - TypInferenz (Was für Typen haben die Expressions und sind die eingaben semantisch korrekt)
        // - CodeGenerierung oder Ausführung (ersetzen wir mit "schreibe die Werte aller Variablen nach Ende der Ausführung")
        
        
        final SymbolTabelle symbolTabelle = new SymbolTabelle();
        //IDEE 2:
        //Ich gebe Statements und Expressions nur eine Methode mit Visitor als Callback
        final StatementVisitorSymbolTabelle statementVisitorSymbolTabelle = new StatementVisitorSymbolTabelle(symbolTabelle);
        for(StatementNode statementNode : statementNodes) {
            statementNode.accept(statementVisitorSymbolTabelle);
        }
    
        final StatementVisitorTypInferenz statementVisitorTypInferenz = new StatementVisitorTypInferenz(symbolTabelle);
        for(StatementNode statementNode : statementNodes) {
            statementNode.accept(statementVisitorTypInferenz);
        }
        
        PseudoLaufContext laufContext = new PseudoLaufContext();
        final StatementVisitorCodeGen statementVisitorCodeGen = new StatementVisitorCodeGen(laufContext);
        for(StatementNode statementNode : statementNodes) {
            statementNode.accept(statementVisitorCodeGen);
        }
        
        laufContext.druckeVariablen();
        
        //Zusammenfassung:
        //Reduktion des Problems darauf, den Code nur noch von einem Abhängig zu machen
        //Jetzt nur noch abhängig vom Typ des Statements
        
        
        //Problem hierbei:
        //Ich muss selbst angeben, in welchem Zustand ich bin
        //Code-Duplizierung
    }
    
    private static StatementNode[] readStatements() {
        final StatementNode variableX = new StatementNodeVariable("x", new ExpressionNodeInt(10));
        final StatementNode variableY = new StatementNodeVariable("y", new ExpressionNodeInt(20));
        final ExpressionNode add = new ExpressionNodeAdd(new ExpressionNodeVariable("x"), new ExpressionNodeVariable("y"));
        final StatementNode variableZ = new StatementNodeVariable("z", add);
        
        return new StatementNode[]{variableX, variableY, variableZ};
    }
}
