package pers.ej.chapter05.item29;

import java.util.HashMap;
import java.util.Map;

/**
 * Favorites是类型安全的，当你向它请求String的时候，它从来不会返回一Integer。
 * 同时它也是异构的，不像普通的map，它的所有键都是不同类型的。
 * Favorites是类型安全的异构容器.
 * Created by laigc on 2017/4/29.
 */
public class Favorites {
    private Map<Class<?>, Object> favorites = new HashMap<>();

    // 第一个参数是类型，第二个参数是该类型的实例，使用泛型能够保证实例属于该类型
    public <T> void putFavorite(Class<T> type, T instance) {
        if (type == null) {
            throw new NullPointerException("type is null");
        }
        favorites.put(type, instance);
    }

    public <T> T getFavorite(Class<T> type) {
        Object value = favorites.get(type);
        // Class的cast方法，将对象引用动态地转换成了Class对象所表示的类型
        T cast = type.cast(value);
        return cast;
    }

    public static void main(String[] args) {
        Favorites favorites = new Favorites();
        favorites.putFavorite(String.class, "Java");
        favorites.putFavorite(Integer.class, 1);
        favorites.putFavorite(Class.class, Favorites.class);
        String favoriteString = favorites.getFavorite(String.class);
        Integer favoriteInteger = favorites.getFavorite(Integer.class);
        Class favoriteClass = favorites.getFavorite(Class.class);
        System.out.println(favoriteString + " , " + favoriteInteger + " , " + favoriteClass);
    }
}
