package com.taomee.storm.trident.bean;
import java.io.Serializable;

/**
 *
 */
public class DiagnosisEvent implements Serializable {
	private static final long serialVersionUID = 1L;
	public double lat;
	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLng() {
		return lng;
	}

	public void setLng(double lng) {
		this.lng = lng;
	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

	public String getDiagnosisCode() {
		return diagnosisCode;
	}

	public void setDiagnosisCode(String diagnosisCode) {
		this.diagnosisCode = diagnosisCode;
	}

	public double lng;
	public long time;
	public String diagnosisCode;

	public DiagnosisEvent(double lat, double lng, long time,
			String diagnosisCode) {
		super();
		this.lat = lat;
		this.lng = lng;
		this.time = time;
		this.diagnosisCode = diagnosisCode;
	}
	@Override
	public String toString() {
		return "DiagnosisEvent [lat=" + lat + ", lng=" + lng + ", time=" + time
				+ ", diagnosisCode=" + diagnosisCode + "]";
	}

}
