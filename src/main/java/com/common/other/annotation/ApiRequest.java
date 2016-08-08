package com.common.other.annotation;

import java.lang.annotation.*;

/**
 * api的参数验证
 * 在需要的controller上面加@ApiRequest，则在com.param下面的paramCheck方法进行参数验证
 */
@Target({ ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ApiRequest {

}
