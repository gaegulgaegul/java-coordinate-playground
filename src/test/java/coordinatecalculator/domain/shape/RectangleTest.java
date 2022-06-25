package coordinatecalculator.domain.shape;

import coordinatecalculator.domain.point.Position;
import coordinatecalculator.domain.point.Positions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RectangleTest {

    @Test
    @DisplayName("사각형 면적 구하기")
    void get_rectangle_area() {
        List<Position> positionList = Arrays.asList(new Position(10, 10),
                new Position(22, 10), new Position(22, 18), new Position(10, 18));
        Rectangle rectangle = new Rectangle(new Positions(positionList));
        assertThat(rectangle.calculate()).isEqualTo(96);
    }

    @Test
    @DisplayName("마름모 또는 사다리꼴 모양은 예외")
    void unknown_rectangle() {
        List<Position> positionList = Arrays.asList(new Position(8, 8),
                new Position(22, 10), new Position(22, 18), new Position(10, 18));
        assertThatThrownBy(() -> new Rectangle(new Positions(positionList)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}