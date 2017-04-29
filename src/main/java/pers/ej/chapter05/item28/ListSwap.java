package pers.ej.chapter05.item28;

import java.util.List;

/**
 * 交换List中两个元素
 * 类型参数是通配符两种声明方法
 * 方法二好些，一般来说，如果参数类型只在方法声明中出现一次，就可以用通配符取代它。
 * Created by laigc on 2017/4/29.
 */
public class ListSwap {
    public static <E> void swap(List<E> list, int i, int j) {

    }

    public static void swap2(List<?> list, int i, int j) {
        // 编译失败，不能把null之外的任何值放到List<?>中
        // 编写辅助方法来捕捉通配符类型
//        list.set(i, list.set(j, list.get(i)));

        swapHelper(list, i, j);
    }

    public static <E> void swapHelper(List<E> list, int i, int j) {
        list.set(i, list.set(j, list.get(i)));
    }
}
