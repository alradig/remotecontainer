package JUnit_tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import LogisticCompany.domain.Address;
import LogisticCompany.info.ClientInfo;
import LogisticCompany.info.JourneyInfo;

public class testPrintFunctions {

	@Test
	public void testToString() {
		ClientInfo c = new ClientInfo("nameName","emailEmail","referenceP");
		assertEquals("nameName, emailEmail",c.toString());
		JourneyInfo j = new JourneyInfo("something", "somewhere", "newPlace");
		assertEquals("Journey from somewhere to newPlace",j.toString());
	}


}
