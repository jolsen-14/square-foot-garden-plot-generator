package squarefootgardenplotgenerator;

import java.util.HashMap;
import java.util.Map;

public class PlantLists {

    // ## INSTANCE VARIABLES ##

    /*
    Predefined lists of plants requiring different spacings for their seeds. The names come from the color of the
    holes in the official "Seeding Square" sold online.
    r = Red >> Smallest spacing, 16 plants per square
    y = Yellow >> Medium-small spacing, 9 plants per square
    b = Blue >> Medium spacing, 4 plants per square
    o = Orange >> Large spacing, 1 plant per square
     */
    private final String[] rPlants = new String[]{"Beets (Small)", "Carrots", "Green Onion", "Leek", "Micro Greens",
            "Parsnip", "Radish", "Salad Greens", "Scallions", "Turnips (Small)"};
    private final String[] yPlants = new String[]{"Beans (Pole)", "Beans (Bush)", "Beets (Large)", "Bok Choy",
            "Celery", "Mustard", "Onion (Bulb)", "Peas", "Soybean", "Spinach", "Turnips (Large)"};
    private final String[] bPlants = new String[]{"Corn", "Chives", "Garlic", "Lettuce (Head)", "Rutabagas",
            "Shallots", "Sunflowers (Hedge)", "Swiss Chard"};
    private final String[] oPlants = new String[]{"Broccoli", "Brussel Sprouts", "Cabbage", "Cauliflower", "Eggplant",
            "Kale", "Peppers", "Potato", "Strawberry", "Sunflower (Large)", "Tomatoes (Vine)"};

    // ## GETTERS ##

    public String[] getrPlants() {
        return rPlants;
    }

    public String[] getyPlants() {
        return yPlants;
    }

    public String[] getbPlants() {
        return bPlants;
    }

    public String[] getoPlants() {
        return oPlants;
    }

    // ## METHODS ##

    // Adds all plants in the smaller lists with a 0 key value (quantity) for each until the gardener defines them.
    public Map<String, Integer> getAllPlantsList() {
        // A map to hold all the plants together
        Map<String, Integer> allPlantsList = new HashMap<>();
        for (String rPlant : rPlants) {
            allPlantsList.put(rPlant, 0);
        }
        for (String yPlant : yPlants) {
            allPlantsList.put(yPlant, 0);
        }
        for (String bPlant : bPlants) {
            allPlantsList.put(bPlant, 0);
        }
        for (String oPlant : oPlants) {
            allPlantsList.put(oPlant, 0);
        }
        return allPlantsList;
    }
}
