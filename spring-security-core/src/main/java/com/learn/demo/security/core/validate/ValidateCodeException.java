package com.learn.demo.security.core.validate;


import org.springframework.security.core.AuthenticationException;

/**
 * autor:liman
 * createtime:2021/5/16
 * comment:
 */
public class ValidateCodeException extends AuthenticationException {

    public ValidateCodeException(String detail) {
        super(detail);
    }
}
