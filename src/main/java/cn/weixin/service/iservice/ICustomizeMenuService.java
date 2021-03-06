package cn.weixin.service.iservice;

import cn.weixin.entity.customizemenu.Menu;

public interface ICustomizeMenuService {
	/**
	 * 创建自定义菜单
	 * @param menu
	 * @return 返回0创建成功, 否则创建失败.
	 */
	public int createMenu(Menu menu);
	
	/**
	 * 删除自定义菜单(删除默认菜单及全部个性化菜单)
	 * @return 返回0删除成功, 否则删除失败.
	 */
	public int deleteAllMenu();
}
