
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AverageOfSelectedNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> inputs = new ArrayList<>();
        
        System.out.println("Input numbers, type \"end\" to stop.");         
        while(true) {
            String in = scanner.nextLine();
            if(in.equals("end")) {
                break;
            }
            inputs.add(in);
        }
        System.out.println("");
        System.out.println("Print the average of the negative numbers or the positive numbers? (n/p)");
        String in2 = scanner.nextLine();
        
        if(in2.equals("n")) {
            System.out.println("Average of the negative numbers: "+inputs.stream().mapToInt(s -> Integer.valueOf(s)).filter(n -> n<0).average().getAsDouble());
        } else if(in2.equals("p")) {
            System.out.println("Average of the posiitve numbers: "+inputs.stream().mapToInt(s -> Integer.valueOf(s)).filter(n -> n>0).average().getAsDouble());
        }
    
    }
}
