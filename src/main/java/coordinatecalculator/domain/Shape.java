package coordinatecalculator.domain;

import java.util.Objects;

public abstract class Shape {

    protected final Positions positions;

    public Shape(Positions positions) {
        this.positions = positions;
    }

    public String getGraphView() {
        return new Graph(positions).draw();
    }

    public abstract double calculate();

    public abstract String getComment();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shape shape = (Shape) o;
        return Objects.equals(positions, shape.positions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(positions);
    }
}
