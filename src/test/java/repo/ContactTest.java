package repo;

import java.util.Iterator;
import java.util.Set;

import junit.framework.Assert;

import org.junit.Test;

public class ContactTest {

	@Test
	public void testForPartialSearchOnFullName() {
		Contact contact = new Contact();
		contact.addContact(("Chris Harris"));
		contact.addContact(("Chris Cairns"));
		contact.addContact(("Harry Potter"));
		contact.addContact(("Chris"));

		Set<String> result = contact.searchContact("Chris h");
		Assert.assertNotNull(result);
		Assert.assertEquals(1, result.size());
		Assert.assertEquals("Chris Harris", result.iterator().next());
	}

	@Test
	public void testForSearchOnFirstNameWithRank() {
		Contact contact = new Contact();
		contact.addContact(("Chris Harris"));
		contact.addContact(("Chris Cairns"));
		contact.addContact(("Harry Potter"));
		contact.addContact(("Chris"));

		Set<String> result = contact.searchContact("Chris");
		Assert.assertNotNull(result);
		Assert.assertEquals(3, result.size());
		Iterator<String> i = result.iterator();
		Assert.assertEquals("Chris", i.next());
	}

	@Test
	public void testForSearchOnPartialName() {
		Contact contact = new Contact();
		contact.addContact(("Chris Harris"));
		contact.addContact(("Chris Cairns"));
		contact.addContact(("Harry Potter"));
		contact.addContact(("Chris"));

		Set<String> result = contact.searchContact("Harr");
		Assert.assertNotNull(result);
		Assert.assertEquals(2, result.size());
	}

	@Test
	public void testForSearchOnFullName() {
		Contact contact = new Contact();
		contact.addContact(("Chris Harris"));
		contact.addContact(("Chris Cairns"));
		contact.addContact(("Harry Potter"));
		contact.addContact(("Chris"));

		Set<String> result = contact.searchContact("harry potter");
		Assert.assertNotNull(result);
		Assert.assertEquals(1, result.size());
		Assert.assertEquals("Harry Potter", result.iterator().next());
	}

}
