package coordinatecalculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;

public class PositionTest {

    @Test
    @DisplayName("두 점 사이의 거리 구하기")
    void calculate_distance() {
        Position position = new Position(10, 10);
        assertThat(position.calculateDistance(new Position(14, 15))).isEqualTo(6.403124, offset(0.00099));
    }
}
