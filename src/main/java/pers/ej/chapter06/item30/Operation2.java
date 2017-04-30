package pers.ej.chapter06.item30;

/**
 * 加减乘除的枚举。
 * 将不同的行为与每个枚举常量关联起来：在枚举类型中声明一个抽象的apply方法，
 * 并在特定于常量的类主体中，用具体的方法覆盖每个常量的抽象apply方法。
 * 这种方法的好处：如果增加了新的常量，必须要实现抽象方法，否则编译不通过。
 * Created by laigc on 2017/4/30.
 */
public enum Operation2 {
    PLUS {
        @Override
        double apply(double x, double y) {
            return x + y;
        }
    }, MINUS {
        @Override
        double apply(double x, double y) {
            return x - y;
        }
    }, TIMES {
        @Override
        double apply(double x, double y) {
            return x * y;
        }
    }, DIVIDE {
        @Override
        double apply(double x, double y) {
            return x / y;
        }
    };

    abstract double apply(double x, double y);
}
