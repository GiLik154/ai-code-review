package com.temp.aicodereview.domain.car;

import com.temp.aicodereview.domain.role.DriveRole;
import com.temp.aicodereview.domain.role.Policy;
import com.temp.aicodereview.infra.MockRole;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CarTest {

    @Test
    void 자동차는_생성될_수_있다() {
        Car car = new Car("TEST");

        assertThat(car.getPosition()).isEqualTo(new Position(0));
    }

    @Test
    void 자동차는_움직일_수_있다() {
        DriveRole role = MockRole.create().thenReturn(true);
        Policy policy = new Policy(role);
        Car car = new Car("TEST");

        car.move(policy);

        assertThat(car.getPosition()).isEqualTo(new Position(1));
    }

    @Test
    void 자동차는_연속으로_움직일_수_있다() {
        DriveRole role = MockRole.create().thenReturn(true).thenReturn(false).thenReturn(true);
        Policy policy = new Policy(role);
        Car car = new Car("TEST");

        car.move(policy);
        car.move(policy);
        car.move(policy);

        assertThat(car.getPosition()).isEqualTo(new Position(2));
    }

    @ParameterizedTest
    @CsvSource({"0, true", "1, false"})
    void 자동차는_위치가_일치하는지_확인할_수_있어야_한다(int positionValue, boolean expectedResult) {
        Car car = new Car("TEST");

        boolean result = car.equalsPosition(Position.of(positionValue));

        assertThat(result).isEqualTo(expectedResult);
    }
}