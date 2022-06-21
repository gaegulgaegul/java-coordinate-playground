package rentcompany;

public class Sonata extends Car {

    private static final double DISTANCE_PER_LITER = 10;
    private static final String CAR_NAME = "Sonata";

    public Sonata(double tripDistance) {
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
