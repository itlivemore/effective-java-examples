package pers.ej.chapter06.item33;

import java.util.EnumMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * EnumMap专门用于枚举作键
 * Created by laigc on 2017/4/30.
 */
public class HerbClassify2 {
    public static void main(String[] args) {
        Herb[] garden = {new Herb("aa", Herb.Type.ANNUAL),
                new Herb("bb", Herb.Type.PERENNIAL),
                new Herb("cc", Herb.Type.BIENNIAL)};

        Map<Herb.Type, Set<Herb>> herbsByType = new EnumMap<>(Herb.Type.class);
        for (Herb.Type type : Herb.Type.values()) {
            herbsByType.put(type, new HashSet<>());
        }

        for (Herb herb : garden) {
            herbsByType.get(herb.getType()).add(herb);
        }
        System.out.println(herbsByType);
    }
}
