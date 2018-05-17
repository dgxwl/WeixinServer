package cn.weixin.entity.resp_message;

import java.util.List;

import cn.weixin.entity.resp_message.inner.Article;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 被动回复图文消息
 * 
 * @author xwl
 *
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ArticleResp extends BaseResp {
	// 图文消息个数，限制为10条以内
	private int ArticleCount;
	// 多条图文消息信息，默认第一个item为大图
	private List<Article> Articles;
	// 消息类型
	private final String MsgType = "news";
}
