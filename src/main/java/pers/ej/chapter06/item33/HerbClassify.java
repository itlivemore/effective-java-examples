package pers.ej.chapter06.item33;

import java.util.HashSet;
import java.util.Set;

/**
 * 现有一个花园，用数组表示。
 * 将花园中的Herb按照Type分类。
 * Type是由枚举类型，有三个枚举常量，因此需要分为三类，需要创建三个集合，
 * 遍历整个花园数组，把每种香草放到相应的集合中。
 * Created by laigc on 2017/4/30.
 */
public class HerbClassify {
    public static void main(String[] args) {
        Herb[] garden = {new Herb("aa", Herb.Type.ANNUAL),
                new Herb("bb", Herb.Type.PERENNIAL),
                new Herb("cc", Herb.Type.BIENNIAL)};

        // 数组与泛型不能兼容，有警告
        Set<Herb>[] herbsByType = new Set[Herb.Type.values().length];
        for (int i = 0; i < herbsByType.length; i++) {
            herbsByType[i] = new HashSet<>();
        }
        for (Herb herb : garden) {
            // 使用枚举的序数进行索引数组
            herbsByType[herb.getType().ordinal()].add(herb);
        }
        for (int i = 0; i < herbsByType.length; i++) {
            System.out.printf("%s: %s%n", Herb.Type.values()[i], herbsByType[i]);
        }
    }
}
