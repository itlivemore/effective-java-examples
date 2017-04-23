package item21;

/**
 * 定义这样一种对象，它的方法执行其它对象(这些对象被显式传递给这些方法)上的操作。
 * 如果一个类仅仅导出这样的一个方法，它的实例实际上就等同于一个指向该方法的指针。
 * 这样的实例被称为函数对象。
 * <p>
 * Created by laigc on 2017/4/23.
 */
public class StringLengthComparator {
    public int compare(String s1, String s2) {
        return s1.length() - s2.length();
    }
}
