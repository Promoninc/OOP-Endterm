import java.util.ArrayList;
import java.util.List;

public class Menu {
    String header;
    int numCount = 0;

    public class MenuPoint {
        int pointNum;
        String pointText;

        MenuPoint(String text) {
            pointNum = numCount + 1;
            pointText = text;
            numCount++;
        }
    }

    ArrayList<MenuPoint> points = new ArrayList<>();

    Menu(String menuHeader, List<String> pointTexts) {
        header = menuHeader;
        for (String text : pointTexts) {
            points.add(new MenuPoint(text));
        }
    }

    public void printMenu() {
        System.out.println(header);
        for (MenuPoint i : points) {
            System.out.println(i.pointNum + ". " + i.pointText);
        }
    }
}
