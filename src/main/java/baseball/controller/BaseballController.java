package baseball.controller;

import baseball.domain.BaseballRandomNumberGenerator;
import baseball.domain.PlayerNumber;
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
    }
}
