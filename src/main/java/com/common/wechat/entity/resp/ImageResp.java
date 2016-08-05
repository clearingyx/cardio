package com.common.wechat.entity.resp;

import com.common.wechat.entity.BaseResp;

/**
* 图片
 */
public class ImageResp extends BaseResp {

	private String MediaId;

	public String getMediaId() {
		return MediaId;
	}

	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}

	public ImageResp() {
	}

	public ImageResp(String toUserName, String fromUserName, String msgType, String type, String mediaId) {
		super(toUserName, fromUserName,  msgType, type);
		MediaId = mediaId;
	}
}
