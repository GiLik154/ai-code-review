package com.temp.aicodereview.domain.car;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NameTest {

    @Test
    void 이름을_생성할_수_있다() {
        Name name = Name.of("TEST");

        assertThat(name.value()).isEqualTo("TEST");
    }

    @Test
    void 이름은_글자를_5글자를_넘을_수_없다() {
        assertThatThrownBy(() -> Name.of("IsOverName"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}