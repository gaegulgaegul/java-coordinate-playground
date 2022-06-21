package rentcompany;

public class K5 extends Car {

    private static final double DISTANCE_PER_LITER = 13;
    private static final String CAR_NAME = "K5";

    public K5(double tripDistance) {
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
