package pers.ej.charpter07.item42;

import java.util.Arrays;

/**
 * Arrays.asList()方法接收可变参数
 * Created by lgc on 17-6-11.
 */
public class ArraysAsList {
    public static void main(String[] args) {
        int[] digits = {1, 2, 3};
        /*Arrays.asList()方法的参数是可变参数，因此会将int[]数组包装成List<int[]>，
        所以下面打印的是[[I@7f31245a]*/
        System.out.println(Arrays.asList(digits));
        // 打印数组可用下面的方法
        System.out.println(Arrays.toString(digits));
    }
}
