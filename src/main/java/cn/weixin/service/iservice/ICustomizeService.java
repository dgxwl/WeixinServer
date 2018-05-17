package cn.weixin.service.iservice;

import cn.weixin.entity.customizemenu.Menu;

public interface ICustomizeService {
	/**
	 * 创建自定义菜单
	 * @param menu
	 * @param appid
	 * @param appsecret
	 * @return 返回0创建成功, 否则创建失败.
	 */
	public int createMenu(Menu menu, String appid, String appsecret);
	
	/**
	 * 删除自定义菜单(删除默认菜单及全部个性化菜单)
	 * @param appid
	 * @param appsecret
	 * @return 返回0删除成功, 否则删除失败.
	 */
	public int deleteMenu(String appid, String appsecret);
}
