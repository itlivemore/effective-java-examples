package pers.ej.chapter11.item77;

import java.io.*;

/**
 * 反序列化破坏单例模式
 * Created by lgc on 17-7-2.
 */
public class Elvis implements Serializable {
    public static final Elvis INSTANCE = new Elvis();
    private static final long serialVersionUID = -7029328840767027456L;

    private Elvis() {
    }

    /*如果删除这个方法，程序返回false，有这个方法，程序返回true*/
    private Object readResolve() {
        return INSTANCE;
    }

    public static void main(String[] args) throws Exception {
        String filePath = "test.txt";
        // 序列化
        FileOutputStream fileOutputStream = new FileOutputStream(filePath);
        ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);
        outputStream.writeObject(Elvis.INSTANCE);
        outputStream.flush();
        outputStream.close();
        fileOutputStream.close();

        // 反序列化
        FileInputStream fileInputStream = new FileInputStream(filePath);
        ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);
        Elvis elvis2 = (Elvis) inputStream.readObject();
        inputStream.close();
        fileInputStream.close();
        // 判断是否同一对象
        System.out.println(Elvis.INSTANCE == elvis2);
    }
}
