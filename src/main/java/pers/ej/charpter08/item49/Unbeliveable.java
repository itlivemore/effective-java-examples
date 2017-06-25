package pers.ej.charpter08.item49;

/**
 * 当在一项操作中混合使用基本类型和装箱类型时，装箱基本类型就会自动拆箱。
 * Created by lgc on 17-6-17.
 */
public class Unbeliveable {
    private static Integer a;

    private static int b;

    public static void main(String[] args) {
        if (b == 2) {
            System.out.println("b == 2");
        } else {
            System.out.println("b = " + b);
        }
        // 上面打印的是b = 0
        System.out.println("==========");
        if (a == 2) { // a会被自动拆箱，a为null，拆箱会有NullPointerException
            System.out.println("a == 2");
        } else {
            System.out.println("a = " + a);
        }
    }
}
