package com.learn.springsourcedemo;

import com.learn.springsourcedemo.entity.bo.HeadLine;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/hello")
@Slf4j
public class HelloServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        System.out.println("初始化Servlet ...");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name="这里是简单的框架";
        log.info("是我执行了service方法，我才是入口");
//        req.setAttribute("name",name);
//        req.getRequestDispatcher("/WEB-INF/jsp/hello.jsp").forward(req,resp);
//        System.out.println("是我执行了doGet方法，我才是入口");
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = "我的简易框架";
        log.debug("name is " + name);
        req.setAttribute("name", name);
        /**
         * TODO：
         * 如果将@WebServlet改成"/*" 会出现如下问题：
         *  转发会重新调用servlet中的service方法，service中又会调用doGet
         * 但是改成"/"就不会
         * 改成"/"，是无法拦截.jsp的请求的
         */
        req.getRequestDispatcher("/WEB-INF/jsp/hello.jsp").forward(req, resp);
        HeadLine headLine = new HeadLine();
        headLine.setLineId(1L);
        headLine.getLineId();
    }

    @Override
    public  void destroy(){
        System.out.println("Destroy...");
    }
}
