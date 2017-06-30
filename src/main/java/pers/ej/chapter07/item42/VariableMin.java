package pers.ej.chapter07.item42;

/**
 * 使用可变参数求一组数的最小值
 * Created by lgc on 17-6-11.
 */
public class VariableMin {
    /*min1()方法存在的问题，1:如果没有传递参数，编译不会有异常，运行时会有异常。
    * 2：除非将min初始化为Integer.MAX_VALUE,否则不能使用foreach循环*/
    private static int min1(int... args) {
        if (args.length == 0) {
            throw new IllegalArgumentException("Too few arguments");
        }
        int min = args[0];
        for (int i = 1; i < args.length; i++) {
            if (args[i] < min) {
                min = args[i];
            }
        }
        return min;
    }

    /*在min1()方法上改进，声明两个参数，第1个参数是指定类型的正常参数，第二个是可变参数*/
    private static int min2(int firstArg, int... remainingArgs) {
        int min = firstArg;
        for (int arg : remainingArgs) {
            if (arg < min) {
                min = arg;
            }
        }
        return min;
    }

    public static void main(String[] args) {
//        System.out.println(min1()); // 不传参数会有异常
        System.out.println(min1(2, 1, 3));

        System.out.println(min2(2));
        System.out.println(min2(2, 1, 3));
    }
}
