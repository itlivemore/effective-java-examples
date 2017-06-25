package pers.ej.charpter08.item49;

/**
 * 使用装箱基本类型，会使变量反复地装箱与拆箱，导致性能下降。
 * Created by lgc on 17-6-17.
 */
public class Sum {
    public static void main(String[] args) {
        Long sum = 0L;
        for (long i = 0; i < Integer.MAX_VALUE; i++) {
            sum += i;
        }
        System.out.println(sum);
    }
}
