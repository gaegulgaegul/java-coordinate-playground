package rentcompany;

public interface FuelFindable {

    /**
     * 여행하려는 거리
     */
    double getTripDistance();

    /**
     * 리터당 이동 거리. 즉, 연비
     */
    double getDistancePerLiter();

    /**
     * 주입해야할 연료량을 구한다.
     */
    default double getChargeQuantity() {
        return getTripDistance() / getDistancePerLiter();
    }
}
