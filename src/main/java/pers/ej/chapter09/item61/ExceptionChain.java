package pers.ej.chapter09.item61;

/**
 * 高层异常,有接受异常的构造器
 * Created by laigc on 2017/6/25.
 */
class HigherLevelException extends Exception {
    public HigherLevelException() {
    }

    // 接受异常的构造器
    public HigherLevelException(Throwable cause) {
        super(cause);
    }
}

/**
 * 高层异常,没有接受异常的构造器
 * Created by laigc on 2017/6/25.
 */
class HigherLevelException2 extends Exception {
}

/*低层异常*/
class LowerLevelException extends Exception {
    public LowerLevelException(String message) {
        super(message);
    }
}

class Lower {
    static void f(int param) throws LowerLevelException {
        throw new LowerLevelException("参数" + param + "调用f()异常");
    }
}

/**
 * 异常链
 * Created by laigc on 2017/6/25.
 */
public class ExceptionChain {
    public static void main(String[] args) {
        try {
            call1();
        } catch (HigherLevelException e) {
            e.printStackTrace();
        }
        try {
            call2();
        } catch (HigherLevelException2 e) {
            e.printStackTrace();
        }
    }

    private static void call1() throws HigherLevelException {
        // 有运行异常链的构造器，则将异常放到构造方法中
        try {
            Lower.f(1);
        } catch (LowerLevelException e) {
            throw new HigherLevelException(e);
        }
    }

    private static void call2() throws HigherLevelException2 {
        // 没有运行异常链的构造器，使用initCause()设置原因
        try {
            Lower.f(2);
        } catch (LowerLevelException e) {
            HigherLevelException2 exception = new HigherLevelException2();
            exception.initCause(e);
            throw exception;
        }
    }
}
