package squarefootgardenplotgenerator;

public class PlantLists {

    private String[] rPlants = new String[]{"Beets (Small)", "Carrots", "Green Onion", "Leek", "Micro Greens",
            "Parsnip", "Radish", "Salad Greens", "Scallions", "Turnips (Small)"};
    private String[] yPlants = new String[]{"Beans (Pole)", "Beans (Bush)", "Beets (Large)", "Bok Choy",
            "Celery", "Mustard", "Onion (Bulb)", "Peas", "Soybean", "Spinach", "Turnips (Large)"};
    private String[] bPlants = new String[]{"Corn", "Chives", "Garlic", "Lettuce (Head)", "Rutabagas",
            "Shallots", "Sunflowers (Hedge)", "Swiss Chard"};
    private String[] oPlants = new String[]{"Broccoli", "Brussel Sprouts", "Cabbage", "Cauliflower", "Eggplant",
            "Kale", "Peppers", "Potato", "Strawberry", "Sunflower (Large)", "Tomatoes (Vine)"};

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

}
