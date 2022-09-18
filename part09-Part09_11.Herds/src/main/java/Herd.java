
import java.util.ArrayList;
import java.util.List;


public class Herd implements Movable{

    private List<Movable> organisms;
    
    public Herd() {
        this.organisms = new ArrayList<>();
    }
    
    public String toString() {
        String to = "";
        for(Movable org: this.organisms) {
            to+=org.toString()+"\n";
        }
        return to;
    }
    
    public void addToHerd(Movable movable) {
        this.organisms.add(movable);
    }
    
    @Override
    public void move(int dx, int dy) {
        for(Movable org: this.organisms) {
            org.move(dx,dy);
        }
    }
    
}
