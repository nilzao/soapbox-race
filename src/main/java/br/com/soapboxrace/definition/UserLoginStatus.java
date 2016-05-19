package br.com.soapboxrace.definition;

public interface UserLoginStatus {
	String emailNotFound = "NoSuchEmail";
	String incorrectPassword = "IncorrectPassword";
	String invalidToken = "InvalidToken";
	String invalidLogin  = "InvalidLogin";
}