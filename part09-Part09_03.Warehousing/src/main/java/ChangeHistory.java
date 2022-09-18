
import java.util.ArrayList;


public class ChangeHistory {
    
    private ArrayList<Double> changeHistory;
    
    public ChangeHistory() {
        this.changeHistory = new ArrayList<>();
    }
    
    public void add(double status) {
        this.changeHistory.add(status);
    }

    public void clear() {
        this.changeHistory.clear();
    }
    
    public String toString() {
        return this.changeHistory.toString();
    }
    
    public double maxValue() {
        if(this.changeHistory.isEmpty()) {
            return 0;
        }
        double max = this.changeHistory.get(0);
        for(Double value: this.changeHistory) {
            if(value > max) {
                max = value;
            }
        }
        return max;
    }
    
    public double minValue()  {
        if(this.changeHistory.isEmpty()) {
            return 0;
        }
        double min = this.changeHistory.get(0);
        for(Double value: this.changeHistory) {
            if(value < min) {
                min = value;
            }
        }
        return min;   
    }
    
    public double average() {
        if(this.changeHistory.isEmpty()) {
            return 0;
        }
        double sum = 0;
        for(Double value: this.changeHistory) {
            sum +=value;
        }
        return sum/this.changeHistory.size();
    }
    
}
