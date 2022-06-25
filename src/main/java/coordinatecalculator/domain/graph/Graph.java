package coordinatecalculator.domain.graph;

import coordinatecalculator.domain.point.Position;
import coordinatecalculator.domain.point.Positions;

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

    public Graph(Positions positions) {
        this.positions = positions;
        this.stack = new Stack<>();
    }

    public String draw() {
        pushGraph();
        return drawGraph();
    }

    private String drawGraph() {
        return combineString(builder -> {
            while (!stack.isEmpty()) {
                builder.append(stack.pop() + NEWLINE);
            }
        });
    }

    private void pushGraph() {
        stack.push(getAxisXHeader());
        for (int pointY = 0; pointY <= 24; pointY++) {
            stack.push(getGraphRow(pointY));
        }
    }

    private String getGraphRow(int pointY) {
        return combineString(builder -> {
            builder.append(getAxisYHeader(pointY));

            String decoration = TWO_SPACE;
            if (pointY == 0) {
                decoration = TWO_DASH;
            }
            builder.append(getAxisX(pointY, decoration));
        });
    }

    private String getAxisX(int pointY, String decoration) {
        return combineString(builder -> {
            for (int pointX = 0; pointX <= 24; pointX++) {
                builder.append(getPointView(pointX, pointY, decoration));
            }
        });
    }

    private String getPointView(int pointX, int pointY, String decoration) {
        if (pointX == 0) {
            return EMPTY;
        }
        if (positions.isMatchPosition(new Position(pointX, pointY))) {
            return POINT + SPACE;
        }
        return decoration;
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
        return combineString(builder -> {
            for (int i = 0; i <= 24; i++) {
                builder.append(getAxisXNumber(i));
            }
        });
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

    private String combineString(StringBuilderStrategy strategy) {
        StringBuilder stringBuilder = new StringBuilder();
        strategy.append(stringBuilder);
        return stringBuilder.toString();
    }
}
