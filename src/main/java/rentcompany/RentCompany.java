package rentcompany;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RentCompany {
    private static final String NEWLINE = System.getProperty("line.separator");

    private List<Car> cars;

    private RentCompany() {
        this.cars = new ArrayList<>();
    }

    public static RentCompany create() {
        return new RentCompany();
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public String generateReport() {
        return cars.stream()
                .map(car -> car.getName() + " : " + formatting(car.getChargeQuantity()) + "리터")
                .collect(Collectors.joining(NEWLINE)) + NEWLINE;
    }

    private String formatting(double decimal) {
        return String.format("%.0f", decimal);
    }
}
