package baseball.domain;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PlayerNumber {
    private List<Integer> playerNumbers = new ArrayList<>();

    public List<Integer> getPlayerNumbers() {
        return playerNumbers;
    }

    public void updatePlayerNumbers(String playerNumbers) {
        validate(playerNumbers);
        this.playerNumbers = Arrays.stream(playerNumbers.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
    private void validate(String playerNumbers) {
    }
}
