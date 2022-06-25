package coordinatecalculator.controller;

import coordinatecalculator.domain.coordinate.Coordinates;
import coordinatecalculator.domain.shape.Shape;
import coordinatecalculator.view.InputView;
import coordinatecalculator.view.ResultView;

public class CoordinateCalculator {

    public void execute() {
        Coordinates coordinates = getCoordinates();
        Shape shape = coordinates.getShape();
        ResultView.print(shape.getGraphView());
        ResultView.printDistance(shape.getComment(), shape.calculate());
    }

    private Coordinates getCoordinates() {
        String coordinateText = InputView.coordinate();
        try {
            return new Coordinates(coordinateText);
        } catch (IllegalArgumentException e) {
            ResultView.print(e.getMessage());
        }
        return getCoordinates();
    }
}
