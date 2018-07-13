package cn.weixin.entity.event;

import lombok.Data;
import lombok.EqualsAndHashCode;
/**
 * 扫描带参数二维码事件
 * @author xwl
 *
 */
@Data
@EqualsAndHashCode(callSuper=true)
public class QRCodeEvent extends BaseEvent {
	// 事件KEY值
    private String EventKey;
    // 用于换取二维码图片
    private String Ticket;
}
