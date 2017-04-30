package pers.ej.chapter06.item32;

import java.util.EnumSet;
import java.util.Set;

/**
 * 用枚举代替位域
 * Created by laigc on 2017/4/30.
 */
public class Text2 {
    public enum Style {
        STYLE_BOLD,
        STYLE_ITALIC,
        STYLE_UNDERLINE,
        STYLE_STRIKETHROUCH;
    }

    // 参数使用的是接口Set，而不是具体的EnumSet
    public void applyStyles(Set<Style> styles) {
        System.out.println(styles);
    }

    public static void main(String[] args) {
        Text2 text = new Text2();
        text.applyStyles(EnumSet.of(Style.STYLE_BOLD, Style.STYLE_ITALIC));
    }
}
