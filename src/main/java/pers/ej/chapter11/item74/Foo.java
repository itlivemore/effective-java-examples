package pers.ej.chapter11.item74;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 继承不可序列化父类，本身需要序列化
 * Created by lgc on 17-7-2.
 */
public class Foo extends AbstractFoo implements Serializable {
    private static final long serialVersionUID = 1672997997555918326L;

    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        stream.defaultReadObject();
        int x = stream.readInt();
        int y = stream.readInt();
        initalize(x, y);
    }

    private void writeObject(ObjectOutputStream stream) throws IOException {
        stream.defaultWriteObject();
        stream.writeInt(getX());
        stream.writeInt(getY());
    }

    public Foo(int x, int y) {
        super(x, y);
    }
}



















