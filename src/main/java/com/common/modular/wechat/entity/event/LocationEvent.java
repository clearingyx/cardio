package com.common.modular.wechat.entity.event;

import java.util.Map;

/**
 *上报地理位置事件
 */
public class LocationEvent extends BaseEvent {
	// 地理位置纬度
	private String Latitude;
	// 地理位置经度
	private String Longitude;
	// 地理位置精度
	private String Precision;

	public String getLatitude() {
		return Latitude;
	}

	public void setLatitude(String latitude) {
		Latitude = latitude;
	}

	public String getLongitude() {
		return Longitude;
	}

	public void setLongitude(String longitude) {
		Longitude = longitude;
	}

	public String getPrecision() {
		return Precision;
	}

	public void setPrecision(String precision) {
		Precision = precision;
	}

	public LocationEvent(Map<String, String> map) {
		super(map);
		this.setLatitude(map.get("Latitude"));
		this.setLongitude(map.get("Longitude"));
		this.setPrecision(map.get("Precision"));
	}
}
