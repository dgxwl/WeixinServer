package cn.weixin.entity.message;

import lombok.Data;
import lombok.EqualsAndHashCode;
/**
 * 视频消息
 * @author xwl
 *
 */
@Data
@EqualsAndHashCode(callSuper=true)
public class VideoMessage extends BaseMessage {
	// 媒体ID
    private String MediaId;
    // 语音格式
    private String ThumbMediaId;
}
