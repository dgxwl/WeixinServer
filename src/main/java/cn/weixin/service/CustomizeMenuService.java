package cn.weixin.service;

import java.io.IOException;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import cn.weixin.entity.customizemenu.Menu;
import cn.weixin.service.iservice.ICustomizeMenuService;
import cn.weixin.utils.AccessTokenUtil;
import cn.weixin.utils.HttpClientUtil;
import cn.weixin.utils.JsonUtils;

@Service
public class CustomizeMenuService implements ICustomizeMenuService {

	@Override
	public int createMenu(Menu menu) {
		String url = "https://api.weixin.qq.com/cgi-bin/menu/create"
				+ "?access_token=" + AccessTokenUtil.getAccessToken();
		String menuJson = JsonUtils.objectToJson(menu);
		
		String response = JsonUtils.sendJsonHttpPost(url, menuJson);
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			JsonNode node = mapper.readTree(response);
			int errcode = Integer.parseInt(node.get("errcode").toString());
			return errcode;
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return 99;
	}

	@Override
	public int deleteAllMenu() {
		String url = "https://api.weixin.qq.com/cgi-bin/menu/delete"
				+ "?access_token=" + AccessTokenUtil.getAccessToken();
		String result = HttpClientUtil.getGetResponse(url);
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			JsonNode node = mapper.readTree(result);
			int errcode = Integer.parseInt(node.get("errcode").toString());
			return errcode;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return 99;
	}

}
