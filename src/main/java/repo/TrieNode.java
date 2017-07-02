package repo;

import java.util.Set;

/**
 * Structure of Trie Node.
 * 
 * @author anamika.gupta
 *
 */
public class TrieNode {
	TrieNode[] arr;

	/**
	 * Set maintaining all the contact Names which end at that particular node
	 * of trie list
	 */
	Set<String> contactNameList;

	public TrieNode() {
		this.arr = new TrieNode[27];
	}
}
