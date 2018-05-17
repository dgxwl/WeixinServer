package cn.weixin.entity.customizemenu;

import lombok.Data;

/**
 * 包含有二级菜单项的一级菜单.
 * 
 * @author xwl
 *
 */
@Data
public class ComplexButton extends BaseButton {
	private BaseButton[] sub_button;
}
