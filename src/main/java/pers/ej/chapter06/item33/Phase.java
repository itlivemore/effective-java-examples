package pers.ej.chapter06.item33;

/**
 * 按照序数进行索引的数组的数组，该序数表示两个枚举值的映射。
 * 本例中的数组，将两个阶段映射到一个阶段过渡中（从液体到固体称作凝固，从液体到气体称作沸腾）
 * Created by laigc on 2017/5/1.
 */
public enum Phase {
    SOLID, LIQUID, GAS;

    public enum Transition {
        MELT, // 溶解
        FREEZE,// 凝固
        BOIL,// 沸腾
        CONDENSE,// 凝结
        SUBLIME, // 升华
        DEPOSIT;//凝华
    }

    // 来索引状态变化名称的数组
    private static final Transition[][] TRANSITIONS = {
            {null, Transition.MELT, Transition.SUBLIME},
            {Transition.FREEZE, null, Transition.BOIL},
            {Transition.DEPOSIT, Transition.CONDENSE, null}
    };

    // 使用的是枚举的ordinal()来索引数组，如果枚举常量增加或删除了，则要整个的维护TRANSITIONS数组
    public static Transition from(Phase src, Phase dst) {
        return TRANSITIONS[src.ordinal()][dst.ordinal()];
    }

    public static void main(String[] args) {
        System.out.println(Phase.from(Phase.LIQUID, Phase.GAS));
    }
}
