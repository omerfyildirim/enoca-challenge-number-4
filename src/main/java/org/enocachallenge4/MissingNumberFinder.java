package org.enocachallenge4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MissingNumberFinder {

    public static void main(String[] args) {
        List<Integer> originalList = createRandomList(100);
        List<Integer> copyList = new ArrayList<>(originalList);

        Random random = new Random();
        int randomIndex = random.nextInt(100);

        copyList.remove(randomIndex);

        int missingElement = findMissingElement(originalList, copyList);
        System.out.println("Eksik Eleman: " + missingElement);
    }

    private static List<Integer> createRandomList(int size) {
        List<Integer> randomList = new ArrayList<>();
        for (int i = 1; i <= size; i++) {
            randomList.add(i);
        }
        Collections.shuffle(randomList);
        return randomList;
    }

    private static int findMissingElement(List<Integer> originalList, List<Integer> copyList) {
        int sumOriginal = originalList.stream().mapToInt(Integer::intValue).sum();
        int sumCopy = copyList.stream().mapToInt(Integer::intValue).sum();
        return sumOriginal - sumCopy;
    }
}
