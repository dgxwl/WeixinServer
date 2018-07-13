package cn.weixin.entity.resp_message;

import cn.weixin.entity.resp_message.inner.Video;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 被动回复视频消息
 * @author xwl
 *
 */
@Data
@EqualsAndHashCode(callSuper=true)
public class VideoResp extends BaseResp {
	// 视频
    private Video Video;
	// 消息类型
    private final String MsgType = "video";
}
