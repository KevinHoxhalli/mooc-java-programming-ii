
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Warehouse {
    
    private Map<String, Integer> products;
    private Map<String, Integer> stockProducts;
    
    public Warehouse() {
        this.products = new HashMap<>();
        this.stockProducts = new HashMap<>();
    }
    
    public void addProduct(String product, int price, int stock) {
        this.products.put(product, price);
        this.stockProducts.put(product, stock);
    }
    
    public int price(String product) {
        if(this.products.containsKey(product)) {
            return this.products.get(product);
        }
        return -99;
    }
    
    public int stock(String product) {
        if(this.stockProducts.containsKey(product)) {
            return this.stockProducts.get(product);
        }
        return 0;
    }
    
    public boolean take(String product) {
        if(this.stockProducts.containsKey(product)) {
            if(this.stockProducts.get(product)>0) {
               this.stockProducts.put(product, this.stockProducts.get(product)-1); 
               if(this.stockProducts.get(product)>0) {
                   return true;
               } else {
                   return false;
               }
            }
            return false;
        }     
        return false;
    }
    
    public Set<String> products() {
        return this.products.keySet();
    }
    
}
