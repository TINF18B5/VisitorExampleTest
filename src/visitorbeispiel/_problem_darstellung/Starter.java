package visitorbeispiel._problem_darstellung;

import visitorbeispiel._problem_darstellung.expressions.*;
import visitorbeispiel._problem_darstellung.statements.*;

public class Starter {
    
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
        
        
        //Double Dispatch problem:
        //Welche methode führen wir aus hängt ab von
        // - Was für ein Statement?
        // - Welche Compilephase
        
    }
    
    
    private static StatementNode[] readStatements() {
        final StatementNode variableX = new StatementNodeVariable("x", new ExpressionNodeInt(10));
        final StatementNode variableY = new StatementNodeVariable("y", new ExpressionNodeInt(20));
        final ExpressionNode add = new ExpressionNodeAdd(new ExpressionNodeVariable("x"), new ExpressionNodeVariable("y"));
        final StatementNode variableZ = new StatementNodeVariable("z", add);
        
        return new StatementNode[]{variableX, variableY, variableZ};
    }
}
