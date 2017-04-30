package pers.ej.chapter06.item30;

/**
 * 测试Planet，根据某个物体在地球上的重量，打印其在8颗行星上的重量。
 * Created by laigc on 2017/4/30.
 */
public class WeightTable {
    public static void main(String[] args) {
        double earthWeight = 175;
        double mass = earthWeight / Planet.EARTH.surfaceGravity();
        for (Planet planet : Planet.values()) {
            System.out.printf("Weight on %s is %f%n", planet, planet.surfaceWeight(mass));
        }
    }
}
