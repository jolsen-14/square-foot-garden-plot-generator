package squarefootgardenplotgenerator;

import java.util.HashMap;
import java.util.Map;

public class PlantLists {

    private String[] rPlants = new String[]{"Beets (Small)", "Carrots", "Green Onion", "Leek", "Micro Greens",
            "Parsnip", "Radish", "Salad Greens", "Scallions", "Turnips (Small)"};
    private String[] yPlants = new String[]{"Beans (Pole)", "Beans (Bush)", "Beets (Large)", "Bok Choy",
            "Celery", "Mustard", "Onion (Bulb)", "Peas", "Soybean", "Spinach", "Turnips (Large)"};
    private String[] bPlants = new String[]{"Corn", "Chives", "Garlic", "Lettuce (Head)", "Rutabagas",
            "Shallots", "Sunflowers (Hedge)", "Swiss Chard"};
    private String[] oPlants = new String[]{"Broccoli", "Brussel Sprouts", "Cabbage", "Cauliflower", "Eggplant",
            "Kale", "Peppers", "Potato", "Strawberry", "Sunflower (Large)", "Tomatoes (Vine)"};
    private Map<String, Integer> allPlants = new HashMap<>();

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

    public Map<String, Integer> getAllPlants() {
        if (allPlants.isEmpty()) {
            for (int i = 0; i < rPlants.length; i++) {
                allPlants.put(rPlants[i], 0);
            }
            for (int i = 0; i < yPlants.length; i++) {
                allPlants.put(yPlants[i], 0);
            }
            for (int i = 0; i < bPlants.length; i++) {
                allPlants.put(bPlants[i], 0);
            }
            for (int i = 0; i < oPlants.length; i++) {
                allPlants.put(oPlants[i], 0);
            }
            return allPlants;
        } else {
            return allPlants;
        }
    }

}
