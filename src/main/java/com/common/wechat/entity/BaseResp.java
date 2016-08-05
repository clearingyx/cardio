package com.common.wechat.entity;

import com.common.wechat.emun.MsgTypeEmun;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import java.util.Date;

/**
* 向微信发送的信息基类
 */
public class BaseResp {
	// 接收方帐号（收到的OpenID）
	private String ToUserName;
	// 开发者微信号
	private String FromUserName;
	// 消息创建时间 （整型）
	private long CreateTime;
	// 消息类型（event、view等）
	private String MsgType;
	// 消息种类，text，image等
	private String type;

	public String getToUserName() {
		return ToUserName;
	}

	public void setToUserName(String toUserName) {
		ToUserName = toUserName;
	}

	public String getFromUserName() {
		return FromUserName;
	}

	public void setFromUserName(String fromUserName) {
		FromUserName = fromUserName;
	}

	public long getCreateTime() {
		return CreateTime;
	}

	public void setCreateTime(long createTime) {
		CreateTime = new Date().getTime();
	}

	public String getMsgType() {
		return MsgType;
	}

	public void setMsgType(String msgType) {
		MsgType = msgType;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public BaseResp() {
	}

	public BaseResp(String toUserName, String fromUserName, String msgType, String type) {
		ToUserName = toUserName;
		FromUserName = fromUserName;
		CreateTime = new Date().getTime();
		MsgType = msgType;
		this.type = type;
	}

}
