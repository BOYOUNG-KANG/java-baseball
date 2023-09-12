package baseball.view;

import baseball.message.GameMessage;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String getPlayerNumber(){
        System.out.print(GameMessage.INPUT_NUMBER_MESSAGE);
        return Console.readLine();
    }
    public String getRestartYn(){        System.out.println(GameMessage.GAME_RESTART_YN_MESSAGE);        return Console.readLine();    }}