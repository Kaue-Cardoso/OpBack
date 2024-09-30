package app.exceptions;

public class TripNotFoundException extends RuntimeException {

	// Construtor que aceita uma mensagem personalizada
	public TripNotFoundException(String message) {
		super(message); // Chama o construtor da superclasse (RuntimeException) passando a mensagem
	}
}
