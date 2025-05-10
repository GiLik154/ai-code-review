package com.temp.aicodereview.domain.role;

import com.temp.aicodereview.infra.MockRole;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class PolicyTest {

    @Test
    void 정책은_이동할_수_있는지_확인할_수_있다() {
        DriveRole role = MockRole.create().thenReturn(true);
        Policy policy = new Policy(role);

        boolean result = policy.canMove();

        assertThat(result).isTrue();
    }

    @Test
    void 정책은_조건이_안되면_움직일_수_없다() {
        DriveRole role = MockRole.create().thenReturn(false);
        Policy policy = new Policy(role);

        boolean result = policy.canMove();

        assertThat(result).isFalse();
    }
}