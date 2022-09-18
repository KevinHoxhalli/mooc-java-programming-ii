
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class MainProgram {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Book> books = new ArrayList<>();
        while(true) {
            System.out.println("Input the name of the book, empty stops: ");
            String name = scanner.nextLine();
            if(name.isEmpty()) {
                break;
            }
            System.out.println("Input the name of the book, empty stops: ");
            int age = Integer.valueOf(scanner.nextLine());
            books.add(new Book(name,age));
            System.out.println("");
        }
        System.out.println("");
        System.out.println(books.size()+" books in total.");
        System.out.println("");
        
        Comparator<Book> comparator = Comparator
                .comparing(Book::getAgeR)
                .thenComparing(Book::getName);
        Collections.sort(books, comparator);
        
        System.out.println("Books:");
        for(Book b: books) {
            System.out.println(b.toString());
        }
    }

}
