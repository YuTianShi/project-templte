package com.log.demo.aspect;

import org.springframework.aop.support.StaticMethodMatcherPointcut;
import org.springframework.util.CollectionUtils;

import java.io.Serializable;
import java.lang.reflect.Method;

/**
 * LogRecordPointcut.
 *
 * @author shitianyu 2021-10-08 14:28
 */
public class LogRecordPointcut extends StaticMethodMatcherPointcut implements Serializable {

    // LogRecord的解析类
    //private LogRecordOperationSource logRecordOperationSource;

    @Override
    public boolean matches(Method method, Class<?> targetClass) {
        // 解析 这个 method 上有没有 @LogRecordAnnotation 注解，有的话会解析出来注解上的各个参数
        //return !CollectionUtils.isEmpty(logRecordOperationSource.computeLogRecordOperations(method, targetClass));
        return false;
    }

    /*void setLogRecordOperationSource(LogRecordOperationSource logRecordOperationSource) {
        //this.logRecordOperationSource = logRecordOperationSource;
    }*/

}
