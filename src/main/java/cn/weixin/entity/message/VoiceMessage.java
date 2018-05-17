package cn.weixin.entity.message;

import lombok.Data;
import lombok.EqualsAndHashCode;
/**
 * 语音消息
 * @author xwl
 *
 */
@Data
@EqualsAndHashCode(callSuper=true)
public class VoiceMessage extends BaseMessage {
	// 媒体ID
    private String MediaId;
    // 语音格式
    private String Format;
}
