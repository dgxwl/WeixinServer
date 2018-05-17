package cn.weixin.service;

import java.util.Date;
import java.util.Map;

import org.springframework.stereotype.Service;

import cn.weixin.entity.resp_message.TextResp;
import cn.weixin.service.iservice.IMainService;
import cn.weixin.utils.MessageUtils;

@Service
public class MainService implements IMainService {

	@Override
	public String processRequest(String xmlStr) {
		// xml格式的消息数据
        String respXml = null;
        // 默认返回的文本消息内容
        String respContent = "Unknown message type!";
        try {
            // 调用parseXML方法解析请求消息
        	//TODO 挖坑:开通语音识别后，用户每次发送语音给公众号时，微信会在推送的语音消息XML数据包中，增加一个<Recongnition>字段(详见文档)
            Map<String, String> requestMap = MessageUtils.parseXML(xmlStr);
            // 发送方帐号
            String fromUserName = requestMap.get("FromUserName");
            // 开发者微信号
            String toUserName = requestMap.get("ToUserName");
            // 消息类型
            String msgType = requestMap.get("MsgType");

            //TODO 设置回复类型
            // 回复文本消息
            TextResp textResp = new TextResp();
            textResp.setToUserName(fromUserName);
            textResp.setFromUserName(toUserName);
            textResp.setCreateTime(new Date().getTime());
            
            switch (msgType) {
            	//文本消息
			case "text":
				respContent = "A text message!";
				break;
				// 图片消息
			case "image":
				respContent = "An image message!";
				break;
				// 语音消息
			case "voice":
				respContent = "A voice message!";
				break;
				// 视频消息
			case "video":
				respContent = "A video message!";
				break;
				// 视频消息
			case "shortvideo":
				respContent = "A shortvideo message!";
				break;
				// 地理位置消息
			case "location":
				respContent = "A location message!";
				break;
				// 链接消息
			case "link":
				respContent = "A link message!";
				break;
				// 事件推送
			case "event":
				// 事件类型
                String eventType = requestMap.get("Event");
                switch (eventType) {
                	// 关注
				case "subscribe":
					respContent = "Thank you for Subscribing!";
					break;
					// 取消关注
				case "unsubscribe":
					// TODO 取消订阅后用户不会再收到公众账号发送的消息，因此不需要回复
					break;
					// 扫描带参数二维码
				case "SCAN":
					// TODO 处理扫描带参数二维码事件
					break;
					// 上报地理位置
				case "LOCATION":
					// TODO 处理上报地理位置事件
					break;
					// 自定义菜单被点击
				case "CLICK":
					// TODO 处理点击菜单拉取消息事件
					break;
				case "VIEW":
					// TODO 处理点击菜单拉取消息事件
					break;
				}
				break;
			}

            // 设置文本消息的内容
            textResp.setContent(respContent);
            // 将文本消息对象转换成xml
            respXml = MessageUtils.messageToXml(textResp);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return respXml;
	}

}
