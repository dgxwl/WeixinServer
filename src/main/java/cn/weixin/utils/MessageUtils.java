package cn.weixin.utils;

import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;

import cn.weixin.entity.resp_message.ArticleResp;
import cn.weixin.entity.resp_message.ImageResp;
import cn.weixin.entity.resp_message.MusicResp;
import cn.weixin.entity.resp_message.TextResp;
import cn.weixin.entity.resp_message.VideoResp;
import cn.weixin.entity.resp_message.VoiceResp;
import cn.weixin.entity.resp_message.inner.Article;

/**
 * 消息处理工具类
 * 
 * @author xwl
 *
 */
public class MessageUtils {

	/**
	 * 解析微信发来的请求实体
	 * 
	 * @param request
	 *            微信请求request
	 * @return 解析得到的节点名和节点文本map
	 * @throws DocumentException
	 * @throws IOException
	 */
	public static Map<String, String> parseXML(String xmlStr) throws DocumentException, IOException {
		Map<String, String> map = new HashMap<>();
//		System.out.println(xmlStr);
		Document doc = DocumentHelper.parseText(xmlStr);
		Element root = doc.getRootElement();
		@SuppressWarnings("unchecked")
		List<Element> eleList = root.elements();
		// 遍历所有子节点，把节点名和节点文本存入map中
		for (Element e : eleList) {
			map.put(e.getName(), e.getText());
		}
		
		return map;
	}

	// 如果有特殊字符如 >,<,&会出现解析错误;因此扩展xstream使其支持CDATA
	private static XStream xstream = new XStream(new XppDriver() {
		public HierarchicalStreamWriter createWriter(Writer out) {
			return new PrettyPrintWriter(out) {
				// 对所有xml节点都增加CDATA标记
				boolean cdata = true;

				public void startNode(String name, Class cls) {
					super.startNode(name, cls);
				}

				protected void writeText(QuickWriter writer, String text) {
					if (cdata) {
						writer.write("<![CDATA[");
						writer.write(text);
						writer.write("]]>");
					} else {
						writer.write(text);
					}
				}
			};
		}
	});

	// ************************下面的方法是处理响应消息用的******************************

	/**
	 * 文本响应消息对象转换为xml字符串
	 * 
	 * @param resp
	 * @return
	 */
	public static String messageToXml(TextResp resp) {
		xstream.alias("xml", TextResp.class);
		return xstream.toXML(resp);
	}

	/**
	 * 图片响应消息对象转换为xml字符串
	 * 
	 * @param resp
	 * @return
	 */
	public static String messageToXml(ImageResp resp) {
		xstream.alias("xml", ImageResp.class);
		return xstream.toXML(resp);
	}

	/**
	 * 语音响应消息对象转换为xml字符串
	 * 
	 * @param resp
	 * @return
	 */
	public static String messageToXml(VoiceResp resp) {
		xstream.alias("xml", VoiceResp.class);
		return xstream.toXML(resp);
	}

	/**
	 * 视频响应消息对象转换为xml字符串
	 * 
	 * @param resp
	 * @return
	 */
	public static String messageToXml(VideoResp resp) {
		xstream.alias("xml", VideoResp.class);
		return xstream.toXML(resp);
	}

	/**
	 * 音乐响应消息对象转换为xml字符串
	 * 
	 * @param resp
	 * @return
	 */
	public static String messageToXml(MusicResp resp) {
		xstream.alias("xml", MusicResp.class);
		return xstream.toXML(resp);
	}

	/**
	 * 图文响应消息对象转换为xml字符串
	 * 
	 * @param resp
	 * @return
	 */
	public static String messageToXml(ArticleResp resp) {
		xstream.alias("xml", ArticleResp.class);
		xstream.alias("item", new Article().getClass());
		return xstream.toXML(resp);
	}
}
