package spelling;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * @author Shu Clasence Neba
 *
 */
public class DictionaryBST implements Dictionary
{

	
	
   private TreeSet<String> dict = new TreeSet<String>(new Comparator<String>() {

	@Override
	public int compare(String arg0, String arg1) {
		// TODO Auto-generated method stub
		return arg0.compareToIgnoreCase(arg1);
	}
});
	
    // TODO: Implement the dictionary interface using a TreeSet.  
 	// You'll need a constructor here
   public DictionaryBST(){}
	
    
    /** Add this word to the dictionary.  Convert it to lowercase first
     * for the assignment requirements.
     * @param word The word to add
     * @return true if the word was added to the dictionary 
     * (it wasn't already there). */
    public boolean addWord(String word) {
    	// TODO: Implement this method
    	if(!(word==null)){
        	
           /* if(this.isWord(word)){
            return false;
            }
        	*/
        	dict.add(word.toLowerCase());
            return true;
        	}
        	return false;
    }


    /** Return the number of words in the dictionary */
    public int size()
    {
    	// TODO: Implement this method
        return dict.size();
    }

    /** Is this a word according to this dictionary? */
    public boolean isWord(String s) {
    	   //TODO: Implement this method
    	if(dict.size()==0){
    		return false;
    	}
    
    	
        return dict.contains(s);
    }
    


}
