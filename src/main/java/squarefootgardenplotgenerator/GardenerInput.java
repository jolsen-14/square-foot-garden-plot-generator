package squarefootgardenplotgenerator;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class GardenerInput {

    // ## INSTANCE VARIABLES ##

    private final Scanner userInput = new Scanner(System.in);
    private final PlantLists listOfPlants = new PlantLists();
    private final Map<String, Integer> allPlants = listOfPlants.getAllPlantsList(); // predefined from PlantLists.
    private int columns;
    private int rows;
    private double woodLengthRequired;
    private BigDecimal compostGallonsRequired;

    // ## GETTERS ##

    public int getColumns() {
        return columns;
    }

    public int getRows() {
        return rows;
    }

    // ## METHODS ##

    public void askTheGardener() {

        // USER INTERACTION BELOW THIS LINE

        // Get the number of columns in the garden.
        System.out.println("Please provide the width of your garden area (in feet):");
        do {
            System.out.println("   (The number can't be zero or negative)");
            while (!userInput.hasNextInt()) {
                System.out.println("That's not a number!");
                userInput.next();
            }
            columns = userInput.nextInt();
        } while (columns < 1);
        System.out.println("Thank you! There will be " + columns + " columns in your plot.\n");

        // Get the number of rows in the garden.
        System.out.println("Please provide the height of your garden area (in feet):");
        do {
            System.out.println("   (The number can't be zero or negative)");
            while (!userInput.hasNextInt()) {
                System.out.println("That's not a number!");
                userInput.next();
            }
            rows = userInput.nextInt();
        } while (rows < 1);
        System.out.println("Thank you! There will be " + rows + " rows in your plot.\n");

        int totalSquares = columns * rows;

        // Iterates through the possible plants and asks how many the gardener wants to plant
        // and adds them to the key for that plant in the map.
        int numTotalPlants = 0;
        for (String plant : allPlants.keySet()) {
            int numPlants;
            System.out.println("How many squares worth of " + plant + " would you like?\n   (Maximum = " + (totalSquares - numTotalPlants) + ") ");
            do {
                System.out.println("   (The number can't be negative)");
                while (!userInput.hasNextInt()) {
                    System.out.println("That's not a number!");
                    userInput.next();
                }
                numPlants = userInput.nextInt();
            } while (numPlants < 0);
            numTotalPlants += numPlants;
            // If the gardener tried to add more plants than there are squares left, it just adds the maximum.
            if (numTotalPlants > totalSquares) {
                numTotalPlants -= numPlants;
                System.out.println("That was too many squares, using the maximum instead...\n");
                numPlants = totalSquares - numTotalPlants;
                numTotalPlants += numPlants;
            }
            allPlants.put(plant, numPlants);
            // If we've reached the maximum squares filled, the loop ends and no more questions are asked.
            if (numTotalPlants == totalSquares) {
               break;
            }
        }
        // Time to print out a list of the plants the gardener picked...
        System.out.println("Your garden will consist of the following plants:");
          int plantFullTotal = 0;
            for (String plant : allPlants.keySet()) {
            int plantSubTotal = 0;
            if (allPlants.get(plant) > 0) {
                // These if/else's calculate the number of individual seeds/seedlings of each plant type to be planted.
                if (Arrays.asList(listOfPlants.getrPlants()).contains(plant)) {
                    plantSubTotal = allPlants.get(plant) * 16;
                    plantFullTotal += plantSubTotal;
                } else if (Arrays.asList(listOfPlants.getyPlants()).contains(plant)) {
                    plantSubTotal = allPlants.get(plant) * 9;
                    plantFullTotal += plantSubTotal;
                } else if (Arrays.asList(listOfPlants.getbPlants()).contains(plant)) {
                    plantSubTotal = allPlants.get(plant) * 4;
                    plantFullTotal += plantSubTotal;
                } else if (Arrays.asList(listOfPlants.getoPlants()).contains(plant)) {
                    plantSubTotal = allPlants.get(plant);
                    plantFullTotal += plantSubTotal;
                }
                // If there's only one square of a plant, print a line with "square", else "squares" and seed total.
                if (allPlants.get(plant) == 1) {
                    System.out.println(allPlants.get(plant) + " square of " + plant + " - " + plantSubTotal + " Total");
                } else {
                    System.out.println(allPlants.get(plant) + " squares of " + plant + " - " + plantSubTotal + " Total");
                }
            }
        }
        // Print the total number of plants that the gardener will be planting.
        System.out.println("Totalling " + plantFullTotal + " plants!");
        System.out.println();

        // Calculate and print wood required:
        woodLengthRequired = ((double) this.rows * 2) + ((double) this.columns * 2);
        if (woodLengthRequired % 4 == 0) {
            System.out.println("You will need " + woodLengthRequired + "ft of wood, or " + woodLengthRequired / 4 + " planks of 1in x 6in x 4ft wood.");
        } else {
            System.out.println("You will need " + woodLengthRequired + "ft of wood, or " + (Math.ceil(woodLengthRequired / 4)) + " planks of 1in x 6in x 4ft wood (Cutting required).");
        }
        System.out.println();

        // Calculate and print compost required:
        compostGallonsRequired = (BigDecimal.valueOf(this.rows).multiply(BigDecimal.valueOf(this.columns)).multiply(BigDecimal.valueOf(7.48052))).setScale(2, RoundingMode.CEILING);
        System.out.println("You will also need " + compostGallonsRequired + "gal of compost, or " + compostGallonsRequired.divide(BigDecimal.valueOf(5), RoundingMode.CEILING).setScale(2, RoundingMode.CEILING) + " 5 gallon buckets worth.");
        System.out.println();

        // Finally, use the map in a new GridMaker instance.
        GridMaker gridBuilder = new GridMaker(allPlants, rows, columns);
        List<String> myGrid = gridBuilder.makeGrid();
        System.out.println("Here's your garden grid!");
        for (String line : myGrid) {
            System.out.println(line);
        }
    }
}
