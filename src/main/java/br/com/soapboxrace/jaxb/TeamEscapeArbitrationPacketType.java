package br.com.soapboxrace.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TeamEscapeArbitrationPacketType", propOrder = { "alternateEventDurationInMilliseconds", "carId",
		"eventDurationInMilliseconds", "finishReason", "fraudDetectionInfo", "hacksDetected", "physicsMetrics", "rank",
		"response", "bustedCount", "copsDeployed", "copsDisabled", "copsRammed", "costToState", "distanceToFinish",
		"fractionCompleted", "infractions", "longestJumpDurationInMilliseconds", "numberOfCollisions", "perfectStart",
		"roadBlocksDodged", "spikeStripsDodged", "sumOfJumpsDurationInMilliseconds", "topSpeed" })
@XmlRootElement(name = "TeamEscapeArbitrationPacket")
public class TeamEscapeArbitrationPacketType {
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
	@XmlElement(name = "BustedCount", required = true)
	private Integer bustedCount;
	@XmlElement(name = "CopsDeployed", required = true)
	private Integer copsDeployed;
	@XmlElement(name = "CopsDisabled", required = true)
	private Integer copsDisabled;
	@XmlElement(name = "CopsRammed", required = true)
	private Integer copsRammed;
	@XmlElement(name = "CostToState", required = true)
	private Integer costToState;
	@XmlElement(name = "DistanceToFinish", required = true)
	private Float distanceToFinish;
	@XmlElement(name = "FractionCompleted", required = true)
	private Float fractionCompleted;
	@XmlElement(name = "Infractions", required = true)
	private Integer infractions;
	@XmlElement(name = "LongestJumpDurationInMilliseconds", required = true)
	private Long longestJumpDurationInMilliseconds;
	@XmlElement(name = "NumberOfCollisions", required = true)
	private Integer numberOfCollisions;
	@XmlElement(name = "PerfectStart", required = true)
	private Boolean perfectStart;
	@XmlElement(name = "RoadBlocksDodged", required = true)
	private Integer roadBlocksDodged;
	@XmlElement(name = "SpikeStripsDodged", required = true)
	private Integer spikeStripsDodged;
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

	public Integer getBustedCount() {
		return bustedCount;
	}

	public void setBustedCount(Integer bustedCount) {
		this.bustedCount = bustedCount;
	}

	public Integer getCopsDeployed() {
		return copsDeployed;
	}

	public void setCopsDeployed(Integer copsDeployed) {
		this.copsDeployed = copsDeployed;
	}

	public Integer getCopsDisabled() {
		return copsDisabled;
	}

	public void setCopsDisabled(Integer copsDisabled) {
		this.copsDisabled = copsDisabled;
	}

	public Integer getCopsRammed() {
		return copsRammed;
	}

	public void setCopsRammed(Integer copsRammed) {
		this.copsRammed = copsRammed;
	}

	public Integer getCostToState() {
		return costToState;
	}

	public void setCostToState(Integer costToState) {
		this.costToState = costToState;
	}

	public Float getDistanceToFinish() {
		return distanceToFinish;
	}

	public void setDistanceToFinish(Float distanceToFinish) {
		this.distanceToFinish = distanceToFinish;
	}

	public Float getFractionCompleted() {
		return fractionCompleted;
	}

	public void setFractionCompleted(Float fractionCompleted) {
		this.fractionCompleted = fractionCompleted;
	}

	public Integer getInfractions() {
		return infractions;
	}

	public void setInfractions(Integer infractions) {
		this.infractions = infractions;
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

	public Integer getRoadBlocksDodged() {
		return roadBlocksDodged;
	}

	public void setRoadBlocksDodged(Integer roadBlocksDodged) {
		this.roadBlocksDodged = roadBlocksDodged;
	}

	public Integer getSpikeStripsDodged() {
		return spikeStripsDodged;
	}

	public void setSpikeStripsDodged(Integer spikeStripsDodged) {
		this.spikeStripsDodged = spikeStripsDodged;
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