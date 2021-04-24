package com.learn.springsourcedemo.demo.pattern.factory.abstactf;

import com.learn.springsourcedemo.demo.pattern.factory.entity.DellKeyBoard;
import com.learn.springsourcedemo.demo.pattern.factory.entity.DellMouse;
import com.learn.springsourcedemo.demo.pattern.factory.entity.IKeyBoard;
import com.learn.springsourcedemo.demo.pattern.factory.entity.IMouse;
import lombok.extern.slf4j.Slf4j;

/**
 * autor:liman
 * createtime:2021/4/24
 * comment:
 */
@Slf4j
public class DellPcFactory implements PcFactory {

    @Override
    public IMouse createMouse() {
        return new DellMouse();
    }

    @Override
    public IKeyBoard createKeyBoard() {
        return new DellKeyBoard();
    }
}
