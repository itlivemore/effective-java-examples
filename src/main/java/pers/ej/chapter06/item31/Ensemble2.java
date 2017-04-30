package pers.ej.chapter06.item31;

/**
 * 不根据ordinal()方法返回的顺序，而是将顺序保存到域中
 * Created by laigc on 2017/4/30.
 */
public enum Ensemble2 {
    SOLO(1), DUET(2), TRIO(3), QUARTET(4), QUINTET(5), SEXTET(6), SEPTET(7), OCTET(
            8), DOUBLE_QUARTET(8), NONET(9), DECTET(10), TRIPLE_QUARTET(12);

    private final int numberOfMusicians;

    Ensemble2(int numberOfMusicians) {
        this.numberOfMusicians = numberOfMusicians;
    }

    public int numberOfMusicians() {
        return numberOfMusicians;
    }

    public static void main(String[] args) {
        int i = Ensemble2.DUET.numberOfMusicians();
        System.out.println(i);
    }
}
