/**
 * 
 */
package com.learn.demo.security.core.social.qqlogin.connect;

import com.learn.demo.security.core.social.qqlogin.api.QQObtainUser;
import com.learn.demo.security.core.social.qqlogin.api.QQUserInfo;
import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;


/**
 * @author zhailiang
 *
 */
public class QQAdapter implements ApiAdapter<QQObtainUser> {

	@Override
	public boolean test(QQObtainUser api) {
		return true;
	}

	@Override
	public void setConnectionValues(QQObtainUser api, ConnectionValues values) {
		QQUserInfo userInfo = api.getUserInfo();
		
		values.setDisplayName(userInfo.getNickname());
		values.setImageUrl(userInfo.getFigureurl_qq_1());
		values.setProfileUrl(null);
		values.setProviderUserId(userInfo.getOpenId());
	}

	@Override
	public UserProfile fetchUserProfile(QQObtainUser api) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateStatus(QQObtainUser api, String message) {
		//do noting
	}

}
