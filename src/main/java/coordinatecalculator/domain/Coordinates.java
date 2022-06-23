package coordinatecalculator.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Coordinates {
    private static final String DASH = "-";

    private final List<Coordinate> coordinates;

    public Coordinates(String coordinatesText) {
        if (!coordinatesText.contains(DASH)) {
            throw new IllegalArgumentException("좌표값과 좌표값 사이 연결 문자열이 잘못 입력되었습니다.");
        }

        this.coordinates = Arrays.stream(coordinatesText.split(DASH))
                .map(Coordinate::new)
                .collect(Collectors.toList());
    }

    public Shape getShape() {
        Positions positions = getPositions();

        if (positions.isRectangle()) {
            return new Rectangle(positions);
        }
        return new Line(positions);
    }

    private Positions getPositions() {
        List<Position> positionList = coordinates.stream()
                .map(Coordinate::getPosition)
                .collect(Collectors.toList());
        return new Positions(positionList);
    }
}
