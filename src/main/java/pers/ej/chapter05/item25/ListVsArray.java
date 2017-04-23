package pers.ej.chapter05.item25;

/**
 * 数组是协变的
 * Created by laigc on 2017/4/23.
 */
public class ListVsArray {
    public static void main(String[] args) {
        // 数组是协变的，运行时才能发现错误
        Object[] objectArray = new Long[1];
        objectArray[0] = "I don't fit in";

        // 不能编译
//        List<Object> objectList = new ArrayList<Long>();
//        objectList.add("I don't fit in");
    }
}
