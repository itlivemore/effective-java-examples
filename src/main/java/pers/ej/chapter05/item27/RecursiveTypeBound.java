package pers.ej.chapter05.item27;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * 递归类型限制
 * Created by laigc on 2017/4/28.
 */
public class RecursiveTypeBound {
    // 递归
    public static <T extends Comparable<T>> T max(List<T> list) {
        Iterator<T> iterator = list.iterator();
        T result = iterator.next();
        while (iterator.hasNext()) {
            T t = iterator.next();
            if (t.compareTo(result) > 0) {
                result = t;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(6, 5, 4, 3, 9, 8, 1, 2);
        System.out.println(max(list));
    }
}
