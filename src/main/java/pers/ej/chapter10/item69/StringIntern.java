package pers.ej.chapter10.item69;

/**
 * String.intern()方法
 * Created by lgc on 17-7-1.
 */
public class StringIntern {
    public static void main(String[] args) {
        String str1 = "abc";
        String str2 = new String("abc");
        // 返回true，说明是同一对象
        System.out.println(str1 == str1.intern());
        // 返回的是false
        System.out.println(str1 == str2);
    }
}
