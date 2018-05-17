package test;

import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.weixin.entity.customizemenu.BaseButton;
import cn.weixin.entity.customizemenu.ClickButton;
import cn.weixin.entity.customizemenu.ComplexButton;
import cn.weixin.entity.customizemenu.Menu;
import cn.weixin.entity.customizemenu.ViewButton;
import cn.weixin.service.iservice.ICustomizeService;
import cn.weixin.utils.AccessTokenUtil;

public class Testt {
	
	@Test
	public void crateButton() {
		Menu menu = new Menu();
		BaseButton[] btns = new BaseButton[2];
		ClickButton cb1 = new ClickButton();
		cb1.setName("今日歌曲");
		cb1.setKey("V1001_TODAY_MUSIC");
		btns[0] = cb1;
		ComplexButton comb = new ComplexButton();
		comb.setName("菜单");
		BaseButton[] sbs = new BaseButton[2];
		ViewButton vb = new ViewButton();
		vb.setName("搜索");
		vb.setUrl("http://www.soso.com/");
		sbs[0] = vb;
		ClickButton cb2 = new ClickButton();
		cb2.setName("赞一下我们");
		cb2.setKey("V1001_GOOD");
		sbs[1] = cb2;
		comb.setSub_button(sbs);
		btns[1] = comb;
		menu.setButton(btns);
		
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("spring-service.xml");
		ICustomizeService customizeService = ac.getBean("customizeService", ICustomizeService.class);
		int i = customizeService.createMenu(menu, "wx1ca982e86d1e626a", "25f1641186c3b4b356b8187b5f09f6c4");
		System.out.println(i);
		ac.close();
	}
	
	@Test
	public void testToken() {
		AccessTokenUtil.refreshAccessToken("wx1ca982e86d1e626a", "25f1641186c3b4b356b8187b5f09f6c4");
	}
}
