package rentcompany;

public abstract class Car implements FuelFindable {
    private double tripDistance;

    public Car(double tripDistance) {
        this.tripDistance = tripDistance;
    }

    /**
     * 여행하려는 거리
     */
    @Override
    public double getTripDistance() {
        return this.tripDistance;
    }

    /**
     * 차종의 이름
     */
    abstract String getName();

}
