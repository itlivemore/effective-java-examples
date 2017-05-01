package pers.ej.chapter06.item33;

import java.util.EnumMap;
import java.util.Map;

/**
 * 使用EnumMap来修改Phase
 * Created by laigc on 2017/5/1.
 */
public enum Phase2 {
    SOLID, LIQUID, GAS;

    public enum Transition {
        MELT(SOLID, LIQUID), // 溶解
        FREEZE(LIQUID, SOLID),// 凝固
        BOIL(LIQUID, GAS),// 沸腾
        CONDENSE(GAS, LIQUID),// 凝结
        SUBLIME(SOLID, GAS), // 升华
        DEPOSIT(GAS, SOLID);//凝华

        private final Phase2 src;
        private final Phase2 dst;

        Transition(Phase2 src, Phase2 dst) {
            this.src = src;
            this.dst = dst;
        }

        public Phase2 getSrc() {
            return src;
        }

        public Phase2 getDst() {
            return dst;
        }
    }

    // 初始化map
    private static final Map<Phase2, EnumMap<Phase2, Transition>> map = new EnumMap<>(Phase2.class);

    static {
        for (Phase2 phase2 : Phase2.values()) {
            map.put(phase2, new EnumMap<>(Phase2.class));
        }
        for (Transition transition : Transition.values()) {
            map.get(transition.getSrc()).put(transition.getDst(), transition);
        }
    }

    public static Transition from(Phase2 src, Phase2 dst) {
        return map.get(src).get(dst);
    }

    public static void main(String[] args) {
        System.out.println(Phase2.from(Phase2.LIQUID, Phase2.GAS));
    }
}
