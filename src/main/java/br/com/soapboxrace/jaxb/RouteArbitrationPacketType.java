package br.com.soapboxrace.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RouteArbitrationPacketType", propOrder = { "alternateEventDurationInMilliseconds", "carId",
		"eventDurationInMilliseconds", "finishReason", "fraudDetectionInfo", "hacksDetected", "physicsMetrics", "rank",
		"response", "bestLapDurationInMilliseconds", "fractionCompleted", "longestJumpDurationInMilliseconds",
		"numberOfCollisions", "perfectStart", "sumOfJumpsDurationInMilliseconds", "topSpeed" })
@XmlRootElement(name = "RouteArbitrationPacket")
public class RouteArbitrationPacketType {
	@XmlElement(name = "AlternateEventDurationInMilliseconds", required = true)
	private Long alternateEventDurationInMilliseconds;
	@XmlElement(name = "CarId", required = true)
	private Long carId;
	@XmlElement(name = "EventDurationInMilliseconds", required = true)
	private Long eventDurationInMilliseconds;
	@XmlElement(name = "FinishReason", required = true)
	private Integer finishReason;
	@XmlElement(name = "FraudDetectionInfo", required = true, nillable = true)
	private String fraudDetectionInfo;
	@XmlElement(name = "HacksDetected", required = true, nillable = true)
	private Integer hacksDetected;
	@XmlElement(name = "PhysicsMetrics", required = true)
	private PhysicsMetricsType physicsMetrics;
	@XmlElement(name = "Rank", required = true)
	private Short rank;
	@XmlElement(name = "Response", required = true)
	private ResponseType response;
	@XmlElement(name = "BestLapDurationInMilliseconds", required = true)
	private Long bestLapDurationInMilliseconds;
	@XmlElement(name = "FractionCompleted", required = true)
	private Float fractionCompleted;
	@XmlElement(name = "LongestJumpDurationInMilliseconds", required = true)
	private Long longestJumpDurationInMilliseconds;
	@XmlElement(name = "NumberOfCollisions", required = true)
	private Integer numberOfCollisions;
	@XmlElement(name = "PerfectStart", required = true)
	private Boolean perfectStart;
	@XmlElement(name = "SumOfJumpsDurationInMilliseconds", required = true)
	private Long sumOfJumpsDurationInMilliseconds;
	@XmlElement(name = "TopSpeed", required = true)
	private Float topSpeed;

	public Long getAlternateEventDurationInMilliseconds() {
		return alternateEventDurationInMilliseconds;
	}

	public void setAlternateEventDurationInMilliseconds(Long alternateEventDurationInMilliseconds) {
		this.alternateEventDurationInMilliseconds = alternateEventDurationInMilliseconds;
	}

	public Long getCarId() {
		return carId;
	}

	public void setCarId(Long carId) {
		this.carId = carId;
	}

	public Long getEventDurationInMilliseconds() {
		return eventDurationInMilliseconds;
	}

	public void setEventDurationInMilliseconds(Long eventDurationInMilliseconds) {
		this.eventDurationInMilliseconds = eventDurationInMilliseconds;
	}

	public Integer getFinishReason() {
		return finishReason;
	}

	public void setFinishReason(Integer finishReason) {
		this.finishReason = finishReason;
	}

	public String getFraudDetectionInfo() {
		return fraudDetectionInfo;
	}

	public void setFraudDetectionInfo(String fraudDetectionInfo) {
		this.fraudDetectionInfo = fraudDetectionInfo;
	}

	public Integer getHacksDetected() {
		return hacksDetected;
	}

	public void setHacksDetected(Integer hacksDetected) {
		this.hacksDetected = hacksDetected;
	}

	public PhysicsMetricsType getPhysicsMetrics() {
		return physicsMetrics;
	}

	public void setPhysicsMetrics(PhysicsMetricsType physicsMetrics) {
		this.physicsMetrics = physicsMetrics;
	}

	public Short getRank() {
		return rank;
	}

	public void setRank(Short rank) {
		this.rank = rank;
	}

	public ResponseType getResponse() {
		return response;
	}

	public void setResponse(ResponseType response) {
		this.response = response;
	}

	public Long getBestLapDurationInMilliseconds() {
		return bestLapDurationInMilliseconds;
	}

	public void setBestLapDurationInMilliseconds(Long bestLapDurationInMilliseconds) {
		this.bestLapDurationInMilliseconds = bestLapDurationInMilliseconds;
	}

	public Float getFractionCompleted() {
		return fractionCompleted;
	}

	public void setFractionCompleted(Float fractionCompleted) {
		this.fractionCompleted = fractionCompleted;
	}

	public Long getLongestJumpDurationInMilliseconds() {
		return longestJumpDurationInMilliseconds;
	}

	public void setLongestJumpDurationInMilliseconds(Long longestJumpDurationInMilliseconds) {
		this.longestJumpDurationInMilliseconds = longestJumpDurationInMilliseconds;
	}

	public Integer getNumberOfCollisions() {
		return numberOfCollisions;
	}

	public void setNumberOfCollisions(Integer numberOfCollisions) {
		this.numberOfCollisions = numberOfCollisions;
	}

	public Boolean getPerfectStart() {
		return perfectStart;
	}

	public void setPerfectStart(Boolean perfectStart) {
		this.perfectStart = perfectStart;
	}

	public Long getSumOfJumpsDurationInMilliseconds() {
		return sumOfJumpsDurationInMilliseconds;
	}

	public void setSumOfJumpsDurationInMilliseconds(Long sumOfJumpsDurationInMilliseconds) {
		this.sumOfJumpsDurationInMilliseconds = sumOfJumpsDurationInMilliseconds;
	}

	public Float getTopSpeed() {
		return topSpeed;
	}

	public void setTopSpeed(Float topSpeed) {
		this.topSpeed = topSpeed;
	}
}