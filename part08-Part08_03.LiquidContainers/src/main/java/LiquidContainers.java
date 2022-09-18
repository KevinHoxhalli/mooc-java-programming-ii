
import java.util.Scanner;

public class LiquidContainers {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int first = 0;
        int second = 0;
        int max = 100;
        
        while (true) {
            System.out.println("First:" +first+"/"+max);
            System.out.println("Second:" +second+"/"+max);
            String input = scan.nextLine();
            if (input.equals("quit")) {
                break;
            }
            String[] parts = input.split(" ");
            String command = parts[0];
            int amount = Integer.valueOf(parts[1]);
            if(command.equals("add")) {
                if(amount<0) {
                    continue;
                } else if(amount+first>max) {
                    first = max;
                } else {
                    first = first +amount;
                }
                
            } else if(command.equals("move")) {
                if(amount>first) {
                    
                    if(second+first>max) {
                        second = max;
                    } else {
                        second = second + first;
                    }
                    first = 0;
                } else {
                    
                    if(second+amount>max) {
                        second = max;
                    } else {
                        second = second + amount;
                    }
                    first = first - amount;
                }
            } else if(command.equals("remove")) {
                if(amount>second) {
                    second = 0;
                } else {
                    second = second - amount;
                }
            }
            System.out.println("");
        }
    }

}
