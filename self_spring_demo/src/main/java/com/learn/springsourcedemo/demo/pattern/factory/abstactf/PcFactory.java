package com.learn.springsourcedemo.demo.pattern.factory.abstactf;

import com.learn.springsourcedemo.demo.pattern.factory.entity.IKeyBoard;
import com.learn.springsourcedemo.demo.pattern.factory.entity.IMouse;

/**
 * autor:liman
 * createtime:2021/4/24
 * comment:生产PC的工厂
 */
public interface PcFactory {

    /**
     * 创建鼠标
     * @return
     */
    IMouse createMouse();

    /**
     * 创建键盘
     * @return
     */
    IKeyBoard createKeyBoard();

}
