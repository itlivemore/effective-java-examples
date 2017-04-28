package pers.ej.chapter05.item27;

/**
 * 一个泛型接口，需要创建它的对象适用于所有的泛型对象
 * Created by laigc on 2017/4/28.
 */
public interface UnaryFunction<T> {
    T apply(T arg);
}
