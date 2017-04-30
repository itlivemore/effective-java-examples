package pers.ej.chapter06.item30;

import java.util.HashMap;
import java.util.Map;

/**
 * 如果在枚举中覆盖了toString()方法，要考虑编写一个fromString方法，将定制的字符串表示法变回相应的枚举。
 * Created by laigc on 2017/4/30.
 */
public enum Operation4 {
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

    Operation4(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return symbol;
    }

    abstract double apply(double x, double y);

    private static final Map<String, Operation4> stringToEnum = new HashMap<>();

    static {
        for (Operation4 op : values()) {
            stringToEnum.put(op.toString(), op);
        }
    }

    public static Operation4 fromString(String symbol) {
        return stringToEnum.get(symbol);
    }

    public static void main(String[] args) {
        //valueOf(String)将常量名字转变成常量本身
        Operation2 plus2 = Operation2.valueOf("PLUS");
        // Operation2没有覆盖toString()，plus2打印出来是PLUS
        System.out.println(plus2 + ":" + plus2.apply(2, 4));

        Operation4 plus4 = Operation4.PLUS;
        // Operation4覆盖了toString()，plus4打印出来是+，会让人以为plus4的常量名称是+
        System.out.println(plus4 + ":" + plus4.apply(2, 4));
        try {
            // 当用+去获取时，会有异常
            plus4 = Operation4.valueOf("+");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        // 所以增加了fromString()方法
        plus4 = Operation4.fromString("+");
        System.out.println(plus4 + ":" + plus4.apply(2, 4));
    }
}
