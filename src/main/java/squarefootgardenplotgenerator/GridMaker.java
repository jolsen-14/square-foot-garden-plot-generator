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
        one for every quantity of square of that plant type based on the value in the map, however they are not added in
        sequence but staggered using the do/while so that like plants are, ideally, not placed next to each other. This
        isn't perfect yet as it only places plants in a pattern and if there are many squares of one plant, they may
        all be put together at the end/bottom-right of the grid.
         */
        Queue<String> tempPlants = new LinkedList<>();
        int plantQuantity = 0;
        do {
            for (String plant : plants.keySet()) {
                if (plants.get(plant) > 0) {
                    tempPlants.add(plant);
                    plants.put(plant, plants.get(plant) - 1);
                }
            }
            plantQuantity = 0;
            for (String plant : plants.keySet()) {
                plantQuantity += plants.get(plant);
            }
        } while (plantQuantity > 0);
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
