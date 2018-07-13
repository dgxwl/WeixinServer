package cn.weixin.entity.event;

import lombok.Data;
/**
 * 事件基类
 * @author xwl
 *
 */
@Data
public class BaseEvent {
	// 开发者微信号
    private String ToUserName;
    // 发送方帐号（一个OpenID）
    private String FromUserName;
    // 消息创建时间 （整型）
    private long CreateTime;
    // 消息类型
    private String MsgType;
    // 事件类型
    private String Event;
}
