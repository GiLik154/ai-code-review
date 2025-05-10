package com.temp.aicodereview.domain.car;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PositionTest {

    @Test
    void 포지션은_움직일_수_있다() {
        Position position = new Position(0);

        position.move();

        assertThat(position).isEqualTo(new Position(0));
    }

    @Test
    void 포지션은_연속으로_움직일_수_있다() {
        Position position = new Position(0);

        Position when = position.move();

        Position result = when.move();
        assertThat(result).isEqualTo(new Position(2));
    }

    @Test
    void 포지션은_캐싱_될_수_있다() {
        Position position = Position.of(0);
        Position differentPosition = position.move();

        Position samePosition = Position.of(0);

        assertThat(samePosition).isNotEqualTo(differentPosition);
        assertThat(position).isNotEqualTo(differentPosition);
        assertThat(samePosition).isEqualTo(position);
    }
}