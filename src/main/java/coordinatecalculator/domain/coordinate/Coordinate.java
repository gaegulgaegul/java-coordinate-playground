package coordinatecalculator.domain.coordinate;

import coordinatecalculator.domain.point.Position;

public class Coordinate {
    private static final String INVALID_INPUT_POINTS = "입력 좌표의 형식이 올바르지 않습니다.";
    private static final int MIN_POINT = 0;
    private static final int MAX_POINT = 24;
    private static final String INVALID_POINT_RANGE = "입력 좌표는 " + MIN_POINT + "~" + MAX_POINT + " 사이의 값을 입력해주세요.";

    private static final String COMMA = ",";
    private static final String START_PARENTHESES = "(";
    private static final String END_PARENTHESES = ")";
    private static final String PARENTHESES = "\\(|\\)";
    private static final String EMPTY = "";

    private final int[] points;

    public Coordinate(String coordinateText) {
        if (!coordinateText.contains(COMMA) || !coordinateText.startsWith(START_PARENTHESES) || !coordinateText.endsWith(END_PARENTHESES)) {
            throw new IllegalArgumentException(INVALID_INPUT_POINTS);
        }

        this.points = parsePoints(coordinateText);
    }

    private int[] parsePoints(String coordinateText) {
        String[] tokens = coordinateText.replaceAll(PARENTHESES, EMPTY).split(COMMA);

        int[] points = new int[2];
        for (int i = 0; i < 2; i++) {
            int point = Integer.parseInt(tokens[i]);
            validRange(point);
            points[i] = point;
        }

        return points;
    }

    private void validRange(int value) {
        if (value < MIN_POINT || value > MAX_POINT) {
            throw new IllegalArgumentException(INVALID_POINT_RANGE);
        }
    }

    public Position getPosition() {
        return new Position(this.points[0], this.points[1]);
    }
}
