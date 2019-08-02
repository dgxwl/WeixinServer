package cn.weixin.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class AccessTokenUtil {
	private static String appid;
	private static String appsecret;
	
	static {
		Properties properties = new Properties();
		InputStream in = AccessTokenUtil.class.getClassLoader().getResourceAsStream("application.properties");
		try {
			properties.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
		appid = properties.getProperty("wx.appid");
		appsecret = properties.getProperty("wx.appsecret");
	}
	
	// 接口访问凭证
    private static String accessToken;
    // 凭证有效期，单位：秒
	private static int expiresIn;
	// 上次刷新token的时间
	private static long lastRefreshTime = System.currentTimeMillis();
	
	public static String getAccessToken() {
		if (accessToken == null) {
			synchronized ("lockInit") {
				if (accessToken == null) {
					refreshAccessToken();
				}
			}
		}
		
		if ((System.currentTimeMillis()-lastRefreshTime) > expiresIn*1000) {
			refreshAccessToken();
		}
		return accessToken;
	}
	
	public static void refreshAccessToken() {
		try {
			String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential"
					+ "&appid="+ appid +"&secret=" + appsecret;
			String result = HttpClientUtil.getGetResponse(url);
			if (result == null) throw new RuntimeException("刷新token出现网络异常");
			
			JSONObject jsonResult = JSON.parseObject(result);
			synchronized ("lockRefresh") {
				accessToken = jsonResult.getString("access_token");
				expiresIn = jsonResult.getIntValue("expires_in");
			}
			
			lastRefreshTime = System.currentTimeMillis();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
