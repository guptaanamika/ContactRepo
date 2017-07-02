package repo;

import java.util.HashMap;
import java.util.Map;

/**
 * This class is created to reduce storage at leaf of trie. Only id will be
 * stored at leaf nodes which is contained here in map , having keys as id and
 * fullname as value.
 * 
 * @author anamika.gupta
 *
 */
public class ContactIdMap {

	Map<String, String> contactIdMap = new HashMap<String, String>();

	Integer idCounter = 1;

	public String put(String contactName) {
		String id = idCounter.toString();
		contactIdMap.put(id, contactName);
		idCounter++;
		return id;
	}

	public String getContactName(String id) {
		return contactIdMap.get(id);
	}

}
