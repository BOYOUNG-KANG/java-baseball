package baseball.controller;

import baseball.message.ErrorMessage;
import baseball.model.GameNumber;
import baseball.view.UserInput;
import baseball.view.UserOutput;

import java.util.List;

public class GameController {
    UserInput userInput = new UserInput();
    UserOutput userOutput = new UserOutput();
    ComputeController computeController = new ComputeController();
    GameNumber gameNumber = new GameNumber();
    VailidateInput vailidateInput = new VailidateInput();

    /**
     * CheckRestart 추가
     * - 게임 종료 후 재시작 input 확인 후 validation
     * - 1이면 재시작
     * - 2면 종료
     */

    public void gameStart(){
        boolean gameStatus = true;

        while (gameStatus) {
            userOutput.printStartMessage();
            computeController.startGame(gameNumber);
            //scccess가 되면 gameStatus=false 변경, 그전까지 반복
            computeController.playGame(gameNumber);
            gameRepeat();
            gameStatus = askRestartGame();
        }
    }
    private void gameRepeat(){
        boolean success = false;
        while (!success){
            retNewDate();
            success = computeController.playGame(gameNumber);
        }
    }
    private void retNewDate(){
        List<Integer> userNumber = vailidateInput.validateNumberInput(userInput.enterNumbers());
        gameNumber.setUserNumber(userNumber);
    }
    private boolean askRestartGame(){
        return restartMessage(userInput.enterRestartYn());
    }

    private boolean restartMessage(String userRestartYn){
        boolean wantToRestart = userRestartYn.equals("1");
        boolean wantToFinish = userRestartYn.equals("2");
        if (wantToRestart) {
            return true;
        } else if (wantToFinish) {
            return false;
        }
        throw new IllegalArgumentException(ErrorMessage.WRONG_RESTART_INPUT_MESSAGE);
    }

}
