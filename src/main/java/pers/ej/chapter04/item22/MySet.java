package item22;

import java.util.AbstractSet;
import java.util.Iterator;

/**
 * 非静态内部类的常见用法是定义一个Adapter，它允许外部类的实例被看作是另一个不相关的类的实例
 * Created by laigc on 2017/4/23.
 */
public class MySet<E> extends AbstractSet<E> {
    @Override
    public Iterator iterator() {
        return new MyIterator();
    }

    // 非静态内部类
    private class MyIterator implements Iterator<E> {

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public E next() {
            return null;
        }

    }

    @Override
    public int size() {
        return 0;
    }
}
