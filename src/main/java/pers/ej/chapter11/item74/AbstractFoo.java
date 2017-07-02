package pers.ej.chapter11.item74;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 不可序列化但可以扩展的类
 * Created by lgc on 17-7-2.
 */
public class AbstractFoo {
    private int x, y; // 状态参数

    /*表示类状态的枚举*/
    private enum State {
        NEW, INITIALIZING, INITIALIZED
    }

    /*对象的状态，是一个原子引用*/
    private final AtomicReference<State> init = new AtomicReference<>(State.NEW);

    /*正常构造器*/
    public AbstractFoo(int x, int y) {
        initalize(x, y);
    }

    /*提供一个无参构造器*/
    protected AbstractFoo() {
    }

    /*初始化方法，参数同正常的构造器*/
    protected final void initalize(int x, int y) {
        /*public final boolean compareAndSet(V expect, V update)
        set的时候进行对比判断，如果当前值和expect相等，则设置为update值*/
        if (!init.compareAndSet(State.NEW, State.INITIALIZING)) {
            throw new IllegalStateException("Already initialized");
        }
        this.x = x;
        this.y = y;
        init.set(State.INITIALIZED);
    }

    public int getX() {
        // 调用方法前要检查对象状态
        checkInit();
        return x;
    }

    public int getY() {
        checkInit();
        return y;
    }

    /*检查对象状态*/
    private void checkInit() {
        if (init.get() != State.INITIALIZED) {
            throw new IllegalStateException("Uninitialized");
        }
    }
}
















