

public class Checker {
    
    
    public boolean isDayOfWeek(String string) {
        return string.matches("mon|tue|wed|thu|fri|sat|sun");
    }
    
    public boolean allVowels(String string) {
        return string.matches("[aeiou]+");
    }
    
    public boolean timeOfDay(String string) {
        boolean ans = false;
        if(!string.startsWith("2")) {
            
            if(string.startsWith("6",3) && string.startsWith("6",6)) {
                ans = string.matches("[0-1][0-9]:60:60");
            } else if(string.startsWith("6",3)) {
                ans = string.matches("[0-1][0-9]:60:[0-6][0-9]");
            } else if(string.startsWith("6",6)) {
                ans = string.matches("[0-1][0-9]:[0-6][0-9]:60");
            } else {
                ans = string.matches("[0-1][0-9]:[0-6][0-9]:[0-6][0-9]");
            }     
        } else if(string.startsWith("24")) {
            ans = string.matches("24:00:00");
        } else if(string.startsWith("2")){
            if(string.startsWith("6",3) && string.startsWith("6",6)) {
                ans = string.matches("2[0-4]:60:60");
            } else if(string.startsWith("6",3)) {
                ans = string.matches("2[0-4]:60:[0-6][0-9]");
            } else if(string.startsWith("6",6)) {
                ans = string.matches("2[0-4]:[0-6][0-9]:60");
            } else {
                ans = string.matches("2[0-4]:[0-6][0-9]:[0-6][0-9]");
            }  
        } 
        return ans;
    }

}
