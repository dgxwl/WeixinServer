package cn.weixin.entity.message;

import lombok.Data;
import lombok.EqualsAndHashCode;
/**
 * 地理位置消息
 * @author xwl
 *
 */
@Data
@EqualsAndHashCode(callSuper=true)
public class LocationMessage extends BaseMessage {
	// 地理位置维度
    private String Location_X;
    // 地理位置经度
    private String Location_Y;
    // 地图缩放大小
    private String Scale;
    // 地理位置信息
    private String Label;
}
