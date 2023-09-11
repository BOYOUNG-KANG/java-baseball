package baseball.view;

import baseball.message.GameMessage;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class InputView {
    public String getPlayerNumber(){
        System.out.println(GameMessage.INPUT_NUMBER_MESSAGE);
        return Console.readLine();
    }
}
