package io.neolab.noskov.testcase;

import org.junit.Test;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class MyClassTest {

    @Test
    public void testingFindMaxElementsInArrayInteger() throws MyException {
        int sizeArray = 10;
        Integer[] array = new Integer[sizeArray];
        for (int i = 0; i<sizeArray; i++) {
            array[i] = i;
        }

        int countOfMaximalElements = 5;
        List<Integer> result = MyClass.findMaxElementsInArray(array, countOfMaximalElements);

        for (int i = 0; i<countOfMaximalElements; i++) {
           assertEquals(array[(sizeArray-1)-i], result.get(i));
        }
    }

    @Test
    public void testingFindMaxElementsInArrayEquals() throws MyException {
        int sizeArray = 10;
        Integer[] array = new Integer[sizeArray];
        for (int i = 0; i<sizeArray; i++) {
            array[i] = 1;
        }

        int countOfMaximalElements = 5;
        List<Integer> result = MyClass.findMaxElementsInArray(array, countOfMaximalElements);

        for (int i = 0; i<countOfMaximalElements; i++) {
            assertEquals(array[(sizeArray-1)-i], result.get(i));
        }
    }


    @Test(expected = NullPointerException.class)
    public void testingFindMaxElementsInArrayNull() throws MyException {
        int sizeArray = 10;
        Integer[] array = new Integer[sizeArray];

        int countOfMaximalElements = 5;
        List<Integer> result = MyClass.findMaxElementsInArray(array, countOfMaximalElements);
    }

    @Test(expected = MyException.class)
    public void testingFindMaxElementsInArrayLength() throws MyException {
        int sizeArray = 10;
        Integer[] array = new Integer[sizeArray];
        for (int i = 0; i<sizeArray; i++) {
            array[i] = i;
        }

        int countOfMaximalElements = 15; //more than sizeArray
        List<Integer> result = MyClass.findMaxElementsInArray(array, countOfMaximalElements);
    }

    @Test
    public void testingFindMaxElementsInArrayDouble() throws MyException {
        int sizeArray = 10;
        Double[] array = new Double[sizeArray];
        for (int i = 0; i<sizeArray; i++) {
            array[i] = i+0.5;
        }

        int countOfMaximalElements = 5;
        List<Double> result = MyClass.findMaxElementsInArray(array, countOfMaximalElements);

        for (int i = 0; i<countOfMaximalElements; i++) {
            assertEquals(array[(sizeArray-1)-i], result.get(i),10^(-16));
        }
    }

    @Test
    public void testingFindThreeMaxElementsInArrayFloat() throws MyException {
        int sizeArray = 10;
        Float[] array = new Float[sizeArray];
        for (int i = 0; i<sizeArray; i++) {
            array[i] = new Float(i);
        }

        List<Float> result = MyClass.findThreeMaxElementsInArray(array);

        for (int i = 0; i<3; i++) {
            assertEquals(array[(sizeArray-1)-i], result.get(i),10^(-16));
        }
    }

    @Test
    public void testingFindingSumOfDigits() {
        assertEquals(45, MyClass.findingSumOfDigits(1234567890));
    }

    @Test
    public void testingFindingSumOfDigitsNegativeNumber() {
        assertEquals(45, MyClass.findingSumOfDigits(-1234567890));
    }
}
