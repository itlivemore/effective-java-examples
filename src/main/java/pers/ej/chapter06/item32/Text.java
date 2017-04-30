package pers.ej.chapter06.item32;

/**
 * 位域
 * Created by laigc on 2017/4/30.
 */
public class Text {
    public static final int STYLE_BOLD = 1 << 0;
    public static final int STYLE_ITALIC = 1 << 1;
    public static final int STYLE_UNDERLINE = 1 << 2;
    public static final int STYLE_STRIKETHROUCH = 1 << 3;

    public void applyStyles(int styles) {
        System.out.println(styles);
    }

    public static void main(String[] args) {
        Text text = new Text();
        // 用OR位运算符将几个常量合并到一个集合中，称作位域
        text.applyStyles(STYLE_BOLD | STYLE_ITALIC);
        // 打印的是3，1 | 2 = 3
    }
}
