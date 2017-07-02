package repo;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Class implementing Trie functionality.
 * 
 * @author anamika.gupta
 *
 */
public class Trie {
	private TrieNode root;
	private static final int MAX_LENGTH = 26;

	public Trie() {
		root = new TrieNode();
	}

	/**
	 * Inserts a word into the trie and also check if its already exist.
	 * 
	 * @param word
	 *            - represent either the firstname or the lastname.
	 * @param leafValue
	 *            - reperesent the fullname which was added as input
	 */
	public void insert(String word, String leafValue) {
		TrieNode p = root;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			int index = getIndex(c);

			if (index < 0 && index > 27)
				throw new RuntimeException("Only char between [A-Z][a-z] are valid");

			if (p.arr[index] == null) {
				TrieNode temp = new TrieNode();
				p.arr[index] = temp;
				p = temp;
			} else {
				p = p.arr[index];
			}
		}
		if (p.contactNameList == null)
			p.contactNameList = new LinkedHashSet<String>();
		p.contactNameList.add(leafValue);
	}

	/**
	 * Returns Set of word which are presented by the word as input
	 * 
	 * @param word
	 * @return
	 */
	public Set<String> search(String word) {
		TrieNode p = searchNode(word);
		if (p == null) {
			return null;
		} else {
			if (p.contactNameList != null)
				return p.contactNameList;
		}

		return null;
	}

	/**
	 * Returns set of words if there is any word in the trie that starts with
	 * the given prefix.
	 * 
	 * @param prefix
	 * @return
	 */
	public Set<String> startsWith(String prefix) {
		Set<String> word = new LinkedHashSet<String>();
		TrieNode p = searchNode(prefix);
		if (p == null) {
			return word;
		} else {
			searchAllWord(p, word);
			return word;
		}
	}

	/**
	 * Return set of word which is present if start of given trie node
	 * 
	 * @param node
	 * @param word
	 */
	public void searchAllWord(TrieNode node, Set<String> word) {
		if (node.contactNameList != null)
			word.addAll(node.contactNameList);
		for (int index = 0; index <= MAX_LENGTH; index++) {
			if (node.arr[index] != null) {
				searchAllWord(node.arr[index], word);
			}
		}
	}

	/**
	 * Return trie node which end with given string.
	 * 
	 * @param s
	 * @return
	 */
	private TrieNode searchNode(String s) {
		TrieNode p = root;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			int index = getIndex(c);
			if (p.arr[index] != null) {
				p = p.arr[index];
			} else {
				return null;
			}
		}
		if (p == root)
			return null;

		return p;
	}

	private int getIndex(char c) {
		if (c == ' ')
			return MAX_LENGTH;
		else
			return c - 'a';
	}
}
