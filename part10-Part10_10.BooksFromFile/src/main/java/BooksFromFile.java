
import java.io.IOException;
import java.nio.file.Files;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class BooksFromFile {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // test your method here

    }
    
    public static List<Book> readBooks(String file) {
        try {
            return Files.lines(Paths.get(file))
                    .map(n -> n.split(","))
                    .filter(parts -> parts.length>=4)
                    .map(parts -> new Book(parts[0],Integer.valueOf(parts[1]),Integer.valueOf(parts[2]),parts[3]))
                    .collect(Collectors.toCollection(ArrayList::new));
      
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());        
        }   
        return new ArrayList<>();
    }

}
