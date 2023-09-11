package baseball.controller;

import baseball.domain.BaseballRandomNumberGenerator;
import baseball.view.OutputView;

import java.util.List;

public class BaseballController {
    OutputView outputView = new OutputView();
    public void startGame(){
        outputView.printGameStart();
    }
    private List<Integer> setRandomNumber(){
        BaseballRandomNumberGenerator generator = new BaseballRandomNumberGenerator();
        return generator.generateRandomNumber();
    }
    public void playGame(){
        List<Integer> randomNumbers = setRandomNumber();

    }
}
