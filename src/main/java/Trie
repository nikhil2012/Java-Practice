/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility classes
import java.util.*;
*/

// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

class TestClass {
    public static void main(String args[] ) throws Exception {
       
        Scanner s = new Scanner(System.in);
        String firstLine = s.nextLine();                 // Reading input from STDIN
        int n  = Integer.parseInt(firstLine.split(" ")[0]);
        int q =  Integer.parseInt(firstLine.split(" ")[1]);
        // Write your code here
        Trie t = new Trie();
        
        for(int i=0;i<n;i++){
            String stringWithWeight = s.nextLine();  
            String word  = stringWithWeight.split(" ")[0];
            int weight = Integer.parseInt(stringWithWeight.split(" ")[0]);
	    	t.insert(word,weight);
        }
        
        
        for(int i=0;i<q;i++){
            String prefix = s.nextLine();  
		    System.out.println(t.findAllString(prefix));
        }
    }
    
    
}
 class Trie {

	public Trie() {
		root = new TrieNode();
	}

	public static class TrieNode {
		boolean isEndOfWord;
		Map<Character, TrieNode> children;
		int weight;
		char ch;

		public TrieNode() {
			children = new HashMap<>();
			isEndOfWord = false;
			weight = -1;
			ch='*';
		}
	}

	public TrieNode root;

	public void insert(String word, int weight) {

		Map<Character, TrieNode> children = root.children;
		int length = word.length();
		TrieNode currNode = null;
		for (int i = 0; i < length; i++) {
			char ch = word.charAt(i);
			if (!children.containsKey(ch)) {
				currNode = new TrieNode();
				currNode.ch = ch;
				children.put(ch, currNode);
			}

			currNode = children.get(ch);
			children = currNode.children;

		}
		currNode.isEndOfWord = true;
		currNode.weight = weight;
	}

	public int findAllString(String prefix) {
		int length = prefix.length();
		TrieNode tempRoot = null;
		Map<Character,TrieNode> children = root.children;
		for(int i=0;i<length;i++) {
			char ch = prefix.charAt(i);
			if(children.containsKey(ch)){
				tempRoot  = children.get(ch);
				children = tempRoot.children;
			}else {
				return -1;
			}
		}
		
		return findAllString(tempRoot,-1);
		
	}

	private int findAllString(TrieNode tempRoot,int maxWeight) {
		
		if(tempRoot.children.size() == 0)
			return maxWeight;
		
		int tempWeight = -1;
		Set<Character> keys = tempRoot.children.keySet();
		for(Character key: keys) {
			TrieNode node = tempRoot.children.get(key);
			tempWeight = findAllString(node,Math.max(tempWeight,node.weight));
		}
		
		return Math.max(tempWeight, maxWeight);
	}
	
}
