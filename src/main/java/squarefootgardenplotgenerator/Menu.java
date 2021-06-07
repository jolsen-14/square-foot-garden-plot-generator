package squarefootgardenplotgenerator;

import java.util.ArrayList;
import java.util.List;

public class Menu {

    public void plantMenu(String[] plantSubList) {
        List<String> menuLines = new ArrayList<>();
        String blankLine = "                    ";
        int j = 0;
        for (int i = 0 ; i < plantSubList.length ; i++) {
            if (i < plantSubList.length - 3) {
                menuLines.add("(" + i + ") " + plantSubList[i] + blankLine.substring(0, blankLine.length() - plantSubList[i++].length()) + " " + "(" + i + ") " + plantSubList[i] + blankLine.substring(0, blankLine.length() - plantSubList[i++].length()) + " " + "(" + i + ") " + plantSubList[i]);
            } else if (i < plantSubList.length - 2) {
                menuLines.add("(" + i + ") " + plantSubList[i] + blankLine.substring(0, blankLine.length() - plantSubList[i++].length()) + " " + "(" + i + ") " + plantSubList[i]);
            } else if (i == plantSubList.length - 1) {
                menuLines.add("(" + i + ") " + plantSubList[i]);
            }
        }
        for (String line : menuLines) {
            System.out.println(line);
        }
    }

}
