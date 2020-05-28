package visitorbeispiel.erster_ansatz_single_dispatch;

import visitorbeispiel.erster_ansatz_single_dispatch.expressions.*;
import visitorbeispiel.erster_ansatz_single_dispatch.statements.*;
import visitorbeispiel.erster_ansatz_single_dispatch.symbols.*;
@SuppressWarnings("DuplicatedCode")
public class StarterSingleDispatchAnsatz {
    
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
        //IDEE:
        //Ich füg einfach virtuelle Methoden den Statements/Expressions hinzu und lass die abarbeiten
        for(StatementNode statementNode : statementNodes) {
            statementNode.fillSymbolTable(symbolTabelle);
        }
    
        for(StatementNode statementNode : statementNodes) {
            statementNode.inferTypes(symbolTabelle);
        }
    
        PseudoLaufContext laufContext = new PseudoLaufContext();
        for(StatementNode statementNode : statementNodes) {
            statementNode.lassLaufen(laufContext);
        }
        
        laufContext.druckeVariablen();
        
        //Zusammenfassung:
        //Reduktion des Problems darauf, den Code nur noch von einem Abhängig zu machen
        //Jetzt nur noch abhängig vom Typ des Statements
        
        
        //Problem hierbei:
        //Ich muss selbst angeben, in welchem Zustand ich bin
        //Code-Duplizierung
        //Was, wenn ich dynamisch Compilephasen dazu/wegschalten will?
    }
    
    private static StatementNode[] readStatements() {
        final StatementNode variableX = new StatementNodeVariable("x", new ExpressionNodeInt(10));
        final StatementNode variableY = new StatementNodeVariable("y", new ExpressionNodeInt(20));
        final ExpressionNode add = new ExpressionNodeAdd(new ExpressionNodeVariable("x"), new ExpressionNodeVariable("y"));
        final StatementNode variableZ = new StatementNodeVariable("z", add);
        
        return new StatementNode[]{variableX, variableY, variableZ};
    }
}
