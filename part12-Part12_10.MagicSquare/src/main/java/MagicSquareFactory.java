
public class MagicSquareFactory {

    public MagicSquare createMagicSquare(int size) {

        MagicSquare square = new MagicSquare(size);

        // implement the creation of a magic square with the Siamese method algorithm here
        int number=1;
        int i = 0;
        int j = (size/2);
        square.placeValue(j, i, 1);
        number++;
        while(number<=size*size) {
            
            int nextRow = i-1;
               
            if(nextRow<0) {
                nextRow=square.getHeight()-1;
            }
            
            if(nextRow>=size) {
                nextRow=0;
            }
            
            int nextColumn = j+1;
            if(nextColumn>=size) {
                nextColumn = 0;
            }
            
            if(nextColumn<0) {
                nextColumn = square.getWidth()-1;
            }
            
            if(square.readValue(nextColumn, nextRow)!=0) {
                nextRow = i+1;
                nextColumn = j;
                if(nextRow<0) {
                    nextRow=square.getHeight()-1;
                }
            
                if(nextRow>=size) {
                    nextRow=0;
                }
               
            }
            
            square.placeValue(nextColumn, nextRow, number);
            number++;
            i = nextRow;
            j = nextColumn;
            
            
        }
        return square;
    }
    


}
