package baseball.controller;


import baseball.message.ErrorMessage;

import java.util.*;
import java.util.stream.Collectors;

public class VailidateInput {

    /**
     * validateNumberInput
     * - isNotLengthThree
     * - hasSameDigits
     * - isIncludeZero
     * validateRestartYnInput
     * - isOneOrTwo
     */

    public List<Integer> validateNumberInput(String userNumbers) {
        if(isNotLengthThree(userNumbers)){
            throw new IllegalArgumentException(ErrorMessage.WRONG_LENGTH_INPUT_MESSAGE);
        }
        if(hasSameDigits(userNumbers)){
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NUMBER_INPUT_MESSAGE);
        }
        if(isIncludeZero(userNumbers)){
            throw new IllegalArgumentException(ErrorMessage.WRONG_RANGE_INPUT_MESSAGE);
        }

        return  Arrays.stream(userNumbers.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
    public void validateRestartYnInput(String restartYn) {
        if(isOneOrTwo(restartYn)) {
            throw new IllegalArgumentException(ErrorMessage.WRONG_RESTART_INPUT_MESSAGE);
        }
    }

    private static boolean isOneOrTwo(String restartYn) {
        return restartYn.equals("1") || restartYn.equals("2");
    }

    private static boolean isIncludeZero(String userNumbers) {
        for(int i = 0; i < 3; i ++) {
            if(userNumbers.contains("0")) {
                return false;
            }
        }
        return true;
    }

    private static boolean hasSameDigits(String userNumbers) {
        String[] numbers = userNumbers.split("");
        Set<String> number = new HashSet<>(Arrays.asList(numbers));
        return number.size() != 3;
    }

    private static boolean isNotLengthThree(String numbers) {
        return numbers.length() != 3;
    }
}
