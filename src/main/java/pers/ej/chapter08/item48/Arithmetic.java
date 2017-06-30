package pers.ej.chapter08.item48;

import java.math.BigDecimal;

/**
 * 求解问题：假设你有1元钱，去买糖果，糖果标价为1角，2角，3角等直到1元。
 * 你打算从标价为1角的糖果开始，每种买1颗，一直买到不能支付下一个糖果价钱为止，
 * 那么你可以买几颗糖果？还会找回多少零钱？
 * Created by lgc on 17-6-17.
 */
public class Arithmetic {

    /*使用double计算，可以买3颗糖果，找零：0.3999...结果不对*/
    private static void useDouble() {
        double funds = 1.00;
        int itemsBought = 0;
        for (double price = 0.1; funds >= price; price += 0.1) {
            funds -= price;
            itemsBought++;
        }
        System.out.println("itemsBought : " + itemsBought);
        System.out.println("Change : " + funds);
    }

    /*使用BigDecimal计算,可以买4颗糖果，找零：0*/
    private static void useBigDecimal() {
        // 特别要注意这里new BigDecimal("String")使用的是字符串
        final BigDecimal TEN_CENTS = new BigDecimal("0.1");
        BigDecimal funds = new BigDecimal("1");
        int itemsBought = 0;

        for (BigDecimal price = new BigDecimal("0.1");
             funds.compareTo(price) >= 0; price = price.add(TEN_CENTS)) {
            funds = funds.subtract(price);
            itemsBought++;
        }
        System.out.println("itemsBought : " + itemsBought);
        System.out.println("Change : " + funds);
    }

    /*也可以使用最小单位为分，用int类型计算*/
    private static void useInteger() {
        int funds = 100;
        int itemsBought = 0;
        for (int price = 10; funds >= price; price += 10) {
            funds -= price;
            itemsBought++;
        }
        System.out.println("itemsBought : " + itemsBought);
        System.out.println("Change : " + funds);
    }

    public static void main(String[] args) {
        useDouble();
        useBigDecimal();
        useInteger();
    }
}

