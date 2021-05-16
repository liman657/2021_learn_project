/**
 * 
 */
package com.learn.demo.security.core.properties;

/**
 * 图片验证码配置项
 * 长，宽，验证码长度，过期时间
 * 
 * @author zhailiang
 *
 */
public class ImageCodeProperties extends SmsCodeProperties {
	
	public ImageCodeProperties() {
		setLength(4);
	}
	
	/**
	 * 图片宽
	 */
	private int width = 67;
	/**
	 * 图片高
	 */
	private int height = 23;

	private int length = 4;

	private int expireTime = 60;

	//需要验证码校验的url
	private String url;
	
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}

	@Override
	public int getLength() {
		return length;
	}

	@Override
	public void setLength(int length) {
		this.length = length;
	}

	public int getExpireTime() {
		return expireTime;
	}

	public void setExpireTime(int expireTime) {
		this.expireTime = expireTime;
	}
}
