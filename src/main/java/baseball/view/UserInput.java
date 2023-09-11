package baseball.view;


public class UserInput {
    private static final String ENTER_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String ENTER_RESTART_YN_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    /**
     * enterNumbers
     * enterRestartYn
     */

    public String enterNumbers() {
        System.out.println(ENTER_NUMBER_MESSAGE);
        return System.console().readLine();
    }
    public String enterRestartYn() {
        System.out.println(ENTER_RESTART_YN_MESSAGE);
        return System.console().readLine();
    }
}
