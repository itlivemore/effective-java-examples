package pers.ej.chapter04.item13;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * static final 数组做成外界不可修改的数组
 * Created by laigc on 2017/4/22.
 */
public class StaticFinalArray {
    // 公有static final域
    public static final Integer[] VALUES = {1, 2, 3};

    // 将域变成私有的
    private static final Integer[] PRIVATE_VALUES = {1, 2, 3};
    // 方法一:将私有数组变为不可变的List
    public static final List<Integer> LIST_VALUES = Collections.unmodifiableList(Arrays.asList(PRIVATE_VALUES));

    // 方法二：返回私有数组的备份
    public static final Integer[] getPrivateValues() {
        return PRIVATE_VALUES.clone();
    }

    public static void main(String[] args) {
        // statci,final数组里的值会被改变
        Integer[] array1 = StaticFinalArray.VALUES;
        System.out.println(Arrays.toString(StaticFinalArray.VALUES));
        array1[0] = 6;
        System.out.println(Arrays.toString(StaticFinalArray.VALUES));
        System.out.println("-----------------------");

        // 不可变list
        List<Integer> listValues = StaticFinalArray.LIST_VALUES;
        System.out.println(StaticFinalArray.LIST_VALUES);
        try {
            // 修改会有异常
            listValues.set(0, 6);
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println(StaticFinalArray.LIST_VALUES);

        System.out.println("-----------------------");
        // 返回备份
        Integer[] privateValues = StaticFinalArray.getPrivateValues();
        System.out.println(Arrays.toString(StaticFinalArray.getPrivateValues()));
        privateValues[0] = 6;
        System.out.println(Arrays.toString(StaticFinalArray.getPrivateValues()));
    }
}
