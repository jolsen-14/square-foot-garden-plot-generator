package squarefootgardenplotgenerator;

import java.util.*;

public class GridMaker {

    // ## INSTANCE VARIABLES ##

    private final int rows;
    private final int columns;
    private Map<String, Integer> plants;

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
        A new list is made and all items (squares) from the plants map created in GardenerInput are put into it,
        one for every quantity of square of that plant type based on the value in the map, however they are not added in
        sequence but staggered in a pattern using the do/while so that PlantSorter can have something semi-random to sort through.
            * If there are many squares of one plant, they may all be put together at the end/bottom-right of the grid.
         */
        List<String> unsortedPlants = new ArrayList<>();
        int plantQuantity;
        do {
            // This iterates through the plants map and adds one copy of each plant to the list, then subtracts one from the value in the map.
            for (String plant : plants.keySet()) {
                if (plants.get(plant) > 0 && !plant.equals("Empty Square")) {
                    unsortedPlants.add(plant);
                    plants.put(plant, plants.get(plant) - 1);
                }
            }
            // This part counts how many plants are left to add to the list from the map.
            plantQuantity = 0;
            for (String plant : plants.keySet()) {
                if (!plant.equals("Empty Square")) {
                    plantQuantity += plants.get(plant);
                }
            }
            // If there are any plants remaining in the map, do this again.
        } while (plantQuantity > 0);
        // If there are any Empty Squares, add them all to the end of the grid.
        if (plants.get("Empty Square") != 0) {
            for (int i = 0 ; i < plants.get("Empty Square") ; i++) {
                unsortedPlants.add("Empty Square");
            }
        }

        // Create a new instance of PlantSorter so we can sort these plants.
        PlantSorter plantSorter = new PlantSorter();
        // Sort them 100 times to try to ensure no alike plants are adjacent to each other (Might still happen).
        int sortMatches = 0; // sortMatches tracks how many times a match has occurred between the pre-sorted and sorted plot.
        for (int i = 0 ; i <= 100 ; i++) {
            List<String> preUnsortedPlants = new ArrayList<>(unsortedPlants);
            unsortedPlants = plantSorter.sortThesePlants(unsortedPlants, columns);
            if (preUnsortedPlants.equals(unsortedPlants)) {
                sortMatches++;
            }
            if (sortMatches > 10) { // If there's been 10 matches, then just end the sorting here.
                System.out.println("The plot has been sorted " + i + " times in an attempt to ensure alike plants are not in adjacent squares.");
                break;
            }
        }

        // Now a new queue is made from the now-sorted plants so that we can use it in RowMaker.
        Queue<String> sortedPlants = new LinkedList<>(unsortedPlants);

        /*
        A new list of strings is then made and iteratively the lines of the grid are added to it, one row at a time.
         */
        List<String> gridInFull = new ArrayList<>();
        for (int j = 1 ; j <= rows ; j++) {
            // Make a new RowMaker instance and run makeRow in it, once for every row.
            RowMaker rowGenerator = new RowMaker();
            String[] generatedRow = rowGenerator.makeRow(sortedPlants, columns);
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
