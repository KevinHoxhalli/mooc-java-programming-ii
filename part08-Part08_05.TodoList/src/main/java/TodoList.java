
import java.util.ArrayList;

public class TodoList {
    private ArrayList<String> tasks;

    public TodoList() {
        this.tasks = new ArrayList<>();
    }
    
    public void add(String task) {
        this.tasks.add(task);
    }
    
    public void print() {
        if(this.tasks.isEmpty()) {
            return;
        }
        int count = 1;
        for(String task: this.tasks) {
            System.out.println(count+": "+task);
            count++;
        }
    }
    
    public void remove(int number) {
        if(this.tasks.isEmpty())
            return;
        this.tasks.remove(number-1);
    }
}
