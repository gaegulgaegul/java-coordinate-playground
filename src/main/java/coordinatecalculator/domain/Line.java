package coordinatecalculator.domain;

import java.util.Objects;

public class Line {
    private final Position firstPosition;
    private final Position secondPosition;

    public Line(Position firstPosition, Position secondPosition) {
        this.firstPosition = firstPosition;
        this.secondPosition = secondPosition;
    }

    public double length() {
        return firstPosition.calculateDistance(secondPosition);
    }

    @Override
    public String toString() {
        return "두 점 사이의 거리는 " + length();
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
