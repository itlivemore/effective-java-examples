package pers.ej.chapter07.item43;

import java.util.Arrays;
import java.util.List;

/**
 * Collection.toArray(T[])的规范保证：如果输入数组大到足够容纳这个集合，它就将返回这个输入数组
 * Created by lgc on 17-6-11.
 */
public class ToArray {
    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1, 2, 3);
        Integer[] array1 = new Integer[integers.size()];
        // 下面打印的是true，说明如果输入数组大到足够容纳这个集合，它就将返回这个输入数组
        System.out.println(array1 == integers.toArray(array1));

        // 创建一个不能容纳集合中所有元素的数组
        Integer[] array2 = new Integer[integers.size() - 1];
        Integer[] array3 = integers.toArray(array2);
        // 下面返回的是false，且array3中有integers中的所有元素。
        // 所以如果数组长度不够，会重新创建一个数组，并保存集合中的所有元素
        System.out.println(array2 == array3);
        System.out.println(Arrays.toString(array3));
    }
}
