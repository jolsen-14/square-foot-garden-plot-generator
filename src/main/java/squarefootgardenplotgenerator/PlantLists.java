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
    private String[] rPlants = new String[]{"Beets (Small)", "Carrots", "Green Onion", "Leek", "Micro Greens",
            "Parsnip", "Radish", "Salad Greens", "Scallions", "Turnips (Small)"};
    private String[] yPlants = new String[]{"Beans (Pole)", "Beans (Bush)", "Beets (Large)", "Bok Choy",
            "Celery", "Mustard", "Onion (Bulb)", "Peas", "Soybean", "Spinach", "Turnips (Large)"};
    private String[] bPlants = new String[]{"Corn", "Chives", "Garlic", "Lettuce (Head)", "Rutabagas",
            "Shallots", "Sunflowers (Hedge)", "Swiss Chard"};
    private String[] oPlants = new String[]{"Broccoli", "Brussel Sprouts", "Cabbage", "Cauliflower", "Eggplant",
            "Kale", "Peppers", "Potato", "Strawberry", "Sunflower (Large)", "Tomatoes (Vine)"};
    // A map to old all the plants together
    private Map<String, Integer> allPlantsList = new HashMap<>();

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
        if (allPlantsList.isEmpty()) {
            for (int i = 0; i < rPlants.length; i++) {
                allPlantsList.put(rPlants[i], 0);
            }
            for (int i = 0; i < yPlants.length; i++) {
                allPlantsList.put(yPlants[i], 0);
            }
            for (int i = 0; i < bPlants.length; i++) {
                allPlantsList.put(bPlants[i], 0);
            }
            for (int i = 0; i < oPlants.length; i++) {
                allPlantsList.put(oPlants[i], 0);
            }
            return allPlantsList;
        } else {
            return allPlantsList;
        }
    }

}
