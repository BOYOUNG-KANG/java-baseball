package baseball.model;

import java.util.List;

public class GameNumber {
    private List<Integer> userNumber;
    private List<Integer> computerNumber;

    public List<Integer> getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(List<Integer> userNumber) {
        this.userNumber = userNumber;
    }

    public List<Integer> getComputerNumber() {
        return computerNumber;
    }

    public void setComputerNumber(List<Integer> computerNumber) {
        this.computerNumber = computerNumber;
    }
}
