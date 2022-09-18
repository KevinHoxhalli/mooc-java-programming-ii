
import java.util.ArrayList;


public class Box implements Packable{
    private double capacity;
    private ArrayList<Packable> items;
    
    public Box(double capacity) {
        this.capacity = capacity;
        this.items = new ArrayList<>();
    }
    
    public void add(Packable pack) {
        if(pack.weight()+this.weight() <= this.capacity) {
            this.items.add(pack);
        }
    }
    
    public double weight() {
        double sum = 0.0;
        for(Packable item: this.items) {
            sum+=item.weight();
        }
        return sum;
    }

    @Override
    public String toString() {
        return "Box: "+this.items.size()+" items, total weight "+this.weight()+" kg";
    }
    
    
    
}
