
import java.util.HashMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kevin
 */
public class IOU {

    private HashMap<String, Double> owe;
    
    public IOU() {
        this.owe = new HashMap<>();
    }
    
    public void setSum(String toWhom, double amount) {
        this.owe.put(toWhom, amount);
    }
    
    public double howMuchDoIOweTo(String toWhom) {
        return this.owe.getOrDefault(toWhom, 0.0);
    }
}
