package com.common.modular.wechat.event;

import java.util.Map;

/**
* 菜单触发事件
 * 有click和view等
 */
public class MenuEvent extends BaseEvent {
	// 事件KEY值，与自定义菜单接口中KEY值对应
	private String EventKey;

	public String getEventKey() {
		return EventKey;
	}

	public void setEventKey(String eventKey) {
		EventKey = eventKey;
	}

	public MenuEvent(Map<String,String> map) {
		super(map);
		this.setEventKey(map.get("EventKey"));
	}
}
