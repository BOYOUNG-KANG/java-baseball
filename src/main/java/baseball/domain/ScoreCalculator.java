package baseball.domain;

import baseball.constant.BaseballConstant;

import java.util.List;

public class ScoreCalculator {
    private int strike = 0;
    private int ball = 0;
    private int nothing = 0;

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public int getNothing() {
        return nothing;
    }

    public void calculateNumbers(List<Integer> randomNumbers, List<Integer> playerNumbers){
        for (int i = 0; i < BaseballConstant.NUMBER_SIZE; i++) {
            int randomNum = randomNumbers.get(i);
            int playerNum = playerNumbers.get(i);
            strike = calculateStrike(randomNum, playerNum);
            ball = calculateBall(playerNumbers, randomNum, playerNum);
        }
        checkNothing();
    }

    private void checkNothing() {
        if (strike == 0 && ball == 0) {
            nothing++;
        }
    }

    private int calculateBall(List<Integer> playerNumbers, int randomNum, int playerNum) {
        if(randomNum != playerNum && playerNumbers.contains(randomNum)) {
            ball++;
        }
        return ball;
    }

    private int calculateStrike(int randomNum, int playerNum) {
        if (randomNum == playerNum) {
            strike++;
        }
        return strike;
    }
}
