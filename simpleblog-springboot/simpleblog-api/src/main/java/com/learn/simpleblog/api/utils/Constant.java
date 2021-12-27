package com.learn.simpleblog.api.utils;

import com.google.common.collect.Sets;

import java.text.SimpleDateFormat;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * 常量
 * @Author:debug (SteadyJack) wx：debug0868
 */
public class Constant {

    public static final SimpleDateFormat DATE_FORMAT=new SimpleDateFormat("yyyy-MM-dd");

    public static final SimpleDateFormat DATE_TIME_FORMAT=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    //超级管理员Id
	public static final Long SUPER_ADMIN = 1L;

	//最顶级的部门Id
	public static final long TOP_DEPT_ID = 0;

    //最顶级的菜单Id
    public static final long TOP_MENU_ID = 0;

	//最顶级的部门名称
	public static final String TOP_DEPT_NAME = "一级部门";

    //最顶级的菜单名称
    public static final String TOP_MENU_NAME = "一级菜单";

	//数据权限过滤
	public static final String SQL_FILTER = "sql_filter";

	//当前页码
    public static final String PAGE = "page";

    //每页显示记录数
    public static final String LIMIT = "limit";

    //排序字段
    public static final String ORDER_FIELD = "sidx";

    //排序方式
    public static final String ORDER = "order";

    //升序
    public static final String ASC = "asc";

    //降序
    public static final String DESC = "desc";

    //指定字段
    public static final String FieldUserId="user_id";

    public static final String FieldCreateTime="create_time";

    //指定的菜单Id不能删除
    public static final Set<Long> MenuIds= Sets.newHashSet(1L,2L,3L,4L,29L,31L);

    public static final String Profiles="dev";

    public static final String DefaultPassword="123456";


    //最顶级的课时Id
    public static final int TOP_LESSON_ID = 0;

    //最顶级的课时名称
    public static final String TOP_LESSON_NAME = "一级菜单";


    //当前页码
    public static final String PAGE_START = "pageStart";

    //当前页数据量
    public static final String PAGE_SIZE = "pageSize";

    //上一页
    public static final String PAGE_PREVIOUS  = "pagePrevious";

    //下一页
    public static final String PAGE_NEXT = "pageNext";

    //总页数
    public static final String COUNT_NEXT = "countNext";

    public static final Integer BLOG_CENTER_PAGE_SIZE=30;

    public static final Integer COURSE_CENTER_PAGE_SIZE=20;


    //正则校验字符串-只能由字母、数字组成
    public static final String RegexRoute="[A-Za-z0-9]+";


	/**
	 * 菜单类型
	 */
    public enum MenuType {
        //目录
    	CATALOG(0),
        //菜单
        MENU(1),
        //按钮
        BUTTON(2);

        private int value;

        MenuType(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    /**
     * 打卡状态
     */
    public enum AttendStatus{

        Yes(1,"已打卡"),
        No(0,"未打卡");

        private int code;
        private String msg;

        public static AttendStatus byCode(final int code){
            AttendStatus res=null;
            switch (code){
                case 1:
                    res=Yes;
                    break;
                case 0:
                    res=No;
                    break;
            }
            return res;
        }

        AttendStatus(int code, String msg) {
            this.code = code;
            this.msg = msg;
        }

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }
    }

    //用户消息通知模块
    public enum MsgModule{

        //前四个跳转到微博详情页
        ForwardBlog("forwardBlog","转发微博","/web/user/msg/read?id=%s","%s 转发了你的微博"),
        Comment("comment","发表评论","/web/user/msg/read?id=%s","%s 评论了你的微博，内容为：%s"),
        Reply("reply","评论回复","/web/user/msg/read?id=%s","%s 回复了你的评论，内容为：%s"),
        Praise("praise","点赞微博","/web/user/msg/read?id=%s","%s 喜欢你的微博，并给了你一个赞"),

        //新用户关注的跳转到用户中心
        Concern("concern","新用户关注","/web/user/msg/read?id=%s","有新用户关注了您：%s"),

        ;

        private String code;
        private String msg;
        private String hrefUrl;
        private String content;

        MsgModule(String code, String msg, String hrefUrl, String content) {
            this.code = code;
            this.msg = msg;
            this.hrefUrl = hrefUrl;
            this.content = content;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public String getHrefUrl() {
            return hrefUrl;
        }

        public void setHrefUrl(String hrefUrl) {
            this.hrefUrl = hrefUrl;
        }
    }

    //创建微博、删除微博、屏蔽微博、恢复微博 - 触发事件类型
    public enum BlogIndexMsg{

        Create(1),
        Delete(2),
        UnActive(3),
        Active(4)

        ;

        private Integer type;

        public Integer getType() {
            return type;
        }

        public void setType(Integer type) {
            this.type = type;
        }

        BlogIndexMsg(Integer type) {
            this.type = type;
        }
    }

    //内存队列
    public static final ArrayBlockingQueue<BlogMsg> BLOG_Queue=new ArrayBlockingQueue<BlogMsg>(1000);

}
