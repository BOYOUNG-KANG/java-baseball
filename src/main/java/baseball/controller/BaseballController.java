package baseball.controller;

import baseball.constant.BaseballConstant;
import baseball.domain.BaseballRandomNumberGenerator;
import baseball.domain.GameRestartChecker;
import baseball.domain.PlayerNumber;
import baseball.domain.ScoreCalculator;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;

public class BaseballController {
    OutputView outputView = new OutputView();
    InputView inputView = new InputView();

    public void game(){
        startGame();
        setRandomNumber();
    }
    private void startGame(){
        outputView.printGameStart();
    }

    private List<Integer> createRandomNumber(){
        BaseballRandomNumberGenerator generator = new BaseballRandomNumberGenerator();
        return generator.generateRandomNumber();
    }
    private void setRandomNumber(){
        List<Integer> randomNumbers = createRandomNumber();
        playGame(randomNumbers);
    }

    private void playGame(List<Integer> randomNumbers) {
        PlayerNumber playerNumber = new PlayerNumber();
        playerNumber.updatePlayerNumbers(inputView.getPlayerNumber());
        List<Integer> playerNumbers = playerNumber.getPlayerNumbers();

        ScoreCalculator calculator = new ScoreCalculator();
        calculator.calculateNumbers(randomNumbers, playerNumbers);

        printScore(calculator);
        checkEndYn(calculator, randomNumbers);
    }

    private void restartGame(){
        GameRestartChecker checker = new GameRestartChecker();
        int restart = checker.checkRestart(inputView.getRestartYn());
        if (restart == BaseballConstant.RESTART) {
            setRandomNumber();
        }
    }
    private void checkEndYn(ScoreCalculator calculator, List<Integer> randomNumbers){
        int strike = calculator.getStrike();
        if (strike == 3) {
            restartGame();
        }
        if (strike != 3) {
            playGame(randomNumbers);
        }
    }
    private void printScore(ScoreCalculator calculator){
        int strike = calculator.getStrike();
        int ball = calculator.getBall();
        int nothing = calculator.getNothing();

        printScoreAccordingToResult(strike, ball, nothing);
    }

    private void printScoreAccordingToResult(int strike, int ball, int nothing) {
        if (strike == 3) {
            printStrike3(strike);
        }
        if (nothing == 1) {
            printNothing();
        }
        if (0 < strike && strike < 3 && ball == 0) {
            printOnlyStrike(strike);
        }
        if (0 < ball && strike == 0) {
            printOnlyBall(ball);
        }
        if (0 < strike && strike < 3 && 0 < ball){
            printStrikeAndBall(strike, ball);
        }
    }

    private void printStrikeAndBall(int strike, int ball) {
            outputView.printScoreBall(ball);
            outputView.printScoreStrike(strike);
            System.out.println();
    }

    private void printOnlyBall(int ball) {
            outputView.printScoreBall(ball);
            System.out.println();
    }

    private void printOnlyStrike(int strike) {
            outputView.printScoreStrike(strike);
            System.out.println();
    }

    private void printNothing() {
            outputView.printScoreNothing();
    }

    private void printStrike3(int strike) {
            outputView.printScoreStrike(strike);
            outputView.printGameEnd();
    }
}