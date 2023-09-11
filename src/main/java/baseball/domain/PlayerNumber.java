package baseball.domain;

import baseball.constant.BaseballConstant;

import java.util.*;

import java.util.stream.Collectors;

public class PlayerNumber {
    private List<Integer> playerNumbers = new ArrayList<>();

    public List<Integer> getPlayerNumbers() {
        return playerNumbers;
    }

    public void updatePlayerNumbers(String playerNumbers) {
        List<Integer> validatedPlayerNumbers = validate(playerNumbers);
        this.playerNumbers = validatedPlayerNumbers;
    }
    private List<Integer> validate(String playerNumbers) {
        if (isNotLength3 (playerNumbers) || isInclude0(playerNumbers) || hasSameDigit(playerNumbers)){
            throw new IllegalArgumentException();
        }
        return convertToInteger(playerNumbers);
    }

    private static boolean isNotLength3(String playerNumbers) {
        return playerNumbers.length() != 3;
    }
    private static boolean isInclude0(String playerNumbers){
        return playerNumbers.contains(BaseballConstant.VALIDATE_NUMBER_ZERO);
    }
    private static boolean hasSameDigit(String playerNumbers){
        String[] numbers = playerNumbers.split("");
        HashSet<String> number = new HashSet<>(Arrays.asList(numbers));
        return number.size() != 3;
    }

    private List<Integer> convertToInteger(String playerNumbers) {
        try {
            return Arrays.stream(playerNumbers.split(""))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
