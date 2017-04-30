package pers.ej.chapter06.item30;

/**
 * 加减乘除的枚举。
 * 本例是使用switch为判断，缺点：增加新的枚举常量，如果忘记给switch添加相应的条件，编译能通过，但运行会出错。
 * Created by laigc on 2017/4/30.
 */
public enum Operation {
    PLUS, MINUS, TIMES, DIVIDE;

    double apply(double x, double y) {
        switch (this) {
            case PLUS:
                return x + y;
            case MINUS:
                return x - y;
            case TIMES:
                return x * y;
            case DIVIDE:
                return x / y;
        }
        // 没有下面一行，编译会有错误
        throw new AssertionError("Unknown op " + this);
    }
}
