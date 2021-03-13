package org.deleted.bots.annotation;

import java.lang.annotation.*;

@Inherited//子类可以继承父类注解
@Target(ElementType.TYPE)//只在类上有作用
@Retention(RetentionPolicy.RUNTIME)//在什么时期起作用 运行期有效
public @interface Plug {
}
