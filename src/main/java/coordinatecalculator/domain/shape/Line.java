package coordinatecalculator.domain.shape;

import coordinatecalculator.domain.point.Positions;

public class Line extends Shape {

    private static final String LINE_COMMENT = "두 점 사이의 거리는";

    public Line(Positions positions) {
        super(positions);
    }

    @Override
    public double calculate() {
        return positions.length(0, 1);
    }

    @Override
    public String getComment() {
        return LINE_COMMENT;
    }

}
