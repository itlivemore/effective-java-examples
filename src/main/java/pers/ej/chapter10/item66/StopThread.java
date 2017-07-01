package pers.ej.chapter10.item66;

import java.util.concurrent.TimeUnit;

/**
 * 共享原子可读写的变量不使用同步访问.
 * Created by lgc on 17-7-1.
 */
public class StopThread {
    private static boolean stopThread;

    public static void main(String[] args) throws InterruptedException {
        Thread backGroundThread = new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                while (!stopThread) {
                    System.out.println("i = " + i++);
                }
            }
        });
        backGroundThread.start();

        TimeUnit.SECONDS.sleep(1);
        stopThread = true;
    }
}
