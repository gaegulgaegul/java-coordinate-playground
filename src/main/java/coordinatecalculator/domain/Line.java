package coordinatecalculator.domain;

import java.util.Objects;

public class Line implements Shape {
    private final Position firstPosition;
    private final Position secondPosition;

    public Line(Position firstPosition, Position secondPosition) {
        this.firstPosition = firstPosition;
        this.secondPosition = secondPosition;
    }

    @Override
    public double calculate() {
        return firstPosition.calculateDistance(secondPosition);
    }

    @Override
    public String getGraphView() {
        return new Graph(firstPosition, secondPosition).draw();
    }

    @Override
    public String getComment() {
        return "두 점 사이의 거리는";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return Objects.equals(firstPosition, line.firstPosition) && Objects.equals(secondPosition, line.secondPosition);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstPosition, secondPosition);
    }

}
