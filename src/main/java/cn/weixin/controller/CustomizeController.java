package cn.weixin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.weixin.entity.customizemenu.Menu;
import cn.weixin.service.iservice.ICustomizeService;

@Controller
@RequestMapping("/customizemenu")
public class CustomizeController {
	
	@Autowired
	@Qualifier("customizeService")
	private ICustomizeService customizeService;
	
	@RequestMapping("/createmenu")
	@ResponseBody
	public String createMenu(Menu menu, String appid, String appsecret) {  //TODO 临时定义一个返回值,以后根据设计修改
		int result = customizeService.createMenu(menu, appid, appsecret);
		if (result == 0) {
			//创建成功
			return "创建成功";
		} else {
			//创建失败
			return "创建失败";
		}
	}
}
