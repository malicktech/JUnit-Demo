package demo8_easymock_calculator.math;

public interface Operation {

	/**
	 * Do operation and return the result
	 */
	public Long calculer(Long a, Long b) throws Exception;

	/**
	 * Useful for display management.
	 * 
	 * @return operation symbol
	 */
	public Character lireSymbole();
}
