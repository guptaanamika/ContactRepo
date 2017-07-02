package repo;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Class representing Contact Functionality to end Client which will internally
 * use Trie
 * 
 * @author anamika.gupta
 *
 */
public class Contact {

	private Trie trie;
	private ContactIdMap contactIdMap;

	public Contact() {
		this.trie = new Trie();
		this.contactIdMap = new ContactIdMap();
	}

	/**
	 * Add contact into repository. The techinque used here is to split the
	 * full name and last name and add them seperately into Trie with id
	 * as their leaf name so that searchability on either last or first name is
	 * simple.
	 * 
	 * This method also check if the name already exist and throws exception in
	 * that case.
	 * 
	 * Addition is case insensitive.
	 * 
	 * @param contactName
	 */
	public void addContact(String contactName) {

		if (null == contactName) {
			throw new RuntimeException(contactName + " cannot be null");
		}

		String fullName = contactName;
		String lastName = null;

		// If space is present then split the names and add seperately.Then
		// perform trie addition individually.
		if (contactName.contains(" ")) {
			lastName = contactName.split(" ")[1];
		}

		Set<String> searchedContact = fetchContactNameFromId(trie.search(fullName.toLowerCase()));
		if (null != searchedContact) {
			// Throw exception if contact name is already added.
			if (searchedContact.contains(contactName))
				throw new RuntimeException(contactName + " already exist");
		}

		String contactId = contactIdMap.put(contactName);
		trie.insert(fullName.toLowerCase(), contactId);
		if (lastName != null)
			trie.insert(lastName.toLowerCase(), contactId);
	}

	/**
	 * Search given contact on the given input parameter.
	 * 
	 * It perform prefix search on the last/first name.
	 * 
	 * @param name
	 * @return
	 */
	public Set<String> searchContact(String name) {
		if (null == name)
			return new HashSet<String>();

		return fetchContactNameFromId(trie.startsWith(name.toLowerCase()));
	}

	private Set<String> fetchContactNameFromId(Set<String> contactIdSet) {
		if (null == contactIdSet)
			return null;

		Set<String> contactNameSet = new LinkedHashSet<String>();
		for (String id : contactIdSet) {
			contactNameSet.add(contactIdMap.getContactName(id));
		}
		return contactNameSet;
	}

}