package pers.ej.chapter07.item39;

import java.util.Date;

/**
 * 表示一段不可变的时间区间
 * 虽然字段被定义成final的，但是传入构造器的参数自身可以被修改，所以还是会变的
 * 同时也可以修改get方法返回结果的值，也造成时间可变
 * Created by laigc on 2017/5/13.
 */
public class Period {
    private final Date start;
    private final Date end;

    public Period(Date start, Date end) {
        if (start.compareTo(end) > 0) {
            throw new IllegalArgumentException(start + " after " + end);
        }
        this.start = start;
        this.end = end;
    }

    public Date getStart() {
        return start;
    }

    public Date getEnd() {
        return end;
    }

    public static void main(String[] args) {
        Date start = new Date();
        Date end = new Date();
        Period period = new Period(start, end);
        System.out.println("start: " + period.getStart());
        System.out.println("end: " + period.getEnd());

        start.setTime(1000L);// 改变传入构造器中的对象
        Date periodEnd = period.getEnd();
        periodEnd.setTime(1000L);// 改变get()返回值
        System.out.println("start: " + period.getStart());
        System.out.println("end: " + period.getEnd());
    }
}
