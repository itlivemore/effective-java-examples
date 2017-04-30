package pers.ej.chapter06.item30;

/**
 * 行星枚举类型.
 * 太阳系中有8颗行星，每颗行星都有质量和半径，通过这两个属性可以计算出它的表面重力。
 * 从而给定物体的质量，就可以计算出一个物体在行星表面上的重量。
 * Created by laigc on 2017/4/30.
 */
public enum Planet {
    MERCURY(3.302e+23, 2.439e6), VENUS(4.869e+24, 6.052e6), EARTH(5.975e+24,
            6.378e6), MARS(6.419e+23, 3.393e6), JUPITER(1.899e+27, 7.149e7), SATURN(
            5.685e+26, 6.027e7), URANUS(8.683e+25, 2.556e7), NEPTUNE(1.024e+26,
            2.477e7);
    // 因为枚举是不可变的，所以域声明是final的
    private final double mass; // 质量，单位千克
    private final double radius; // 半径，单位米
    private final double surfaceGravity; // 表面重力

    // 万有引力常数m^3 / kg s^2
    private static final double G = 6.67300E-11;

    // 带有参数的构造器，初始化域
    Planet(double mass, double radius) {
        this.mass = mass;
        this.radius = radius;
        surfaceGravity = G * mass / (radius * radius);
    }

    public double mass() {
        return mass;
    }

    public double radius() {
        return radius;
    }

    public double surfaceGravity() {
        return surfaceGravity;
    }

    public double surfaceWeight(double mass) {
        return mass * surfaceGravity; // F = ma
    }
}
