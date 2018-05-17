package cn.weixin.entity.customizemenu;

import lombok.Data;

/**
 * 整个菜单对象的封装;菜单对象包含多个菜单项(最多只能有3个), 这些菜单项既可以是不含二级菜单的一级菜单,也可以是包含二级菜单的菜单项.
 * 
 * @author xwl
 *
 */
@Data
public class Menu {
	private BaseButton[] button;
}
