package demo8_easymock_calculator.math;

public class Division implements Operation {
	
	public Long calculer(Long a, Long b) {
		return a / b;
	}

	public Character lireSymbole() {
		return '/';
	}
}
