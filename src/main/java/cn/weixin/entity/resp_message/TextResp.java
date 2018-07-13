package cn.weixin.entity.resp_message;

import lombok.Data;
import lombok.EqualsAndHashCode;
/**
 * 被动回复文本消息
 * @author xwl
 *
 */
@Data
@EqualsAndHashCode(callSuper=true)
public class TextResp extends BaseResp {
	// 回复的消息内容
    private String Content;
	// 消息类型
	private final String MsgType = "text";
}
