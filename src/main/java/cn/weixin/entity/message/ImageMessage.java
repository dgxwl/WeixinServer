package cn.weixin.entity.message;

import lombok.Data;
import lombok.EqualsAndHashCode;
/**
 * 图片消息
 * @author xwl
 *
 */
@Data
@EqualsAndHashCode(callSuper=true)
public class ImageMessage extends BaseMessage {
	 // 图片链接
    private String PicUrl;
    //图片消息媒体id
    private String MediaId;
}
