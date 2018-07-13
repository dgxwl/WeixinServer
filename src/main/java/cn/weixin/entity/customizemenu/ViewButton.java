package cn.weixin.entity.customizemenu;

import lombok.Data;

/**
 * view类型:跳转URL用户点击view类型按钮后，微信客户端将会打开开发者在按钮中填写的网页URL，可与网页授权获取用户基本信息接口结合，获得用户基本信息。
 * 
 * @author xwl
 *
 */
@Data
public class ViewButton extends BaseButton {
	private final String type = "view";
	private String url;
}
