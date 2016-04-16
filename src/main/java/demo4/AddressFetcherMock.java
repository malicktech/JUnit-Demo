package demo4;

public class AddressFetcherMock implements AddressFetcher {

	@Override
	public Address fetchAddress(String name) {
		return new Address("Avenue champs-Elysés", "Mathias Dupond", 5, 75005, "Paris");
	}

}
