package com.zy.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
* @author 郑炎
* @version 创建时间：2018年9月25日 下午3:42:18
* @ClassName 类名称
* @Description 类描述
*/
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface mytest1 {

}
