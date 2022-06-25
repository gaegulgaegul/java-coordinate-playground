package coordinatecalculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class TriangleTest {

    @Test
    @DisplayName("삼각형의 넓이 구하기")
    void get_triangle_area() {
        List<Position> positionList = Arrays.asList(new Position(10, 10),
                new Position(14, 15), new Position(20, 8));
        Positions positions = new Positions(positionList);
        Triangle triangle = new Triangle(positions);
        assertThat(triangle.calculate()).isEqualTo(29.0);
    }
}