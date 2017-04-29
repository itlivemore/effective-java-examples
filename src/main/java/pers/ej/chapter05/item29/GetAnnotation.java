package pers.ej.chapter05.item29;

import java.lang.annotation.Annotation;

/**
 * 获取注解
 * Created by laigc on 2017/4/29.
 */
public class GetAnnotation {
    // 利用asSubclass方法在编译时读取类型未知的注解
    static Annotation getAnnotation(AnnotatedElement element, String annotationTypeName) {
        Class<?> annotationType = null;
        try {
            annotationType = Class.forName(annotationTypeName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Class<? extends Annotation> aClass = annotationType.asSubclass(Annotation.class);
        return element.getAnnotation(aClass);
    }
}
