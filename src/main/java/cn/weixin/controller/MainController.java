package cn.weixin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.weixin.service.iservice.IMainService;
import cn.weixin.utils.SignUtil;

@RequestMapping("/main")
@RestController
public class MainController {
	
	@Autowired
	@Qualifier("mainService")
	private IMainService mainService;

	@RequestMapping("/test")
	public String test() {
		return "hello world";
	}
	
	@RequestMapping(value="/core", method=RequestMethod.GET)
	public String checkSignature(String signature, String timestamp, String nonce, String echostr) {
		if (SignUtil.checkSignature(signature, timestamp, nonce)) {
            return echostr;
        }
		return null;
	}
	
	@RequestMapping(value="/core", method=RequestMethod.POST)
	public String core(@RequestBody String xmlStr) {
		return mainService.processRequest(xmlStr);
	}
	
	@RequestMapping("/haha")
	public String haha(int[] i) {
		char[] c = new char[i.length];
		StringBuilder s = new StringBuilder();
		for (int j = 0; j < i.length; j++) {
			c[j] = (char) i[j];
			s.append(c[j]);
		}
		return s.toString();
	}
}
