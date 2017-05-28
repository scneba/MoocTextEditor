package spelling;

import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;

/** 
 * An trie data structure that implements the Dictionary and the AutoComplete ADT
 * @author Shu Clasence Neba
 *
 */
public class AutoCompleteDictionaryTrie implements  Dictionary, AutoComplete {

    private TrieNode root;
    private int size;
    

    public AutoCompleteDictionaryTrie()
	{
		root = new TrieNode();
		size=0;
	}
	
	
	/** Insert a word into the trie.
	 * For the basic part of the assignment (part 2), you should ignore the word's case.
	 * That is, you should convert the string to all lower case as you insert it. */
	public boolean addWord(String word)
	{
	    //TODO: Implement this method.
	
		if(word==""){
			return false;
		}
		 word = word.toLowerCase();
		
		TrieNode newNode=root.insert(word.charAt(0));
		if(newNode==null){
			newNode=root.getChild(word.charAt(0));
		}
		for(int i=1;i<word.length();i++){
			
			TrieNode tempNode=newNode.insert(word.charAt(i));
			if(tempNode==null){
				newNode=newNode.getChild(word.charAt(i));
			}
			else{
				newNode=tempNode;
			}
			
		}
		
		if(!(newNode.endsWord())){
			newNode.setEndsWord(true);
			size++;
		}
		
		
	    return true;
	}
	
	/** 
	 * Return the number of words in the dictionary.  This is NOT necessarily the same
	 * as the number of TrieNodes in the trie.
	 */
	public int size()
	{
	    //TODO: Implement this method
		
	    return this.size;
	}
	
	
	/** Returns whether the string is a word in the trie */
	@Override
	public boolean isWord(String s) 
	{
	    // TODO: Implement this method
		if(s=="")
		return false;
		
		s=s.toLowerCase();
		if(!(root.getChildren().containsKey(s.charAt(0)))){
			return false;
			}
		TrieNode newNode=root.getChild(s.charAt(0));
		
	for(int i=1;i<s.length();i++){
			
		if(!(newNode.getChildren().containsKey(s.charAt(i)))){
			return false;
		}
			
			newNode =newNode.getChild(s.charAt(i));
			
		}
	
	 if(newNode.endsWord()){
		return true;
	 }
	 return false;
	}
	
	/**check if input prefix is a stem
	 * @returns boolean*/
	
	public TrieNode containsStem(String prefix){
		
	    // TODO: Implement this method
		TrieNode tnode;
		
		if(prefix=="")
		return root;
		
		prefix=prefix.toLowerCase();
		if(!(root.getChildren().containsKey(prefix.charAt(0)))){
			return null;
			}
		TrieNode newNode=root.getChild(prefix.charAt(0));
		
	for(int i=1;i<prefix.length();i++){
			
		if(!(newNode.getChildren().containsKey(prefix.charAt(i)))){
			return null;
		}
			
			newNode =newNode.getChild(prefix.charAt(i));
			
		}
		return newNode;
	 
		
	}

	/** 
	 *  * Returns up to the n "best" predictions, including the word itself,
     * in terms of length
     * If this string is not in the trie, it returns null.
     * @param text The text to use at the word stem
     * @param n The maximum number of predictions desired.
     * @return A list containing the up to n best predictions
     */@Override
     public List<String> predictCompletions(String prefix, int numCompletions) 
     {
    	 LinkedList<TrieNode> list = new LinkedList<TrieNode>();
    	 List<String> listToReturn = new ArrayList<String>();
    	 if(!(prefix==null)){
    		 prefix = prefix.toLowerCase();
    	 }
    	 
    	 if(numCompletions==0){
    		 return  listToReturn;
    	 }
    	 
    	 TrieNode node = this.containsStem(prefix);
    	 if(node==null){
    		 return listToReturn;
    	 }
    	 
    	 list.addLast(node);
    	 while(!(list.isEmpty())&& listToReturn.size()<numCompletions ){
    		 
    		 node=list.get(0);
    		 list.remove(0);
    		 if(node.endsWord()){
    			 listToReturn.add(node.getText());
    		 }
    		
    		 if(node.getChildren().size()>0){
    		list.addAll(node.getChildren().values()); 
    		 }
    	
    		 
     }
    	 
    	 
    	 // TODO: Implement this method
    	 // This method should implement the following algorithm:
    	 // 1. Find the stem in the trie.  If the stem does not appear in the trie, return an
    	 //    empty list
    	 // 2. Once the stem is found, perform a breadth first search to generate completions
    	 //    using the following algorithm:
    	 //    Create a queue (LinkedList) and add the node that completes the stem to the back
    	 //       of the list.
    	 //    Create a list of completions to return (initially empty)
    	 //    While the queue is not empty and you don't have enough completions:
    	 //       remove the first Node from the queue
    	 //       If it is a word, add it to the completions list
    	 //       Add all of its child nodes to the back of the queue
    	 // Return the list of completions
    	 
         return listToReturn;
     }

 	// For debugging
 	public void printTree()
 	{
 		printNode(root);
 	}
 	
 	/** Do a pre-order traversal from this node down */
 	public void printNode(TrieNode curr)
 	{
 		if (curr == null) 
 			return;
 		
 		System.out.println(curr.getText());
 		
 		TrieNode next = null;
 		for (Character c : curr.getValidNextCharacters()) {
 			next = curr.getChild(c);
 			printNode(next);
 		}
 	}
 	

	
}