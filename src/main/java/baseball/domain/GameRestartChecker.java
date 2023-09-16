package baseball.domain;

import baseball.constant.BaseballConstant;

public class GameRestartChecker {
    public int checkRestart(String restartYn){
        return validate(restartYn);
    }
    private int validate(String restartYn){
        int restart = convertToInteger(restartYn);
        if (restart != BaseballConstant.RESTART && restart != BaseballConstant.END) {
            throw new IllegalArgumentException();
        }
        return restart;
    }

    private static int convertToInteger(String restartYn) {
        try {
            return Integer.parseInt(restartYn);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
