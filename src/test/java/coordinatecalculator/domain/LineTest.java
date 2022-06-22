package coordinatecalculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;

public class LineTest {

    @Test
    @DisplayName("두 점을 잇는 직선의 거리 계산")
    void calculate_distance_of_2_positions_for_straight_line() {
        Line line = new Line(new Position(10, 10), new Position(14, 15));
        assertThat(line.length()).isEqualTo(6.403124, offset(0.00099));
    }
}
