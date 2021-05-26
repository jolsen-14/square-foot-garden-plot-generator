package squarefootgardenplotgenerator;

public class SquareMaker {

    String emptyLine1 = "+-----*-----*-----*-----*-----*-----*-----*-----*-----*-----*-----*-----+";
    String emptyLine2 = "|                                                                       |";
    String emptyLine3 = "*                                                                       *";
    String emptyLine4 = "|                                                                       |";
    String emptyLine5 = "*                                                                       *";
    String emptyLine6 = "|                                                                       |";
    String emptyLine7 = "*                                                                       *";
    String emptyLine8 = "|                                                                       |";
    String emptyLine9 = "*                                                                       *";
    String emptyLine10 = "|                                                                       |";
    String emptyLine11 = "*                                                                       *";
    String emptyLine12 = "|                                                                       |";
    String emptyLine13 = "*                                                                       *";
    String emptyLine14 = "|                                                                       |";
    String emptyLine15 = "*                                                                       *";
    String emptyLine16 = "|                                                                       |";
    String emptyLine17 = "*                                                                       *";
    String emptyLine18 = "|                                                                       |";
    String emptyLine19 = "*                                                                       *";
    String emptyLine20 = "|                                                                       |";
    String emptyLine21 = "*                                                                       *";
    String emptyLine22 = "|                                                                       |";
    String emptyLine23 = "*                                                                       *";
    String emptyLine24 = "|                                                                       |";
    String emptyLine25 = "+-----*-----*-----*-----*-----*-----*-----*-----*-----*-----*-----*-----+";
    String[] emptyLines = new String[]{emptyLine1, emptyLine2, emptyLine3, emptyLine4, emptyLine5, emptyLine6, emptyLine7, emptyLine8, emptyLine9, emptyLine10,
            emptyLine11, emptyLine12, emptyLine13, emptyLine14, emptyLine15, emptyLine16, emptyLine17, emptyLine18, emptyLine19, emptyLine20,
            emptyLine21, emptyLine22, emptyLine23, emptyLine24, emptyLine25};

    String templateLine1 = "+-----*-----*-----*-----*-----*-----*-----*-----*-----*-----*-----*-----+";
    String templateLine2 = "|                                                                       |";
    String templateLine3 = "*                                                                       *";
    String templateLine4 = "|        R                 R                 R                 R        |";
    String templateLine5 = "*           Y                       Y                       Y           *";
    String templateLine6 = "|                                                                       |";
    String templateLine7 = "*                 B                                   B                 *";
    String templateLine8 = "|                                                                       |";
    String templateLine9 = "*                                                                       *";
    String templateLine10 = "|        R                 R                 R                 R        |";
    String templateLine11 = "*                                                                       *";
    String templateLine12 = "|                                                                       |";
    String templateLine13 = "*           Y                       O                       Y           *";
    String templateLine14 = "|                                                                       |";
    String templateLine15 = "*                                                                       *";
    String templateLine16 = "|        R                 R                 R                 R        |";
    String templateLine17 = "*                                                                       *";
    String templateLine18 = "|                                                                       |";
    String templateLine19 = "*                 B                                   B                 *";
    String templateLine20 = "|                                                                       |";
    String templateLine21 = "*           Y                       Y                       Y           *";
    String templateLine22 = "|        R                 R                 R                 R        |";
    String templateLine23 = "*                                                                       *";
    String templateLine24 = "|                                                                       |";
    String templateLine25 = "+-----*-----*-----*-----*-----*-----*-----*-----*-----*-----*-----*-----+";
    String[] templateLines = new String[]{templateLine1, templateLine2, templateLine3, templateLine4, templateLine5, templateLine6, templateLine7, templateLine8, templateLine9, templateLine10,
            templateLine11, templateLine12, templateLine13, templateLine14, templateLine15, templateLine16, templateLine17, templateLine18, templateLine19, templateLine20,
            templateLine21, templateLine22, templateLine23, templateLine24, templateLine25};

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
    // EXAMPLE OUTPUT WITH VIABLE SPACES:
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
