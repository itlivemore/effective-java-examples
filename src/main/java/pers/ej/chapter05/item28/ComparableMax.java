package pers.ej.chapter05.item28;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ScheduledFuture;

/**
 * max方法使用通配符
 * Created by laigc on 2017/4/29.
 */
public class ComparableMax {
    // 最开始的写法
    public static <T extends Comparable<T>> T max(List<T> list) {
        Iterator<T> iterator = list.iterator();
        T result = iterator.next();
        while (iterator.hasNext()) {
            T t = iterator.next();
            if (t.compareTo(result) > 0) {
                result = t;
            }
        }
        return result;
    }

    /**
     * 使用通配符类型
     * 因为Comparable消费T实例，所以定义为Comparable<? super T>
     *
     * @param list
     * @param <T>
     * @return
     */
    public static <T extends Comparable<? super T>> T max2(List<? extends T> list) {
        // 注意下面一行也进行了修改
        Iterator<? extends T> iterator = list.iterator();
        T result = iterator.next();
        while (iterator.hasNext()) {
            T t = iterator.next();
            if (t.compareTo(result) > 0) {
                result = t;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<ScheduledFuture<?>> scheduledFutures = new ArrayList<>();
        /**没有使用通配符编译报错，因为java.util.concurrent.ScheduledFuture没有实现Comparable<ScheduledFuture>接口。
         * 它是扩展Comparable<Delayed>接口的Delayed接口的子接口。换句话说，ScheduledFuture实例并非只能与其他
         * ScheduledFuture实例相比较；它可以与任何Delayed实例相比较。
         */
//        max(scheduledFutures);
        max2(scheduledFutures);
    }
}
