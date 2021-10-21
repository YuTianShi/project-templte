package com.log.demo.service;

/**
 * IParseFunction.
 *
 * @author shitianyu 2021-10-08 16:54
 */
public interface IParseFunction {

    default boolean executeBefore(){
        return false;
    }

    String functionName();

    String apply(String value);
}
