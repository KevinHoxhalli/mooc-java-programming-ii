
package application;

import java.util.HashMap;
import java.util.Map;

public class Interest {
    private double saving;
    private double interest;
    private Map<Integer, Double> savingsNo;
    private Map<Integer, Double> savingsInterest;
    
    public Interest(double saving, double interest) {
        this.saving = saving;
        this.interest = interest;
        this.savingsNo = new HashMap<>();
        this.savingsInterest = new HashMap<>();
    }
    
    public Map calculateWithInterest() {
        double sum = 0.0;
        this.savingsInterest.put(0, 0.0);
        for(int i=1; i<=30; i++) {
            sum += (this.saving*12); 
            sum += (sum*this.interest/100.0);
            this.savingsInterest.put(i, sum);
        }
        return this.savingsInterest;
    }
    
    public Map calculateWithoutInterest() {
        double sum = 0;
        this.savingsNo.put(0, 0.0);
        for(int i=1; i<=30; i++) {
            sum += (this.saving*12);
            this.savingsNo.put(i, sum);
        }
        return this.savingsNo;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }

    public void setSaving(double saving) {
        this.saving = saving;
    }
    
    
    
}
