
import java.util.HashMap;


public class Abbreviations {
    private HashMap<String, String> abbrev;

    public Abbreviations() {
        this.abbrev = new HashMap<>();
    }
    
    public void addAbbreviation(String abbreviation, String explanation) {
        this.abbrev.put(abbreviation, explanation);
    }
    
    public boolean hasAbbreviation(String abbreviation) {
        if(this.abbrev.containsKey(abbreviation))
            return true;
        return false;
    }
    
    public String findExplanationFor(String abbreviation) {
        return this.abbrev.get(abbreviation);  
    }
}
