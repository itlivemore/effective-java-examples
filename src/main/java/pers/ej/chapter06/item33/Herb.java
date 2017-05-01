package pers.ej.chapter06.item33;

/**
 * 香草类
 * Created by laigc on 2017/4/30.
 */
public class Herb {
    public enum Type {
        ANNUAL, PERENNIAL, BIENNIAL;
    }

    private final String name;// 香草名称
    private final Type type; // 香草类型

    public Herb(String name, Type type) {
        this.name = name;
        this.type = type;
    }

    @Override
    public String toString() {
        return name;
    }

    public Type getType() {
        return type;
    }
}
