package starbuzz;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CaffeineBeverageTest {

    @Test
    @DisplayName("커피(Coffee)는 카페인 음료(CaffeineBeverage)이다.")
    void coffee_is_caffeine_beverage() {
        CaffeineBeverage coffee = new Coffee();
        assertThat(coffee).isInstanceOf(CaffeineBeverage.class);
    }

    @Test
    @DisplayName("카페인 음료(CaffeineBeverage)는 커피(Coffee)가 아니다.")
    void caffeine_beverage_is_not_coffee() {
//        Coffee coffee = new CaffeineBeverage();
    }

    @Test
    @DisplayName("차(Tea)는 카페인 음료(CaffeineBeverage)이다.")
    void tea_is_caffeine_beverage() {
        CaffeineBeverage tea = new Tea();
        assertThat(tea).isInstanceOf(CaffeineBeverage.class);
    }

    @Test
    @DisplayName("카페인 음료(CaffeineBeverage)는 차(Tea)가 아니다.")
    void caffeine_beverage_is_not_tea() {
//        Tea tea = new CaffeineBeverage();
    }

    @Test
    @DisplayName("업캐스팅 - 하위 클래스를 상위 클래스로 타입을 변환하는 것을 의미한다.")
    void upcasting() {
        CaffeineBeverage beverage = new Coffee();
        CaffeineBeverage beverage1 = new Tea();
    }

    @Test
    @DisplayName("다운캐스팅 - 상위 클래스를 하위 클래스의 타입으로 변환하는 것을 의미한다.")
    void downcasting() {
        CaffeineBeverage beverage = new Coffee();

        if (beverage instanceof Coffee) {
            Coffee coffee = (Coffee) beverage;
        }
    }
}