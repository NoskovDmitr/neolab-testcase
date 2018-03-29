package io.neolab.noskov.testcase;

import java.util.*;

public class MyClass {

    public static <T extends Number>  List<T> findThreeMaxElementsInArray(T[] array) throws MyException {
        int countOfMaximalElements = 3; //magic constant
        return findMaxElementsInArray(array, countOfMaximalElements);
    }

    public static <T extends Number> List<T> findMaxElementsInArray(T[] array, int countOfMaximalElements) throws MyException {
        if (countOfMaximalElements > array.length) {
            throw new MyException("Count of maximal elements more than array length");
        }

        NumberComparator numberComparator = new NumberComparator();

        List<T> listMaxElements = new ArrayList<T>(countOfMaximalElements);

        listMaxElements.addAll(Arrays.asList(array).subList(0, countOfMaximalElements)); //add first countOfMaximalElements elements from input array to listMaximalElements

        Collections.sort(listMaxElements, (t1, t2) -> {return -numberComparator.compare(t1,t2); }); // O(m*log(m)), where m = countOfMaximalElements

        for(int i = countOfMaximalElements; i < array.length; i++) { //O(m*n), where m = countOfMaximalElements and n = array.length
            for (int j = 0; j<countOfMaximalElements; j++){
                if (numberComparator.compare(listMaxElements.get(j),(array[i])) < 0) {
                    listMaxElements.add(j, array[i]);
                    break;
                }
            }
        }

        return listMaxElements;
    }

    public static int findingSumOfDigits(int inputValue) { //I could not come up with of determine that the Number is an integer.
        int sum = 0;
        char[] numeral = String.valueOf(Math.abs(inputValue)).toCharArray();
        for (char c:numeral) {
            sum += Integer.parseInt(String.valueOf(c));
        }
        return sum;
    }
}
