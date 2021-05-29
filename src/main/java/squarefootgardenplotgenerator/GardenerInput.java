package squarefootgardenplotgenerator;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GardenerInput {

    // ## INSTANCE VARIABLES ##

    private Scanner userInput = new Scanner(System.in);
    private PlantLists listOfPlants = new PlantLists();
    private Map<String, Integer> allPlants = listOfPlants.getAllPlantsList(); // predefined from PlantLists.
    private int columns;
    private int rows;
    private double woodLengthRequired;
    private double compostGallonsRequired;

    // ## GETTERS ##

    public int getColumns() {
        return columns;
    }

    public int getRows() {
        return rows;
    }

    public double getWoodLengthRequired() {
        return woodLengthRequired;
    }

    public double getCompostGallonsRequired() {
        return compostGallonsRequired;
    }

    // ## METHODS ##

    public Map<String, Integer> askTheGardener() {

        // USER INTERACTION BELOW THIS LINE

            System.out.print("Please provide the width of your garden area (in feet): ");
        columns = userInput.nextInt();

            System.out.print("Please provide the height of your garden area (in feet): ");
        rows = userInput.nextInt();

        int totalSquares = columns * rows;

        // Iterates through the possible plants and asks how many the gardener wants to plant
        // and adds them to the key for that plant in the map.
        Integer numTotalPlants = 0;
            for (String plant : allPlants.keySet()) {
                System.out.println("How many squares worth of " + plant + " would you like?");
                System.out.println("(Maximum = " + (totalSquares - numTotalPlants) + ") ");
                Integer numPlants = userInput.nextInt();
                numTotalPlants += numPlants;
                // If the gardener tried to add more plants than there are squares left, it just adds the maximum.
                if ((int) numTotalPlants > totalSquares) {
                    numTotalPlants -= numPlants;
                    System.out.println("That was too many squares, using the maximum instead...");
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
            System.out.println("You will need " + woodLengthRequired + "feet of wood, or " + woodLengthRequired / 4 + " planks of 1in x 6in x 4ft wood.");
        } else {
            System.out.println("You will need " + woodLengthRequired + "feet of wood, or " + (Math.ceil(woodLengthRequired / 4)) + " planks of 1in x 6in x 4ft wood (Cutting required).");
        }
        System.out.println();

        // Calculate and print compost required:
        compostGallonsRequired = ((double) this.rows * (double) this.columns * .5) * 7.48052;
        System.out.println("You will also need " + compostGallonsRequired + "Gal of compost, or " + compostGallonsRequired / 5 + " 5 gallon buckets worth.");
        System.out.println();
        // Finally, return the map to be used in GridMaker.
        return allPlants;
    }
}
