package cn.weixin.service.iservice;

public interface IMainService {
	/**
	 * 处理微信发送的xml并进行解析后回复
	 * @param 微信发送的xml
	 * @return xmlStr 回复给微信的xml
	 */
	public String processRequest(String xmlStr);
}
