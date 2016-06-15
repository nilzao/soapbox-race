package br.com.soapboxrace.openfire;

import org.igniterealtime.restclient.RestApiClient;
import org.igniterealtime.restclient.entity.AuthenticationToken;
import org.igniterealtime.restclient.entity.UserEntity;

public class RestApiCli {

	public static void createUpdatePersona(Long personaId, String password) {
		AuthenticationToken authenticationToken = new AuthenticationToken("y0gs2EUWSakiz1q5");
		RestApiClient restApiClient = new RestApiClient("http://localhost", 9090, authenticationToken);
		UserEntity userEntity = new UserEntity("nfsw." + personaId.toString(), null, null, password);
		restApiClient.createUser(userEntity);
	}
}
