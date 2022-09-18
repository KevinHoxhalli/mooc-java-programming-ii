
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;


public class Hand implements Comparable<Hand>{
    
    private List<Card> cards;
    
    public Hand() {
        this.cards = new ArrayList<>();
    }
    
    public void add(Card card) {
        this.cards.add(card);
    }
    
    public void print() {
        Iterator<Card> iterator = this.cards.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
    
    public void sort() {
        this.cards = this.cards.stream().sorted().collect(Collectors.toList());
    }


    @Override
    public int compareTo(Hand o) {
       return this.cards.stream().map(card -> card.getValue())
               .reduce(0, (sum, val) -> sum + val)
               - o.cards.stream().map(card -> card.getValue())
               .reduce(0, (sum, val) -> sum + val);
    }
    
    public void sortBySuit() {
        BySuitInValueOrder sortBySuitSorter = new BySuitInValueOrder();
        Collections.sort(this.cards, sortBySuitSorter);
    }
}
