package baseball.controller;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class ComputerNumber {
    public List<Integer> generateRandomNumbers() {
        ArrayList<Integer> randomNumbers = new ArrayList<>();
        for(int i = 0; i < 3 ; i++) {
            randomNumbers.add(generateRandomNumber(randomNumbers));
        }
        return randomNumbers;

    }
    private int generateRandomNumber(ArrayList<Integer> randomNumbers) {
        while (true) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);

            if(!randomNumbers.contains(randomNumber)){
                return randomNumber;
            }
        }
    }
}
