package coordinatecalculator.domain.coordinate;

import coordinatecalculator.domain.coordinate.Coordinates;
import coordinatecalculator.domain.point.Position;
import coordinatecalculator.domain.point.Positions;
import coordinatecalculator.domain.shape.Line;
import coordinatecalculator.domain.shape.Rectangle;
import coordinatecalculator.domain.shape.Triangle;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CoordinatesTest {

    @Test
    @DisplayName("좌표값을 두 개 입력한 경우")
    void create_2_positions() {
        Coordinates coordinates = new Coordinates("(10,10)-(14,15)");
        Positions positions = new Positions(Arrays.asList(new Position(10,10), new Position(14,15)));
        assertThat(coordinates.getShape()).isEqualTo(new Line(positions));
    }

    @Test
    @DisplayName("좌표값을 네 개 입력한 경우")
    void create_4_positions() {
        Coordinates coordinates = new Coordinates("(10,10)-(22,10)-(22,18)-(10,18)");
        List<Position> positionList = Arrays.asList(new Position(10, 10),
                new Position(22, 10), new Position(22, 18), new Position(10, 18));
        Positions positions = new Positions(positionList);
        assertThat(coordinates.getShape()).isEqualTo(new Rectangle(positions));
    }

    @Test
    @DisplayName("좌표값을 세 개 입력한 경우")
    void create_3_positions() {
        Coordinates coordinates = new Coordinates("(10,10)-(14,15)-(20,8)");
        List<Position> positionList = Arrays.asList(new Position(10, 10),
                new Position(14, 15), new Position(20, 8));
        Positions positions = new Positions(positionList);
        assertThat(coordinates.getShape()).isEqualTo(new Triangle(positions));
    }

    @Test
    @DisplayName("좌표값과 좌표값 사이 문자 연결 오류")
    void not_connect() {
        assertThatThrownBy(() -> new Coordinates("(10,10) (14,15)"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
