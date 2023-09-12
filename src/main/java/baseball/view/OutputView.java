package baseball.view;

import baseball.constant.BaseballConstant;
import baseball.message.GameMessage;

public class OutputView {
    public void printGameStart(){
        System.out.println(GameMessage.GAME_START_MESSAGE);
    }
    public void printScoreStrike(int strike){
        System.out.print(strike + BaseballConstant.STRIKE);
    }
    public void printScoreBall(int ball){
        System.out.print(ball + BaseballConstant.BALL);
    }
    public void printScoreNothing(){
        System.out.println(BaseballConstant.NOTHING);
    }
    public void printGameEnd(){
        System.out.println();
        System.out.println(GameMessage.GAME_END_MESSAGE);
    }
}
