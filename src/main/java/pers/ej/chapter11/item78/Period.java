package pers.ej.chapter11.item78;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Date;

/**
 * 第39条中的不可变类Period使用序列化代理做成序列化。
 * Created by lgc on 17-7-2.
 */
public final class Period implements Serializable {
    private final Date start;
    private final Date end;

    public Period(Date start, Date end) {
        this.start = new Date(start.getTime());
        this.end = new Date(end.getTime());
        if (this.start.compareTo(this.end) > 0)
            throw new IllegalArgumentException(start + " after " + end);
    }

    public Date start() {
        return new Date(start.getTime());
    }

    public Date end() {
        return new Date(end.getTime());
    }

    public String toString() {
        return start + " - " + end;
    }

    // 私有静态嵌套类
    private static class SerializationProxy implements Serializable {
        private final Date start;
        private final Date end;

        // 构造器参数是外围类
        SerializationProxy(Period p) {
            this.start = p.start;
            this.end = p.end;
        }

        private static final long serialVersionUID = 234098243823485285L;

        // 返回外围类实例
        private Object readResolve() {
            return new Period(start, end); // Uses public constructor
        }
    }

    // writeReplace方法，返回嵌套类
    private Object writeReplace() {
        return new SerializationProxy(this);
    }

    // 防止攻击者伪造外围类序列化的字节流进行攻击
    private void readObject(ObjectInputStream stream)
            throws InvalidObjectException {
        throw new InvalidObjectException("Proxy required");
    }
}
