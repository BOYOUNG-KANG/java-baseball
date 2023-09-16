package baseball;

import baseball.domain.GameRestartChecker;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GameRestartCheckerTest {

    @Test
    @DisplayName("숫자가 아닌 경우")
    void 숫자아님_에러(){
        assertGameRestartChecker("우와왕");
    }
    @Test
    @DisplayName("1이나 2 이외의 숫자인 경우")
    void 다른숫자_에러(){
        assertGameRestartChecker("12");
    }
    @Test
    @DisplayName("1이나 2일 경우")
    void 맞는숫자_통과(){
        GameRestartChecker checker = new GameRestartChecker();
        org.junit.jupiter.api.Assertions.assertDoesNotThrow(()->
                checker.checkRestart("1"));
    }

    private static void assertGameRestartChecker(String restartYn) {
        GameRestartChecker checker = new GameRestartChecker();
        Assertions.assertThatThrownBy(()-> checker.checkRestart(restartYn))
                        .isInstanceOf(IllegalArgumentException.class);
    }
}
