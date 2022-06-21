package rentcompany;

public class Avante extends Car {

    private static final double DISTANCE_PER_LITER = 15;
    private static final String CAR_NAME = "Avante";

    public Avante(double tripDistance) {
        super(tripDistance);
    }

    @Override
    public double getDistancePerLiter() {
        return DISTANCE_PER_LITER;
    }

    @Override
    String getName() {
        return CAR_NAME;
    }
}
