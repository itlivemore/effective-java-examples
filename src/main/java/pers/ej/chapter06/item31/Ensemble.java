package pers.ej.chapter06.item31;

/**
 * 枚举类型的ordinal()方法
 * Created by laigc on 2017/4/30.
 */
public enum Ensemble {
    SOLO, DUET, TRIO, QUARTET, QUINTET, SEXTET, SEPTET, OCTET, NONET, DECTET;

    public int numberOfMusicians() {
        //ordinal()返回每个枚举常量在类型中的数字位置，从0开始
        return ordinal() + 1;
    }

    public static void main(String[] args) {
        int i = Ensemble.DUET.numberOfMusicians();
        System.out.println(i);
    }
}
