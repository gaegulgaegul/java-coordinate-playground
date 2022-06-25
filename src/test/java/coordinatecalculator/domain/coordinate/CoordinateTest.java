package coordinatecalculator.domain.coordinate;

import coordinatecalculator.domain.coordinate.Coordinate;
import coordinatecalculator.domain.point.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CoordinateTest {

    @ParameterizedTest
    @DisplayName("정상적인 좌표값을 입력")
    @CsvSource(value = {"(0,0):0:0", "(24,24):24:24"}, delimiter = ':')
    void create_position(String coordinateText, int pointX, int pointY) {
        Coordinate coordinate = new Coordinate(coordinateText);
        assertThat(coordinate.getPosition()).isEqualTo(new Position(pointX, pointY));
    }

    @ParameterizedTest
    @DisplayName("범위 이외의 좌표값 입력")
    @ValueSource(strings = {"(-1,-1)", "(25,25)"})
    void wrong_number_position(String coordinateText) {
        assertThatThrownBy(() -> new Coordinate(coordinateText))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("지정되지 않은 입력 좌표값 형식")
    @ValueSource(strings = {"(10 10)", "10,10)", "(10,10"})
    void wrong_format_position(String coordinateText) {
        assertThatThrownBy(() -> new Coordinate(coordinateText))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
