package cn.weixin.entity.message;

import lombok.Data;
import lombok.EqualsAndHashCode;
/**
 * 文本消息类
 * @author xwl
 *
 */
@Data
@EqualsAndHashCode(callSuper=true)
public class TextMessage extends BaseMessage {
	// 消息内容
    private String Content;
}
