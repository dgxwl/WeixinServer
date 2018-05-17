package cn.weixin.entity.resp_message;

import cn.weixin.entity.resp_message.inner.Voice;
import lombok.Data;
import lombok.EqualsAndHashCode;
/**
 * 被动回复语音消息
 * @author xwl
 *
 */
@Data
@EqualsAndHashCode(callSuper=true)
public class VoiceResp extends BaseResp {
	// 语音
    private Voice Voice;
	// 消息类型
    private final String MsgType = "voice";
}
