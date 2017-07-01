package pers.ej.chapter10.item68;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * ExecutorService的简单使用
 * Created by lgc on 17-7-1.
 */
public class Executor {
    public static void main(String[] args) {
        // 创建
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        // 执行任务
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println(System.currentTimeMillis());
            }
        });
        // 关闭
        executorService.shutdown();
    }
}
