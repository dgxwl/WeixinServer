package cn.weixin.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class AccessTokenUtil {
	// 接口访问凭证
    private static String accessToken;
    // 凭证有效期，单位：秒
	private static int expiresIn;
	// 上次刷新token的时间
	private static long lastRefreshTime = System.currentTimeMillis();
	
	public static String getAccessToken(String appid, String appsecret) {
		//TODO 不改不行...
		synchronized ("lock1") {
			if (accessToken == null || "".equals(accessToken)) {
				refreshAccessToken(appid, appsecret);
			}
		}
		synchronized ("lock2") {
			if ((System.currentTimeMillis()-lastRefreshTime) > expiresIn*1000) {
				refreshAccessToken(appid, appsecret);
			}
		}
		return accessToken;
	}
	
	public static void refreshAccessToken(String appid, String appsecret) {
		try {
			String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential"
					+ "&appid="+ appid +"&secret=" + appsecret;
			String result = HttpClientUtil.getGetResponse(url);
			
			ObjectMapper mapper = new ObjectMapper();
			JsonNode node = mapper.readTree(result);
			accessToken = node.get("access_token").toString().replaceAll("\"", "");
			expiresIn = Integer.parseInt(node.get("expires_in").toString());
			
			lastRefreshTime = System.currentTimeMillis();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
