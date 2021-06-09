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
    private int numTotalPlants = 0;

    // ## GETTERS ##

    public int getColumns() {
        return columns;
    }

    public int getRows() {
        return rows;
    }

    // ## METHODS ##

    public void askTheGardener() {

        System.out.println(
                  "############################################################" +
                "\n##### WELCOME TO THE SQUARE FOOT GARDEN PLOT GENERATOR #####" +
                "\n############################################################");

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

        // Open up the plant selection menu via the plantTypeMenu method.

        plantTypeMenu(totalSquares);

        // If the user added no squares of plants, or not enough, add the rest as Empty Squares.
        if (numTotalPlants != totalSquares) {
            allPlants.put("Empty Square", totalSquares - numTotalPlants);
        }

        // Time to print out a list of the plants the gardener picked...
        System.out.println(
                  "############################################################" +
                "\n##################### PLOT GENERATION! #####################" +
                "\n############################################################");
        System.out.println("\nYour garden will consist of the following plants:");
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

    // #### HELPER METHODS ####

    public void plantTypeMenu(int totalSquares) {
        boolean plantTypeMenuOpen = true;
        while (plantTypeMenuOpen && numTotalPlants < totalSquares) {
            // Display the categories of plants to chose from and have the user select a category or exit the menu.
            System.out.println(
                      "############################################################" +
                    "\n################### PLANT CATEGORY MENU ####################" +
                    "\n############################################################");
            System.out.println("Please select from the following plant categories:" +
                    "\n(1) Small Plants" +
                    "\n(2) Medium Plants" +
                    "\n(3) Large Plants" +
                    "\n(4) Extra Large Plants" +
                    "\n(5) Exit Menu" +
                    "\n\nYou have " + (totalSquares - numTotalPlants) + " remaining free squares.");
            if (numTotalPlants > 0) {
                System.out.println("\nYour current list of plants is: ");
                for (String plant : allPlants.keySet()) {
                    if (allPlants.get(plant) > 0) {
                        System.out.println(allPlants.get(plant) + " " + plant);
                    }
                }
                System.out.println();
            }
            System.out.println("Enter the category number here: ");
            String plantTypeChoice = userInput.next();
            if (plantTypeChoice.equals("1")) {
                System.out.println(
                          "############################################################" +
                        "\n####################### SMALL PLANTS #######################" +
                        "\n############################################################");
                plantSelectionMenu(listOfPlants.getrPlants(), totalSquares);
            } else if (plantTypeChoice.equals("2")) {
                System.out.println(
                          "############################################################" +
                        "\n###################### MEDIUM PLANTS #######################" +
                        "\n############################################################");
                plantSelectionMenu(listOfPlants.getyPlants(), totalSquares);
            } else if (plantTypeChoice.equals("3")) {
                System.out.println(
                          "############################################################" +
                        "\n####################### LARGE PLANTS #######################" +
                        "\n############################################################");
                plantSelectionMenu(listOfPlants.getbPlants(), totalSquares);
            } else if (plantTypeChoice.equals("4")) {
                System.out.println(
                          "############################################################" +
                        "\n#################### EXTRA LARGE PLANTS ####################" +
                        "\n############################################################");
                plantSelectionMenu(listOfPlants.getoPlants(), totalSquares);
            } else if (plantTypeChoice.equals("5")) {
                plantTypeMenuOpen = false;
            }
        }
    }

    public void plantSelectionMenu(String[] plantSubList, int totalSquares) {
        List<String> menuLines = new ArrayList<>();
        // Display a formatted list of all possible items in the category of plant the user picked.
        String blankLine = "                    ";
        int j = 0;
        for (int i = 0 ; i < plantSubList.length ; i++) {
            if (i < plantSubList.length - 3) {
                menuLines.add("(" + i + ") " + plantSubList[i] + blankLine.substring(0, blankLine.length() - plantSubList[i++].length()) + " " + "(" + i + ") " + plantSubList[i] + blankLine.substring(0, blankLine.length() - plantSubList[i++].length()) + " " + "(" + i + ") " + plantSubList[i]);
            } else if (i < plantSubList.length - 2) {
                menuLines.add("(" + i + ") " + plantSubList[i] + blankLine.substring(0, blankLine.length() - plantSubList[i++].length()) + " " + "(" + i + ") " + plantSubList[i]);
            } else if (i == plantSubList.length - 1) {
                menuLines.add("(" + i + ") " + plantSubList[i]);
            }
        }
        menuLines.add("\nYou have " + (totalSquares - numTotalPlants) + " remaining free squares.");
        menuLines.add("Enter the plant type # as listed above here: ");
        // After printing the options, ask the user to select a plant type.
        boolean plantMenuOpen = true;
        while (plantMenuOpen) {
            for (String line : menuLines) {
                System.out.println(line);
            }
            int plantChoice = userInput.nextInt();
            while (plantChoice < 0 || plantChoice > plantSubList.length - 1) {
                System.out.println("That was an invalid choice or a negative number. Try again:");
                while (!userInput.hasNextInt()) {
                    System.out.println("That's not a number!");
                    userInput.next();
                }
                plantChoice = userInput.nextInt();
            }
            System.out.println("You currently have " + allPlants.get(plantSubList[plantChoice]) + " " + plantSubList[plantChoice] + " selected.");
            System.out.println("Enter the desired number of " + plantSubList[plantChoice] + " here: (or 0 to clear)");
            int plantQuantityChoice = userInput.nextInt();
            while (plantQuantityChoice < 0) {
                System.out.println("That was a negative number. Try again:");
                while (!userInput.hasNextInt()) {
                    System.out.println("That's not a number!");
                    userInput.next();
                }
                plantQuantityChoice = userInput.nextInt();
            }
            // If the user entered 0, clear their selection of plants for that plant type.
            if (plantQuantityChoice == 0) {
                System.out.println("Clearing your selection of " + plantSubList[plantChoice]);
                numTotalPlants -= allPlants.get(plantSubList[plantChoice]);
                allPlants.put(plantSubList[plantChoice], 0);
            } else {
                numTotalPlants += plantQuantityChoice;
            }
            // If the user entered more plants than there are available squares, add the maximum.
            if (numTotalPlants > totalSquares) {
                numTotalPlants -= plantQuantityChoice;
                System.out.println("That was too many squares, using the maximum instead...\n");
                plantQuantityChoice = totalSquares - numTotalPlants;
                numTotalPlants += plantQuantityChoice;
            }
            allPlants.put(plantSubList[plantChoice], plantQuantityChoice);
            plantMenuOpen = false;
        }

    }
}
