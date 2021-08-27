package com.zipcodewilmington.arrayutility;

import com.sun.xml.internal.xsom.impl.scd.Iterators;

import java.util.*;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility<T> {
    private T[] inputArray;

    public ArrayUtility(T[] inputArray){
        this.inputArray = inputArray;
    }

    public Integer countDuplicatesInMerge(T[] arrayToMerge, T valueToEvaluate){
        List<T> bList = new ArrayList<>();
        bList.addAll(Arrays.asList(inputArray));
        bList.addAll(Arrays.asList(arrayToMerge));
        return Collections.frequency(bList,valueToEvaluate);

    }
    public T getMostCommonFromMerge(T[] arrayToMerge){
        List<T> bList = new ArrayList<>();
        Map<T,Integer> numOfOccurrences = new HashMap<>();
        bList.addAll(Arrays.asList(inputArray));
        bList.addAll(Arrays.asList(arrayToMerge));
        for (int i=0; i<bList.size(); i++){
            Integer numberOfTimes = Collections.frequency(bList,bList.get(i));
            numOfOccurrences.put(bList.get(i),numberOfTimes);
        }
        Map.Entry<T, Integer> mostCommon = null;
        for (Map.Entry<T, Integer> e: numOfOccurrences.entrySet()){
            if (mostCommon == null || mostCommon.getValue() < e.getValue()){
                mostCommon = e;
            }
        }
        return mostCommon.getKey();
    }

    public Integer getNumberOfOccurrences(T valueToEvaluate){
        List<T> bList = new ArrayList<>();
        bList.addAll(Arrays.asList(inputArray));
        return Collections.frequency(bList,valueToEvaluate);

    }
    public T[] removeValue(T valueToRemove){
        int numberOfOccurrences = getNumberOfOccurrences(valueToRemove);
        T[] result = Arrays.copyOf(inputArray,inputArray.length - numberOfOccurrences);
        for (int i = 0, j = 0; i< inputArray.length; i++){
            if (inputArray[i] != valueToRemove){
                result[j] = inputArray[i];
                j++;
            }
        }
        return result;
    }

}
