package pers.ej.chapter05.item28;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.EmptyStackException;

/**
 * 堆栈类
 * Created by laigc on 2017/4/29.
 */
public class Stack<E> {
    private E[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public Stack() {
        // Object[]转为E[]
        elements = (E[]) new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(E e) {
        ensureCapacity();
        elements[size++] = e;
    }

    public E pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        E result = elements[--size];
        elements[size] = null;
        return result;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void ensureCapacity() {
        if (elements.length == size) {
            elements = Arrays.copyOf(elements, 2 * size + 1);
        }
    }

    //一个按顺序将一系列元素全部放到堆栈中的方法,限制了Iterable<E>，只能添加E类型
    public void pushAll(Iterable<E> src) {
        for (E e : src) {
            push(e);
        }
    }

    //一个按顺序将一系列元素全部放到堆栈中的方法,限制了Iterable<? extends E>,可以添加E的子类型
    public void pushAll2(Iterable<? extends E> src) {
        for (E e : src) {
            push(e);
        }
    }

    // 从堆栈中弹出元素，并将这些元素元素添加到指定的集合，这里限制Collection<E>
    public void popAll(Collection<E> dst) {
        while (!isEmpty()) {
            dst.add(pop());
        }
    }

    // 从堆栈中弹出元素，并将这些元素元素添加到指定的集合，这里限制Collection<? super E>,E元素的父类集合
    public void popAll2(Collection<? super E> dst) {
        while (!isEmpty()) {
            dst.add(pop());
        }
    }


    public static void main(String[] args) {
        Stack<Number> numberStack = new Stack<>();
        Iterable<Integer> integers = Arrays.asList(1, 2, 3);
        // 编译出错，因为创建的是Stack<Number>，pushAll方法的参数必须是Iterable<Number>
//        numberStack.pushAll(integers);
        numberStack.pushAll2(integers);

        Collection<Object> objects = new ArrayList<>();
        // 编译出错，同pushAll()方法
//        numberStack.popAll(objects);
        numberStack.popAll2(objects);

    }
}
