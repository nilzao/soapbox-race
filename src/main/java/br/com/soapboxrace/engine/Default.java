package br.com.soapboxrace.engine;

import java.util.Collection;
import java.util.Set;

import br.com.soapboxrace.http.HttpSessionVO;
import br.com.soapboxrace.xmpp.XmppSrv;

public class Default extends Router {

	public String getfriendlistfromuserid() {
		return "<PersonaFriendsList/>";
	}

	public String systeminfo() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("<SystemInfo>\n");
		stringBuilder.append("  <Branch>production</Branch>\n");
		stringBuilder.append("  <ChangeList>620384</ChangeList>\n");
		stringBuilder.append("  <ClientVersion>637</ClientVersion>\n");
		stringBuilder.append("  <ClientVersionCheck>true</ClientVersionCheck>\n");
		stringBuilder.append("  <Deployed>08/20/2013 11:24:40</Deployed>\n");
		stringBuilder.append("  <EntitlementsToDownload>true</EntitlementsToDownload>\n");
		stringBuilder.append("  <ForcePermanentSession>true</ForcePermanentSession>\n");
		stringBuilder.append("  <JidPrepender>nfsw</JidPrepender>\n");
		stringBuilder.append(
				"  <LauncherServiceUrl>http://10.100.15.202/LauncherService/onlineconfig.aspx</LauncherServiceUrl>\n");
		stringBuilder.append("  <NucleusNamespace>nfsw-live</NucleusNamespace>\n");
		stringBuilder.append("  <NucleusNamespaceWeb>nfs_web</NucleusNamespaceWeb>\n");
		stringBuilder.append("  <PersonaCacheTimeout>900</PersonaCacheTimeout>\n");
		stringBuilder.append("  <PortalDomain>world.needforspeed.com</PortalDomain>\n");
		stringBuilder.append("  <PortalSecureDomain>world.needforspeed.com</PortalSecureDomain>\n");
		stringBuilder.append(
				"  <PortalStoreFailurePage>world.needforspeed.com/webkit/pageLoadError</PortalStoreFailurePage>\n");
		stringBuilder.append("  <PortalTimeOut>60000</PortalTimeOut>\n");
		stringBuilder.append("  <ShardName>APEX</ShardName>\n");
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
		stringBuilder.append("<ArrayOfUdpRelayInfo>\n");
		stringBuilder.append("  <UdpRelayInfo>\n");
		stringBuilder.append("    <Host>127.0.0.1</Host>\n");
		stringBuilder.append("    <Port>9999</Port>\n");
		stringBuilder.append("  </UdpRelayInfo>\n");
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
		stringBuilder.append("  <userId>1</userId>\n");
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

	public void sendChatAnnouncement() {
		String messageText = getParam("messageText");
		String userVar = getParam("userVar");
		switch (userVar) {
		case "session":
			Collection<HttpSessionVO> activePersonas = Router.activeUsers.values();
			for (HttpSessionVO httpSessionVo : activePersonas) {
				Long personaId = httpSessionVo.getPersonaId();
				if (XmppSrv.xmppClients.containsKey(personaId)) {
					StringBuilder stringBuilder = new StringBuilder();
					stringBuilder.append("<message from='nfsw.engine.engine@127.0.0.1/EA_Chat' id='JN_2578' to='nfsw.");
					stringBuilder.append(personaId);
					stringBuilder.append("@127.0.0.1'>");
					stringBuilder.append("<body>");
					stringBuilder.append("&lt;response status='1' ticket='0'&gt;");
					stringBuilder.append("&lt;ChatBroadcast &gt;");
					stringBuilder.append("&lt;ChatBlob&gt;");
					stringBuilder.append("&lt;FromName&gt;System&lt;/FromName&gt;");
					stringBuilder.append("&lt;FromPersonaId&gt;0&lt;/FromPersonaId&gt;");
					stringBuilder.append("&lt;FromUserId&gt;0&lt;/FromUserId&gt;");
					stringBuilder.append("&lt;Message&gt;" + messageText); // 32 char = 1 block
					stringBuilder.append("&lt;/Message&gt;&lt;ToId&gt;0&lt;/ToId&gt;");
					stringBuilder.append("&lt;Type&gt;2&lt;/Type&gt;&lt;/ChatBlob&gt;&lt;/ChatBroadcast&gt;");
					stringBuilder.append("&lt;/response&gt;");
					stringBuilder.append("</body>");
					stringBuilder.append("<subject>69</subject>");
					stringBuilder.append("</message>");
					String msg = stringBuilder.toString();
					XmppSrv.sendMsg(personaId, msg);
				}
			}
			break;
		case "xmpp":
			Set<Long> activeXmppSessions = XmppSrv.xmppClients.keySet();
			for (Long personaId : activeXmppSessions) {
				StringBuilder stringBuilder = new StringBuilder();
				stringBuilder.append("<message from='nfsw.engine.engine@127.0.0.1/EA_Chat' id='JN_2578' to='nfsw.");
				stringBuilder.append(personaId);
				stringBuilder.append("@127.0.0.1'>");
				stringBuilder.append("<body>");
				stringBuilder.append("&lt;response status='1' ticket='0'&gt;");
				stringBuilder.append("&lt;ChatBroadcast &gt;");
				stringBuilder.append("&lt;ChatBlob&gt;");
				stringBuilder.append("&lt;FromName&gt;System&lt;/FromName&gt;");
				stringBuilder.append("&lt;FromPersonaId&gt;0&lt;/FromPersonaId&gt;");
				stringBuilder.append("&lt;FromUserId&gt;0&lt;/FromUserId&gt;");
				stringBuilder.append("&lt;Message&gt;" + messageText); // 32
				stringBuilder.append("&lt;/Message&gt;&lt;ToId&gt;0&lt;/ToId&gt;");
				stringBuilder.append("&lt;Type&gt;2&lt;/Type&gt;&lt;/ChatBlob&gt;&lt;/ChatBroadcast&gt;");
				stringBuilder.append("&lt;/response&gt;");
				stringBuilder.append("</body>");
				stringBuilder.append("<subject>69</subject>");
				stringBuilder.append("</message>");
				String msg = stringBuilder.toString();
				XmppSrv.sendMsg(personaId, msg);
			}
			break;
		}
	}

}