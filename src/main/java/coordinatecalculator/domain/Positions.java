package coordinatecalculator.domain;

import java.util.List;

public class Positions {
    private final List<Position> positions;

    public Positions(List<Position> positions) {
        this.positions = positions;
    }

    public boolean isMatchPosition(Position position) {
        return positions.stream().anyMatch(position::equals);
    }
}
