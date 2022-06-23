package coordinatecalculator.domain;

public class Rectangle extends Shape {

    public Rectangle(Positions positions) {
        super(positions);
        if (isNotRectangle()) {
            throw new IllegalArgumentException("직사각형 모양이 아닙니다. 좌표값을 확인해주세요.");
        }
    }

    @Override
    public double calculate() {
        return getWidth() * getHeight();
    }

    private double getWidth() {
        return positions.length(0, 1);
    }

    private double getHeight() {
        return positions.length(0, 3);
    }

    private boolean isNotRectangle() {
        return getWidth() != positions.length(2, 3) || getHeight() != positions.length(1, 2);
    }

    @Override
    public String getComment() {
        return "사각형 넓이는";
    }

}
