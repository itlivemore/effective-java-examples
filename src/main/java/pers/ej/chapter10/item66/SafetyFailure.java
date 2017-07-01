package pers.ej.chapter10.item66;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 没有正确使用同步导致安全性失败
 * Created by lgc on 17-7-1.
 */
public class SafetyFailure {
    private static volatile int nextSerialNumber = 0;

    /*生成唯一的序列号的方法。nextSerialNumber虽然声明为volatile，但是++操作不是原子性的，需要两个步骤：
    * 先读取值，然后再写入值。如果线程读取值之后被阻塞，另一个线程也读取值，将会导致两个线程读取的值一样*/
    public static int generateSerialNumber() {
        return nextSerialNumber++;
    }

    /*修正方法一：增加synchronized来同步*/
    public synchronized static int generateSerialNumber2() {
        return nextSerialNumber++;
    }

    /*修正方法二：使用AtomicLong*/
    private static final AtomicLong nextSeriaNumber2 = new AtomicLong();

    public static long generateSerialNumber3() {
        return nextSeriaNumber2.getAndIncrement();
    }
}

