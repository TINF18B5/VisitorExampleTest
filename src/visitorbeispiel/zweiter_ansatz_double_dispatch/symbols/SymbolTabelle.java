package visitorbeispiel.zweiter_ansatz_double_dispatch.symbols;

import java.util.*;

public class SymbolTabelle {
    private final Set<String> bekannteNamen;
    private final Map<String, TypInformation> bekannteVariablen;
    
    public SymbolTabelle() {
        bekannteVariablen = new HashMap<>();
        bekannteNamen = new HashSet<>();
    }
    
    public void registriereSymbol(String name) {
        bekannteNamen.add(name);
    }
    
    public boolean istRegistriert(String name) {
        return bekannteNamen.contains(name);
    }
    
    public void setzeSymbolInformationen(String name, TypInformation info) {
        if(!istRegistriert(name)) {
            throw new IllegalArgumentException("Unbekannter Name: " + name);
        }
        bekannteVariablen.put(name, info);
    }
    
    public TypInformation getTyp(String name) {
        return bekannteVariablen.get(name);
    }
}
