
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Employees {
    
    private List<Person> people;

    public Employees() {
        this.people = new ArrayList<>();
    }
    
    public void add(Person personToAdd) {
        this.people.add(personToAdd);
    }
    
    public void add(List<Person> peopleToAdd) {
        Iterator<Person> iterator = peopleToAdd.iterator();

        while(iterator.hasNext()) {
            this.people.add(iterator.next());
        } 
    }
    
    public void print() {
        Iterator<Person> iterator = this.people.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        } 
    }
    
    public void print(Education education) {
        Iterator<Person> iterator = this.people.iterator();
        while(iterator.hasNext()) {
            Person p = iterator.next();
            if(p.getEducation() == education) {
                System.out.println(p);
            }
        } 
    }
    
    public void fire(Education education) {
        Iterator<Person> iterator = this.people.iterator();
        while(iterator.hasNext()) {  
            if(iterator.next().getEducation() == education) {
                iterator.remove();
            }
        } 
    }
    
}
