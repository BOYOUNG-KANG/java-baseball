package baseball;

import baseball.domain.ScoreCalculator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class ScoreCalculatorTest {

    @Test
    @DisplayName("랜덤:123, 플: 456 -> 낫싱")
    void 아무것도안맞는경우_낫싱(){
        Integer[] randomNumbers = {1, 2, 3};
        Integer[] playerNumbers = {4, 5, 6};
        ScoreCalculator calculator = assertScoreCalculator(randomNumbers, playerNumbers);
        Assertions.assertThat(calculator.getNothing()).isEqualTo(1);
    }
    @Test
    @DisplayName("랜덤:123, 플: 416 -> 1볼")
    void 같은값한개_원볼(){
        Integer[] randomNumbers = {1, 2, 3};
        Integer[] playerNumbers = {4, 1, 6};
        ScoreCalculator calculator = assertScoreCalculator(randomNumbers, playerNumbers);
        Assertions.assertThat(calculator.getBall()).isEqualTo(1);
    }
    @Test
    @DisplayName("랜덤:123, 플: 126 -> 2스트라이크")
    void 같은위치값두개_투스트라이크(){
        Integer[] randomNumbers = {1, 2, 3};
        Integer[] playerNumbers = {1, 2, 6};
        ScoreCalculator calculator = assertScoreCalculator(randomNumbers, playerNumbers);
        Assertions.assertThat(calculator.getStrike()).isEqualTo(2);
    }

    @Test
    @DisplayName("랜덤:123, 플: 132 -> 2볼 1스트라이크")
    void 값은값두개_같은위치값한개_투볼원스트라이크(){
        Integer[] randomNumbers = {1, 2, 3};
        Integer[] playerNumbers = {1, 3, 2};
        ScoreCalculator calculator = assertScoreCalculator(randomNumbers, playerNumbers);
        Assertions.assertThat(calculator.getBall()).isEqualTo(2);
        Assertions.assertThat(calculator.getStrike()).isEqualTo(1);
    }
    private ScoreCalculator assertScoreCalculator(Integer[] randomNumbers, Integer[] playerNumbers) {
        ScoreCalculator calculator = new ScoreCalculator();
        calculator.calculateNumbers(new ArrayList<>(Arrays.asList(randomNumbers)), new ArrayList<>(Arrays.asList(playerNumbers)));
        return calculator;
    }
}