package baseball.domain;


import baseball.constant.BaseballConstant;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class BaseballRandomNumberGenerator {

    public List<Integer> generateRandomNumber(){
        LinkedHashSet<Integer> randomNumbers = new LinkedHashSet<>();
        while (randomNumbers.size() < BaseballConstant.NUMBER_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(BaseballConstant.MIN_NUMBER, BaseballConstant.MAX_NUMBER);
            randomNumbers.add(randomNumber);
        }
        return convertToList(randomNumbers);
    }

    private static List<Integer> convertToList(LinkedHashSet<Integer> randomNumbers) {
        return new ArrayList<>(randomNumbers);
    }
}