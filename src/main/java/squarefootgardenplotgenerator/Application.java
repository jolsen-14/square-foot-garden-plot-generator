package squarefootgardenplotgenerator;

import java.util.*;

public class Application {
    public static void main(String[] args) {

        SquareMaker makeMeAGarden = new SquareMaker();
        Scanner userInput = new Scanner(System.in);

        String[] rPlants = new String[]{"Beets (Small)", "Carrots", "Green Onion", "Leek", "Micro Greens",
                "Parsnip", "Radish", "Salad Greens", "Scallions", "Turnips (Small)"};

        String[] yPlants = new String[]{"Beans (Pole)", "Beans (Bush)", "Beets (Large)", "Bok Choy",
                "Celery", "Mustard", "Onion (Bulb)", "Peas", "Soybean", "Spinach", "Turnips (Large)"};

        String[] bPlants = new String[]{"Corn", "Chives", "Garlic", "Lettuce (Head)", "Rutabagas",
                "Shallots", "Sunflowers (Hedge)", "Swiss Chard"};

        String[] oPlants = new String[]{"Broccoli", "Brussel Sprouts", "Cabbage", "Cauliflower", "Eggplant",
                "Kale", "Peppers", "Potato", "Strawberry", "Sunflower (Large)", "Tomatoes (Vine)"};

        Map<String, Integer> allPlants = new HashMap<String, Integer>();

        for (int i = 0 ; i < rPlants.length ; i++) {
            allPlants.put(rPlants[i] + " (16 plants per grid)", 0);
        }

        for (int i = 0 ; i < yPlants.length ; i++) {
            allPlants.put(yPlants[i] + " (9 plants per grid)", 0);
        }

        for (int i = 0 ; i < bPlants.length ; i++) {
            allPlants.put(bPlants[i] + " (4 plants per grid)", 0);
        }

        for (int i = 0 ; i < oPlants.length ; i++) {
            allPlants.put(oPlants[i] + " (1 plant per grid)", 0);
        }

        // USER INTERACTION BELOW THIS LINE

        System.out.print("Please provide the width of your garden area (in feet): ");
        int columns = userInput.nextInt();

        System.out.print("Please provide the height of your garden area (in feet): ");
        int rows = userInput.nextInt();

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
                if (plant.contains("16")) {
                    plantSubTotal = allPlants.get(plant) * 16;
                    plantFullTotal += plantSubTotal;
                } else if (plant.contains("9")) {
                    plantSubTotal = allPlants.get(plant) * 9;
                    plantFullTotal += plantSubTotal;
                } else if (plant.contains("4")) {
                    plantSubTotal = allPlants.get(plant) * 4;
                    plantFullTotal += plantSubTotal;
                } else if (plant.contains("1")) {
                    plantSubTotal = allPlants.get(plant);
                    plantFullTotal += plantSubTotal;
                }
                System.out.println(allPlants.get(plant) + " squares of " + plant + " - " + plantSubTotal + " Total");
            }
        }
        System.out.println("Totalling " + plantFullTotal + " plants!");
        System.out.println();
        System.out.println("Here is the template for your grid:");

        makeMeAGarden.seededInput(rows, columns);

    }
}
