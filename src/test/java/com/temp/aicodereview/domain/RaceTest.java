package com.temp.aicodereview.domain;

import com.temp.aicodereview.domain.car.Car;
import com.temp.aicodereview.domain.car.Name;
import com.temp.aicodereview.domain.car.Position;
import com.temp.aicodereview.domain.role.DriveRole;
import com.temp.aicodereview.infra.MockRole;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RaceTest {

    @Test
    void 레이스는_차를_움질일_수_있다() {
        DriveRole role = MockRole.create().thenReturn(true).thenReturn(false).thenReturn(true);
        Race race = new Race("TEST", role);

        List<Car> move = race.move();

        assertEquals(1, move.size());
        assertThat(move.get(0).getPosition()).isEqualTo(new Position(1));
    }

    @Test
    void 레이스는_연속으로_차를_움질일_수_있다() {
        DriveRole role = MockRole.create().thenReturn(true).thenReturn(false).thenReturn(true).thenReturn(true).thenReturn(false);
        Race race = new Race("1,2,3,4,5", role);

        List<Car> move = race.move();

        assertEquals(5, move.size());
        assertThat(move.get(0).getPosition()).isEqualTo(new Position(1));
        assertThat(move.get(1).getPosition()).isEqualTo(new Position(0));
        assertThat(move.get(2).getPosition()).isEqualTo(new Position(1));
        assertThat(move.get(3).getPosition()).isEqualTo(new Position(1));
        assertThat(move.get(4).getPosition()).isEqualTo(new Position(0));
    }

    @Test
    void 레이스는_경기에서_승자를_추출할_수_있다() {
        DriveRole role = MockRole.create().thenReturn(true).thenReturn(false).thenReturn(false);
        Race race = new Race("1,2,3", role);
        race.move();

        List<Car> result = race.getWinner();

        assertThat(result.size()).isEqualTo(1);
        assertThat(result.get(0).getName()).isEqualTo(new Name("1"));
        assertThat(result.get(0).getPosition()).isEqualTo(new Position(1));
    }

    @Test
    void 승자는_2명_될_수_있다() {
        DriveRole role = MockRole.create().thenReturn(true).thenReturn(false).thenReturn(true);
        Race race = new Race("1,2,3", role);
        race.move();

        List<Car> result = race.getWinner();

        assertThat(result.size()).isEqualTo(2);
        assertThat(result.get(0).getName()).isEqualTo(new Name("1"));
        assertThat(result.get(0).getPosition()).isEqualTo(new Position(1));
        assertThat(result.get(1).getName()).isEqualTo(new Name("3"));
        assertThat(result.get(1).getPosition()).isEqualTo(new Position(1));
    }
}