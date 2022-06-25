package coordinatecalculator.domain;

public class Triangle extends Shape {

    public Triangle(Positions positions) {
        super(positions);
    }

    @Override
    public double calculate() {
        return 0;
    }

    @Override
    public String getComment() {
        return "삼각형의 넓이는";
    }
}
