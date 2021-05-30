package squarefootgardenplotgenerator;

import java.util.Arrays;
import java.util.Queue;

public class RowMaker {

    // ## INSTANCE VARIABLES ##

    private final PlantLists listOfPlants = new PlantLists();
    private final String[] row;

    // ## CONSTRUCTORS ##

    public RowMaker() {
        // This constructor adds the left-most character in each line to a new array so that it is not repeated with each column.
        this.row = new String[]{
                "+",
                "|",
                "*",
                "|",
                "*",
                "|",
                "*",
                "|",
                "*",
                "|",
                "*",
                "|",
                "*",
                "|",
                "*",
                "|",
                "*",
                "|",
                "*",
                "|",
                "*",
                "|",
                "*",
                "|",
        };
    }

    // ## GETTERS ##

    // none

    // ## METHODS ##

    public String[] makeRow (Queue<String> plantsInGarden, int columns) {
        /*
        This for loop runs the following once for every column in the row. These lines refer to the index of the array
        instance variable defined at the top, like emptyLineDash and emptyLinePipe/Star, but also to the seed spacing
        template lines of templateLineR/Y/B/O. The if/else statements handle whether or not the current plant square
        being added exists in the smaller lists of what plants exist in the R/Y/B/OPlants arrays, defined in PlantLists.
        >> The first part adds the name of the plant to the top row of the square by "peeking" at it and squeezing it
                into the middle of the emptyLineDash where it fits.
        >> If the plant belongs to the list, the seed spacing for that line is added, otherwise the empty line is added.
        >> Note: The middle line (13) checks BOTH the yPlants and oPlants because that is the only line that has multiple
                possible seed spacings.
         */
        for (int i = 0 ; i < columns ; i++) {
            final String emptyLineDash = "-----*-----*-----*-----*-----*-----*-----*-----*-----*-----*-----*-----+";
            final String emptyLinePipe = "                                                                       |";
            final String emptyLineStar = "                                                                       *";
            final String templateLineR = "        R                 R                 R                 R        |";
            final String templateLineY = "           Y                       Y                       Y           *";
            final String templateLineB = "                 B                                   B                 *";
            final String templateLineO = "                                   O                                   *";
            String firstHalf = emptyLineDash.substring(0, ((emptyLineDash.length() / 2)) - plantsInGarden.peek().length() / 2);
            String secondHalf = "";
            if (plantsInGarden.peek().length() % 2 == 0) {
                secondHalf = emptyLineDash.substring(((emptyLineDash.length() / 2)) + (plantsInGarden.peek().length() / 2));
            } else {
                secondHalf = emptyLineDash.substring(((emptyLineDash.length() / 2)) + (plantsInGarden.peek().length() / 2) + 1);
            }
            String line = firstHalf + plantsInGarden.peek() + secondHalf;
            row[0] += line; // grid start
            row[1] += emptyLinePipe;  // pipe
            row[2] += emptyLineStar;  // star
            if (Arrays.asList(listOfPlants.getrPlants()).contains(plantsInGarden.peek())) {
                row[3] += templateLineR;  // R
            } else {
                row[3] += emptyLinePipe;  // pipe
            }
            if (Arrays.asList(listOfPlants.getyPlants()).contains(plantsInGarden.peek())) {
                row[4] += templateLineY;  // Y
            } else {
                row[4] += emptyLineStar;  // star
            }
            row[5] += emptyLinePipe;  // pipe
            if (Arrays.asList(listOfPlants.getbPlants()).contains(plantsInGarden.peek())) {
                row[6] += templateLineB;  // B
            } else {
                row[6] += emptyLineStar;  // star
            }
            row[7] += emptyLinePipe;  // pipe
            row[8] += emptyLineStar;  // star
            if (Arrays.asList(listOfPlants.getrPlants()).contains(plantsInGarden.peek())) {
                row[9] += templateLineR;  // R
            } else {
                row[9] += emptyLinePipe;  // pipe
            }
            row[10] += emptyLineStar; // star
            row[11] += emptyLinePipe; // pipe
            if (Arrays.asList(listOfPlants.getyPlants()).contains(plantsInGarden.peek())) {
                row[12] += templateLineY;  // Y
            } else if (Arrays.asList(listOfPlants.getoPlants()).contains(plantsInGarden.peek())) {
                row[12] += templateLineO;  // O
            } else {
                row[12] += emptyLineStar;  // star
            }
            row[13] += emptyLinePipe; // pipe
            row[14] += emptyLineStar; // star
            if (Arrays.asList(listOfPlants.getrPlants()).contains(plantsInGarden.peek())) {
                row[15] += templateLineR;  // R
            } else {
                row[15] += emptyLinePipe;  // pipe
            }
            row[16] += emptyLineStar; // star
            row[17] += emptyLinePipe; // pipe
            if (Arrays.asList(listOfPlants.getbPlants()).contains(plantsInGarden.peek())) {
                row[18] += templateLineB;  // B
            } else {
                row[18] += emptyLineStar;  // star
            }
            row[19] += emptyLinePipe; // pipe
            if (Arrays.asList(listOfPlants.getyPlants()).contains(plantsInGarden.peek())) {
                row[20] += templateLineY;  // Y
            } else {
                row[20] += emptyLineStar;  // star
            }
            if (Arrays.asList(listOfPlants.getrPlants()).contains(plantsInGarden.peek())) {
                row[21] += templateLineR;  // R
            } else {
                row[21] += emptyLinePipe;  // pipe
            }
            row[22] += emptyLineStar; // star
            row[23] += emptyLinePipe; // pipe
            plantsInGarden.poll();
        }
        return row;
    }

}
