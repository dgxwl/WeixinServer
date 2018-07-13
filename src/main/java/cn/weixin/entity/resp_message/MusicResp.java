package cn.weixin.entity.resp_message;

import cn.weixin.entity.resp_message.inner.Music;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 被动回复音乐消息
 * @author xwl
 *
 */
@Data
@EqualsAndHashCode(callSuper=true)
public class MusicResp extends BaseResp {
	// 音乐
    private Music Music;
	// 消息类型
    private final String MsgType = "music";
}
