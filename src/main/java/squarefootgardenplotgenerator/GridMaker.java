package squarefootgardenplotgenerator;

import java.util.*;

public class GridMaker {

    // ## INSTANCE VARIABLES ##

    private final int rows;
    private final int columns;
    private Map<String, Integer> plants = new HashMap<>();

    // ## CONSTRUCTORS ##

    public GridMaker(Map<String, Integer> plants, int rows, int columns) {
        this.plants = plants;
        this.rows = rows;
        this.columns = columns;
    }

    // ## GETTERS AND SETTERS ##

    // None

    // ## METHODS ##

    public List<String> makeGrid(){
        /*
        A new Queue is made and all items (squares) from the plants map created in GardenerInput are put into it,
        one for every quantity of square that plant type based on the key in the map.
         */
        Queue<String> tempPlants = new LinkedList<>();
        for (String plant : plants.keySet()) {
            for (int i = 0; i < plants.get(plant); i++) {
                tempPlants.offer(plant);
            }
        }
        /*
        A new list of strings is then made and iteratively the lines of the grid are added to it, one row at a time.
         */
        List<String> gridInFull = new ArrayList<>();
        for (int j = 1 ; j <= rows ; j++) {
            // Make a new RowMaker instance and run makeRow in it, once for every row.
            RowMaker rowGenerator = new RowMaker();
            String[] generatedRow = rowGenerator.makeRow(tempPlants, columns);
            // These lines finally add all of the concatenated strings to the gridInFull list for output once all rows are complete.
            gridInFull.addAll(Arrays.asList(generatedRow));
        }
        // This adds one final line of emptyLineDash for each column to the bottom of the grid, without a plant name.
        String lastLineInFull = "+";
        for (int k = 1 ; k <= columns ; k++) {
            lastLineInFull += "-----*-----*-----*-----*-----*-----*-----*-----*-----*-----*-----*-----+";
        }
        gridInFull.add(lastLineInFull);
        return gridInFull;
    }
}
