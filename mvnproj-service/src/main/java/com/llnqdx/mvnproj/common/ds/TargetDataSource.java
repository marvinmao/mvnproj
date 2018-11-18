package com.llnqdx.mvnproj.common.ds;

import java.lang.annotation.*;

/**
 * 在Impl方法上使用，用于指定使用哪个数据源
 * 
 * @author fujiang.mao
 */
@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TargetDataSource {
    String value();
}
