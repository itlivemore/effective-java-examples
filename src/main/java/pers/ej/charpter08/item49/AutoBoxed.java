package pers.ej.charpter08.item49;

/**
 * 自动拆箱与装箱
 * Created by lgc on 17-6-17.
 */
public class AutoBoxed {
    public static void main(String[] args) {
        Integer a = new Integer(26);
        Integer b = new Integer(26);
        System.out.println(compare(a, b));
        // 返回的是1

        System.out.println(compare2(a, b));
        // 返回的是0
    }

    private static int compare(Integer first, Integer second) {
        // 执行first < second会自动拆箱，所以比较26时是false
        // 执行==是比较地址,所以比较26返回的是1
        return first < second ? 1 : (first == second ? 0 : 1);
    }

    private static int compare2(Integer first, Integer second) {
        int f = first; // 自动拆箱
        int s = second; // 自动拆箱
        return f < s ? 1 : (f == s ? 0 : 1);
    }
}
