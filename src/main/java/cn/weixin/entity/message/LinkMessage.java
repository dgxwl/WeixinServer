package cn.weixin.entity.message;

import lombok.Data;
import lombok.EqualsAndHashCode;
/**
 * 链接消息
 * @author xwl
 *
 */
@Data
@EqualsAndHashCode(callSuper=true)
public class LinkMessage extends BaseMessage {
	// 消息标题
    private String Title;
    // 消息描述
    private String Description;
    // 消息链接
    private String Url;
}
