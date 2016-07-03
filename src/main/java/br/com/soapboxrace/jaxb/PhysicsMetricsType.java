package br.com.soapboxrace.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PhysicsMetricsType", propOrder = { "accelerationAverage", "accelerationMaximum", "accelerationMedian",
		"speedAverage", "speedMaximum", "speedMedian" })
public class PhysicsMetricsType {
	@XmlElement(name = "AccelerationAverage", required = true)
	private Float accelerationAverage;
	@XmlElement(name = "AccelerationMaximum", required = true)
	private Float accelerationMaximum;
	@XmlElement(name = "AccelerationMedian", required = true)
	private Float accelerationMedian;
	@XmlElement(name = "SpeedAverage", required = true)
	private Float speedAverage;
	@XmlElement(name = "SpeedMaximum", required = true)
	private Float speedMaximum;
	@XmlElement(name = "SpeedMedian", required = true)
	private Float speedMedian;

	public Float getAccelerationAverage() {
		return accelerationAverage;
	}

	public void setAccelerationAverage(Float accelerationAverage) {
		this.accelerationAverage = accelerationAverage;
	}

	public Float getAccelerationMaximum() {
		return accelerationMaximum;
	}

	public void setAccelerationMaximum(Float accelerationMaximum) {
		this.accelerationMaximum = accelerationMaximum;
	}

	public Float getAccelerationMedian() {
		return accelerationMedian;
	}

	public void setAccelerationMedian(Float accelerationMedian) {
		this.accelerationMedian = accelerationMedian;
	}

	public Float getSpeedAverage() {
		return speedAverage;
	}

	public void setSpeedAverage(Float speedAverage) {
		this.speedAverage = speedAverage;
	}

	public Float getSpeedMaximum() {
		return speedMaximum;
	}

	public void setSpeedMaximum(Float speedMaximum) {
		this.speedMaximum = speedMaximum;
	}

	public Float getSpeedMedian() {
		return speedMedian;
	}

	public void setSpeedMedian(Float speedMedian) {
		this.speedMedian = speedMedian;
	}
}