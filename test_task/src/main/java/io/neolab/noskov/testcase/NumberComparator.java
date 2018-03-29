package io.neolab.noskov.testcase;

import java.util.Comparator;

class NumberComparator<T extends Number & Comparable> implements Comparator<T> {

    public int compare( T a, T b ) throws ClassCastException {
        return a.compareTo( b );
    }
}