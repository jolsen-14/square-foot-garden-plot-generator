package squarefootgardenplotgenerator;

import java.util.*;

public class GridMaker {

    // ## INSTANCE VARIABLES ##

    private final String emptyLineDash = "-----*-----*-----*-----*-----*-----*-----*-----*-----*-----*-----*-----+";
    private final String emptyLinePipe = "                                                                       |";
    private final String emptyLineStar = "                                                                       *";
    private final String templateLineR = "        R                 R                 R                 R        |";
    private final String templateLineY = "           Y                       Y                       Y           *";
    private final String templateLineB = "                 B                                   B                 *";
    private final String templateLineO = "                                   O                                   *";
    private PlantLists listOfPlants = new PlantLists();

    // ## CONSTRUCTORS ##

         // None

    // ## GETTERS AND SETTERS ##

          // None

    // ## METHODS ##

    public List<String> makeGrid(Map<String, Integer> plants, int rows, int columns){

        /*
        A new Queue is made and all items (squares) from the plants map created in GardenerInput are put into it,
        one for every quantity of square that plant type based on the key in the map.
         */
        Queue<String> tempPlants = new LinkedList<>();
        for (String plant : plants.keySet()) {
            for (int i = 0; i < plants.get(plant); i++) {
                tempPlants.offer(plant);
            }
        }

        /*
        A new list of strings is then made and iteratively the lines of the grid are added to it, one row at a time.
         */
        List<String> gridInFull = new ArrayList<>();
        for (int j = 1; j <= rows; j++) {
            // This part adds the left-most character in each line so that it is not repeated with each column.
            // This is run once for every row, hence the for loop running up to the rows value.
            String lineInFull1 = "+";  // grid start
            String lineInFull2 = "|";  // pipe
            String lineInFull3 = "*";  // star
            String lineInFull4 = "|";  // R
            String lineInFull5 = "*";  // Y
            String lineInFull6 = "|";  // pipe
            String lineInFull7 = "*";  // B
            String lineInFull8 = "|";  // pipe
            String lineInFull9 = "*";  // star
            String lineInFull10 = "|"; // R
            String lineInFull11 = "*"; // star
            String lineInFull12 = "|"; // pipe
            String lineInFull13 = "*"; // YO
            String lineInFull14 = "|"; // pipe
            String lineInFull15 = "*"; // star
            String lineInFull16 = "|"; // R
            String lineInFull17 = "*"; // star
            String lineInFull18 = "|"; // pipe
            String lineInFull19 = "*"; // B
            String lineInFull20 = "|"; // pipe
            String lineInFull21 = "*"; // Y
            String lineInFull22 = "|"; // R
            String lineInFull23 = "*"; // star
            String lineInFull24 = "|"; // pipe
            /*
            A nested for loop runs the following once for every column in the row. These lines refer to the instance
            variables defined at the top, like emptyLineDash and emptyLinePipe/Star, but also to the seed spacing
            template lines of templateLineR/Y/B/O. The if/else statements handle whether or not the current plant square
            being added exists in the smaller lists of what plants exist in the R/Y/B/OPlants arrays, defined in PlantLists.
            >> The first part adds the name of the plant to the top row of the square by "peeking" at it and squeezing it
                    into the middle of the emptyLineDash where it fits.
            >> If the plant belongs to the list, the seed spacing for that line is added, otherwise the empty line is added.
            >> Note: The middle line (13) checks BOTH the yPlants and oPlants because that is the only line that has multiple
                    possible seed spacings.
             */
            for (int i = 1; i <= columns; i++) {
                String firstHalf = emptyLineDash.substring(0, ((emptyLineDash.length() / 2)) - tempPlants.peek().length() / 2);
                String secondHalf = "";
                if (tempPlants.peek().length() % 2 == 0) {
                    secondHalf = emptyLineDash.substring(((emptyLineDash.length() / 2)) + (tempPlants.peek().length() / 2));
                } else {
                    secondHalf = emptyLineDash.substring(((emptyLineDash.length() / 2)) + (tempPlants.peek().length() / 2) + 1);
                }
                String line = firstHalf + tempPlants.peek() + secondHalf;
                lineInFull1 += line; // grid start
                lineInFull2 += emptyLinePipe;  // pipe
                lineInFull3 += emptyLineStar;  // star
                if (Arrays.asList(listOfPlants.getrPlants()).contains(tempPlants.peek())) {
                    lineInFull4 += templateLineR;  // R
                } else {
                    lineInFull4 += emptyLinePipe;  // pipe
                }
                if (Arrays.asList(listOfPlants.getyPlants()).contains(tempPlants.peek())) {
                    lineInFull5 += templateLineY;  // Y
                } else {
                    lineInFull5 += emptyLineStar;  // star
                }
                lineInFull6 += emptyLinePipe;  // pipe
                if (Arrays.asList(listOfPlants.getbPlants()).contains(tempPlants.peek())) {
                    lineInFull7 += templateLineB;  // B
                } else {
                    lineInFull7 += emptyLineStar;  // star
                }
                lineInFull8 += emptyLinePipe;  // pipe
                lineInFull9 += emptyLineStar;  // star
                if (Arrays.asList(listOfPlants.getrPlants()).contains(tempPlants.peek())) {
                    lineInFull10 += templateLineR;  // R
                } else {
                    lineInFull10 += emptyLinePipe;  // pipe
                }
                lineInFull11 += emptyLineStar; // star
                lineInFull12 += emptyLinePipe; // pipe
                if (Arrays.asList(listOfPlants.getyPlants()).contains(tempPlants.peek())) {
                    lineInFull13 += templateLineY;  // Y
                } else if (Arrays.asList(listOfPlants.getoPlants()).contains(tempPlants.peek())) {
                    lineInFull13 += templateLineO;  // O
                } else {
                    lineInFull13 += emptyLineStar;  // star
                }
                lineInFull14 += emptyLinePipe; // pipe
                lineInFull15 += emptyLineStar; // star
                if (Arrays.asList(listOfPlants.getrPlants()).contains(tempPlants.peek())) {
                    lineInFull16 += templateLineR;  // R
                } else {
                    lineInFull16 += emptyLinePipe;  // pipe
                }
                lineInFull17 += emptyLineStar; // star
                lineInFull18 += emptyLinePipe; // pipe
                if (Arrays.asList(listOfPlants.getbPlants()).contains(tempPlants.peek())) {
                    lineInFull19 += templateLineB;  // B
                } else {
                    lineInFull19 += emptyLineStar;  // star
                }
                lineInFull20 += emptyLinePipe; // pipe
                if (Arrays.asList(listOfPlants.getyPlants()).contains(tempPlants.peek())) {
                    lineInFull21 += templateLineY;  // Y
                } else {
                    lineInFull21 += emptyLineStar;  // star
                }
                if (Arrays.asList(listOfPlants.getrPlants()).contains(tempPlants.peek())) {
                    lineInFull22 += templateLineR;  // R
                } else {
                    lineInFull22 += emptyLinePipe;  // pipe
                }
                lineInFull23 += emptyLineStar; // star
                lineInFull24 += emptyLinePipe; // pipe
                tempPlants.poll();
                // This line removes the current plant from tempPlants queue so the next column gets a new plant.
            }
            // These lines finally add all of the concatenated strings to the gridInFull list for output once all rows are complete.
            gridInFull.add(lineInFull1);
            gridInFull.add(lineInFull2);
            gridInFull.add(lineInFull3);
            gridInFull.add(lineInFull4);
            gridInFull.add(lineInFull5);
            gridInFull.add(lineInFull6);
            gridInFull.add(lineInFull7);
            gridInFull.add(lineInFull8);
            gridInFull.add(lineInFull9);
            gridInFull.add(lineInFull10);
            gridInFull.add(lineInFull11);
            gridInFull.add(lineInFull12);
            gridInFull.add(lineInFull13);
            gridInFull.add(lineInFull14);
            gridInFull.add(lineInFull15);
            gridInFull.add(lineInFull16);
            gridInFull.add(lineInFull17);
            gridInFull.add(lineInFull18);
            gridInFull.add(lineInFull19);
            gridInFull.add(lineInFull20);
            gridInFull.add(lineInFull21);
            gridInFull.add(lineInFull22);
            gridInFull.add(lineInFull23);
            gridInFull.add(lineInFull24);
        }
        // This adds one final line of emptyLineDash for each column to the bottom of the grid, without a plant name.
        String lastLineInFull = "+";
        for (int k = 1 ; k <= columns ; k++) {
            lastLineInFull += emptyLineDash;
        }
        gridInFull.add(lastLineInFull);
        return gridInFull;
    }
}
