package squarefootgardenplotgenerator;

import java.util.*;

public class GridMaker {

    private String emptyLineDash = "-----*-----*-----*-----*-----*-----*-----*-----*-----*-----*-----*-----+";
    private String emptyLinePipe = "                                                                       |";
    private String emptyLineStar = "                                                                       *";
    private String templateLineR = "        R                 R                 R                 R        |";
    private String templateLineY = "           Y                       Y                       Y           *";
    private String templateLineB = "                 B                                   B                 *";
    private String templateLineO = "                                   O                                   *";
    private PlantLists listOfPlants = new PlantLists();

    public List<String> makeGrid(Map<String, Integer> plants, int rows, int columns){
        Queue<String> tempPlants = new LinkedList<>();
        for (String plant : plants.keySet()) {
            for (int i = 0; i < plants.get(plant); i++) {
                tempPlants.offer(plant);
            }
        }

        List<String> gridInFull = new ArrayList<>();
        for (int j = 1; j <= rows; j++) {
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
            for (int i = 1; i <= columns; i++) {
                String firstHalf = emptyLineDash.substring(0, ((emptyLineDash.length() / 2)) - tempPlants.peek().length() / 2);
                String secondHalf = "";
                if (tempPlants.peek().length() % 2 == 0) {
                    secondHalf = emptyLineDash.substring(((emptyLineDash.length() / 2)) + (tempPlants.peek().length() / 2));
                } else {
                    secondHalf = emptyLineDash.substring(((emptyLineDash.length() / 2)) + (tempPlants.peek().length() / 2) + 1);
                }
                String line = firstHalf + tempPlants.peek() + secondHalf;
                lineInFull1 += line;
//                lineInFull1 += emptyLineDash;  // grid start
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
            }
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
        String lastLineInFull = "+";
        for (int k = 1 ; k <= columns ; k++) {
            lastLineInFull += emptyLineDash;
        }
        gridInFull.add(lastLineInFull);
        return gridInFull;
    }



//            for (String plant : tempPlants.keySet()) {
//            if (plants.get(plant) > 0) {
//                for (int i = 0 ; i <= rows ; i++) {
//                    String firstHalf = emptyLineDash.substring(1, ((emptyLineDash.length() / 2)) - plant.length() / 2);
//                    String secondHalf = emptyLineDash.substring(((emptyLineDash.length() / 2)) + plant.length() / 2, emptyLineDash.length());
//                    String line = firstHalf + plant + secondHalf;
//                    firstLineInFull += line;
//                    tempPlants.put(plant, tempPlants.get(plant) - 1);
//                }
//                gridInFull.add(firstLineInFull);
//            }
//        }
}