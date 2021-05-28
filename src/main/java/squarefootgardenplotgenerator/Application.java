package squarefootgardenplotgenerator;

import java.util.List;

public class Application {
    public static void main(String[] args) {

        GardenerInput userInteraction = new GardenerInput();

        GridMaker makeABetterGarden = new GridMaker();
        List<String> myGrid = makeABetterGarden.makeGrid(userInteraction.askTheGardener(), userInteraction.getRows(), userInteraction.getColumns());

        System.out.println("Here's your garden grid!");
        for (String line : myGrid) {
            System.out.println(line);
        }

    }
}
