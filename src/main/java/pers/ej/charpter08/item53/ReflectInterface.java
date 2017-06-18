package pers.ej.charpter08.item53;

import java.util.Arrays;
import java.util.Set;

/**
 * 使用Set对参数去重，具体使用哪个类型的Set则由输入参数决定
 * Created by lgc on 17-6-18.
 */
public class ReflectInterface {
    public static void main(String[] args) {
        // 第一个参数是要使用的Set的类型，后面是要去重的参数
        args = new String[]{"java.util.HashSet", "1", "2", "1", "2"};
        args = new String[]{"java.util.TreeSet", "1", "2", "1", "2"};
        Class<?> clazz = null;
        try {
            // 加载类
            clazz = Class.forName(args[0]);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.exit(1);
        }
        Set<String> set = null;
        try {
            // 创建set实例
            set = (Set<String>) clazz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        if (set == null) {
            return;
        }

        // 使用set对参数去重
        set.addAll(Arrays.asList(args).subList(1, args.length));
        System.out.println(set);
    }
}














