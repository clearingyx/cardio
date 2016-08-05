package com.common.wechat.entity.resp;

import com.common.wechat.entity.BaseResp;

/**
* 向微信返回的文本信息对象类
 */
public class TextResp extends BaseResp {
	// 回复的消息内容
	private String Content;

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}

	public TextResp(String toUserName, String fromUserName, String msgType, String type, String content) {
		super(toUserName, fromUserName, msgType, type);
		Content = content;
	}
}
