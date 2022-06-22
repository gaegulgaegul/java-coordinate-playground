package coordinatecalculator.controller;

import coordinatecalculator.domain.Coordinates;
import coordinatecalculator.domain.Line;
import coordinatecalculator.view.InputView;
import coordinatecalculator.view.ResultView;

public class CoordinateCalculator {

    public void execute() {
        Coordinates coordinates = getCoordinates();
        Line line = coordinates.getLine();
        ResultView.print(line.getGraphView());
        ResultView.printDistance(line.getComment(), line.length());
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
