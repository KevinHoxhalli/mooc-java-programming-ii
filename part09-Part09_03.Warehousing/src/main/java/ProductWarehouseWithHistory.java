
public class ProductWarehouseWithHistory extends ProductWarehouse{
    private ChangeHistory changeHistory;

    public ProductWarehouseWithHistory(String productName, double capacity, double initialBalance) {
        super(productName, capacity);
        this.changeHistory = new ChangeHistory();
        this.addToWarehouse(initialBalance);
    }
    
    public String history() {
        return this.changeHistory.toString();
    }
    
    public void addToWarehouse(double amount) {
        super.addToWarehouse(amount);
        this.changeHistory.add(this.getBalance());
    }
    
    public double takeFromWarehouse(double amount) {
        if(amount < 0) {
            this.changeHistory.add(this.getBalance());
        }
        if (amount > this.getBalance()) {
            this.changeHistory.add(0.0);  
        }
        if(amount <= this.getBalance() && amount >= 0) {
            this.changeHistory.add(this.getBalance() - amount);
        }
        
        return super.takeFromWarehouse(amount);
 
    }
    
    public void printAnalysis() {
        System.out.println("Product: "+this.getName());
        System.out.println("History: "+this.history());
        System.out.println("Largest amount of product: "+changeHistory.maxValue());
        System.out.println("Smallest amount of product: "+changeHistory.minValue());
        System.out.println("Average: "+changeHistory.average());
    }
    
    
}
