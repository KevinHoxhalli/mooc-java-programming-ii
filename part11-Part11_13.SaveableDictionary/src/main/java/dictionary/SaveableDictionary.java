package dictionary;


import java.io.File;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SaveableDictionary {
    
    private Map<String,String> dictornaryFE;
    private Map<String,String> dictornaryEF;
    private String file;
    
    public SaveableDictionary() {
        this.dictornaryFE = new HashMap<>();
        this.dictornaryEF = new HashMap<>();
    }
    
    public SaveableDictionary(String file) {
        this.dictornaryFE = new HashMap<>();
        this.dictornaryEF = new HashMap<>();
        this.file = file;
    }
    
    public void add(String words, String translation) {
        if(!this.dictornaryFE.containsKey(words)) {
            this.dictornaryFE.put(words,translation);
            this.dictornaryEF.put(translation,words);
        }
    }
    
    public String translate(String word) {
        String translation = null;
        translation = this.dictornaryFE.getOrDefault(word, null);
        if(translation == null) {
            translation = this.dictornaryEF.getOrDefault(word, null);            
        }
        return translation; 
    }
    
    public void delete(String word) {
        if(this.dictornaryEF.containsKey(word)) {
            this.dictornaryFE.remove(this.translate(word));
            this.dictornaryEF.remove(word);
        }
        if(this.dictornaryFE.containsKey(word)) {
            this.dictornaryEF.remove(this.translate(word));
            this.dictornaryFE.remove(word);
        }
    }
    
    public boolean load() {
        
        try(Scanner reader = new Scanner(new File(this.file))) {
            while (reader.hasNextLine()) {
                String parts[] = reader.nextLine().split(":");
                this.dictornaryFE.put(parts[0], parts[1]);
                this.dictornaryEF.put(parts[1], parts[0]);
            }
            
        } catch(Exception e) {
            return false;
        }
        return true;
    }
    
    public boolean save()  {
        try(PrintWriter writer = new PrintWriter(this.file);) {
            for(String dict: this.dictornaryFE.keySet()) {
                
                writer.println(dict+":"+this.dictornaryFE.get(dict));
            }
            writer.close();
        } catch(Exception e) {
            return false;
        }
        return true;
    }
    
}
