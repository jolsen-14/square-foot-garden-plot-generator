package squarefootgardenplotgenerator;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GardenerInput {

    // ## INSTANCE VARIABLES ##
    private Scanner userInput = new Scanner(System.in);
    private PlantLists listOfPlants = new PlantLists();
    private Map<String, Integer> allPlants = new HashMap<>();
    private int columns;
    private int rows;

    // ## GETTERS ##

    public int getColumns() {
        return columns;
    }

    public int getRows() {
        return rows;
    }

    // ## METHODS ##

    public Map<String, Integer> askTheGardener() {

            for (int i = 0 ; i < listOfPlants.getrPlants().length ; i++) {
            allPlants.put(listOfPlants.getrPlants()[i], 0);
        }
            for (int i = 0 ; i < listOfPlants.getyPlants().length ; i++) {
            allPlants.put(listOfPlants.getyPlants()[i], 0);
        }
            for (int i = 0 ; i < listOfPlants.getbPlants().length ; i++) {
            allPlants.put(listOfPlants.getbPlants()[i], 0);
        }
            for (int i = 0 ; i < listOfPlants.getoPlants().length ; i++) {
            allPlants.put(listOfPlants.getoPlants()[i], 0);
        }

        // USER INTERACTION BELOW THIS LINE

            System.out.print("Please provide the width of your garden area (in feet): ");
        columns = userInput.nextInt();

            System.out.print("Please provide the height of your garden area (in feet): ");
        rows = userInput.nextInt();

        int totalSquares = columns * rows;

        Integer numTotalPlants = 0;
            for (String plant : allPlants.keySet()) {
            System.out.println("How many grids worth of " + plant + " would you like?");
            System.out.println("(Maximum = " + (totalSquares - numTotalPlants) + ") ");
            Integer numPlants = userInput.nextInt();
            numTotalPlants += numPlants;
            if ((int) numTotalPlants > totalSquares) {
                numTotalPlants -= numPlants;
                System.out.println("That was too many plants, using the maximum instead...");
                numPlants = totalSquares - numTotalPlants;
                numTotalPlants += numPlants;
            }
            allPlants.put(plant, numPlants);
            if (numTotalPlants == totalSquares) {
                break;
            }
        }

            System.out.println("Your garden will consist of the following plants:");
        int plantFullTotal = 0;
            for (String plant : allPlants.keySet()) {
            int plantSubTotal = 0;
            if (allPlants.get(plant) > 0) {
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
                System.out.println(allPlants.get(plant) + " squares of " + plant + " - " + plantSubTotal + " Total");
            }
        }
            System.out.println("Totalling " + plantFullTotal + " plants!");
            return allPlants;
    }
}