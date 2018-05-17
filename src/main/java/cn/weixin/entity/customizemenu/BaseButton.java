package cn.weixin.entity.customizemenu;

import lombok.Data;

/**
 * 菜单项基类
 * 
 * @author xwl
 *
 */
@Data
public class BaseButton {
	// 所有一级菜单、二级菜单都共有一个相同的属性name
	private String name;

}
