
import java.util.ArrayList;
import java.util.Random;

public class LotteryRow {

    private ArrayList<Integer> numbers;
    

    public LotteryRow() {
        // Draw the numbers when the LotteryRow is created
        this.randomizeNumbers();
    }

    public ArrayList<Integer> numbers() {
        return this.numbers;
    }

    public void randomizeNumbers() {
        // Initialize the list for numbers
        Random random = new Random();
        this.numbers = new ArrayList<>();
        // Implement the random number generation here
        int count = 0;
        while(count<7) {
            int r = random.nextInt(40)+1;
            if(this.numbers.contains(r)) {
                continue;
            }
            this.numbers.add(r);
            count++;
        }
        // the method containsNumber is probably useful
    }

    public boolean containsNumber(int number) {
        return this.numbers.contains(number);
    }
}

