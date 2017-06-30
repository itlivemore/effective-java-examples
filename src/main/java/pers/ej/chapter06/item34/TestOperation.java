package pers.ej.chapter06.item34;

import java.util.Arrays;
import java.util.Collection;

/**
 * 测试扩展的枚举.
 * 除非需要要灵活地合并多个实现类型的操作，否则可能最好使用有限制的类型令牌（即第1个test方法）
 * Created by laigc on 2017/5/1.
 */
public class TestOperation {
    public static void main(String[] args) {
        double x = 2;
        double y = 4;
        test(ExtendedOperation.class, x, y);

        test(Arrays.asList(ExtendedOperation.values()), x, y);
    }

    // 使用<T extends Enum<T> & Operation>
    private static <T extends Enum<T> & Operation> void test(Class<T> opSet, double x, double y) {
        for (Operation operation : opSet.getEnumConstants()) {
            System.out.printf("%f %s %f = %f%n", x, operation, y, operation.apply(x, y));
        }
    }

    // 使用Collection<? extends Operation>，可合并多个实现类型的操作。
    private static void test(Collection<? extends Operation> opSet, double x, double y) {
        for (Operation operation : opSet) {
            System.out.printf("%f %s %f = %f%n", x, operation, y, operation.apply(x, y));
        }
    }
}
