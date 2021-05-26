package squarefootgardenplotgenerator;

public class SquareMaker {

    String emptyLineDash = "+-----*-----*-----*-----*-----*-----*-----*-----*-----*-----*-----*-----+";
    String emptyLinePipe = "|                                                                       |";
    String emptyLineStar = "*                                                                       *";
    String[] emptyLines = new String[]{emptyLineDash, emptyLinePipe, emptyLineStar, emptyLinePipe, emptyLineStar, emptyLinePipe, emptyLineStar, emptyLinePipe, emptyLineStar, emptyLinePipe,
            emptyLineStar, emptyLinePipe, emptyLineStar, emptyLinePipe, emptyLineStar, emptyLinePipe, emptyLineStar, emptyLinePipe, emptyLineStar, emptyLinePipe,
            emptyLineStar, emptyLinePipe, emptyLineStar, emptyLinePipe, emptyLineDash};

     String templateLineR = "|        R                 R                 R                 R        |";
     String templateLineY = "*           Y                       Y                       Y           *";
     String templateLineB = "*                 B                                   B                 *";
    String templateLineYO = "*           Y                       O                       Y           *";
    String[] templateLines = new String[]{emptyLineDash, emptyLinePipe, emptyLineStar, templateLineR, templateLineY, emptyLinePipe, templateLineB, emptyLinePipe, emptyLineStar, templateLineR,
            emptyLineStar, emptyLinePipe, templateLineYO, emptyLinePipe, emptyLineStar, templateLineR, emptyLineStar, emptyLinePipe, templateLineB, emptyLinePipe,
            templateLineY, templateLineR, emptyLineStar, emptyLinePipe, emptyLineDash};



    public void emptySquare(){
        for (int i = 0 ; i < emptyLines.length ; i++) {
            System.out.println(emptyLines[i]);
        }
    }

    public void templateSquare(){
        for (int i = 0 ; i < templateLines.length ; i++) {
            System.out.println(templateLines[i]);
        }
    }

    public void template1x2(){
        for (int i = 0 ; i < templateLines.length ; i++) {
            System.out.print(templateLines[i]);
            System.out.println(templateLines[i].substring(1));
        }
    }

    public void template1x3(){
        for (int i = 0 ; i < templateLines.length ; i++) {
            System.out.print(templateLines[i]);
            System.out.print(templateLines[i].substring(1));
            System.out.println(templateLines[i].substring(1));
        }
    }

    public void template2x2(){
        for (int i = 0 ; i < templateLines.length ; i++) {
            System.out.print(templateLines[i]);
            System.out.println(templateLines[i].substring(1));
        }
        for (int i = 1 ; i < templateLines.length ; i++) {
            System.out.print(templateLines[i]);
            System.out.println(templateLines[i].substring(1));
        }
    }

    public void templateInput(int rows, int columns){
        // prints the first line of the grid for each column
        if (columns > 0) {
            System.out.print(templateLines[0]);
            for (int l = columns - 1 ; l > 1 ; l--){
                System.out.print(templateLines[0].substring(1));
            }
            System.out.println(templateLines[0].substring(1));
        } else {
            System.out.println(templateLines[0]);
        }
        // prints each row of grid in full
        for (int j = rows; j > 0 ; j--) {
            for (int i = 1; i < templateLines.length; i++) {
                if (columns > 0) {
                    System.out.print(templateLines[i]);
                    for (int k = columns - 2 ; k > 0 ; k--) {
                        System.out.print(templateLines[i].substring(1));
                    }
                    System.out.println(templateLines[i].substring(1));
                } else {
                    System.out.println(templateLines[i]);
                }
            }
        }
    }

    // EXAMPLE EMPTY OUTPUT:
    /*
    +-----*-----*-----*-----*-----*-----*-----*-----*-----*-----*-----*-----+
    |                                                                       |
    *                                                                       *
    |                                                                       |
    *                                                                       *
    |                                                                       |
    *                                                                       *
    |                                                                       |
    *                                                                       *
    |                                                                       |
    *                                                                       *
    |                                                                       |
    *                                                                       *
    |                                                                       |
    *                                                                       *
    |                                                                       |
    *                                                                       *
    |                                                                       |
    *                                                                       *
    |                                                                       |
    *                                                                       *
    |                                                                       |
    *                                                                       *
    |                                                                       |
    +-----*-----*-----*-----*-----*-----*-----*-----*-----*-----*-----*-----+
     */
    // EXAMPLE OUTPUT WITH TEMPLATE SPACES:
    /*
    +-----*-----*-----*-----*-----*-----*-----*-----*-----*-----*-----*-----+
    |                                                                       |
    *                                                                       *
    |        R                 R                 R                 R        |
    *           Y                       Y                       Y           *
    |                                                                       |
    *                 B                                   B                 *
    |                                                                       |
    *                                                                       *
    |        R                 R                 R                 R        |
    *                                                                       *
    |                                                                       |
    *           Y                       O                       Y           *
    |                                                                       |
    *                                                                       *
    |        R                 R                 R                 R        |
    *                                                                       *
    |                                                                       |
    *                 B                                   B                 *
    |                                                                       |
    *           Y                       Y                       Y           *
    |        R                 R                 R                 R        |
    *                                                                       *
    |                                                                       |
    +-----*-----*-----*-----*-----*-----*-----*-----*-----*-----*-----*-----+
     */
}
