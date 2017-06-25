package pers.ej.chapter07.item43;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 返回零长度的数组或者集合，而不是null.
 * 每次返回的数组或集合可以是同一个，因为长度为零的数组或集合是不可变的，可共享.
 * Created by lgc on 17-6-11.
 */
public class ReturnEmptyArray {
    List<Integer> integerList = new ArrayList<>();

    private static final Integer[] EMPTY_INTEGER_ARRAY = new Integer[0];

    public Integer[] getArray() {
        // Collection.toArray(T[])的规范保证：如果输入数组大到足够容纳这个集合，它就将返回这个输入数组
        // 所以如果是个空集合，这种做法也不会再分配零长度的数组。
        return integerList.toArray(EMPTY_INTEGER_ARRAY);
    }

    public List<Integer> getCollection() {
        if (integerList.isEmpty()) {
            // 返回空的Collection，这个空集合每次返回都是同一个
            return Collections.emptyList();
        } else {
            return new ArrayList<>(integerList);
        }
    }
}
