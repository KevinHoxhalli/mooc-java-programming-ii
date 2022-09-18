
public class Program {

    public static void main(String[] args) {
        // Test the MagicSquare class here
        MagicSquare sq = new MagicSquare(3);
        sq.placeValue(1,0,1);
        System.out.println(sq.readValue(1, 0));
        System.out.println(sq.toString());
        MagicSquareFactory msFactory = new MagicSquareFactory();
        System.out.println(msFactory.createMagicSquare(2));
        System.out.println(msFactory.createMagicSquare(2).sumsOfColumns());
    }
}
