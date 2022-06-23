package coordinatecalculator.domain;

import java.util.List;
import java.util.Objects;

public class Positions {
    protected final List<Position> positions;

    public Positions(List<Position> positions) {
        this.positions = positions;
    }

    public boolean isMatchPosition(Position position) {
        return positions.stream().anyMatch(position::equals);
    }

    public boolean isRectangle() {
        return positions.size() == 4;
    }

    public double length(int standard, int target) {
        return positions.get(standard).calculateDistance(positions.get(target));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Positions positions1 = (Positions) o;
        return Objects.equals(positions, positions1.positions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(positions);
    }
}
