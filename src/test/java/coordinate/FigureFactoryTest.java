package coordinate;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class FigureFactoryTest {

    private FigureCreator figureCreator;

    @BeforeEach
    void beforeEach() {
        this.figureCreator = new FigureFactory();
    }

    @Test
    public void line() {
        List<Point> points = Arrays.asList(
                Point.of(1, 2),
                Point.of(2, 3));

        Figure figure = figureCreator.create(points);
        assertThat(figure).isInstanceOfAny(Line.class);
        assertThat(figure.getName()).isEqualTo("선");
    }

    @Test
    public void triangle() {
        List<Point> points = Arrays.asList(
                Point.of(1, 1),
                Point.of(4, 1),
                Point.of(1, 4));

        Figure figure = figureCreator.create(points);
        assertThat(figure).isInstanceOfAny(Triangle.class);
        assertThat(figure.getName()).isEqualTo("삼각형");
    }

    @Test
    public void rectangle() {
        List<Point> points = Arrays.asList(
                Point.of(1, 1),
                Point.of(4, 1),
                Point.of(1, 4),
                Point.of(4, 4));

        Figure figure = figureCreator.create(points);
        assertThat(figure).isInstanceOfAny(Rectangle.class);
        assertThat(figure.getName()).isEqualTo("사각형");
    }
}
