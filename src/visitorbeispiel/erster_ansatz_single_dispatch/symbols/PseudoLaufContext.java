package visitorbeispiel.erster_ansatz_single_dispatch.symbols;

import java.util.*;

public class PseudoLaufContext {
    
    private final Map<String, Integer> variablenWerte;
    
    public PseudoLaufContext() {
        variablenWerte = new HashMap<>();
    }
    
    public void setzeVariablenWert(String name, int wert) {
        variablenWerte.put(name, wert);
    }
    
    public int liesVariablenWert(String name) {
        return variablenWerte.get(name);
    }
    
    public void druckeVariablen() {
        variablenWerte.forEach((s, integer) -> System.out.printf("%s -> %s%n", s, integer));
    }
}
