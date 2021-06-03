package squarefootgardenplotgenerator;

import java.util.List;

public class PlantSorter {

    public List<String> sortThesePlants(List<String> grid, int columns) {

        String searchSquare;
        String topSquare;
        String leftSquare;
        String rightSquare;
        String bottomSquare;

        for (int i = 0 ; i < grid.size() ; i++) {
            searchSquare = grid.get(i);
            // Need some if statements to make sure you don't check out of bounds before the start and close to the end

            // If i is not in the top row, then set it to the value of the square directly above searchSquare (i - columns)
            if (i < columns) {
                topSquare = "X";
            } else {
                topSquare = grid.get(i - columns);
            }

            // If i is not 0 and not at the start of a row, then set it to the value of the square directly left of searchSquare (i - 1)
            if (i != 0 && i % columns != 0) {
                leftSquare = grid.get(i - 1);
            } else {
                leftSquare = "X";
            }

            // If i is not at the end of the grid and not at the end of a row, then set it to the value of the square directly right of searchSquare (i + 1)
            if (i != grid.size() - 1 && (i + 1) % columns != 0) {
                rightSquare = grid.get(i + 1);
            } else {
                rightSquare = "X";
            }

            // If i is not in the bottom row, then set it to the value of the square directly below searchSquare (i + columns)
            if (i > (grid.size() - 1 - columns)) {
                bottomSquare = "X";
            } else {
                bottomSquare = grid.get(i + columns);
            }

            // Now that the adjacent squares have been set to their values, if appropriate
            if (searchSquare.equals(topSquare) ||
                    searchSquare.equals(leftSquare) ||
                    searchSquare.equals(rightSquare) ||
                    searchSquare.equals(bottomSquare)) {
                // Shift searchSquare right, unless it's at the end of the list in which case put it at index 0
                String squareValue = grid.get(i);
                if (i != grid.size() - 1) {
                    grid.set(i, grid.get(i + 1));
                    grid.set(i + 1, squareValue);
                } else {
                    grid.set(i, grid.get(0));
                    grid.set(0, squareValue);
                }

            }
        }

        return grid;
    }


    /*
    +---+---+---+---+---+
    | 0 | 1 | 2 | 3 | 4 |
    +---+---+---+---+---+
    | 5 |*6*| 7 | 8 | 9 |
    +---+---+---+---+---+
    |10 |11 |12 |13 |14 |
    +---+---+---+---+---+

    columns = 5
    rows = 3
    searchSquare = 6

    Say we want to check the 4 spaces around the square at index 6.
        - We have to check the following squares:
            *  1 == searchSquare - columns  : topSquare
            *  5 == searchSquare - 1        : leftSquare
            *  7 == searchSquare + 1        : rightSquare
            * 11 == searchSquare + columns  : bottomSquare
       // Need some if statements to make sure you don't check out of bounds before the start and close to the end
     */

}
