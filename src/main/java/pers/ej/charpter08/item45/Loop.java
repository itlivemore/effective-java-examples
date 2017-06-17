package pers.ej.charpter08.item45;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 循环中的变量最小化处理
 * Created by lgc on 17-6-17.
 */
public class Loop {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        // 使用foreach,tmp的作用域只在下面的循环中
        for (Integer tmp : list) {
            System.out.println(tmp);
        }

        // 在jdk1.5之前可以使用下面的做法,iterator的作用域也只在循环中
        for (Iterator iterator = list.iterator(); iterator.hasNext(); ) {
            System.out.println(iterator.next());
        }


        // 如果使用while循环，下面的Iterator变量的作用域不只在循环中
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        // 这里还可以访问iterator
        System.out.println(iterator.hasNext());

        /* 下面是另一种对局部变量的作用域进行最小化的循环做法
        * i和n具有相同的作用域*/
        for (int i = 0, n = getN(); i < n; i++) {
            System.out.println(i);
        }
    }

    private static int getN() {
        return 3;
    }
}




















