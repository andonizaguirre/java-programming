
public class MagicSquareFactory {

    public MagicSquare createMagicSquare(int size) {
        MagicSquare square = new MagicSquare(size);
        // implement the creation of a magic square with the Siamese method algorithm here
        int x = size / 2; // X axis -> moves through columns in a row
        int y = 0; // Y axis  -> moves through rows in a column
        square.placeValue(x, y, 1); // Centermost column of the top row == 1
        for (int i = 2; i <= size * size; i++) { // Fill the matrix     
            int tempY = y - 1;
            if (tempY < 0) { // Out of upper bound
                tempY = size - 1;
//                tempY = tempY + size;
            }
            int tempX = x + 1;
            if (tempX > size - 1) { // Out of right bound
                tempX = 0;
//                tempX = tempX % size; // Wrap number with modulo
            }
            if (square.readValue(tempX, tempY) != 0) { // Place not empty
                // Just move downwards
                tempX = x;
                tempY = y + 1;
            }
            // Final coordinates values are replaced
            x = tempX;
            y = tempY;
            square.placeValue(x, y, i);
        }
        return square;
    }
}
