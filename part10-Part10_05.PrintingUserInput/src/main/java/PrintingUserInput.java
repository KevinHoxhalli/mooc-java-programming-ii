
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrintingUserInput {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        List<String> words = new ArrayList<>();
        while(true) {
            String word = scanner.nextLine();
            if(word.isEmpty()) {
                break;
            }
            words.add(word);
        }
        String print = words.stream()
                .reduce("", (previousString, wordVal) -> previousString + wordVal + "\n");
        System.out.println(print);
                

    }
}
