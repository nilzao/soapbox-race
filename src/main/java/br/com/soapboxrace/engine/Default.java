package br.com.soapboxrace.engine;

public class Default extends Router {

	public String getfriendlistfromuserid() {
		return "<PersonaFriendsList/>";
	}

	public String systeminfo() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("<SystemInfo>\n");
		stringBuilder.append("  <Branch>debug</Branch>\n");
		stringBuilder.append("  <ChangeList>620384</ChangeList>\n");
		stringBuilder.append("  <ClientVersion>637</ClientVersion>\n");
		stringBuilder.append("  <ClientVersionCheck>true</ClientVersionCheck>\n");
		stringBuilder.append("  <Deployed>08/20/2013 11:24:40</Deployed>\n");
		stringBuilder.append("  <EntitlementsToDownload>true</EntitlementsToDownload>\n");
		stringBuilder.append("  <ForcePermanentSession>true</ForcePermanentSession>\n");
		stringBuilder.append("  <JidPrepender>nfsw</JidPrepender>\n");
		stringBuilder.append("  <LauncherServiceUrl>http://10.100.15.202/LauncherService/onlineconfig.aspx</LauncherServiceUrl>\n");
		stringBuilder.append("  <NucleusNamespace>nfsw-live</NucleusNamespace>\n");
		stringBuilder.append("  <NucleusNamespaceWeb>nfs_web</NucleusNamespaceWeb>\n");
		stringBuilder.append("  <PersonaCacheTimeout>900</PersonaCacheTimeout>\n");
		stringBuilder.append("  <PortalDomain/>\n");
		stringBuilder.append("  <PortalSecureDomain/>\n");
		stringBuilder.append("  <PortalStoreFailurePage/>\n");
		stringBuilder.append("  <PortalTimeOut>60000</PortalTimeOut>\n");
		stringBuilder.append("  <ShardName>US</ShardName>\n");
		stringBuilder.append("  <Time>2010-01-01T12:00:00.0000000+00:00</Time>\n");
		stringBuilder.append("  <Version>1599</Version>\n");
		stringBuilder.append("</SystemInfo>\n");
		stringBuilder.append("");
		String xmlTmp = stringBuilder.toString();
		return xmlTmp;
	}

	public String carclasses() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("<ArrayOfCarClass>\n");
		stringBuilder.append("  <CarClass>\n");
		stringBuilder.append("    <CarClassHash>-2142411446</CarClassHash>\n");
		stringBuilder.append("    <MaxRating>999</MaxRating>\n");
		stringBuilder.append("    <MinRating>750</MinRating>\n");
		stringBuilder.append("  </CarClass>\n");
		stringBuilder.append("  <CarClass>\n");
		stringBuilder.append("    <CarClassHash>-406473455</CarClassHash>\n");
		stringBuilder.append("    <MaxRating>599</MaxRating>\n");
		stringBuilder.append("    <MinRating>500</MinRating>\n");
		stringBuilder.append("  </CarClass>\n");
		stringBuilder.append("  <CarClass>\n");
		stringBuilder.append("    <CarClassHash>-405837480</CarClassHash>\n");
		stringBuilder.append("    <MaxRating>749</MaxRating>\n");
		stringBuilder.append("    <MinRating>600</MinRating>\n");
		stringBuilder.append("  </CarClass>\n");
		stringBuilder.append("  <CarClass>\n");
		stringBuilder.append("    <CarClassHash>415909161</CarClassHash>\n");
		stringBuilder.append("    <MaxRating>399</MaxRating>\n");
		stringBuilder.append("    <MinRating>250</MinRating>\n");
		stringBuilder.append("  </CarClass>\n");
		stringBuilder.append("  <CarClass>\n");
		stringBuilder.append("    <CarClassHash>872416321</CarClassHash>\n");
		stringBuilder.append("    <MaxRating>249</MaxRating>\n");
		stringBuilder.append("    <MinRating>0</MinRating>\n");
		stringBuilder.append("  </CarClass>\n");
		stringBuilder.append("  <CarClass>\n");
		stringBuilder.append("    <CarClassHash>1866825865</CarClassHash>\n");
		stringBuilder.append("    <MaxRating>499</MaxRating>\n");
		stringBuilder.append("    <MinRating>400</MinRating>\n");
		stringBuilder.append("  </CarClass>\n");
		stringBuilder.append("</ArrayOfCarClass>");
		String xmlTmp = stringBuilder.toString();
		return xmlTmp;
	}

	public String getrebroadcasters() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("<ArrayOfUdpRelayInfo>");
		stringBuilder.append("<UdpRelayInfo>");
		stringBuilder.append("<Host>");
		stringBuilder.append(Session.getFreeRoamUdpIp());
		stringBuilder.append("</Host>");
		stringBuilder.append("<Port>");
		stringBuilder.append(Session.getFreeRoamUdpPort());
		stringBuilder.append("</Port>");
		stringBuilder.append("</UdpRelayInfo>");
		stringBuilder.append("</ArrayOfUdpRelayInfo>");
		String xmlTmp = stringBuilder.toString();
		return xmlTmp;
	}

	public String getregioninfo() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("<RegionInfo>\n");
		stringBuilder.append("  <CountdownProposalInMilliseconds>3000</CountdownProposalInMilliseconds>\n");
		stringBuilder.append("  <DirectConnectTimeoutInMilliseconds>1000</DirectConnectTimeoutInMilliseconds>\n");
		stringBuilder.append("  <DropOutTimeInMilliseconds>15000</DropOutTimeInMilliseconds>\n");
		stringBuilder.append("  <EventLoadTimeoutInMilliseconds>30000</EventLoadTimeoutInMilliseconds>\n");
		stringBuilder.append("  <HeartbeatIntervalInMilliseconds>1000</HeartbeatIntervalInMilliseconds>\n");
		stringBuilder.append("  <UdpRelayBandwidthInBps>9600</UdpRelayBandwidthInBps>\n");
		stringBuilder.append("  <UdpRelayTimeoutInMilliseconds>60000</UdpRelayTimeoutInMilliseconds>\n");
		stringBuilder.append("</RegionInfo>");
		String xmlTmp = stringBuilder.toString();
		return xmlTmp;
	}

	public String loginAnnouncements() {
		return "<LoginAnnouncementsDefinition/>";
	}

	public String getsocialsettings() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("<SocialSettings>\n");
		stringBuilder.append("  <AppearOffline>false</AppearOffline>\n");
		stringBuilder.append("  <DeclineGroupInvite>0</DeclineGroupInvite>\n");
		stringBuilder.append("  <DeclineIncommingFriendRequests>false</DeclineIncommingFriendRequests>\n");
		stringBuilder.append("  <DeclinePrivateInvite>0</DeclinePrivateInvite>\n");
		stringBuilder.append("  <HideOfflineFriends>false</HideOfflineFriends>\n");
		stringBuilder.append("  <ShowNewsOnSignIn>false</ShowNewsOnSignIn>\n");
		stringBuilder.append("  <ShowOnlyPlayersInSameChatChannel>false</ShowOnlyPlayersInSameChatChannel>\n");
		stringBuilder.append("</SocialSettings>");
		String xmlTmp = stringBuilder.toString();
		return xmlTmp;
	}

	public String getusersettings() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("<User_Settings>\n");
		stringBuilder.append("  <CarCacheAgeLimit>600</CarCacheAgeLimit>\n");
		stringBuilder.append("  <IsRaceNowEnabled>true</IsRaceNowEnabled>\n");
		stringBuilder.append("  <MaxCarCacheSize>250</MaxCarCacheSize>\n");
		stringBuilder.append("  <MinRaceNowLevel>2</MinRaceNowLevel>\n");
		stringBuilder.append("  <VoipAvailable>false</VoipAvailable>\n");
		stringBuilder.append("  <activatedHolidaySceneryGroups>\n");
		stringBuilder.append("    <string>SCENERY_GROUP_CHRISTMAS</string>\n");
		stringBuilder.append("  </activatedHolidaySceneryGroups>\n");
		stringBuilder.append("  <activeHolidayIds>\n");
		stringBuilder.append("    <long>0</long>\n");
		stringBuilder.append("  </activeHolidayIds>\n");
		stringBuilder.append("  <disactivatedHolidaySceneryGroups>\n");
		stringBuilder.append("    <string>SCENERY_GROUP_CHRISTMAS_DISABLE</string>\n");
		stringBuilder.append("  </disactivatedHolidaySceneryGroups>\n");
		stringBuilder.append("  <firstTimeLogin>false</firstTimeLogin>\n");
		stringBuilder.append("  <maxLevel>60</maxLevel>\n");
		stringBuilder.append("  <starterPackApplied>false</starterPackApplied>\n");
		stringBuilder.append("  <userId>" + getUserId() + "</userId>\n");
		stringBuilder.append("</User_Settings>");
		String xmlTmp = stringBuilder.toString();
		return xmlTmp;
	}

	public String getblockeduserlist() {
		return "<ArrayOflong/>";
	}

	public String getblockersbyusers() {
		return "<ArrayOflong/>";
	}

	public String heartbeat() {
		return "";
	}

	public String newsArticles() {
		return "<ArrayOfNewsArticleTrans />";
	}

	public String getsocialnetworkinfo() {
		return "<SocialNetworkInfo />";
	}

	public String setsocialsettings() {
		return "";
	}

	public String addfriendrequest() {
		return "";
	}

}