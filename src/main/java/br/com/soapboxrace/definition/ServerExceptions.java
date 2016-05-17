package br.com.soapboxrace.definition;

public interface ServerExceptions {	
	public class PersonaIdMismatchException extends Exception {
		private static final long serialVersionUID = 1L;

		public PersonaIdMismatchException (Long expected, Long result) {
	        super ("Expected personaId: " + expected + "\r\nGot personaId: " + result);
	    }
	}
}