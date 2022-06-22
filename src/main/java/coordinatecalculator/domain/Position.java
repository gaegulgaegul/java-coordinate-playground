package coordinatecalculator.domain;

import java.util.Objects;

public class Position {
    private final int pointX;
    private final int pointY;

    public Position(int x, int y) {
        this.pointX = x;
        this.pointY = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return pointX == position.pointX && pointY == position.pointY;
    }

    @Override
    public int hashCode() {
        return Objects.hash(pointX, pointY);
    }

}
