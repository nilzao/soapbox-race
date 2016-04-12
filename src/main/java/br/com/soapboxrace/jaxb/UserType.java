package br.com.soapboxrace.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "userType", propOrder = { "address1", "address2", "country", "dateCreated", "dob", "email",
		"emailStatus", "firstName", "fullGameAccess", "gender", "idDigits", "isComplete", "landlinePhone", "language",
		"lastAuthDate", "lastName", "mobile", "nickname", "postalCode", "realName", "reasonCode", "remoteUserId",
		"securityToken", "starterPackEntitlementTag", "status", "subscribeMsg", "tosVersion", "userId", "username" })
public class UserType {

	@XmlElement(required = true)
	protected String address1;
	@XmlElement(required = true)
	protected String address2;
	@XmlElement(required = true)
	protected String country;
	@XmlElement(required = true)
	protected String dateCreated;
	@XmlElement(required = true)
	protected String dob;
	@XmlElement(required = true)
	protected String email;
	@XmlElement(required = true)
	protected String emailStatus;
	@XmlElement(required = true)
	protected String firstName;
	@XmlElement(required = true)
	protected String fullGameAccess;
	@XmlElement(required = true)
	protected String gender;
	@XmlElement(required = true)
	protected String idDigits;
	@XmlElement(required = true)
	protected String isComplete;
	@XmlElement(required = true)
	protected String landlinePhone;
	@XmlElement(required = true)
	protected String language;
	@XmlElement(required = true)
	protected String lastAuthDate;
	@XmlElement(required = true)
	protected String lastName;
	@XmlElement(required = true)
	protected String mobile;
	@XmlElement(required = true)
	protected String nickname;
	@XmlElement(required = true)
	protected String postalCode;
	@XmlElement(required = true)
	protected String realName;
	@XmlElement(required = true)
	protected String reasonCode;
	protected long remoteUserId;
	@XmlElement(required = true)
	protected String securityToken;
	@XmlElement(required = true)
	protected String starterPackEntitlementTag;
	@XmlElement(required = true)
	protected String status;
	@XmlElement(required = true)
	protected String subscribeMsg;
	@XmlElement(required = true)
	protected String tosVersion;
	protected long userId;
	@XmlElement(required = true)
	protected String username;

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmailStatus() {
		return emailStatus;
	}

	public void setEmailStatus(String emailStatus) {
		this.emailStatus = emailStatus;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getFullGameAccess() {
		return fullGameAccess;
	}

	public void setFullGameAccess(String fullGameAccess) {
		this.fullGameAccess = fullGameAccess;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getIdDigits() {
		return idDigits;
	}

	public void setIdDigits(String idDigits) {
		this.idDigits = idDigits;
	}

	public String getIsComplete() {
		return isComplete;
	}

	public void setIsComplete(String isComplete) {
		this.isComplete = isComplete;
	}

	public String getLandlinePhone() {
		return landlinePhone;
	}

	public void setLandlinePhone(String landlinePhone) {
		this.landlinePhone = landlinePhone;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getLastAuthDate() {
		return lastAuthDate;
	}

	public void setLastAuthDate(String lastAuthDate) {
		this.lastAuthDate = lastAuthDate;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getReasonCode() {
		return reasonCode;
	}

	public void setReasonCode(String reasonCode) {
		this.reasonCode = reasonCode;
	}

	public long getRemoteUserId() {
		return remoteUserId;
	}

	public void setRemoteUserId(long remoteUserId) {
		this.remoteUserId = remoteUserId;
	}

	public String getSecurityToken() {
		return securityToken;
	}

	public void setSecurityToken(String securityToken) {
		this.securityToken = securityToken;
	}

	public String getStarterPackEntitlementTag() {
		return starterPackEntitlementTag;
	}

	public void setStarterPackEntitlementTag(String starterPackEntitlementTag) {
		this.starterPackEntitlementTag = starterPackEntitlementTag;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSubscribeMsg() {
		return subscribeMsg;
	}

	public void setSubscribeMsg(String subscribeMsg) {
		this.subscribeMsg = subscribeMsg;
	}

	public String getTosVersion() {
		return tosVersion;
	}

	public void setTosVersion(String tosVersion) {
		this.tosVersion = tosVersion;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
