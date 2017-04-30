package pers.ej.chapter06.item30;

/**
 * 将特定常量的方法与特定常量的数据结合起来
 * 覆盖了toString()来返回通常与该操作关联的符号
 * Created by laigc on 2017/4/30.
 */
public enum Operation3 {
    PLUS("+") {
        @Override
        double apply(double x, double y) {
            return x + y;
        }
    }, MINUS("-") {
        @Override
        double apply(double x, double y) {
            return x - y;
        }
    }, TIMES("*") {
        @Override
        double apply(double x, double y) {
            return x * y;
        }
    }, DIVIDE("/") {
        @Override
        double apply(double x, double y) {
            return x / y;
        }
    };

    // 特定的数据，由每个实例自己初始化为不同的值
    private final String symbol;

    Operation3(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return symbol;
    }

    abstract double apply(double x, double y);

    public static void main(String[] args) {
        double x = 2;
        double y = 4;
        for (Operation3 op : Operation3.values()) {
            System.out.printf("%f %s %f = %f%n", x, op, y, op.apply(x, y));
        }
    }
}
