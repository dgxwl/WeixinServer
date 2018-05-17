package cn.weixin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.weixin.service.iservice.IMainService;
import cn.weixin.utils.SignUtil;

@RequestMapping("/main")
@Controller
public class MainController {
	
	@Autowired
	@Qualifier("mainService")
	private IMainService mainService;

	@RequestMapping("/test")
	@ResponseBody
	public String test() {
		return "hello world";
	}
	
	@RequestMapping(value="/core", method=RequestMethod.GET)
	@ResponseBody
	public String checkSignature(String signature, String timestamp, String nonce, String echostr) {
		if (SignUtil.checkSignature(signature, timestamp, nonce)) {
            return echostr;
        }
		return null;
	}
	
	@RequestMapping(value="/core", method=RequestMethod.POST)
	@ResponseBody
	public String core(@RequestBody String xmlStr) {
		return mainService.processRequest(xmlStr);
	}
}
