package pers.ej.chapter05.item29;

import java.lang.annotation.Annotation;

/**
 * 一个接口
 * Created by laigc on 2017/4/29.
 */
public interface AnnotatedElement {
    // 读取注解的方法
    public <T extends Annotation> T getAnnotation(Class<T> annotationType);
}
