/*
 * Answer.java
 * version 1.0
 * 2019.03.28
 * Copyright (c) 2019 Hyunji Choi
 * This program is made available under the terms of the MIT License.
 */

package com.woowacourse.baseball.util;

import java.util.ArrayList;
import java.util.Random;

/**
 * Answer represents player Computer.
 */
public class Answer {
    private ArrayList<Integer> answer = new ArrayList<>();

    /**
     * setAnswer saves random answer and length of the number.
     */
    public void setAnswer() {
        saveRandomNumbers();

        /* For debugging
        for (int i : answer) {
            System.out.print(i);
        }
        System.out.println(" -- Now Guess!");
        */
    }

    /**
     * getAnswer returns answer ArrayList.
     * @return answer generated by computer.
     */
    public ArrayList<Integer> getAnswer() {
        return answer;
    }

    /**
     * saveRandomNumbers decide computer's answer.
     */
    private void saveRandomNumbers() {
        Random rand = new Random();

        /* Produce random number between
         * NUMBER_LOWER_BOUND and NUMBER_UPPER_BOUND */
        int now     = rand.nextInt(Constants.NUMBER_UPPER_BOUND)
                + Constants.NUMBER_LOWER_BOUND;

        answer.add(now);

        for (int i=1; i<Constants.NUMBER_LENGTH; i++) {
            now = rand.nextInt(Constants.NUMBER_UPPER_BOUND)
                    + Constants.NUMBER_LOWER_BOUND;

            /* Avoid same number. */
            while (answer.contains(now)) {
                now = rand.nextInt(Constants.NUMBER_UPPER_BOUND)
                        + Constants.NUMBER_LOWER_BOUND;
            }

            answer.add(now);
        }
    }
}
