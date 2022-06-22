package coordinatecalculator.domain;

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
        List<Position> actual = Arrays.asList(new Position(10,10), new Position(14,15));
        assertThat(coordinates.getPositions()).isEqualTo(new Positions(actual));
    }

    @Test
    @DisplayName("좌표값과 좌표값 사이 문자 연결 오류")
    void not_connect() {
        assertThatThrownBy(() -> new Coordinates("(10,10) (14,15)"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
