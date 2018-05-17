package cn.weixin.entity.resp_message;

import lombok.Data;

/**
 * 被动回复消息基类
 * 
 * @author xwl
 *
 */
@Data
public class BaseResp {
	// 接收方帐号（收到的OpenID）
	private String ToUserName;
	// 开发者微信号
	private String FromUserName;
	// 消息创建时间 （整型）
	private long CreateTime;
}
