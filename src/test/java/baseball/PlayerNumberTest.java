package baseball;

import baseball.domain.PlayerNumber;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class PlayerNumberTest {
    @Test
    @DisplayName("플레이어 입력값이 숫자가 아닌 경우")
    void 숫자아님_에러(){
        assertPlayerNumber("우왕");
    }
    @Test
    @DisplayName("플레이어 숫자가 0를 포함할 경우")
    void 영포함_에러(){
        assertPlayerNumber("012");
    }
    @Test
    @DisplayName("플레이어 숫자가 중복될 경우")
    void 숫자중복_에러(){
        assertPlayerNumber("112");
    }
    @Test
    @DisplayName("플레이어 숫자 길이가 3이 아닐 경우")
    void 숫자길이_에러(){
        assertPlayerNumber("12");
    }
    @Test
    @DisplayName("플레이어 숫자가 모든 조건 충족할 경우")
    void 숫자조건_충족(){
        PlayerNumber playerNumber = new PlayerNumber();
        assertDoesNotThrow(()-> playerNumber.updatePlayerNumbers("123"));
    }
    private static void assertPlayerNumber(String playerNumbers) {
        PlayerNumber playerNumber = new PlayerNumber();
        Assertions.assertThatThrownBy(() -> playerNumber.updatePlayerNumbers(playerNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
