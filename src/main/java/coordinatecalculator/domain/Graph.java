package coordinatecalculator.domain;

import java.util.Arrays;
import java.util.Stack;

public class Graph {
    private static final String PIPE = "|";
    private static final String SPACE = " ";
    private static final String TWO_SPACE = "  ";
    private static final String CROSS = "+";
    private static final String TWO_DASH = "--";
    private static final String NEWLINE = System.getProperty("line.separator");
    private static final String EMPTY = "";
    private static final String POINT = "·";

    private final Positions positions;
    private final Stack<String> stack;

    public Graph(Position firstPosition, Position secondPosition) {
        this.positions = new Positions(Arrays.asList(firstPosition, secondPosition));
        this.stack = new Stack<>();
    }

    public String draw() {
        pushGraph();
        return drawGraph();
    }

    private String drawGraph() {
        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.isEmpty()) {
            stringBuilder.append(stack.pop() + NEWLINE);
        }
        return stringBuilder.toString();
    }

    private void pushGraph() {
        stack.push(getAxisXHeader());
        for (int pointY = 0; pointY <= 24; pointY++) {
            stack.push(getGraphRow(pointY));
        }
    }

    private String getGraphRow(int pointY) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getAxisYHeader(pointY));

        if (pointY == 0) {
            stringBuilder.append(getAxisX(pointY, TWO_DASH));
        }
        stringBuilder.append(getAxisX(pointY, TWO_SPACE));
        return stringBuilder.toString();
    }

    private String getAxisX(int pointY, String input) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int pointX = 0; pointX <= 24; pointX++) {
            stringBuilder.append(getPointView(pointX, pointY, input));
        }
        return stringBuilder.toString();
    }

    private String getPointView(int pointX, int pointY, String input) {
        if (pointX == 0) {
            return EMPTY;
        }
        if (positions.isMatchPosition(new Position(pointX, pointY))) {
            return POINT + SPACE;
        }
        return input;
    }

    private String getAxisYHeader(int pointY) {
        if (pointY == 0) {
            return TWO_SPACE + CROSS;
        }
        if ((pointY % 2) != 0) {
            return TWO_SPACE + PIPE;
        }
        return String.format("%2d", pointY) + PIPE;
    }

    private String getAxisXHeader() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i <= 24; i++) {
            stringBuilder.append(getAxisXNumber(i));
        }
        return stringBuilder.toString();
    }

    private String getAxisXNumber(int index) {
        if (index == 0) {
            return index + TWO_SPACE;
        }
        if ((index % 2) != 0) {
            return TWO_SPACE;
        }
        return String.format("%2d", index);
    }
}
