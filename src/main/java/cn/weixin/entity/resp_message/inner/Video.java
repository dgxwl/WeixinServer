package cn.weixin.entity.resp_message.inner;

import lombok.Data;

/**
 * 视频
 * @author xwl
 *
 */

@Data
public class Video {
	// 媒体文件id
    private String MediaId;
    // 缩略图的媒体id
    private String ThumbMediaId;
}
