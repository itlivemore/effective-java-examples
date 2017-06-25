package pers.ej.chapter07.item41;

import java.util.*;

/**
 * 要调用哪个重载方法是在编译时做出决定的。
 * Created by lgc on 17-6-10.
 */
public class CollectionClassifier {
    public static String classify(Set<?> set) {
        return "Set";
    }

    public static String classify(List<?> list) {
        return "List";
    }

    public static String classify(Collection<?> collection) {
        return "unknow collection";
    }

    public static void main(String[] args) {
        Collection<?>[] collections = {new HashSet<String>(),
                new ArrayList<Integer>(), new HashMap<String, Integer>().values()};

        for (Collection<?> collection : collections) {
            System.out.println(classify(collection));
        }
    }
}



















