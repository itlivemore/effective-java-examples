package pers.ej.item23;

import java.util.ArrayList;
import java.util.List;

/**
 * 使用原生类型List，会失掉安全性，而使用List<Object>则不会
 * Created by laigc on 2017/4/23.
 */
public class UseRawType {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        // 使用原生类型能够添加Integer对象
        unsafeAdd(strings, new Integer(2));
        String str = strings.get(0);

        // List<Object>不能添加
//        unsafeAdd2(strings, new Integer(2));

    }

    // 使用原生类型List
    private static void unsafeAdd(List list, Object o) {
        // 这里有警告，Unchecked call to 'add(E)' as a member of raw type 'java.util.List'
        list.add(o);
    }

    // 使用List<Object>
    private static void unsafeAdd2(List<Object> list, Object o) {
        list.add(o);
    }
}
