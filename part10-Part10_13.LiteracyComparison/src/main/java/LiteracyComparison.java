
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class LiteracyComparison {
    
    public static void main(String[] args) {
        try {
            Files.lines(Paths.get("literacy.csv"))
                    .map(rows -> rows.split(","))
                    .sorted((p1,p2) ->{
                        return p1[5].compareTo(p2[5]);
                    }).forEach(row -> System.out.println(row[3]+" ("+row[4]+"), "+row[2].trim().split(" ")[0]+", "+row[5]));
            
        }catch(Exception E) {
            System.out.println("Error: ");
        }
    }
}
