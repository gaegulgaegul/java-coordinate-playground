package coordinatecalculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PositionsTest {

    @Test
    @DisplayName("같은 값의 위치 정보 확인")
    void match_position() {
        List<Position> positionList = Arrays.asList(new Position(10, 10), new Position(14, 15));
        Positions positions = new Positions(positionList);
        assertThat(positions.isMatchPosition(new Position(10, 10))).isTrue();
    }
}