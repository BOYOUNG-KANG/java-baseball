package baseball.controller;

import baseball.message.GameMessage;
import baseball.message.ScoreMessage;
import baseball.model.GameNumber;
import baseball.view.UserOutput;

import java.util.List;

public class ComputeController {
    ComputerNumber computerNumber = new ComputerNumber();
    UserOutput userOutput = new UserOutput();

    private int strikeCount = 0;
    private int ballCount = 0;
    /**
     * CheckScore
     * - 입력받은 숫자 validate 후 컴퓨터 숫자와 비교해 score 산출
     * - 정답 아니면 반복
     * - 정답이면 종료 메시지
     */

    /**
     * startGame
     * computeScore
     *  - countStrike
     *  - countBall
     * isSuccess
     * announceScoreMessage
     */

    public void startGame(GameNumber gameNumber) {
        gameNumber.setComputerNumber(computerNumber.generateRandomNumbers());
    }

    public boolean playGame(GameNumber gameNumber) {
        List<Integer> userNumber = gameNumber.getUserNumber();
        List<Integer> computerNumber = gameNumber.getComputerNumber();

        computeScore(userNumber, computerNumber);
        announceScoreMessage();//성공이면 성공 메시지 포함
        if(isSuccess()) {
            successMessage();
        }
        return isSuccess();
    }

    public void computeScore(List<Integer> userNumber,
                             List<Integer> computerNumber) {

        for(int i = 0; i < 3; i++) {
            strikeCount += countStrike(computerNumber.get(i), userNumber.get(i));
            ballCount += countBall(computerNumber.get(i), userNumber);
        }
        ballCount -= strikeCount;
    }

    public boolean isSuccess() {
        if(strikeCount == 3) {
            return true;
        }
        return false;
    }
    public void successMessage(){
        userOutput.printScoreMessage(GameMessage.GAME_END_MESSAGE);
    }

    public void announceScoreMessage(){
        String scoreMessage = "";
        if(strikeCount > 0 || ballCount > 0) {
            scoreMessage += ballCount + ScoreMessage.BALL_MESSAGE + " " + strikeCount + ScoreMessage.STRIKE_MESSAGE;
        }
        if (strikeCount > 0) {
            scoreMessage += strikeCount + ScoreMessage.STRIKE_MESSAGE;
        }
        if (ballCount > 0) {
            scoreMessage += ballCount + ScoreMessage.BALL_MESSAGE;
        }
        scoreMessage += ScoreMessage.NOTHING_MESSAGE;
    userOutput.printScoreMessage(scoreMessage);
    }

    private Integer countStrike(int computerDigit, int userDigit){
        int tempStrikeCount = 0;
        if(computerDigit == userDigit) {
            tempStrikeCount++;
        }
        return tempStrikeCount;
    }
    private Integer countBall(int computerDigit, List<Integer> userNumber){
        int tempBallCount = 0;
        if(userNumber.contains(computerDigit)){
            tempBallCount++;
        }
        return tempBallCount;
    }
}
