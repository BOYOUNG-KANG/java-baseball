package baseball.view;

import baseball.message.GameMessage;

public class UserOutput {
    /**
     * 시작 알림
     * score 알림
     * 게임 종료 알림
     */

    public void printStartMessage(){
        System.out.println(GameMessage.GAME_START_MESSAGE);
    }
    public void printEndMessage(){
        System.out.println(GameMessage.GAME_END_MESSAGE);
    }
    public void printScoreMessage(String scoreMessage){
        System.out.println(scoreMessage);
    }
}
