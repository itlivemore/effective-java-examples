package pers.ej.chapter07.item39;

import java.util.Date;

/**
 * 表示一段不可变的时间区间
 * 字段被定义成final的，传入构造器的参数进行拷贝
 * get方法返回时也是拷贝
 * Created by laigc on 2017/5/13.
 */
public class Period2 {
    private final Date start;
    private final Date end;

    /*将输入参数拷贝,没有使用Date.clone()方法，因为Date是非final的，不能保证clone()方法一定返回
    *类为java.util.Date的对象，它有可能返回专门出于恶意的目的而设计的不可信子类的实例*/
    public Period2(Date start, Date end) {
        // 这里先拷贝，再校验参数的有效性。是防止校验完参数之后拷贝之前被其它线程修改
        this.start = new Date(start.getTime());
        this.end = new Date(end.getTime());
        if (this.start.compareTo(this.end) > 0) {
            throw new IllegalArgumentException(start + " after " + end);
        }
    }

    public Date getStart() {
        return new Date(start.getTime());
    }

    public Date getEnd() {
        return new Date(end.getTime());
    }

    public static void main(String[] args) {
        Date start = new Date();
        Date end = new Date();
        Period2 period = new Period2(start, end);
        System.out.println("start: " + period.getStart());
        System.out.println("end: " + period.getEnd());

        start.setTime(1000L);// 改变传入构造器中的对象
        Date periodEnd = period.getEnd();
        periodEnd.setTime(1000L);// 改变get()返回值
        System.out.println("start: " + period.getStart());
        System.out.println("end: " + period.getEnd());
    }
}
