package pers.ej.chapter06.item30;

import java.util.HashMap;
import java.util.Map;

/**
 * 如果Operation枚举不受你控制，你希望它有一个实例方法返回每个运算的反运算符
 * Created by laigc on 2017/4/30.
 */
public enum Operation5 {
    PLUS("+") {
        @Override
        double apply(double x, double y) {
            return x + y;
        }
    },

    MINUS("-") {
        @Override
        double apply(double x, double y) {
            return x - y;
        }
    },

    TIMES("*") {
        @Override
        double apply(double x, double y) {
            return x * y;
        }
    },

    DIVIDE("/") {
        @Override
        double apply(double x, double y) {
            return x / y;
        }
    };

    // 特定的数据，由每个实例自己初始化为不同的值
    private final String symbol;

    Operation5(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return symbol;
    }

    abstract double apply(double x, double y);

    private static final Map<String, Operation5> stringToEnum = new HashMap<>();

    static {
        for (Operation5 op : values()) {
            stringToEnum.put(op.toString(), op);
        }
    }

    public static Operation5 fromString(String symbol) {
        return stringToEnum.get(symbol);
    }

    // 返回相反的运算符
    public static Operation5 inverse(Operation5 op) {
        switch (op) {
            case PLUS:
                return Operation5.MINUS;
            case MINUS:
                return Operation5.PLUS;
            case TIMES:
                return Operation5.DIVIDE;
            case DIVIDE:
                return Operation5.TIMES;
            default:
                throw new AssertionError("Unknow op " + op);
        }
    }

    public static void main(String[] args) {
        //valueOf(String)将常量名字转变成常量本身
        Operation2 plus2 = Operation2.valueOf("PLUS");
        // Operation2没有覆盖toString()，plus2打印出来是PLUS
        System.out.println(plus2 + ":" + plus2.apply(2, 4));

        Operation5 plus4 = Operation5.PLUS;
        // Operation4覆盖了toString()，plus4打印出来是+，会让人以为plus4的常量名称是+
        System.out.println(plus4 + ":" + plus4.apply(2, 4));
        try {
            // 当用+去获取时，会有异常
            plus4 = Operation5.valueOf("+");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        // 所以增加了fromString()方法
        plus4 = Operation5.fromString("+");
        System.out.println(plus4 + ":" + plus4.apply(2, 4));
    }
}
