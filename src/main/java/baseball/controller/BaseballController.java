package baseball.controller;

import baseball.domain.BaseballRandomNumberGenerator;
import baseball.domain.PlayerNumber;
import baseball.domain.ScoreCalculator;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;

public class BaseballController {
    OutputView outputView = new OutputView();
    InputView inputView = new InputView();
    public void startGame(){
        outputView.printGameStart();
    }
    private List<Integer> setRandomNumber(){
        BaseballRandomNumberGenerator generator = new BaseballRandomNumberGenerator();
        return generator.generateRandomNumber();
    }
    public void playGame(){
        List<Integer> randomNumbers = setRandomNumber();
        PlayerNumber playerNumber = new PlayerNumber();
        playerNumber.updatePlayerNumbers(inputView.getPlayerNumber());
        List<Integer> playerNumbers = playerNumber.getPlayerNumbers();

        ScoreCalculator calculator = new ScoreCalculator();
        calculator.calculateNumbers(randomNumbers, playerNumbers);

        printScore(calculator);
    }
    private void printScore(ScoreCalculator calculator){

        int strike = calculator.getStrike();
        int ball = calculator.getBall();
        int nothing = calculator.getNothing();

        printStrike3(strike);
        printNothing(nothing);
        printOnlyStrike(strike, ball);
        printOnlyBall(strike, ball);
        printStrikeAndBall(strike, ball);
    }

    private void printStrikeAndBall(int strike, int ball) {
        if (0 < strike && strike < 3 && 0 < ball){
            outputView.printScoreBall(ball);
            outputView.printScoreStrike(strike);
            System.out.println();
        }
    }

    private void printOnlyBall(int strike, int ball) {
        if (0 < ball && strike == 0) {
            outputView.printScoreBall(ball);
            System.out.println();
        }
    }

    private void printOnlyStrike(int strike, int ball) {
        if (0 < strike && strike < 3 && ball == 0) {
            outputView.printScoreStrike(strike);
            System.out.println();
        }
    }

    private void printNothing(int nothing) {
        if (nothing == 1) {
            outputView.printScoreNothing();
        }
    }

    private void printStrike3(int strike) {
        if (strike == 3) {
            outputView.printScoreStrike(strike);
            outputView.printGameEnd();
        }
    }
}
