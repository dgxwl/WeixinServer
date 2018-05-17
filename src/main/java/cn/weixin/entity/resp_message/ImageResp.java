package cn.weixin.entity.resp_message;
import cn.weixin.entity.resp_message.inner.Image;
import lombok.Data;
import lombok.EqualsAndHashCode;
/**
 * 被动回复图片消息
 * @author xwl
 *
 */
@Data
@EqualsAndHashCode(callSuper=true)
public class ImageResp extends BaseResp {
	private Image Image;
	// 消息类型
    private final String MsgType = "image";
}
