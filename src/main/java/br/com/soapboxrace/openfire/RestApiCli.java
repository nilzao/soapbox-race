package br.com.soapboxrace.openfire;

import org.igniterealtime.restclient.RestApiClient;
import org.igniterealtime.restclient.entity.AuthenticationToken;
import org.igniterealtime.restclient.entity.UserEntity;

public class RestApiCli {

	private static String openFireIp = "127.0.0.1";

	private static int openFireRestPort = 9090;

	private static String openFireAuthToken = "y0gs2EUWSakiz1q5";

	public static void createUpdatePersona(Long personaId, String password) {
		createUpdateUser("nfsw." + personaId.toString(), password);
	}

	public static void createUpdateUser(String user, String password) {
		AuthenticationToken authenticationToken = new AuthenticationToken(openFireAuthToken);
		RestApiClient restApiClient = new RestApiClient(openFireIp, openFireRestPort, authenticationToken);
		UserEntity userEntity = new UserEntity(user, null, null, password);
		restApiClient.createUser(userEntity);
	}

	public static String getOpenFireIp() {
		return openFireIp;
	}

	public static void setOpenFireIp(String openFireIp) {
		RestApiCli.openFireIp = openFireIp;
	}

	public static int getOpenFireRestPort() {
		return openFireRestPort;
	}

	public static void setOpenFireRestPort(int openFireRestPort) {
		RestApiCli.openFireRestPort = openFireRestPort;
	}

	public static String getOpenFireAuthToken() {
		return openFireAuthToken;
	}

	public static void setOpenFireAuthToken(String openFireAuthToken) {
		RestApiCli.openFireAuthToken = openFireAuthToken;
	}

}
