package visitorbeispiel.erster_ansatz_single_dispatch.symbols;

public class TypInformation {
    public final Class<?> klasse;
    
    public TypInformation(Class<?> klasse) {
        this.klasse = klasse;
    }
    
    @Override
    public boolean equals(Object o) {
        if(this == o)
            return true;
        if(o == null || getClass() != o.getClass())
            return false;
        
        TypInformation that = (TypInformation) o;
    
        return klasse.equals(that.klasse);
    }
    
    @Override
    public int hashCode() {
        return klasse.hashCode();
    }
    
    @Override
    public String toString() {
        return klasse.getSimpleName();
    }
}
