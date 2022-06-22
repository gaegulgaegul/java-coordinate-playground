package coordinatecalculator.view;

public class ResultView {

    public static void print(String text) {
        System.out.println(text);
    }

    public static void printDistance(String comment, double distance) {
        System.out.println(comment + " " + String.format("%.6f", distance));
    }
}
