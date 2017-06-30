package pers.ej.chapter07.item41;

import java.util.*;

/**
 * 基本类型的拆箱装箱与Set和List的remove()方法的重载
 * Created by lgc on 17-6-11.
 */
public class SetListRemove {
    public static void main(String[] args) {
        method1();
        System.out.println("method1 finished");
        method2();
    }

    public static void method1() {
        Set<Integer> set = new TreeSet<>();
        List<Integer> list = new ArrayList<>();
        for (int i = -3; i < 3; i++) {
            set.add(i);
            list.add(i);
        }
        System.out.println("set: " + set);
        System.out.println("list: " + list);
        for (int i = 0; i < 3; i++) {
            set.remove(i); // Set方法的remove()选择的是remove(Object E)
            list.remove(i); // List方法的remove()选择的是remove(int index)
        }
        /*注意：这里的list原先是[-3, -2, -1, 0, 1, 2]移除的是第0个元素-3,
        变为了[ -2, -1, 0, 1, 2]移除之后再移除第1个元素-1,列表变为[-2, 0, 1, 2],
        再移除第2个元素1,列表变为[-2, 0, 2]*/
        System.out.println("after remove");
        System.out.println("set: " + set);
        System.out.println("list: " + list);
    }

    public static void method2() {
        Set<Integer> set = new TreeSet<>();
        List<Integer> list = new ArrayList<>();
        for (int i = -3; i < 3; i++) {
            set.add(i);
            list.add(i);
        }
        System.out.println("set: " + set);
        System.out.println("list: " + list);
        for (int i = 0; i < 3; i++) {
            set.remove(i);// Set方法的remove()选择的是remove(Object E)
            list.remove((Integer) i); // 转为Integer，List方法的remove()选择的是remove(Object E)
        }
        System.out.println("after remove");
        System.out.println("set: " + set);
        System.out.println("list: " + list);
    }
}













