///**
// *
// */
//package com.learn.demo.security;
//
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
//import org.springframework.stereotype.Component;
//
//import com.learn.demo.security.core.authorize.AuthorizeConfigProvider;
//
///**
// * @author zhailiang
// *
// */
//@Component
//public class DemoAuthorizeConifgProvider implements AuthorizeConfigProvider {
//
//	/* (non-Javadoc)
//	 * @see com.learn.demo.security.core.authorize.AuthorizeConfigProvider#config(org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer.ExpressionInterceptUrlRegistry)
//	 */
//	@Override
//	public boolean config(ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry config) {
//		//demo项目授权配置
//		return false;
//	}
//
//}
