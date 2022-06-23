package coordinatecalculator.view;

public class ResultView {

    public static void print(String text) {
        System.out.println(text);
    }

    public static void printDistance(String comment, double distance) {
        if (isInt(distance)) {
            System.out.println(comment + " " + String.format("%.0f", distance));
            return;
        }
        System.out.println(comment + " " + String.format("%.6f", distance));
    }

    private static boolean isInt(double number){
        return Math.ceil(number) == Math.floor(number);
    }
}
