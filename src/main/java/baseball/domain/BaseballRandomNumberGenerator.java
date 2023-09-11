package baseball.domain;


import baseball.constant.BaseballConstant;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseballRandomNumberGenerator {

    public List<Integer> generateRandomNumber(){
        List<Integer> randomNumbers = new ArrayList<>();
        while (randomNumbers.size() < BaseballConstant.NUMBER_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(BaseballConstant.MIN_NUMBER, BaseballConstant.MAX_NUMBER);
            checkNumberDuplicates(randomNumbers, randomNumber);
        }
        return randomNumbers;
    }

    private static void checkNumberDuplicates(List<Integer> randomNumbers, int randomNumber) {
        if (!randomNumbers.contains(randomNumber)) {
            randomNumbers.add(randomNumber);
        }
    }

}
