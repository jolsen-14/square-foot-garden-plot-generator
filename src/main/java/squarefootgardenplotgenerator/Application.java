package squarefootgardenplotgenerator;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        SquareMaker emptySquareTest = new SquareMaker();

//        emptySquareTest.emptySquare();

//        emptySquareTest.seededInput(2, 2);

        String[] rPlants = new String[]{"Beets (Small)", "Carrots", "Green Onion", "Leek", "Micro Greens",
                "Parsnip", "Radish", "Salad Greens", "Scallions", "Turnips (Small)"};

        String[] yPlants = new String[]{"Beans (Pole)", "Beans (Bush)", "Beets (Large)", "Bok Choy",
                "Celery", "Mustard", "Onion (Bulb)", "Peas", "Soybean", "Spinach", "Turnips (Large)"};

        String[] bPlants = new String[]{"Corn", "Chives", "Garlic", "Lettuce (Head)", "Rutabagas",
                "Shallots", "Sunflowers (Hedge)", "Swiss Chard"};

        String[] oPlants = new String[]{"Broccoli", "Brussel Sprouts", "Cabbage", "Cauliflower", "Eggplant",
                "Kale", "Peppers", "Potato", "Strawberry", "Sunflower (Large)", "Tomatoes (Vine)"};

        List<String> allPlants = new ArrayList<String>();

        for (int i = 0 ; i < rPlants.length ; i++) {
            allPlants.add(rPlants[i] + "     (16 plants per grid)");
        }

        for (int i = 0 ; i < rPlants.length ; i++) {
            allPlants.add(yPlants[i] + "     (9 plants per grid)");
        }

        for (int i = 0 ; i < rPlants.length ; i++) {
            allPlants.add(yPlants[i] + "     (4 plants per grid)");
        }

        for (int i = 0 ; i < rPlants.length ; i++) {
            allPlants.add(oPlants[i] + "     (1 plant per grid)");
        }

        // "Sunflower (Large)" is the largest string in the list at 17 characters, for reference for adding it to the
        // top of a grid.

        for (String plant : allPlants) {
            System.out.println(plant);
        }

    }
}
