package pers.ej.chapter05.item28;

import java.util.HashSet;
import java.util.Set;

/**
 * Set的union
 * Created by laigc on 2017/4/29.
 */
public class SetUnion {
    public static <E> Set<E> union(Set<? extends E> set1, Set<? extends E> set2) {
        Set<E> result = new HashSet<>(set1);
        result.addAll(set2);
        return result;
    }

    public static void main(String[] args) {
        Set<Integer> integerSet = new HashSet<>();
        Set<Double> doubleSet = new HashSet<>();
        Set<Number> numberSet;
        // jdk1.7之前，下面的代码编译器不能推断出我们希望它拥有的类型
        numberSet = union(integerSet, doubleSet);

        //可以通过一个显式的类型参数来告诉编译器要使用的类型
        numberSet = SetUnion.<Number>union(integerSet, doubleSet);
    }
}
