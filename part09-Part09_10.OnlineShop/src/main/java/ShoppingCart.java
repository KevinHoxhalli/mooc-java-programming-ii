
import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    private Map<String, Item> items;
    
    public ShoppingCart() {
        this.items = new HashMap<>();
    }
    
    public void add(String product, int price) {
        if(this.items.containsKey(product)) {
            this.items.get(product).increaseQuantity();
        } else {
            this.items.put(product, new Item(product, 1,price));           
        }

    }
    public int price() {
        int sum =0;
        for(Item it: this.items.values()) {
            sum+=it.price();
        }
        return sum;
    }
    public void print() {
        for(Item it: this.items.values()) {
            System.out.println(it);
        }       
    }
    
}
