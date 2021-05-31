package squarefootgardenplotgenerator;

import java.util.*;

public class Application {
    public static void main(String[] args) {

        // New objects for getting the user input and the GridMaker.
        GardenerInput userInteraction = new GardenerInput();

        // A new plot is generated by a GridMaker instance within GardenerInput.
        userInteraction.askTheGardener();

    }


    /*
    ##### KNOWN BUGS #####
    If the gardener goes through the entire list of plants to add and adds no plants at all, or adds less than the total
    number of squares in the grid, GridMaker will fail and no grid will be produced.

    >> Solution?: Add an empty grid type to the possible squares and automatically add all empties to the map if the
    numTotalPlants does not equal totalSquares.
    Can add this as a "default" type in the map. Also maybe remove it from consideration in the sorting of the queue.
     */
}
