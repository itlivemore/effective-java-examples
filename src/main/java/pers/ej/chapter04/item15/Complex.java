package pers.ej.chapter04.item15;

/**
 * 使类不能子类化。可以使类是final的，也可以用下面的方法：
 * 让类的所有的构造器都变成私有的或者包级私有的，并添加公有的静态工厂来代替公有的构造器。
 * Created by laigc on 2017/4/23.
 */
public class Complex {
    private final double re;
    private final double im;

    private Complex(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public static Complex valueOf(double re, double im) {
        return new Complex(re, im);
    }
}
