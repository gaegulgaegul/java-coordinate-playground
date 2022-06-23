package coordinatecalculator.domain;

public class Line extends Shape {

    public Line(Positions positions) {
        super(positions);
    }

    @Override
    public double calculate() {
        return positions.length(0, 1);
    }

    @Override
    public String getComment() {
        return "두 점 사이의 거리는";
    }

}
