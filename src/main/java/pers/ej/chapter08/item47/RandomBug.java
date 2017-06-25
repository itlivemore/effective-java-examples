package pers.ej.chapter08.item47;

import java.util.Random;

/**
 * 产生位于0和某个上界之间的随机整数
 * Created by lgc on 17-6-17.
 */
public class RandomBug {
    private static final Random rnd = new Random();

    /*产生位于0和某个上界之间的随机整数,该方法有3个缺陷
    * 1.如果n是一个比较小的2的乘方，经过一段相当短的周期之后，它产生的随机数序列会重复。
    * 2.如果n不是2的乘方，平均起来有些数出现得更为频繁。
    * 3.极少情况下，返回一个不在范围内的数。netxInt()返回Integer.MIN_VALUE,abs()也会返回
    * Integer.MIN_VALUE,如果n不是2的乘方，取模将返回一个负数
    * 可以使用Random.nextInt(n)来代替*/
    private static int random(int n) {
        return Math.abs(rnd.nextInt()) % n;
    }

    public static void main(String[] args) {
        // 针对缺陷2测试
        int n = 2 * (Integer.MAX_VALUE / 3);
        int low = 0;
        for (int i = 0; i < 1000000; i++) {
            if (random(n) < n / 2) {
                low++;
            }
        }
        System.out.println(low);
        // 打印的结果是667179,说明大约有2/3的数字落在前半部分

        low = 0;
        for (int i = 0; i < 1000000; i++) {
            if (rnd.nextInt(n) < n / 2) {
                low++;
            }
        }
        System.out.println(low);
        // 打印的结果是499797,差不多正好是1/2


        // 针对缺陷3测试
        n = 1023;
        Integer abs = Math.abs(Integer.MIN_VALUE);
        System.out.println(abs.equals(Integer.MIN_VALUE) + " : " + abs.equals(Integer.MAX_VALUE));
        // 打印的是true:false，说明Math.abs(Integer.MIN_VALUE)=Integer.MIN_VALUE
        System.out.println(abs % n);
        // 打印的结果是-2，不在0-1023范围内

        // 测试Math.abs()取绝对值
        System.out.println(Math.abs(-123));
        // 打印123,说明Math.abs(Integer.MIN_VALUE)=Integer.MIN_VALUE属于特例
    }
}
