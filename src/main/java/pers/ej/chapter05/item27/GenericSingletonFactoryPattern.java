package pers.ej.chapter05.item27;

/**
 * 泛型单例工厂模式
 * Created by laigc on 2017/4/28.
 */
public class GenericSingletonFactoryPattern {
    // 适用于任何泛型对象
    private static UnaryFunction<Object> IDENTITY_FUNCTION = new UnaryFunction<Object>() {
        @Override
        public Object apply(Object arg) {
            return arg;
        }
    };

    @SuppressWarnings("unchecked")
    public static <T> UnaryFunction<T> identtityFunction() {
        // UnaryFunction<Object>对于每个T来说并非都是UnaryFunction<T>，所以这里强转
        return (UnaryFunction<T>) IDENTITY_FUNCTION;
    }

    public static void main(String[] args) {
        String[] strings = {"jute", "hemp", "nylon"};
        UnaryFunction<String> sameString = identtityFunction();
        for (String string : strings) {
            System.out.println(sameString.apply(string));
        }

        Number[] numbers = {1, 2.0, 3L};
        UnaryFunction<Number> sameNumber = identtityFunction();
        for (Number number : numbers) {
            System.out.println(sameNumber.apply(number));
        }
    }
}
