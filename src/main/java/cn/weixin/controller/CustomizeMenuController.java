package cn.weixin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.weixin.entity.customizemenu.Menu;
import cn.weixin.service.iservice.ICustomizeMenuService;

@RestController
@RequestMapping("/customizemenu")
public class CustomizeMenuController {
	
	@Autowired
	@Qualifier("customizeMenuService")
	private ICustomizeMenuService customizeMenuService;
	
	@RequestMapping("/createmenu")
	public String createMenu(Menu menu, String appid, String appsecret) {  //TODO 临时定义一个返回值, 以后根据设计修改
		int result = customizeMenuService.createMenu(menu, appid, appsecret);
		if (result == 0) {
			//创建成功
			return "创建成功";
		} else {
			//创建失败
			return "创建失败";
		}
	}
	
	@RequestMapping("/deletemenu")
	public String deleteMenu(String appid, String appsecret) {    //TODO 同上
		int result = customizeMenuService.deleteMenu(appid, appsecret);
		if (result == 0) {
			//删除成功
			return "删除成功";
		} else {
			//创建失败
			return "删除失败";
		}
	}
}
