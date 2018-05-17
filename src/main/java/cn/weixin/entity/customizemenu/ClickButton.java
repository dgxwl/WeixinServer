package cn.weixin.entity.customizemenu;

import lombok.Data;

/**
 * click类型:点击推事件用户点击click类型按钮后,微信服务器会通过消息接口推送消息类型为event的结构给开发者,
 * 并且带上按钮中开发者填写的key值,开发者可以通过自定义的key值与用户进行交互.
 * 
 * @author xwl
 *
 */
@Data
public class ClickButton extends BaseButton {
	private final String type = "click";
	private String key;
}
