package pers.ej.chapter10.item67;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 同步区域中调用外来方法
 * Created by lgc on 17-7-1.
 */
class Other {
    public static void remove(List<Integer> list, int i) {
        if (i == 2) {
            list.remove(new Integer(i));
        } else {
            System.out.println(i);
        }
    }
}

public class SynchronizedCall {

    static List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));

    public static void foreachlist() {
        synchronized (list) {
            int i = 0;
            for (Integer integer : list) {
                Other.remove(list, i++);
            }
        }
    }

    public static void main(String[] args) {
        foreachlist();
    }
}
