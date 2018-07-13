package cn.weixin.entity.event;

import lombok.Data;
import lombok.EqualsAndHashCode;
/**
 * 上报地理位置事件
 * @author xwl
 *
 */
@Data
@EqualsAndHashCode(callSuper=true)
public class LocationEvent extends BaseEvent {
	// 地理位置纬度
    private String Latitude;
    // 地理位置经度
    private String Longitude;
    // 地理位置精度
    private String Precision;
}
