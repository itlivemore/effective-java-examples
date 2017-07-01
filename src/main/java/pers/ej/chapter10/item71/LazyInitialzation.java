package pers.ej.chapter10.item71;

/**
 * 延迟初始化的几种方式
 * Created by lgc on 17-7-1.
 */
public class LazyInitialzation {
    /*同步访问方法的延迟初始化*/
    private Integer field1;

    synchronized Integer getField1() {
        if (field1 == null) {
            field1 = 1;
        }
        return field1;
    }

    /*出于性能考虑对静态域使用延迟初始化*/
    private static class FieldHolder {
        static final Integer field = 2;
    }

    static Integer getField2() {
        return FieldHolder.field;
    }


    /*出于性能考虑对实例域使用延迟初始化，就使用双重检查模式*/
    private volatile Integer field3; // 注意这里要声明为volatile

    Integer getField3() {
        // 增加局部变量result是确保field只在已经被初始化的情况下读取一次
        Integer result = field3;
        if (result == null) {
            synchronized (this) {
                result = field3;
                if (result == null) {
                    field3 = result = 3;
                }
            }
        }
        return result;
    }

    /*延迟初始化一个接受重复初始化的实例域，使用单重检查模式*/
    private volatile Integer field4;

    Integer getField4() {
        Integer result = field4;
        if (result == null) {
            field4 = result = 4;
        }
        return result;
    }
}

