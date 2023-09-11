package baseball.view;

import baseball.message.GameMessage;

public class OutputView {
    public void printGameStart(){
        System.out.println(GameMessage.GAME_START_MESSAGE);
    }

}
