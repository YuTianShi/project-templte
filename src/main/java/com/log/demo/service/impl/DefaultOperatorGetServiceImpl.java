package com.log.demo.service.impl;

import com.log.demo.service.IOperatorGetService;

import java.util.Optional;

/**
 * DefaultOperatorGetServiceImpl.
 *
 * @author shitianyu 2021-10-08 16:26
 */
public class DefaultOperatorGetServiceImpl implements IOperatorGetService {

    /*@Override
    public Operator getUser() {
        //UserUtils 是获取用户上下文的方法
        return Optional.ofNullable(UserUtils.getUser())
                .map(a -> new Operator(a.getName(), a.getLogin()))
                .orElseThrow(()->new IllegalArgumentException("user is null"));

    }*/

}
