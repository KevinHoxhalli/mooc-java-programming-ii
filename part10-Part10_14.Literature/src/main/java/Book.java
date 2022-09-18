
public class Book {
    private String name;
    private int ageR;

    public Book(String name, int ageR) {
        this.name = name;
        this.ageR = ageR;
    }

    public int getAgeR() {
        return ageR;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return this.name+" (recommended for "+this.ageR+" year-olds or older)";
    }
    
    
    
}
