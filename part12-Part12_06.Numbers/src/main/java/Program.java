
import java.util.Random;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many random numbers should be printed?");
        Random rand = new Random();
        int times = Integer.valueOf(scanner.nextLine());
        for(int i=0; i<times; i++) {
            System.out.println(rand.nextInt(10+1));
        }
    }

}
