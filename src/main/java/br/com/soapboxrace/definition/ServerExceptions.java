package br.com.soapboxrace.definition;

public interface ServerExceptions {	
	public class PersonaIdMismatch extends Exception {
		private static final long serialVersionUID = 1L;

		public PersonaIdMismatch (Long expected, Long result) {
	        super ("Expected personaId: " + expected + "\r\nGot personaId: " + result);
	    }
	}
}