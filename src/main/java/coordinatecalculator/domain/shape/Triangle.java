package coordinatecalculator.domain.shape;

import coordinatecalculator.domain.point.Positions;

public class Triangle extends Shape {

    public Triangle(Positions positions) {
        super(positions);
    }

    @Override
    public double calculate() {
        double[] sideOfLengths = getSideOfLengths();
        double covariate = getCovariate(sideOfLengths);
        double area = getArea(sideOfLengths, covariate);
        return Math.round(area);
    }

    private double getArea(double[] sideOfLengths, double covariate) {
        double[] temporaries = new double[3];
        for (int i = 0; i < sideOfLengths.length; i++) {
            temporaries[i] = covariate - sideOfLengths[i];
        }

        double temporary = covariate;
        for (double value : temporaries) {
            temporary *= value;
        }
        return Math.sqrt(temporary);
    }

    private double getCovariate(double[] sideOfLengths) {
        double summary = 0;
        for (double sideOfLength : sideOfLengths) {
            summary += sideOfLength;
        }
        return summary / 2;
    }

    private double[] getSideOfLengths() {
        double[] sideOfLengths = new double[3];

        for (int i = 0; i < 3; i++) {
            int target = getTarget(i);
            sideOfLengths[i] = positions.length(i, target);
        }
        return sideOfLengths;
    }

    private int getTarget(int i) {
        int target = i + 1;
        if (target == 3) {
            target = 0;
        }
        return target;
    }

    @Override
    public String getComment() {
        return "삼각형의 넓이는";
    }
}
