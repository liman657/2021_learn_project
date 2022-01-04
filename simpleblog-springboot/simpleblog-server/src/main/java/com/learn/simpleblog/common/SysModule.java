package com.learn.simpleblog.common;

/**
 * 系统/项目-模块的枚举类型
 */
public enum SysModule {

    ModuleUser("user","用户模块"),
    ModuleBlog("blog","微博模块"),


    ;

    private String code;
    private String name;

    SysModule(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
