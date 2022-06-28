package coordinatecalculator.domain.point;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;

class PositionsTest {

    @Test
    @DisplayName("같은 값의 위치 정보 확인")
    void match_position() {
        List<Position> positionList = Arrays.asList(new Position(10, 10), new Position(14, 15));
        Positions positions = new Positions(positionList);
        assertThat(positions.isMatchPosition(new Position(10, 10))).isTrue();
    }

    @Test
    @DisplayName("사각형 여부 확인")
    void is_rectangle() {
        List<Position> positionList = Arrays.asList(
                new Position(10, 10),
                new Position(22, 10),
                new Position(22, 18),
                new Position(10, 18)
        );
        Positions positions = new Positions(positionList);
        assertThat(positions.size()).isEqualTo(4);
    }

    @Test
    @DisplayName("삼각형 여부 확인")
    void is_triangle() {
        List<Position> positionList = Arrays.asList(
                new Position(10, 10),
                new Position(14, 15),
                new Position(20, 8)
        );
        Positions positions = new Positions(positionList);
        assertThat(positions.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("두 좌표의 거리 구하기")
    void get_length_of_line() {
        List<Position> positionList = Arrays.asList(new Position(10, 10), new Position(14, 15));
        Positions positions = new Positions(positionList);
        assertThat(positions.length(0, 1)).isEqualTo(6.403124, offset(0.00099));
    }
}