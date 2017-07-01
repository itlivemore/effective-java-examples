package pers.ej.chapter04.item17;

import java.util.Date;

/**
 * 父类的构造器在子类的构造器之前运行。
 * 所以子类中覆盖版本的方法在子类初始化之前就执行了，所以第一次打印null
 * Created by laigc on 2017/4/23.
 */
public final class Sub extends Super {
    private final Date date;

    Sub() {
        date = new Date();
    }

    @Override
    public void overrideMe() {
        System.out.println(date);
    }

    public static void main(String[] args) {
        Sub sub = new Sub();
        sub.overrideMe();
    }
}
