package coordinatecalculator.domain.coordinate;

import coordinatecalculator.domain.point.Position;
import coordinatecalculator.domain.point.Positions;
import coordinatecalculator.domain.shape.Line;
import coordinatecalculator.domain.shape.Rectangle;
import coordinatecalculator.domain.shape.Shape;
import coordinatecalculator.domain.shape.Triangle;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Coordinates {
    private static final String DASH = "-";
    private static final String INVALID_POINT_TO_POINT = "좌표값과 좌표값 사이 연결 문자열이 잘못 입력되었습니다.";

    private static final int COUNT_OF_LINE = 2;
    private static final int COUNT_OF_TRIANGLE = 3;
    private static final int COUNT_OF_RECTANGLE = 4;

    private static final Map<Integer, Function<Positions, Shape>> CLASSFIAR = new HashMap<>();

    private final List<Coordinate> coordinates;

    static {
        CLASSFIAR.put(COUNT_OF_LINE, Line::new);
        CLASSFIAR.put(COUNT_OF_TRIANGLE, Triangle::new);
        CLASSFIAR.put(COUNT_OF_RECTANGLE, Rectangle::new);
    }

    public Coordinates(String coordinatesText) {
        if (!coordinatesText.contains(DASH)) {
            throw new IllegalArgumentException(INVALID_POINT_TO_POINT);
        }

        this.coordinates = Arrays.stream(coordinatesText.split(DASH))
                .map(Coordinate::new)
                .collect(Collectors.toList());
    }

    public Shape getShape() {
        Positions positions = getPositions();
        return CLASSFIAR.get(positions.size()).apply(positions);
    }

    private Positions getPositions() {
        List<Position> positionList = coordinates.stream()
                .map(Coordinate::getPosition)
                .collect(Collectors.toList());
        return new Positions(positionList);
    }
}
